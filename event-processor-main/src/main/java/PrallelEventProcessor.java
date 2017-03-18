import com.google.gson.Gson;
import dto.SaleReciept;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import util.Bill;
import util.Constant;
import util.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by chetan.anand on 3/16/17.
 * <p>
 * This class create a Runnable kafka consumer. The input of
 * constructor is partitionId
 * <p>
 * As mentioned in the design doc the number of consumer will be equal to number of partition.
 */
public class PrallelEventProcessor implements Runnable {

    private int threadId;
    private KafkaConsumer<String, String> consumer;
    private List<String> topicList;
    private Map<Integer, SaleReciept> saleRecieptHashMap;

    public PrallelEventProcessor(int threadId, List<String> topicList) {
        this.threadId = threadId;
        this.consumer = new KafkaConsumer<String, String>(Constant.getConsumerProperties());
        this.topicList = topicList;
        this.saleRecieptHashMap = new HashMap<Integer, SaleReciept>();
        consumer.subscribe(topicList);
    }

    public void run() {
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Constant.PollTimeout);
            for (ConsumerRecord<String, String> record : records) {
                processBillingEvent(record);
            }

        }
    }

    private void processBillingEvent(ConsumerRecord<String, String> record) {
        Bill bill = new Gson().fromJson(record.value(), Bill.class);
        Float totalSalePerItem = 0f;
        for (Item item : bill.getItems()) {
            totalSalePerItem += item.getTotal_price_paid();
        }
        Long bucketedTimeStamp = Constant.getBucketedTimeStamp(record.timestamp(), Constant.TimePeriod);
        if (null != saleRecieptHashMap.get(bill.getStore_id())) {
            SaleReciept saleRecieptTemp = saleRecieptHashMap.get(bill.getStore_id());
            if (bucketedTimeStamp.equals(saleRecieptTemp.getTimestamp())) {
                saleRecieptTemp.setTotalSales(saleRecieptTemp.getTotalSales() + totalSalePerItem);
            } else {
                ConsumerQueue.saleRecieptQueue.offer(saleRecieptTemp);
                SaleReciept saleReciept = SaleReciept.builder().storeId(bill.getStore_id())
                        .timestamp(bucketedTimeStamp)
                        .totalSales(totalSalePerItem)
                        .offSet(record.offset())
                        .build();
                saleRecieptHashMap.put(bill.getStore_id(), saleReciept);
            }
        } else {
            SaleReciept saleReciept = SaleReciept.builder().storeId(bill.getStore_id())
                    .timestamp(bucketedTimeStamp)
                    .totalSales(totalSalePerItem)
                    .offSet(record.offset())
                    .build();
            saleRecieptHashMap.put(bill.getStore_id(), saleReciept);
        }
    }
}

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import util.Constant;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Created by chetan.anand on 3/16/17.
 *
 * This class create a Runnable kafka consumer. The input of
 * constructor is partitionId
 */
public class PrallelEventProcessor implements Runnable {

    private int threadId;
    private KafkaConsumer<String,String> consumer;
    private List<String> topicList;

    public PrallelEventProcessor(int threadId, List<String> topicList){
        this.threadId = threadId;
        this.consumer = new KafkaConsumer<String, String>(Constant.getConsumerProperties());
        this.topicList = topicList;
        consumer.subscribe(topicList);
    }

    public void run() {
        while(true) {
            ConsumerRecords<String, String> records = consumer.poll(Constant.PollTimeout);
            for (ConsumerRecord<String, String> record : records) {
                System.out.print("topic=" + record.topic());
                System.out.print(" partition=" + record.partition());
                System.out.print(" thread=" + threadId);
                System.out.println(" offset=" + record.offset());
                //System.out.println(consumer.endOffsets(Arrays.asList(new TopicPartition(record.topic(), 0))));
                //System.out.println(record.value());
                //System.out.println(new Date(Constant.getPeriodicTimeStamp(record.timestamp(),Constant.TimePeriod)));
            }
        }
    }
}

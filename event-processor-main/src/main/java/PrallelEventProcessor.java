import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import util.Constant;

import java.util.Arrays;
import java.util.Date;


/**
 * Created by chetan.anand on 3/16/17.
 *
 * This class create a Runnable kafka consumer. The input of
 * constructor is partitionId
 */
public class PrallelEventProcessor implements Runnable {

    private int partitionId;

    public PrallelEventProcessor(int partitionId){
        this.partitionId = partitionId;
    }

    public void run() {
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(Constant.getConsumerProperties());
        consumer.subscribe(Arrays.asList(Constant.TOPIC_NAME));
        while(true) {
            ConsumerRecords<String, String> records = consumer.poll(Constant.PollTimeout);
            System.out.println(records.count());
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("topic = " + record.topic());
                System.out.println("partition = " + record.partition());
                System.out.println("offset = " + record.offset());
                System.out.println(consumer.endOffsets(Arrays.asList(new TopicPartition(record.topic(), 0))));
                System.out.println(record.value());
                System.out.println(new Date(Constant.getPeriodicTimeStamp(record.timestamp(),Constant.TimePeriod)));
            }
        }
    }
}

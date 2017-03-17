import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

/**
 * Created by chetan.anand on 3/16/17.
 */
public class OffSetCheckPointing implements Runnable {

    public static Queue<Integer> checkPointIndex = new LinkedList<Integer>();

    public void run() {
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String,String>(getConsumerProperties());
        consumer.subscribe(Arrays.asList("sales_receipts"));
    }

    private Properties getConsumerProperties(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "false");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }
}

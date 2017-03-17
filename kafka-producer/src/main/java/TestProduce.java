import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import util.Mock;

import java.util.Properties;
import java.util.UUID;

/**
 * Created by chetan.anand on 3/16/17.
 */
public class TestProduce {
    private static final int no_of_partitions = 5;
    public static void main(String[] args) {
        Producer<String, String> producer = new KafkaProducer<String, String>(getProducerProperties());
        for(int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<String, String>("sales_receipts", String.valueOf(i % no_of_partitions), Mock.getMockBillJson(i % no_of_partitions)));
        }
        producer.close();
    }

    private static Properties getProducerProperties(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }


}

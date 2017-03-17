import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import util.Constant;
import util.Mock;

import java.util.Random;

/**
 * Created by chetan.anand on 3/18/17.
 */
public class EventProducer implements Runnable {
    public void run() {
        Producer<String, String> producer = new KafkaProducer<String, String>(Constant.getProducerProperties());
        Integer NO_OF_PARTITION = producer.partitionsFor(Constant.TOPIC_NAME).size();
        Random random = new Random();
        int temp = Math.abs(random.nextInt());
        producer.send(new ProducerRecord<String, String>(
                    Constant.TOPIC_NAME, String.valueOf(temp % NO_OF_PARTITION),
                    Mock.getMockBillJson(temp % NO_OF_PARTITION)));
        producer.close();
    }
}

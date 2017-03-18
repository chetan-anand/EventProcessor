package util;

import java.util.Properties;

/**
 * Created by chetan.anand on 3/17/17.
 */
public class Constant {

    public static final String TOPIC_NAME = "sales_receipts";

    public static final Long TimePeriod = 1000l;

    public static Properties getProducerProperties() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("block.on.buffer.full", true);
        return props;
    }
}

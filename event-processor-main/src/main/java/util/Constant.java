package util;

import java.util.Properties;

/**
 * Created by chetan.anand on 3/17/17.
 */
public class Constant {
    public static final String TOPIC_NAME = "sales_receipts";

    public static final Long TimePeriod = 30000l;

    public static final Long PollTimeout = 20000l;

    public static final Integer NO_OF_PARTITION = 5;

    public static Properties getConsumerProperties() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }

    /**
     * @param Long
     * @return Returns the  buckuted time stamp according to  the timeperiod
     */
    public static Long getBucketedTimeStamp(Long timeStamp, Long timePeriod) {
        return (timeStamp - timeStamp % timePeriod);
    }
}

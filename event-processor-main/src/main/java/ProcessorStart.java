import util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by chetan.anand on 3/16/17.
 */
public class ProcessorStart {
    public static void main(String[] args) {
        List<String> topicList = new ArrayList<String>();
        topicList.add(Constant.TOPIC_NAME);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(Constant.NO_OF_PARTITION);
        for(int i=0; i< Constant.NO_OF_PARTITION ; i++) {
            scheduledExecutorService.execute(new PrallelEventProcessor(i,topicList));
        }
    }
}

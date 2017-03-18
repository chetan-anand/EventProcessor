import util.Constant;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by chetan.anand on 3/16/17.
 */
public class TestProduce {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new EventProducer(), 0, Constant.TimePeriod, TimeUnit.MILLISECONDS);
    }
}

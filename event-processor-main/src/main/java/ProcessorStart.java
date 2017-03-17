import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by chetan.anand on 3/16/17.
 */
public class ProcessorStart {
    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.execute(new PrallelEventProcessor(1));
    }
}

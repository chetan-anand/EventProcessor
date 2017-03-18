import dto.SaleReciept;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by chetan.anand on 3/17/17.
 * <p>
 * This queue has the output from all the parallel running kafaka consumer.
 * That's why it is Concurrent.
 */
public class ConsumerQueue {
    public static Queue<SaleReciept> saleRecieptQueue = new ConcurrentLinkedQueue<SaleReciept>();
}

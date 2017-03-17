import dto.SaleReciept;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by chetan.anand on 3/17/17.
 */
public class ConsumerQueue {
    public static Queue<SaleReciept> queue = new ConcurrentLinkedQueue<SaleReciept>();
}

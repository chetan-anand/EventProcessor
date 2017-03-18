import dto.SaleReciept;
import util.Constant;

import java.util.Date;

/**
 * Created by chetan.anand on 3/18/17.
 */
public class ProcessedEventOutputStream implements Runnable {
    public void run() {
        while(true){
            if(!ConsumerQueue.saleRecieptQueue.isEmpty()){
                SaleReciept saleReciept = ConsumerQueue.saleRecieptQueue.poll();
                Date start= new Date(saleReciept.getTimestamp());
                Date end  = new Date(saleReciept.getTimestamp());
                System.out.println("StoreId: "+saleReciept.getStoreId()+"  "+"Total Sales: "+saleReciept.getTotalSales()+" "+"ProcessTimeRange: "+start+"-"+end);
            }
        }
    }
}

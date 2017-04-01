import dto.SaleReciept;
import util.Constant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chetan.anand on 3/18/17.
 */
public class ProcessedEventOutputStream implements Runnable {
    public void run() {
        while (true) {
            if (!ConsumerQueue.saleRecieptQueue.isEmpty()) {
                SaleReciept saleReciept = ConsumerQueue.saleRecieptQueue.poll();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
                String start = dateFormat.format(new Date(saleReciept.getTimestamp()));
                String end = dateFormat.format(new Date(saleReciept.getTimestamp() + Constant.TimePeriod));
                System.out.println("StoreId: " + saleReciept.getStoreId() + "  " + "Total Sales: " + saleReciept.getTotalSales() + "    " + "ProcessTimeRange: {" + start + "  " + end + "}");
            }
        }
    }
}

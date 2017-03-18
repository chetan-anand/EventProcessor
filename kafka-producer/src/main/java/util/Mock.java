package util;

import com.google.gson.Gson;
import dto.Bill;
import dto.Item;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by chetan.anand on 3/16/17.
 */
public class Mock {
    private static Gson gson = new Gson();

    public static String getMockBillJson(int storeid){
        Item item = Item.builder()
                .item_id(1)
                .quantity(1)
                .total_price_paid(1.0f)
                .build();
        List<Item> itemList= new ArrayList<Item>();
        itemList.add(item);
        Bill mockBill = Bill.builder()
                .items(itemList)
                .customer_id(1)
                .receipt_id(1)
                .store_id(storeid)
                .build();
        return gson.toJson(mockBill);
    }

    public static void main(String[] args) {
        System.out.println(getMockBillJson(1));
    }

}

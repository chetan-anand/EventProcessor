package util;

import com.google.gson.Gson;
import dto.Bill;
import dto.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by chetan.anand on 3/16/17.
 */
public class Mock {
    private static Gson gson = new Gson();

    public static String getMockBillJson(int storeid){
        Item item1 = new Item();
        item1.setItem_id(1);
        item1.setQuantity(1);
        item1.setTotal_price_paid(1.0f);
        List<Item> itemList= new ArrayList<Item>();
        itemList.add(item1);
        Bill mockBill = new Bill();
        mockBill.setItems(itemList);
        mockBill.setCustomer_id(1);
        mockBill.setReceipt_id(1);
        mockBill.setStore_id(storeid);
        return gson.toJson(mockBill);
    }

    public static void main(String[] args) {
        System.out.println(getMockBillJson(1));
    }

}

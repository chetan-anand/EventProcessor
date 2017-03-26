package dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by chetan.anand on 3/16/17.
 */
@Data
@Builder
public class Item implements Serializable{
    private Integer item_id;
    private Integer quantity;
    private Float total_price_paid;
}

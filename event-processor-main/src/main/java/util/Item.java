package util;

import lombok.Builder;
import lombok.Data;

/**
 * Created by chetan.anand on 3/16/17.
 */
@Data
@Builder
public class Item {
    private Integer item_id;
    private Integer quantity;
    private Float total_price_paid;
}

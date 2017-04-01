package dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by chetan.anand on 3/16/17.
 */

@Data
@Builder
public class Bill {
    private Integer store_id;
    private Integer receipt_id;
    private Integer customer_id;
    private List<Item> items;
}

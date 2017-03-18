package dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by chetan.anand on 3/17/17.
 */
@Data
@Builder
public class SaleReciept {
    private Integer storeId;
    private Float totalSales;
    private Long timestamp;
    private Long offSet;
}

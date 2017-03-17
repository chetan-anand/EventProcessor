package dto;

import lombok.Data;

/**
 * Created by chetan.anand on 3/17/17.
 */
@Data
public class SaleReciept {
    private Integer storeId;
    private Float totalSales;
    private Long timestamp;
    private Long offSet;
}

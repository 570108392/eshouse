package it.qsbl.com.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductInfoVO {
    private String productId;

    private String productName;

    private Date productionDate;

    private BigDecimal productPrice;

    private String productImage;

    private Integer productStock;

    private Integer productStatus;

    private String productUser;

    private Integer productTypeId;



}
package it.qsbl.com.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderMasterVO {

    private Integer orderId;

    private Long orderSn;

    private Integer customerId;

    private String shippingUser;

    private BigDecimal paymentMoney;

    private String shippingSn;

    private Date shippingTime;

    private Date createTime;

    private Date receiveTime;

    private Byte orderStatus;

}

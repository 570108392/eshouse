package it.qsbl.com.domain;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetail {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.order_detail_id
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    private Integer orderDetailId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.order_id
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.product_id
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.product_name
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    private String productName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.product_cnt
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    private Integer productCnt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.product_price
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    private BigDecimal productPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.average_cost
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    private BigDecimal averageCost;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.weight
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    private Float weight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.fee_money
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    private BigDecimal feeMoney;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.w_id
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    private Integer wId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.modified_time
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    private Date modifiedTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.order_detail_id
     *
     * @return the value of order_detail.order_detail_id
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.order_detail_id
     *
     * @param orderDetailId the value for order_detail.order_detail_id
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.order_id
     *
     * @return the value of order_detail.order_id
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.order_id
     *
     * @param orderId the value for order_detail.order_id
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.product_id
     *
     * @return the value of order_detail.product_id
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.product_id
     *
     * @param productId the value for order_detail.product_id
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.product_name
     *
     * @return the value of order_detail.product_name
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.product_name
     *
     * @param productName the value for order_detail.product_name
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.product_cnt
     *
     * @return the value of order_detail.product_cnt
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public Integer getProductCnt() {
        return productCnt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.product_cnt
     *
     * @param productCnt the value for order_detail.product_cnt
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public void setProductCnt(Integer productCnt) {
        this.productCnt = productCnt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.product_price
     *
     * @return the value of order_detail.product_price
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.product_price
     *
     * @param productPrice the value for order_detail.product_price
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.average_cost
     *
     * @return the value of order_detail.average_cost
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public BigDecimal getAverageCost() {
        return averageCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.average_cost
     *
     * @param averageCost the value for order_detail.average_cost
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public void setAverageCost(BigDecimal averageCost) {
        this.averageCost = averageCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.weight
     *
     * @return the value of order_detail.weight
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public Float getWeight() {
        return weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.weight
     *
     * @param weight the value for order_detail.weight
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public void setWeight(Float weight) {
        this.weight = weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.fee_money
     *
     * @return the value of order_detail.fee_money
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public BigDecimal getFeeMoney() {
        return feeMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.fee_money
     *
     * @param feeMoney the value for order_detail.fee_money
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public void setFeeMoney(BigDecimal feeMoney) {
        this.feeMoney = feeMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.w_id
     *
     * @return the value of order_detail.w_id
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public Integer getwId() {
        return wId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.w_id
     *
     * @param wId the value for order_detail.w_id
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public void setwId(Integer wId) {
        this.wId = wId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.modified_time
     *
     * @return the value of order_detail.modified_time
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.modified_time
     *
     * @param modifiedTime the value for order_detail.modified_time
     *
     * @mbg.generated Mon Apr 22 09:09:04 CST 2019
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
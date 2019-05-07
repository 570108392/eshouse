package it.qsbl.com.service;

import it.qsbl.com.domain.ProductInfo;
import it.qsbl.com.domain.vo.ProductInfoVO;

import java.util.List;


public interface ProductInfoService {

    /**
     * 获取所有的商品信息
     * @return
     */
    List<ProductInfo> getAllProductInfo();


    /**
     * 根据商品ID获取商品的详细信息
     * @param id
     * @return
     */
    ProductInfo getProductInfo(String id);


    /**
     * 添加商品信息
     * @param productInfo
     */
    void addProductInfo(ProductInfo productInfo);

    /**
     * 更新商品信息
     * @param productInfo
     */
    void editProductInfo(ProductInfo productInfo);

    /**
     * 删除指定商品信息
     * @param id
     * @return
     */
    Integer productInfoDelete(String id);

    /**
     * 批量删除指定商品信息
     * @param ids
     */
    void productInfoDeleteBatch(List<String> ids);

    /**
     * 根据条件获取所有商品信息
     * @param productionDate
     * @param productStatus
     * @param startTime
     * @param endTime
     * @return
     */
//    List<ProductInfoVO> getAllProductInfo(String productionDate, String productStatus, String startTime, String endTime);
    List<ProductInfo> getAllProductInfo(String productionDate, String productStatus, String startTime, String endTime);
}

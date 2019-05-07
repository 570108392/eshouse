package it.qsbl.com.dao;

import it.qsbl.com.domain.ProductInfo;
import it.qsbl.com.domain.vo.ProductInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductInfoMapper {
    int deleteByPrimaryKey(String productId);

    int insert(ProductInfo record);

    ProductInfo selectByPrimaryKey(String productId);


    int updateByPrimaryKey(ProductInfo record);

    @Select("select * from product_info")
    List<ProductInfo> getAllProductInfo();

//    List<ProductInfoVO> getAllProductInfo();

    void getAllProductInfoByConitions(List<String> list);

    List<ProductInfo> getAllProductInfoByConition(@Param("productName") String productName,
                                                    @Param("productStatus")String productStatus,
                                                    @Param("startTime")String startTime,
                                                    @Param("endTime")String endTime);
/*
    List<ProductInfoVO> getAllProductInfoByConition(@Param("productName") String productName,
                                                    @Param("productStatus")String productStatus,
                                                    @Param("startTime")String startTime,
                                                    @Param("endTime")String endTime);
*/
}
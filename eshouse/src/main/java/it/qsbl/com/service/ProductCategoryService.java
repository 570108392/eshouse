package it.qsbl.com.service;

import it.qsbl.com.domain.ProductCategory;

import java.util.List;
import java.util.Map;

public interface ProductCategoryService {

    /**
     * 获取所有的商品类型菜单书
     * @return
     */
    List<Map<String, Object>>  getAllMenus();

    /**
     * 获取所有商品类型
     * @return
     */
    List<ProductCategory>  getAll();

    /**
     * 删除指定的商品类型
     * @param id
     * @return
     */
    int deleteProductCategory(String id);

    /**
     * 更新指定的商品类型
     * @param productCategory
     * @return
     */
    Integer updateProductCategory(ProductCategory productCategory);

    /**
     * 获取指定商品类型
     * @param id
     * @return
     */
    ProductCategory getProductCategory(String id);

    /**
     * 添加商类型
     * @param productCategory
     * @return
     */
    Integer addProductCategory(ProductCategory productCategory);


    /**
     * 前台获取所有的商品类型 列表 拼接HTML字符串返回broker
     * @return
     */
    String getProtalProductCategory();
}

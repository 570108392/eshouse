package it.qsbl.com.dao;

import it.qsbl.com.domain.ProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductCategoryMapper {

    int deleteByPrimaryKey(String categoryId);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);
    ProductCategory selectByPrimaryKey(String categoryId);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);

    @Select("select * from product_category")
    List<ProductCategory> getAll();
    @Select("select * from product_category where parent_id = #{id}")
    List<ProductCategory> getAllParent(@Param("id")String id);
}
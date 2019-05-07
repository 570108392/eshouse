package it.qsbl.com.service.impl;

import it.qsbl.com.dao.ProductCategoryMapper;
import it.qsbl.com.domain.ProductCategory;
import it.qsbl.com.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Override
    public List<Map<String, Object>> getAllMenus() {
        List<ProductCategory>  productCategories = productCategoryMapper.getAllParent("-1");

        List<Map<String,Object>> parent = new ArrayList<>();

        return getChildrenMap(productCategories,parent);
    }

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryMapper.getAll();
    }


    public List<Map<String, Object>> getChildrenMap(List<ProductCategory>  productCategories, List<Map<String,Object>> parent ){
        productCategories.forEach(productCategory -> {
                Map<String,Object> map = new HashMap<>();;
                map.put("name",productCategory.getCategoryName());
                map.put("id",productCategory.getCategoryId());
                List<ProductCategory>  child_productCategories = productCategoryMapper.getAllParent(productCategory.getCategoryId());
                if(child_productCategories.size() != 0)
                map.put("children",getChildrenMap(child_productCategories,new ArrayList<Map<String,Object>>()));
                parent.add(map);
        });
        return parent;

    }

    @Override
    public int deleteProductCategory(String id) {
        return productCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer updateProductCategory(ProductCategory productCategory) {
        return productCategoryMapper.updateByPrimaryKey(productCategory);
    }

    @Override
    public ProductCategory getProductCategory(String id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addProductCategory(ProductCategory productCategory) {
        return productCategoryMapper.insert(productCategory);
    }

    @Override
    public String getProtalProductCategory() {

        String _html = "";

        List<Map<String, Object>> allMenus = getAllMenus();

        for (int i = 0; i < allMenus.size(); i++){
            Map<String,Object> map = allMenus.get(i);
            _html += "<dl><dt>"+map.get("name")+"</dt>";

            List<Map<String,Object>> productCategories = (List<Map<String, Object>>) map.get("children");

            if( null == productCategories || productCategories.isEmpty()){

                _html += "</dl>";
            }else{
                for(int j = 0; j < productCategories.size(); j++){
                    Map<String,Object> m = productCategories.get(j);
                    _html += "<dd><a onclick='catagroyType("+m.get("id")+",this)' id='"+m.get("id")+"'>"+m.get("name")+"</a></dd>";
//                    _html += "<dd><a onclick='catagroyType()' href='/protal/details/"+m.get("id")+"'>"+m.get("name")+"</a></dd>";
                }
            }
            _html += "</dl>";
        }
        return _html;
    }
}

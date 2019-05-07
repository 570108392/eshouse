package it.qsbl.com.controller;

import it.qsbl.com.domain.ProductCategory;
import it.qsbl.com.service.ProductCategoryService;
import it.qsbl.com.utils.BaseResponse;
import it.qsbl.com.utils.Result;
import it.qsbl.com.utils.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("category")
public class ProductCategoryController {

    @Autowired
    private  ProductCategoryService productCategoryService;

    @GetMapping("allmenus")
    public Result getProductMenus(){

        List<Map<String, Object>> allMenus = productCategoryService.getAllMenus();


        if(allMenus.size() == 0)
            return Result.error(StatusEnum.NOT_ENTITY);

        return Result.seccess(allMenus);
    }

    /**
     * 获取所有的商品种类
     * @return
     */
    @GetMapping("all")
    public BaseResponse getAll(){

        List<ProductCategory> allMenus = productCategoryService.getAll();

        return new BaseResponse(0,"",allMenus,allMenus.size());
    }

    /**
     * 删除指定商品类型
     * @param id
     * @return
     */
    @GetMapping("deleteProductCategory/{id}")
    public Result deleteProductCategory(@PathVariable String id){

        int i = productCategoryService.deleteProductCategory(id);

        if(i == 0)
            return Result.error(StatusEnum.NOT_ENTITY);
        return Result.seccess("删除成功");

    }

    /**
     * 更新商品类型
     * @param productCategory
     * @return
     */
    @PostMapping("editProductCategory")
    public Result editProductCategory(@RequestBody ProductCategory productCategory){

        Integer i = productCategoryService.updateProductCategory(productCategory);

        if(i == 0)
            return Result.error("更新失败");

        return Result.seccess("更新成功");

    }

    /**
     * 添加商品类型信息
     * @param productCategory
     * @return
     */
    @PostMapping("addProductCategory")
    public Result addProductCategory(@RequestBody ProductCategory productCategory){

        Integer i = productCategoryService.addProductCategory(productCategory);

        if(i == 0)
            return Result.error("添加失败");

        return Result.seccess("添加成功");

    }

}

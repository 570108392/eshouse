package it.qsbl.com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import it.qsbl.com.domain.ProductInfo;
import it.qsbl.com.domain.vo.ProductInfoVO;
import it.qsbl.com.service.ProductInfoService;
import it.qsbl.com.utils.Result;
import it.qsbl.com.utils.ResultTable;
import it.qsbl.com.utils.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 获取所有的商品信息
     * @return
     */
    @PostMapping("list")
    public ResultTable getAllProductInfos(  @RequestParam(value = "product_name",required = false)String product_name,
                                            @RequestParam(value = "product_status", required = false)String productStatus,
                                            @RequestParam(value="page",defaultValue="0")int pageNum,
                                            @RequestParam(value = "limit", defaultValue = "10") int size,
                                            @RequestParam(value = "startTime",required = false)String startTime,
                                            @RequestParam(value = "endTime",required = false)String endTime){

        PageHelper.startPage(pageNum,size,"product_id asc");

        startTime = StringUtils.isEmpty(startTime) ? startTime : startTime+" 00:00:00";
        endTime = StringUtils.isEmpty(endTime) ? endTime : endTime+" 23:59:59";

        List<ProductInfo> allProductInfo = productInfoService.getAllProductInfo(product_name,productStatus,startTime,endTime);
//        List<ProductInfoVO> allProductInfo = productInfoService.getAllProductInfo(product_name,productStatus,startTime,endTime);

        if(allProductInfo == null)
            return ResultTable.error(StatusEnum.NOT_ENTITY);

        PageInfo<ProductInfo> page = new PageInfo<>(allProductInfo);

        return ResultTable.seccess(page.getList(),page.getTotal());
    }

    /**
     * 获取指定的商品详细信息
     * @return
     */
    @GetMapping("getProductInfo/{id}")
    public Result getProductInfo(@PathVariable String id){
        ProductInfo productInfo = productInfoService.getProductInfo(id);

        if(productInfo == null)
            return  Result.error(StatusEnum.NOT_ENTITY);

        return Result.seccess(productInfo);
    }

    /**
     * 添加商品详细信息
     * @param productInfo
     * @param bindingResult
     * @return
     */
    @PostMapping("productAdd")
    public Result productInfoAdd(@RequestBody @Valid  ProductInfo productInfo, BindingResult bindingResult){

        if(bindingResult.hasErrors())
            return new Result(false,bindingResult.getFieldError().getDefaultMessage(),500);

        productInfo.setProductId(new Date().getTime()+"");
        productInfoService.addProductInfo(productInfo);

        return Result.seccess("添加商品信息成功");

    }

    /**
     * 更新商品详细信息
     * @param productInfo
     * @param result
     * @return
     */
    @PostMapping("productEdit")
    public Result productInfoEdit(@RequestBody @Valid ProductInfo productInfo,BindingResult result){

        if(result.hasErrors())
            return new Result(false,result.getFieldError().getDefaultMessage(),500);

        productInfoService.editProductInfo(productInfo);

        return Result.seccess("更新商品信息成功");
    }

    /**
     * 删除指定商品信息
     * @param id
     * @return
     */
    @GetMapping("productDelete/{id}")
    public Result productInfoDelete(@PathVariable String id){
        Integer size =  productInfoService.productInfoDelete(id);

        if(size == 0)
            return Result.error("删除失败");
        return Result.seccess("删除成功");
    }

    /**
     * 批量删除商品信息
     * @param productInfos
     * @return
     */
    @PostMapping("productInfoDeleteBatch")
    public Result productInfoDeleteBatch(@RequestBody List<ProductInfo> productInfos){
        if(productInfos.size() == 0)
            return Result.error(StatusEnum.PARAMS_NOT_NULL);
        List<String> ids = productInfos.stream().map(ProductInfo::getProductId).collect(Collectors.toList());
        productInfoService.productInfoDeleteBatch(ids);

        return Result.seccess("批量删除成功");
    }


}

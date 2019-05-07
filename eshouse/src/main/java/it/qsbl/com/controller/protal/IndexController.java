package it.qsbl.com.controller.protal;

import it.qsbl.com.domain.ProductCategory;
import it.qsbl.com.domain.search.GoodsInfo;
import it.qsbl.com.service.ProductCategoryService;
import it.qsbl.com.service.es.GoodInfoService;
import it.qsbl.com.utils.Result;
import it.qsbl.com.utils.ResultTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("protal")
public class IndexController {

    @Autowired
    private GoodInfoService goodInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;
    @GetMapping("getAllCategory")
    public String getAllCategory(){

       return productCategoryService.getProtalProductCategory();

    }

    @GetMapping("getGoodsCommodity")
    public ResultTable getGoodsCommodity(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                    @RequestParam(value = "size",defaultValue = "15")Integer size ){

        Pageable pageable = new PageRequest(page-1,size,Sort.Direction.DESC,"price");
        Iterable<GoodsInfo> all = goodInfoService.findALLByPage(pageable);

        String _html = "";
        Iterator<GoodsInfo> iterator = all.iterator();
        long total = goodInfoService.getTotal();
        while (iterator.hasNext()){
            _html += iterator.next().getGoodsHtml();
        }

        return ResultTable.seccess(_html,total);
    }

    @GetMapping("productDetail/{id}")
    public Result getProductDetails(@PathVariable("id") Integer id){

        GoodsInfo goodsInfo = (GoodsInfo) goodInfoService.search(id);

        return  Result.seccess(goodsInfo);
    }

    @GetMapping("getProductByCategoryType/{id}")
    public Result getProductByCategoryType(@PathVariable("id") Integer id,
                                           @RequestParam(value = "page",defaultValue = "1") Integer page,
                                           @RequestParam(value = "size",defaultValue = "15")Integer size,
                                           @RequestParam(value = "condtition",defaultValue = "price") String condtition,
                                           @RequestParam(value = "direction",defaultValue = "DESC") String direction){

        Pageable pageable = new PageRequest(page-1,size,Sort.Direction.valueOf(direction),condtition);

        long total = goodInfoService.getListProductByCategoryCounts(id);
        List<GoodsInfo> goodsInfo =  goodInfoService.getListProductByCategory(id,pageable);

        String _html = "";
        for(int i = 0; i< goodsInfo.size(); i++){
            _html += goodsInfo.get(i).getGoodsHtml();
        }

        return  ResultTable.seccess(_html,total);
    }
}

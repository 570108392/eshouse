package it.qsbl.com.controller.homeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("productHome")
public class ProductHomeController {

    private static final String PRODUCT_BASIC_URL = "pages/product/";
    private static final String CATEGORY_BASIC_URL = "pages/productCategory/";

    /**
     * 所有商品信息页面跳转页
     * @return
     */
    @GetMapping("productList")
    public String productList(){
        return PRODUCT_BASIC_URL+"list";
    }

    @GetMapping("stockList")
    public String stockList(){
        return PRODUCT_BASIC_URL+"stock";
    }

    /**
     * 添加商品页面跳转页
     * @return
     */
    @GetMapping("productAdd")
    public String productAdd(){
        return PRODUCT_BASIC_URL+"add";
    }
    /**
     * 编辑商品页面跳转页
     * @return
     */
    @GetMapping("productEdit")
    public String productEdit(){
        return PRODUCT_BASIC_URL+"edit";
    }


    /**
     * 查看商品信息页面跳转页
     * @return
     */
    @GetMapping("productShow")
    public String productShow(){
        return PRODUCT_BASIC_URL+"show";
    }


    /**
     * 跳转到商品类型列表页面
     * @return
     */
    @GetMapping("categoryList")
    public String categoryList(){
        return CATEGORY_BASIC_URL+"list";
    }
}

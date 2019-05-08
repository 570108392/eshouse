package it.qsbl.com.controller;

import it.qsbl.com.domain.ProductInfo;
import it.qsbl.com.domain.search.GoodsInfo;
import it.qsbl.com.domain.vo.ProductInfoVO;
import it.qsbl.com.service.ProductInfoService;
import it.qsbl.com.service.es.Impl.GoodInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * 用户访问登录相关=操作
 */
@RequestMapping("login")
@Controller
public class LoginController {


    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("success")
    public String success(){
        System.out.println("用户登录成功");
        return "index";
    }

    @RequestMapping("index")
    public String center(){
        return "index";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }


    @Autowired
    private  GoodInfoServiceImpl goodInfoService;
    @GetMapping("es")
    public String test(){


        List<ProductInfo> allProductInfo = productInfoService.getAllProductInfo();
        allProductInfo.forEach(productInfoVO -> {
            GoodsInfo goodsInfo = new GoodsInfo();

            goodsInfo.setCreateTime(new Date());
            goodsInfo.setId(Integer.parseInt(productInfoVO.getProductId()));
            goodsInfo.setName(productInfoVO.getProductName());
            goodsInfo.setCategoryId(Integer.parseInt(productInfoVO.getProductTypeId()));
            goodsInfo.setProductStatus(productInfoVO.getProductStatus());
            goodsInfo.setPrice(Double.valueOf(productInfoVO.getProductPrice()+""));
            goodsInfo.setSellCount(productInfoVO.getProductStock());
            goodsInfo.setProductDesc(productInfoVO.getProductDesc());
            goodsInfo.setProductUser(productInfoVO.getProductUser());
            goodsInfo.setSuggestName(productInfoVO.getProductName());
            goodsInfo.setProductImage(productInfoVO.getProductImage());
            goodsInfo.setWeight(Double.valueOf(productInfoVO.getProductWeight().toString()));
            goodsInfo.setGoodsHtml("<div class='item'>" +
                    "                <div class='img'>" +
                    "                  <a href='/protal/details/"+productInfoVO.getProductId()+"'>" +
                    "                   <img src='"+productInfoVO.getProductImage()+"'></a>" +
                    "                </div>" +
                    "                <div class='text'>" +
                    "                  <p class='title'>"+productInfoVO.getProductName()+"</p>" +
                    "                  <p class='price'>" +
                    "                    <span class='pri'>￥"+productInfoVO.getProductPrice()+"</span>" +
                    "                    <span class='nub'>库存："+productInfoVO.getProductStock()+"</span>" +
                    "                  </p>" +
                    "                </div>" +
                    "              </div>");

            goodInfoService.save(goodsInfo);

        });


//        goodInfoService.save(goodsInfo);

//        goodsInfo = goodInfoService.search(goodsInfo);
//
//        System.out.println(goodsInfo);

        return "sss";
    }
}

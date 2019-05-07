package it.qsbl.com.controller.homeController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("protal")
@Slf4j
public class ProtalHomeController {

    private static  final  String BASE_PROTAL_URL = "pages/portal/";

    @GetMapping("commodity")
    public String commodity(){
        return BASE_PROTAL_URL +"commodity";
    }
    @GetMapping("aa")
    public String aa(){
        return BASE_PROTAL_URL +"aa";


    }
    @GetMapping("about")
    public String about(){
        return BASE_PROTAL_URL +"about";
    }
    @GetMapping("buytoday")
    public String buytoday(){
        return BASE_PROTAL_URL +"buytoday";
    }


    @GetMapping("details/{id}")
    public String details(@PathVariable Integer id, Model model){

        model.addAttribute("msg",id);

        log.info("访问ID"+id+"的商品详细信息");

        return BASE_PROTAL_URL +"details";
    }


    @GetMapping("index")
    public String index(){
        return BASE_PROTAL_URL +"index";
    }

    @GetMapping("information")
    public String information(){
        return BASE_PROTAL_URL +"information";
    }

    @GetMapping("login")
    public String login(){
        return BASE_PROTAL_URL +"login";
    }

    @GetMapping("shopcart")
    public String shopcart(){
        return BASE_PROTAL_URL +"shopcart";
    }


}

package it.qsbl.com.controller.homeController;

import it.qsbl.com.domain.User;
import it.qsbl.com.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("protal")
@Slf4j
public class ProtalHomeController {

    @Autowired
    private UserService userService;

    private static  final  String BASE_PROTAL_URL = "pages/portal/";

    @GetMapping("commodity")
    public String commodity(){
        return BASE_PROTAL_URL +"commodity";
    }
    @GetMapping("aa")
    public String aa(){
        return BASE_PROTAL_URL +"aa";


    }

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    @PostMapping("reg")
    public String reg(String username,String password){

        User user = new User();
        user.setPassword(password);
        user.setName(username);
        user.setCreateTime(new Date());
        user.setId(new Random().nextInt(100000000));
        Integer size = userService.insertUser(user);

        if(size > 0)
            return "redirect:/login/login";
        else
            return "404";
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

    @GetMapping("registe")
    public String login(){
        return BASE_PROTAL_URL +"login";
    }

    @GetMapping("shopcart")
    public String shopcart(){
        return BASE_PROTAL_URL +"shopcart";
    }


}

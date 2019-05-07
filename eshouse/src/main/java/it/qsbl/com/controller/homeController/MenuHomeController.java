package it.qsbl.com.controller.homeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("menuHome")
public class MenuHomeController {

    private static final String MEMBER_BASE_RUL = "pages/menu/";

    /**
     * 菜单列表
     * @return
     */
    @GetMapping("list")
    public String list(){
        return MEMBER_BASE_RUL+"list";
    }

}

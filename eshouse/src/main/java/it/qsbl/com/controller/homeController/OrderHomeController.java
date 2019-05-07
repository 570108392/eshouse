package it.qsbl.com.controller.homeController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("orderHome")
public class OrderHomeController {

    private static final String ORDER_BASE_RUL = "pages/order/";

    /**
     * 订单列表
     * @return
     */
    @GetMapping("list")
    public String list(){
        return ORDER_BASE_RUL+"list";
    }



    /**
     * 管理员查看订单的详细信息
     * @return
     */
    @GetMapping("detail")
    public String detail(String orderId, Model model){

        if(!StringUtils.isEmpty(orderId))
            model.addAttribute("orderId",orderId);
        return ORDER_BASE_RUL+"detail";
    }


    /**
     * 订单信息编辑
     * @return
     */
    @GetMapping("edit")
    public String edit(){
        return ORDER_BASE_RUL+"edit";
    }
    /**
     * 添加订单
     * @return
     */
    @GetMapping("add")
    public String add(){
        return ORDER_BASE_RUL+"add";
    }


    @GetMapping("show")
    public String show(){
        return ORDER_BASE_RUL+"show";
    }
}

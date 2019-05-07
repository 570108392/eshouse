package it.qsbl.com.controller.protal;

import it.qsbl.com.domain.OrderCart;
import it.qsbl.com.domain.User;
import it.qsbl.com.service.OrderCardService;
import it.qsbl.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
public class ProductCartController {

    @Autowired
    private OrderCardService orderCardService;

    @PostMapping("add")
    public Result getCart(@RequestBody OrderCart orderCart,
                          /*@RequestParam("image")*/ String image,
                          /*@RequestParam("name")*/ String name){


        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        orderCart.setCustomerId(user.getId());

        String _html="<ul class='item-content layui-clear'>" +
                "<li class='th th-chk'>" +
                "   <div class='select-all'>" +
                "       <div class='cart-checkbox'>" +
                "           <input class='CheckBoxShop check' id=' ' type='checkbox' num='all' name='select-all' value='true'>" +
                "       </div>" +
                "   </div>" +
                "</li>" +
                "<li class='th th-item'>" +
                "   <div class='item-cont'>" +
                "       <a href='javascript:;'>" +
                "           <img src='"+orderCart.getImage()+"' alt=''>" +
                "       </a>" +
                "       <div class='text'>" +
                "           <div class='title'>"+orderCart.getName()+"</div>" +
                "           <p>" +
                "               <span>粉色</span>  " +
                "               <span>130</span>cm" +
                "           </p>" +
                "       </div>" +
                "   </div>" +
                "</li>" +
                "<li class='th th-price'>" +
                "   <span class='th-su'>"+orderCart.getPrice()+"</span>" +
                "</li>" +
                "<li class='th th-amount'>" +
                "   <div class='box-btn layui-clear'>" +
                "       <div class='less layui-btn'>-</div>" +
                "       <input class='Quantity-input' type='' name='' value='"+orderCart.getProductAmount()+"' disabled='disabled'>" +
                "       <div class='add layui-btn'>+</div>" +
                "   </div>" +
                "</li>" +
                "<li class='th th-sum'>" +
                "   <span class='sum'>"+orderCart.getPrice().intValue()*orderCart.getProductAmount()+"</span>" +
                "</li>" +
                "<li class='th th-op'>" +
                "   <span class='dele-btn'>删除</span>" +
                "</li>" +
                "</ul>";

        orderCart.setStringToHtml(_html);

        orderCart.setProductAmount(2);

        orderCardService.save(orderCart);
        return Result.seccess(_html);
    }

    @GetMapping("cartList")
    public Result getList(){

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<OrderCart> orderCarts = orderCardService.getAllOrderCartByUser(user.getId());


        if(orderCarts.size() <= 0)
            return Result.error("暂无购物信息");


        String _html = "";
        for(int i = 0; i< orderCarts.size(); i++){
            _html += orderCarts.get(i).getStringToHtml();
        }
        return Result.seccess(_html);
    }

}

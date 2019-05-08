package it.qsbl.com.controller.protal;

import it.qsbl.com.dao.OrderDetailMapper;
import it.qsbl.com.domain.OrderCart;
import it.qsbl.com.domain.OrderDetail;
import it.qsbl.com.domain.OrderMaster;
import it.qsbl.com.domain.User;
import it.qsbl.com.service.OrderCardService;
import it.qsbl.com.service.OrderDetailService;
import it.qsbl.com.service.OrderMasterService;
import it.qsbl.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("cart")
public class ProductCartController {

    @Autowired
    private OrderCardService orderCardService;

    @Autowired
    private OrderMasterService orderMasterService;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

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

    /**
     * 用户结算购物车
     * @return
     */
    public Result cartSubmit(String ids){

        List<Integer> cartIds = Stream.of(ids.split(",")).collect(Collectors.toList()).stream().map(i -> Integer.parseInt(i)).collect(Collectors.toList());
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        //获取前端用户在购物车中选中的商品
        List<OrderCart> allOrderCartByBatch = orderCardService.getAllOrderCartByBatch(cartIds);

        if(allOrderCartByBatch.size() <= 0)
            return Result.error("系统错误");

        int total = 0;

        for (int i = 0; i< allOrderCartByBatch.size();i++){
            total += allOrderCartByBatch.get(i).getPrice().intValue();
        }

        //生成订单主表
        OrderMaster orderMaster = new OrderMaster();
        long orderId = new Random().nextLong();
        orderMaster.setOrderSn(orderId);
        orderMaster.setCustomerId(user.getId());
        orderMaster.setShippingUser(user.getName());
        orderMaster.setPaymentMoney(BigDecimal.valueOf(total));
        orderMaster.setOrderMoney(BigDecimal.valueOf(total));
        orderMaster.setOrderSn(new Random().nextLong());
        Integer i = orderMasterService.addOrderMaster(orderMaster);
        if(i <= 0)
            return Result.error("系统错误");

        //生成订单明细表
        for(int j = 0; j< allOrderCartByBatch.size(); j++){

            OrderCart orderCart = allOrderCartByBatch.get(j);

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(Integer.parseInt(orderId+""));
            orderDetail.setProductId(orderCart.getProductId());
            orderDetail.setProductName(orderCart.getName());
            orderDetail.setProductCnt(orderCart.getProductAmount());
            orderDetail.setAverageCost(BigDecimal.valueOf(orderCart.getPrice().intValue() / orderCart.getProductAmount()));
            orderDetail.setProductPrice(orderCart.getPrice());
            orderDetailMapper.insertSelective(orderDetail);
        }

        return Result.seccess();
    }


    @PostMapping("subNow")
    @Transactional
    public Result submit(@RequestBody OrderDetail orderDetail){

        User user = (User) SecurityContextHolder.getContext()  .getAuthentication() .getPrincipal();


        //生成订单主表
        OrderMaster orderMaster = new OrderMaster();
        long orderId = new Random().nextInt(1000000000);
        orderMaster.setOrderSn(orderId);
        orderMaster.setCustomerId(user.getId());
        orderMaster.setShippingUser(user.getName());
        orderMaster.setPaymentMoney(orderDetail.getProductPrice());
        orderMaster.setOrderMoney(orderDetail.getProductPrice());
        orderMaster.setCreateTime(new Date());
        orderMaster.setShippingSn(new Date().getTime()+"");
        orderMaster.setOrderStatus((byte) 1);
        Integer i = orderMasterService.addOrderMaster(orderMaster);
        if(i <= 0)
            return Result.error("系统错误");

        //生成订单明细表
        orderDetail.setOrderId((int) orderId);
        orderDetail.setProductPrice(BigDecimal.valueOf(orderDetail.getAverageCost().intValue() * orderDetail.getProductCnt()));
        orderDetailMapper.insertSelective(orderDetail);

        return Result.seccess();
    }
}

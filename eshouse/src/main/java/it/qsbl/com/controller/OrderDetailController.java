package it.qsbl.com.controller;

import it.qsbl.com.domain.OrderDetail;
import it.qsbl.com.service.OrderDetailService;
import it.qsbl.com.utils.Result;
import it.qsbl.com.utils.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("list/{id}")
    public Result list(@PathVariable Integer id){

        List<OrderDetail> orderDetails = orderDetailService.getAllByOrderID(id);

        if(orderDetails.size() == 0)
            return Result.error(StatusEnum.NOT_ENTITY);

        return  Result.seccess(orderDetails);
    }
}

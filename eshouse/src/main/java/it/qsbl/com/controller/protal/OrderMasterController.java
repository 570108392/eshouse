package it.qsbl.com.controller.protal;

import it.qsbl.com.domain.OrderMaster;
import it.qsbl.com.service.OrderMasterService;
import it.qsbl.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("protal/orderMaster")
public class OrderMasterController {

    @Autowired
    private OrderMasterService orderMasterService;

    public Result submitOrderMaster(@RequestBody OrderMaster orderMaster){
        orderMasterService.addOrderMaster(orderMaster);

        return Result.seccess();
    }
}

package it.qsbl.com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import it.qsbl.com.domain.OrderMaster;
import it.qsbl.com.domain.User;
import it.qsbl.com.domain.vo.OrderMasterVO;
import it.qsbl.com.service.OrderMasterService;
import it.qsbl.com.utils.Result;
import it.qsbl.com.utils.ResultTable;
import it.qsbl.com.utils.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderMasterService orderMasterService;

    /**
     * 根据条件粒度获取所有会员的信息列表
     * @return
     */
    @PostMapping("list")
    public ResultTable getAll(@RequestParam(value="page",defaultValue="0")int pageNum,
                              @RequestParam(value = "limit", defaultValue = "10") int size,
                              @RequestParam(value = "orderStatus", required = false) Byte orderStatus,
                              @RequestParam(value = "startTime",required = false)String startTime,
                              @RequestParam(value = "endTime",required = false)String endTime){

        PageHelper.startPage(pageNum,size,"order_id asc");

        startTime = StringUtils.isEmpty(startTime) ? startTime : startTime+" 00:00:00";
        endTime = StringUtils.isEmpty(endTime) ? endTime : endTime+" 23:59:59";

        List<OrderMasterVO> orders = orderMasterService.getAllOrderByCondition(orderStatus,startTime,endTime);

        if(orders ==  null)
            return ResultTable.error(StatusEnum.NOT_ENTITY);

        PageInfo<OrderMasterVO> page = new PageInfo<>(orders);

        return ResultTable.seccess(page.getList(),page.getTotal());
    }

    @PostMapping("listByPerson")
    public ResultTable listByPerson(@RequestParam(value="page",defaultValue="0")int pageNum,
                              @RequestParam(value = "limit", defaultValue = "10") int size,
                              @RequestParam(value = "orderStatus", required = false) Byte orderStatus,
                              @RequestParam(value = "startTime",required = false)String startTime,
                              @RequestParam(value = "endTime",required = false)String endTime){

       User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PageHelper.startPage(pageNum,size,"order_id asc");

        startTime = StringUtils.isEmpty(startTime) ? startTime : startTime+" 00:00:00";
        endTime = StringUtils.isEmpty(endTime) ? endTime : endTime+" 23:59:59";

        List<OrderMasterVO> orders = orderMasterService.getAllOrderByConditionByPerson(user.getId(),orderStatus,startTime,endTime);

        if(orders ==  null)
            return ResultTable.error(StatusEnum.NOT_ENTITY);

        PageInfo<OrderMasterVO> page = new PageInfo<>(orders);

        return ResultTable.seccess(page.getList(),page.getTotal());
    }

    /**
     * 删除指定会员信息
     * @param id
     * @return
     */
    @GetMapping("deleteOrder/{id}")
    public Result deleteorder(@PathVariable Integer id){

        Integer i = orderMasterService.deleteOrderMasterByOrderId(id);

        if(i == 0)
            return Result.error("删除会员信息失败");

        return Result.seccess("删除会员信息成功");
    }

    /**
     * 获取指定会员信息
     * @param id
     * @return
     */
    @GetMapping("getOrder/{id}")
    public Result getorder(@PathVariable Integer id){
        OrderMaster m = orderMasterService.getOrderMasterByOrderId(id);

        if(m == null)
            return Result.error(StatusEnum.NOT_ENTITY);

        return  Result.seccess(m);
    }

    /**
     * 更新会员信息
     * @param order
     * @return
     */
    @PostMapping("updateOrder")
    public Result updateMessage(@RequestBody OrderMaster order){


        order.setModifiedTime(new Date());
        Integer i = orderMasterService.updateOrderMaster(order);

        if(i == 0)
            return Result.error("更新会员信息失败");

        return Result.seccess("更新会员信息成功");

    }

    /**
     * 修改会员状态
     * @return
     */
    @PostMapping("editStatus")
    public Result editStatus(@RequestParam("status")Integer status,@RequestParam("id")Integer id){


        status = status == 0 ? 1 : 0;

        Integer i = orderMasterService.updateStatusToOrder(status,id);

        if(i == 0)
            return Result.error("修改会员状态失败");

        return Result.seccess("修改会员状态成功");

    }
}

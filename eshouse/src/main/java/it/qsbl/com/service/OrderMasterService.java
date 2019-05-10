package it.qsbl.com.service;

import it.qsbl.com.domain.OrderMaster;
import it.qsbl.com.domain.vo.OrderMasterVO;

import java.util.List;

public interface OrderMasterService {

    OrderMaster getOrderMasterByOrderId(Integer id);

    Integer addOrderMaster(OrderMaster orderMaster);

    Integer updateOrderMaster(OrderMaster orderMaster);

    Integer deleteOrderMasterByOrderId(Integer id);

    List<OrderMasterVO> getAllOrderByCondition(Byte orderStatus,String startTime,String endTime);

    Integer updateStatusToOrder(Integer status, Integer id);

    List<OrderMasterVO> getAllOrderByConditionByPerson(Integer id, Byte orderStatus, String startTime, String endTime);
}

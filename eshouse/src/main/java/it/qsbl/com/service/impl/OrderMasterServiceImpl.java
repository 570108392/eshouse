package it.qsbl.com.service.impl;

import it.qsbl.com.dao.OrderMasterMapper;
import it.qsbl.com.domain.OrderMaster;
import it.qsbl.com.domain.vo.OrderMasterVO;
import it.qsbl.com.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderMasterServiceImpl  implements OrderMasterService {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Override
    public OrderMaster getOrderMasterByOrderId(Integer id) {
        return orderMasterMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addOrderMaster(OrderMaster orderMaster) {
        return orderMasterMapper.insert(orderMaster);
    }

    @Override
    public Integer updateOrderMaster(OrderMaster orderMaster) {
        return orderMasterMapper.updateByPrimaryKey(orderMaster);
    }

    @Override
    public Integer deleteOrderMasterByOrderId(Integer id) {
        return orderMasterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<OrderMasterVO> getAllOrderByCondition(Byte orderStatus, String startTime, String endTime) {
        return orderMasterMapper.getAllOrderByConition(orderStatus,startTime,endTime);
    }

    @Override
    public Integer updateStatusToOrder(Integer status, Integer id) {
        return orderMasterMapper.updateStatusToOrder(status,id);
    }
}

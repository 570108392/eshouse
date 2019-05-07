package it.qsbl.com.service.impl;

import it.qsbl.com.dao.OrderDetailMapper;
import it.qsbl.com.domain.OrderDetail;
import it.qsbl.com.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderDetail> getAllByOrderID(Integer id) {
        return orderDetailMapper.getAllByOrderID(id);
    }
}

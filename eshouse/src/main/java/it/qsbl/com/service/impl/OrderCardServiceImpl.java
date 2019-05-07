package it.qsbl.com.service.impl;

import it.qsbl.com.dao.OrderCartMapper;
import it.qsbl.com.domain.OrderCart;
import it.qsbl.com.service.OrderCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCardServiceImpl implements OrderCardService {

    @Autowired
    private OrderCartMapper orderCartMapper;

    @Override
    public void save(OrderCart orderCart) {

        orderCartMapper.insertSelective(orderCart);
    }

    @Override
    public List<OrderCart> getAllOrderCartByUser(Integer uid) {
        return orderCartMapper.selectByUserID(uid);
    }
}

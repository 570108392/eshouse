package it.qsbl.com.service;

import it.qsbl.com.domain.OrderCart;

import java.util.List;

public interface OrderCardService {

    void save(OrderCart orderCart);

    List<OrderCart> getAllOrderCartByUser(Integer uid);
}

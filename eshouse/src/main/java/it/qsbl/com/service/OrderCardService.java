package it.qsbl.com.service;

import it.qsbl.com.domain.OrderCart;

import java.util.List;

public interface OrderCardService {

    void save(OrderCart orderCart);

    List<OrderCart> getAllOrderCartByUser(Integer uid);

    /**
     * 获取购物车指定商品信息
     * @param cartIds
     * @return
     */
    List<OrderCart> getAllOrderCartByBatch(List<Integer> cartIds);

    void deleteRoleBatchByBatch(List<Integer> cartIds);
}

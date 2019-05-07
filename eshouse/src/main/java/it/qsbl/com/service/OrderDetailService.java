package it.qsbl.com.service;


import it.qsbl.com.domain.OrderDetail;

import java.util.List;

public interface OrderDetailService  {

    /**
     * 获取指定点单的所有商品明细
     * @param id
     * @return
     */
    List<OrderDetail> getAllByOrderID(Integer id);
}

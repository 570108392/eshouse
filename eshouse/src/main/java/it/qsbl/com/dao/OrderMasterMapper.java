package it.qsbl.com.dao;

import it.qsbl.com.domain.OrderMaster;
import it.qsbl.com.domain.vo.OrderMasterVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface OrderMasterMapper {

    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    OrderMaster selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);

    List<OrderMasterVO> getAllOrderByConition(@Param("orderStatus")Byte orderStatus,
                                             @Param("startTime")String startTime,
                                             @Param("endTime")String endTime);


    @Update("update order_master set order_status = #{status} where id = #{order_id}")
    Integer updateStatusToOrder(@Param("stauts") Integer status,
                                @Param("order_id") Integer orderID);

}
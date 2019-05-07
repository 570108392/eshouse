package it.qsbl.com.dao;

import it.qsbl.com.domain.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer orderDetailId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer orderDetailId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    @Select("select * from order_detail where order_id = #{id}")
    List<OrderDetail> getAllByOrderID(@Param("id")Integer id);
}
package it.qsbl.com.dao;

import it.qsbl.com.domain.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    @Select("select * from user_role where uid = #{uid}")
    UserRole getUserRoleByUID(@Param("uid") Integer uid);

    @Update("update user_role set rid = #{rid} where uid = #{rid}")
    int updateUserRoleByUID(@Param("uid") Integer uid,
                            @Param("rid") Integer rid);
}
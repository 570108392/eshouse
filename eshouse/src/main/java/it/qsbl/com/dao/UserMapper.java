package it.qsbl.com.dao;

import it.qsbl.com.domain.User;
import org.apache.ibatis.annotations.*;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("select * from user where id=#{userID}")
    User FindByUserID(@Param("userID") Integer userID);

    @Select("select * from user where name=#{userName}")
    User FindByUserName(@Param("userName") String userName);

    @Select("select * from user")
    List<User> getAllUsers();

    /**
     * 获取所有的普通用户
     * @return
     */
    @Select("select * from user where status = 0")
    List<User> getAllUsersOfProtal();

    User selectByPrimaryKey(Integer id);

    List<User> selectAllUserByCondition(@Param("name")String name,
                                        @Param("startTime")String startTime,
                                        @Param("endTime")String endTime);

    @Insert("insert into user(name,phone_number,email,password,avatar) values(#{name},#{phoneNumber},#{email},#{password},#{avatar})")
    Integer insertUser(User user);

//    Integer insert(User user);

    void deleteUsers(@Param("list")List<Integer> list);

    @Delete("delete from user where id = #{id}")
    void deleteUser(@Param("id")Integer id);

    @Update("update user set name = #{name},phone_number = #{phoneNumber},email = #{email},password = #{password},avatar = #{avatar} where id = #{id}")
    void editUser(User user);

    /**
     * 修改用户角色
     * @param id
     * @param rid
     * @return
     */
    @Update("update user set user_role_id = #{rid} where id = #{id}")
    int updateUserRoleNameByUserID(@Param("id") Integer id,
                                   @Param("rid") Integer rid);

    /**
     * 获取指定用户角色及其用户信息
     * @param id
     * @return
     */
    @Select("select u.*,ur.name as roleName from (select * from user where id = #{id}) as u left join  role ur on user_role_id = ur.id")
    Map<String,Object> getUserAndRole(@Param("id") Integer id);

    /**
     * 获取所有的用户及其用户的角色关联信息
     * @return
     */
    @Select("select u.*,ur.name as roleName from user u left join  role ur on user_role_id = ur.id")
    List<Map<String,Object>> getAllUserAndRole();


}

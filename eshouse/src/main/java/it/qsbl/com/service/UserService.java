package it.qsbl.com.service;

import it.qsbl.com.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 根据用户id获取用户信息
     * @param userID
     * @return
     */
    User findUseByUserID(Integer userID);

    /**
     * 获取所有的用户信息
     * @return
     */
    List<User> getAllUsers();

    /**
     * 根据条件获取所有的用户信息
     * @param name
     * @param startTime
     * @param endTime
     * @return
     */
    List<User> selectAllUserByCondition(String name, String startTime, String endTime);

    /**
     * 后台系统新增一个管理员 或者用户
     * @param user
     * @return
     */
    Integer insertUser(User user);

    /**
     * 管理员批量删除用户操作
     * @param ids
     */
    void deleteUsers(List<Integer> ids);
    /**
     * 管理员批量指定用户操作
     * @param id
     */
    void deleteUser(Integer id);


    /**
     * 修改用户信息
     * @param user
     */
    void editUser(User user);

    /**
     * 获取指定用户角色及其用户信息
     * @param id
     * @return
     */
    Map<String,Object> getUserAndRole(Integer id);

    /**
     * 获取所有的用户及其用户的角色关联信息
     * @return
     */
    List<Map<String,Object>> getAllUserAndRole();

    /**
     * 修改用户角色
     * @param id
     * @param rid
     * @return
     */
    int updateUserRoleNameByUserID(Integer id, Integer rid);

    /**
     * 获取所有的普通用户
     * @return
     */
    List<User> getAllUsersOfProtal();
}

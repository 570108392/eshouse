package it.qsbl.com.service.impl;

import it.qsbl.com.dao.UserMapper;
import it.qsbl.com.domain.User;
import it.qsbl.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUseByUserID(Integer userID){

        return userMapper.FindByUserID(userID);
    }
    public List<User> selectAllUserByCondition(String name, String startTime, String endTime){
        return userMapper.selectAllUserByCondition(name,startTime,endTime);
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public void deleteUsers(List<Integer> ids) {
         userMapper.deleteUsers(ids);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

    @Override
    public void editUser(User user) {
        userMapper.editUser(user);
    }

    @Override
    public Map<String, Object> getUserAndRole(Integer id) {
        return userMapper.getUserAndRole(id);
    }

    @Override
    public List<Map<String, Object>> getAllUserAndRole() {
        return userMapper.getAllUserAndRole();
    }

    @Override
    public int updateUserRoleNameByUserID(Integer id, Integer rid) {
        return userMapper.updateUserRoleNameByUserID(id,rid);
    }

    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }
}
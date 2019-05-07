package it.qsbl.com.service.impl;

import it.qsbl.com.dao.UserRoleMapper;
import it.qsbl.com.domain.UserRole;
import it.qsbl.com.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserRole getUserRoleByUID(Integer uid) {
        return userRoleMapper.getUserRoleByUID(uid);
    }

    @Override
    public int updateUserRoleByUID(Integer uid, Integer rid) {
        return userRoleMapper.updateUserRoleByUID(uid,rid);
    }
}

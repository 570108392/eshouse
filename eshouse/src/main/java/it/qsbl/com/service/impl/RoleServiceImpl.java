package it.qsbl.com.service.impl;

import it.qsbl.com.dao.RoleMapper;
import it.qsbl.com.domain.Role;
import it.qsbl.com.service.RoleSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleSerivce {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> gatAllRolesByName(Integer userID) {
        return roleMapper.gatAllRolesByName(userID);
    }

    @Override
    public List<Role> getAllRolesList() {
        return roleMapper.gatAllRolesList();
    }

    @Override
    public Role getRoleByID(Integer id) {
        return roleMapper.getRoleByID(id);
    }

    @Override
    public void deleteRoleBatchByids(List<Integer> list) {
        roleMapper.deleteRoleBatchByids(list);
    }

    @Override
    public void deleteRoleByID(Integer id) {
        roleMapper.deleteRoleByID(id);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    @Override
    public void insertRole(Role role) {
        roleMapper.insertRole(role);
    }
}

package it.qsbl.com.service.impl;

import it.qsbl.com.dao.MenuRoleMapper;
import it.qsbl.com.domain.MenuRole;
import it.qsbl.com.service.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuRoleServiceImpl implements MenuRoleService {
    @Autowired
    private MenuRoleMapper menuRoleMapper;

    @Override
    public void deleteByRid(Integer rid) {
         menuRoleMapper.deleteByRid(rid);
    }

    @Override
    public int addMenuRole(List<MenuRole> menuRoles) {
        return menuRoleMapper.insertBatch(menuRoles);
    }

    @Override
    public List<Integer> getAllMenuIdByRoleID(Integer id) {
        return menuRoleMapper.getAllMenuIdByRoleID(id);
    }
}

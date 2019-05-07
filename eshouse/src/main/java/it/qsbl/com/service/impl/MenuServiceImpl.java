package it.qsbl.com.service.impl;

import it.qsbl.com.dao.MenuMapper;
import it.qsbl.com.domain.Menu;
import it.qsbl.com.domain.vo.MenuVO;
import it.qsbl.com.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;



    @Override
    public List<Menu> getAllMenuByRoleIDParent(Integer rid) {
        return menuMapper.getALLmenuByRroleIDPrent(rid);
    }

    @Override
    public List<Menu> getALLmenuByRroleIDChildren(Integer rid, Integer pid) {
        return menuMapper.getALLmenuByRroleIDChildren(rid,pid);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    @Override
    public List<Menu> getAllMenusOfParent(Integer pid) {
        return menuMapper.getAllMenusOfParent(pid);
    }

    @Override
    public List<MenuVO> getAllMenusToMenuVO() {
        return menuMapper.getAllMenusToMenuVO();
    }
}

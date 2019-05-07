package it.qsbl.com.service;


import it.qsbl.com.domain.Menu;
import it.qsbl.com.domain.vo.MenuVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MenuService {

    /**
     * 根据角色返回相应顶级的菜单
     * @param rid
     * @return
     */
    List<Menu> getAllMenuByRoleIDParent(Integer rid);

    /**
     * 根据角色返回相应二级的菜单
     * @param rid
     * @param pid
     * @return
     */
    List<Menu>getALLmenuByRroleIDChildren(Integer rid,Integer pid);


    /**
     * 获取所有的菜单项
     * @return
     */
    List<Menu> getAllMenus();


    /**
     * 得到所有的一级菜单
     * @return
     */
    List<Menu> getAllMenusOfParent(Integer pid);

    /**
     * 封装方法 主要负责角色分配权限回显封装
     * @return
     */
    List<MenuVO> getAllMenusToMenuVO();
}

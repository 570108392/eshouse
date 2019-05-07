package it.qsbl.com.controller;

import it.qsbl.com.domain.Menu;
import it.qsbl.com.domain.MenuRole;
import it.qsbl.com.domain.User;
import it.qsbl.com.domain.vo.MenuVO;
import it.qsbl.com.service.MenuRoleService;
import it.qsbl.com.service.MenuService;
import it.qsbl.com.utils.BaseResponse;
import it.qsbl.com.utils.Result;
import it.qsbl.com.utils.ResultTable;
import it.qsbl.com.utils.StatusEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 不同用户不同角色显示不同菜单
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuRoleService menuRoleService;

    /**
     * 获取所有的角色列表
     * @return
     */
    @GetMapping("menuList/{id}")
    public BaseResponse getAllMenus(@PathVariable Integer id){
        List<MenuVO> menus = menuService.getAllMenusToMenuVO();

        //获取该角色拥有的所有菜单列表
        List<Integer> mids = menuRoleService.getAllMenuIdByRoleID(id);


        menus.forEach(menuVO -> {
           if(mids.contains(menuVO.getMid()))
               menuVO.setLAY_CHECKED(true);
        });

        if(menus.size() == 0)
            return null;

        return new BaseResponse(0,"",menus,menus.size());
    }
    @GetMapping("menuList")
    public BaseResponse getAllMenus(){
        List<Menu> menus = menuService.getAllMenus();


        if(menus.size() == 0)
            return null;

        return new BaseResponse(0,"",menus,menus.size());
    }

    @GetMapping("list")
    public Result menuList(){
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Menu> pmenu = menuService.getALLmenuByRroleIDChildren(user.getUserRoleId(),-1);
        if(pmenu.size() == 0)
            return Result.error(StatusEnum.NOT_ENTITY);

        String _html = "";


        for (int i = 0; i < pmenu.size();i++){
            Menu m = pmenu.get(i);
            _html += "<li><a href='javascript:;' >" +
                    "<i class='iconfont'>&#xe6b8;</i>" +
                    "<cite>"+m.getMname()+"</cite>" +
                    "<i class='iconfont nav_right'>&#xe697;</i>" +
                    "</a>";
            List<Menu> childMenu = menuService.getALLmenuByRroleIDChildren(user.getUserRoleId(),m.getMid());

            if(childMenu.size() >0){
                _html += "<ul class='sub-menu'>";
                for (int j = 0; j < childMenu.size();j++){
                    Menu cm = childMenu.get(j);
                    _html += "<li><a _href='"+cm.getMenuUrl()+"'><i class='iconfont'>&#xe6a7;</i><cite>"+cm.getMname()+"</cite></a></li>";
                }
                _html += "</ul>";
            }
            _html += "</li>";
        }
        return Result.seccess(_html);
    }

    @PostMapping("updateRolePermission/{id}")
    public Result updateRolePermission(@PathVariable Integer id, @RequestBody List<Menu> menus){

        List<Integer> ids = menus.stream().map(Menu::getMid).collect(Collectors.toList());

        List<MenuRole> menuRoles = new ArrayList<>();
        for (Integer i : ids) {
            MenuRole menuRole = new MenuRole();
            menuRole.setMid(i);
            menuRole.setRid(id);
            menuRoles.add(menuRole);
        }

        menuRoleService.deleteByRid(id);

        menuRoleService.addMenuRole(menuRoles);

        return Result.seccess("授权成功");

    }
}

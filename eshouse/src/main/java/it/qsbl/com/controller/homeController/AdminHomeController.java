package it.qsbl.com.controller.homeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeController {

    private static final String PAGES_ADMIN_BASIC = "pages/admin/";
    private static final String PAGES_ROLE_BASIC = "pages/role/";

    /**
     * 大众用户登录页面跳转页
     * @return
     */
    @GetMapping("portal/login")
    public String userLogin(){
        return "portal/login";
    }


    @GetMapping(value = {"pages/welcome","login/pages/welcome"})
    public String pagesWelcome(){
        return "pages/welcome";
    }

    /**
     * 大众用户首页 跳转页
     * @return
     */
    @GetMapping("portal/index")
    public String userIndex(){
        return "portal/index";
    }


    /**
     * 系统用户列表跳转页
     * @return
     */
    @GetMapping("admin/list/index")
    public String adminListIndex(){
        return PAGES_ADMIN_BASIC+"list";
    }


    /**
     * 系统权限列表跳转页
     * @return
     */
    @GetMapping("admin/permission/index")
    public String adminPermissionIndex(){
        return PAGES_ADMIN_BASIC+"rule";
    }

    /**
     * 添加用户信息跳转页
     * @return
     */
    @GetMapping("admin/list/add")
    public String adminListAdd(){
        return PAGES_ADMIN_BASIC+"add";
    }

    /**
     * 查看指定用户信息跳转页
     * @return
     */
    @GetMapping("admin/list/show")
    public String adminListShow(){
        return PAGES_ADMIN_BASIC+"show";
    }

    /**
     * 修改指定用户信息跳转页
     * @return
     */
    @GetMapping("admin/list/edit")
    public String adminListEdit(){
        return PAGES_ADMIN_BASIC+"edit";
    }

    /**
     * 查看所有角色页面跳转页
     * @return
     */
    @GetMapping("admin/role/index")
    public String roleListList(){
        return PAGES_ROLE_BASIC+"list";
    }

    /**
     * 添加用户角色页面跳转页
     * @return
     */
    @GetMapping("admin/role/add")
    public String roleListAdd(){
        return PAGES_ROLE_BASIC+"add";
    }

    /**
     * 查看指定角色信息跳转页
     * @return
     */
    @GetMapping("admin/role/show")
    public String roleListShow(){
        return PAGES_ROLE_BASIC+"show";
    }

    /**
     * 修改指定角色信息跳转页
     * @return
     */
    @GetMapping("admin/role/edit")
    public String roleListEdit(){
        return PAGES_ROLE_BASIC+"edit";
    }


    @GetMapping("admin/permission")
    public String permission(){
        return PAGES_ADMIN_BASIC+"permission";
    }

    @GetMapping("role/permission")
    public String rolePermission(){
        return PAGES_ROLE_BASIC+"permission";
    }

}

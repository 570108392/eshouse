package it.qsbl.com.controller;

import it.qsbl.com.domain.Menu;
import it.qsbl.com.domain.Role;
import it.qsbl.com.domain.User;
import it.qsbl.com.service.MenuService;
import it.qsbl.com.service.RoleSerivce;
import it.qsbl.com.service.UserService;
import it.qsbl.com.utils.Result;
import it.qsbl.com.utils.ResultTable;
import it.qsbl.com.utils.StatusEnum;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("role")
@RestController
public class RoleController {

    @Autowired
    private RoleSerivce roleSerivce;

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    /**
     * 获取所有的角色列表
     * @return
     */
    @GetMapping("roleList")
    public Result getAllRoles(){
        List<Role> roles = roleSerivce.getAllRolesList();

        if(roles.size() == 0)
            return Result.error(StatusEnum.NOT_ENTITY);

        return ResultTable.seccess(roles, (long) roles.size());
    }

    /**
     * 根据角色id获取角色信息
     * @param id
     * @return
     */
    @GetMapping("getRole/{id}")
    public Result getRole(@PathVariable @RequestParam("id") Integer id){
        Role role = roleSerivce.getRoleByID(id);

        if(role ==  null)
            return Result.error(StatusEnum.NOT_ENTITY);

        return Result.seccess(role);
    }

    @GetMapping("premission/{id}")
    public Result premission(@PathVariable Integer id){

        //1:获取所有角色
        List<Role> roles = roleSerivce.getAllRolesList();

        if(roles.size() == 0)
            return Result.error(StatusEnum.NOT_ENTITY);
        //2 获取管理员拥有角色
        User user = userService.findUseByUserID(id);

        String _html = "<option value=''>审核状态</option>";
        if(user !=  null){
            for(int i = 0;i<roles.size();i++){
                Role role1 = roles.get(i);
                if(user.getUserRoleId() == (long)role1.getId())
                    _html += "<option value='"+role1.getId()+"' selected>"+role1.getName()+"</option>";
                else
                    _html += "<option value='"+role1.getId()+"'>"+role1.getName()+"</option>";
            }
        }

        return Result.seccess(_html);
    }

    /**
     * 新增一个角色
     * @param role
     * @param result
     * @return
     */
    @PostMapping("addRole")
    public Result addRole(@RequestBody @Valid Role role , BindingResult result){

        if (result.hasErrors())
            return new Result(false,result.getFieldError().getDefaultMessage(),500);

        roleSerivce.insertRole(role);

        return Result.seccess();

    }

    /**
     * 根据角色id删除角色
     * 1：删除角色数据
     * @param id
     * @return
     */
    @GetMapping("deleteRole/{id}")
    public Result deleteRole(@PathVariable Integer id){

        roleSerivce.deleteRoleByID(id);

        return Result.seccess();
    }

    /**
     * 批量删除角色
     * @param roles
     * @return
     */
    @PostMapping("deleteRoleBatch")
    public Result deleteRoleBatchByids(@RequestBody List<Role> roles){
        if(roles.size() == 0)
            return Result.error(StatusEnum.NOT_ENTITY);
        List<Integer> ids = roles.stream().map(Role::getId).collect(Collectors.toList());

        roleSerivce.deleteRoleBatchByids(ids);

        return Result.seccess("批量删除角色信息成功");
    }

    /**
     * 更新角色信息
     * @param role
     * @param result
     * @return
     */
    @PostMapping("updateRole")
    public Result updateRole(@RequestBody @Valid Role role,BindingResult result){
        if(result.hasErrors())
            return new Result(false,result.getFieldError().getDefaultMessage(),500);

        roleSerivce.updateRole(role);

        return Result.seccess();
    }

    @GetMapping("roleMenu/{id}")
    public Result roleMenu(@PathVariable Integer id){

        List<Menu> pmenu = menuService.getAllMenusOfParent(-1);

//        List<Role> roles = roleSerivce.getr
        if(pmenu.size() == 0)
            return Result.error(StatusEnum.NOT_ENTITY);

        String _html = "";


        for (int i = 0; i < pmenu.size();i++){
            Menu m = pmenu.get(i);
            _html += "<div class='layui-input-inline'>" +
                    " <label class='layui-form-label'>" +
                    " <span class='we-red'>*</span>"+m.getMname()+"" +
                    " </label>" +
                    " <div class='layui-input-inline'>";
            List<Menu> childMenu = menuService.getAllMenusOfParent(m.getMid());

            if(childMenu.size() >0){
                for (int j = 0; j < childMenu.size();j++){
                    Menu cm = childMenu.get(j);
                    _html += "<input type='checkbox' name='' title='"+cm.getMname()+"' ><div class='layui-unselect layui-form-checkbox '><span>"+cm.getMname()+"</span><i class='layui-icon layui-icon-ok'></i></div>";
//                    _html += "<input type='checkbox' name=' ' title='"+cm.getMname()+"' checked>";
                }
            }
            _html += "</div></div>";
        }


        return Result.seccess(_html);
    }
}

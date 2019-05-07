package it.qsbl.com.controller;

import it.qsbl.com.service.UserService;
import it.qsbl.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户角色分配相关操作
 */
@RestController
@RequestMapping("permission")
public class PermissionController {


    @Autowired
    private UserService userService;

    @PostMapping("updateUserRole")
    public Result updateUserRole(@RequestParam("uid") Integer uid,
                                 @RequestParam("rid") Integer rid){

        int i = userService.updateUserRoleNameByUserID(uid, rid);

        if(i <= 0)
            return Result.error("更新用户角色出错了");

        return Result.seccess("更新用户角色成功");
    }
}

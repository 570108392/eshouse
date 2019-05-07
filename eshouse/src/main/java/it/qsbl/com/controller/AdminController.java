package it.qsbl.com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import it.qsbl.com.domain.Role;
import it.qsbl.com.domain.User;
import it.qsbl.com.service.RoleSerivce;
import it.qsbl.com.service.UserService;
import it.qsbl.com.utils.Result;
import it.qsbl.com.utils.ResultTable;
import it.qsbl.com.utils.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 后台管理员模块相关操作
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private RoleSerivce roleSerivce;

    @Autowired
    private UserService userService;

    /**
     * 获取所有的用户信息
     * @return
     */
    @PostMapping("list")
    public Result allUsers(@RequestParam(value="page",defaultValue="0")int pageNum,
                           @RequestParam(value = "limit", defaultValue = "10") int size,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "startTime",required = false)String startTime,
                           @RequestParam(value = "endTime",required = false)String endTime){

        PageHelper.startPage(pageNum,size,"id asc");

        startTime = StringUtils.isEmpty(startTime) ? startTime : startTime+" 00:00:00";
        endTime = StringUtils.isEmpty(endTime) ? endTime : endTime+" 23:59:59";
        List<User> users = userService.selectAllUserByCondition(name,startTime,endTime);

        if(users.size() <=0)
            return  Result.error();

        PageInfo<User> page = new PageInfo<>(users);

        return ResultTable.seccess(page.getList(),page.getTotal());

    }

    @GetMapping("getUser/{id}")
    public Result getUser(@PathVariable Integer id){

        if(id == 0)
            return Result.error(StatusEnum.PARAMS_NOT_NULL);

        User user = userService.findUseByUserID(id);

        if(user == null)
            return Result.error(StatusEnum.NOT_ENTITY);

        return Result.seccess(user);

    }

    /*@PostMapping("add")
    public Result addUser(@RequestParam(value="name")String name,
                          @RequestParam(value = "phoneNumber") String phoneNumber,
                          @RequestParam(value = "email") String email,
                          @RequestParam(value = "password")String password){*/
    @PostMapping("add")
    public Result addUser(@RequestBody User user){

        if(user == null)
            return Result.error(StatusEnum.PARAMS_NOT_NULL);

        Integer sun = userService.insertUser(user);

        if(sun == 0)
            return Result.error("新增用户失败");

        return Result.seccess("新增用户成功");

    }

    @PostMapping("deleteUsers")
    public Result deleteUsers(@RequestBody List<User> users){

        if(users .size() ==  0)
            return Result.error(StatusEnum.PARAMS_NOT_NULL);

        List<Integer> ids = users.stream().map(User::getId).collect(Collectors.toList());
       userService.deleteUsers(ids);


        return Result.seccess("删除用户成功");

    }
    @PostMapping("deleteUser")
    public Result deleteUser(@RequestParam(value = "id",defaultValue = "0")Integer id){

        if(id ==  0)
            return Result.error(StatusEnum.PARAMS_NOT_NULL);

       userService.deleteUser(id);


        return Result.seccess("删除指定用户成功");

    }

    @PostMapping("editUser")
    public Result editUser(@RequestBody User user){

        if(user == null)
            return Result.error(StatusEnum.PARAMS_NOT_NULL);

        userService.editUser(user);


        return Result.seccess("更新用户信息成功");

    }
}

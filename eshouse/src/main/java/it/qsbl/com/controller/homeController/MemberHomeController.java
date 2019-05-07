package it.qsbl.com.controller.homeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("memberHome")
public class MemberHomeController {

    private static final String MEMBER_BASE_RUL = "pages/member/";

    /**
     * 会员列表
     * @return
     */
    @GetMapping("list")
    public String list(){
        return MEMBER_BASE_RUL+"list";
    }

    /**
     * 管理员管理会员
     * @return
     */
    @GetMapping("manage")
    public String manage(){
        return MEMBER_BASE_RUL+"manage";
    }


    /**
     * 管理员查看会员的详细信息
     * @return
     */
    @GetMapping("show")
    public String show(){
        return MEMBER_BASE_RUL+"show";
    }


    /**
     * 会员信息编辑
     * @return
     */
    @GetMapping("edit")
    public String edit(){
        return MEMBER_BASE_RUL+"edit";
    }
    /**
     * 添加会员
     * @return
     */
    @GetMapping("add")
    public String add(){
        return MEMBER_BASE_RUL+"add";
    }
    /**
     * 消息推送页面跳转
     * @return
     */
    @GetMapping("quartzSend")
    public String quartzSend(){
        return MEMBER_BASE_RUL+"quartzSend";
    }
}

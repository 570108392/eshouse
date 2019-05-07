package it.qsbl.com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import it.qsbl.com.domain.Member;
import it.qsbl.com.domain.vo.MemberVO;
import it.qsbl.com.service.MemberService;
import it.qsbl.com.utils.Result;
import it.qsbl.com.utils.ResultTable;
import it.qsbl.com.utils.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 根据条件粒度获取所有会员的信息列表
     * @return
     */
    @PostMapping("list")
    public ResultTable getAll(@RequestParam(value="page",defaultValue="0")int pageNum,
                              @RequestParam(value = "limit", defaultValue = "10") int size,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "memberStatus", required = false) Integer memberStatus,
                              @RequestParam(value = "startTime",required = false)String startTime,
                              @RequestParam(value = "endTime",required = false)String endTime){

        PageHelper.startPage(pageNum,size,"member_id asc");

        startTime = StringUtils.isEmpty(startTime) ? startTime : startTime+" 00:00:00";
        endTime = StringUtils.isEmpty(endTime) ? endTime : endTime+" 23:59:59";

        List<MemberVO> members = memberService.getAllByConditions(name,memberStatus,startTime,endTime);

        if(members ==  null)
            return ResultTable.error(StatusEnum.NOT_ENTITY);

        PageInfo<MemberVO> page = new PageInfo<>(members);

        return ResultTable.seccess(page.getList(),page.getTotal());
    }

    /**
     * 删除指定会员信息
     * @param id
     * @return
     */
    @GetMapping("deleteMember/{id}")
    public Result deleteMember(@PathVariable Integer id){

        Integer i = memberService.deleteMemberById(id);

        if(i == 0)
            return Result.error("删除会员信息失败");

        return Result.seccess("删除会员信息成功");
    }
    /**
     * 删除指定会员信息
     * @param members
     * @return
     */
    @PostMapping("deleteMembers")
    public Result deleteMember(@RequestBody List<Member> members){

        List<Integer> ids = members.stream().map(Member::getMemberId).collect(Collectors.toList());

        Integer i = memberService.deleteMemberByBatch(ids);

        if(i == 0)
            return Result.error("批量删除会员信息失败");

        return Result.seccess("批量删除会员信息成功");
    }

    /**
     * 获取指定会员信息
     * @param id
     * @return
     */
    @GetMapping("getMember/{id}")
    public Result getMember(@PathVariable Integer id){
        Member m = memberService.getMember(id);

        if(m == null)
            return Result.error(StatusEnum.NOT_ENTITY);

        return  Result.seccess(m);
    }

    /**
     * 更新会员信息
     * @param member
     * @return
     */
    @PostMapping("updateMember")
    public Result updateMessage(@RequestBody Member member){


        member.setLastTime(new Date());
        member.setUpdateTime(new Date());
        Integer i = memberService.updateMember(member);

        if(i == 0)
            return Result.error("更新会员信息失败");

        return Result.seccess("更新会员信息成功");

    }

    /**
     * 添加会员信息
     * @param member
     * @return
     */
    @PostMapping("add")
    public Result addMessage(@RequestBody Member member){


        member.setLastTime(new Date());
        member.setUpdateTime(new Date());
        member.setRegisterTime(new Date());
        Integer i = memberService.addMember(member);

        if(i == 0)
            return Result.error("添加会员信息失败");

        return Result.seccess("添加会员信息成功");

    }
    /**
     * 修改会员状态
     * @return
     */
    @PostMapping("editStatus")
    public Result editStatus(@RequestParam("status")Integer status,@RequestParam("id")Integer id){


        //status = status == 0 ? 1 : 0;

        Integer i = memberService.updateStatusToMember(status,id);

        if(i == 0)
            return Result.error("修改会员状态失败");

        return Result.seccess("修改会员状态成功");

    }



}

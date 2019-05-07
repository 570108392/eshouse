package it.qsbl.com.service;


import it.qsbl.com.domain.Member;
import it.qsbl.com.domain.vo.MemberVO;

import java.util.List;

public interface MemberService {

    /**
     * 根据条件粒度分页获取所有的会员信息
     * @param name
     * @param startTime
     * @param endTime
     * @return
     */
    List<MemberVO> getAllByConditions(String name,Integer status, String startTime, String endTime);

    /**
     * 根据会员ID获取指定会员信息
     * @param id
     * @return
     */
    Member getMember(Integer id);

    /**
     * 更新会员信息
     * @param Member
     * @return
     */
    Integer updateMember(Member Member);

    /**
     * 增加会员信息
     * @param Member
     * @return
     */
    Integer addMember(Member Member);

    /**
     * 根据ID删除指定会员信息
     * @param id
     * @return
     */
    Integer deleteMemberById(Integer id);


    /**
     * 批量删除会员信息
     * @param ids
     * @return
     */
    Integer deleteMemberByBatch(List<Integer> ids);


    Integer updateStatusToMember(Integer status,Integer id);
}

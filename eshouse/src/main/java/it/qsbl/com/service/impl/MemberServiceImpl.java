package it.qsbl.com.service.impl;

import it.qsbl.com.dao.MemberMapper;
import it.qsbl.com.domain.Member;
import it.qsbl.com.domain.vo.MemberVO;
import it.qsbl.com.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;
    @Override
    public List<MemberVO> getAllByConditions(String name,Integer status, String startTime, String endTime) {
        return memberMapper.getAllMemberByConition(name,status,startTime,endTime);
    }

    @Override
    public Member getMember(Integer id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateMember(Member member) {
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public Integer addMember(Member member) {
        return memberMapper.insert(member);
    }

    @Override
    public Integer deleteMemberById(Integer id) {
        return memberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteMemberByBatch(List<Integer> ids) {
        return memberMapper.deleteMembersBatch(ids);
    }

    @Override
    public Integer updateStatusToMember(Integer status, Integer id) {
        return memberMapper.updateStatusToMember(status,id);
    }
}

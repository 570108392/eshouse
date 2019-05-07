package it.qsbl.com.dao;

import it.qsbl.com.domain.Member;
import it.qsbl.com.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MemberMapper {

    int deleteByPrimaryKey(Integer memberId);

    Integer deleteMembersBatch(List<Integer> list);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer memberId);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    List<MemberVO> getAllMemberByConition(@Param("memberName") String memberName,
                                          @Param("memberStatus")Integer memberStatus,
                                          @Param("startTime")String startTime,
                                          @Param("endTime")String endTime);

    @Update("update member set member_status = #{status} where member_id = #{id}")
    int updateStatusToMember(@Param("status") Integer status,@Param("id") Integer id);
}
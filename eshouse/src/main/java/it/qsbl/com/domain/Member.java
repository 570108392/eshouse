package it.qsbl.com.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Member {

    private Integer memberId;

    private String memberName;

    private String memberAddress;

    private BigDecimal memberPrice;

    private Date lastTime;

    private Date registerTime;

    private Date updateTime;

    private String memberTell;

    private Integer memberStatus;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.member_name
     *
     * @param memberName the value for member.member_name
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.member_address
     *
     * @return the value of member.member_address
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public String getMemberAddress() {
        return memberAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.member_address
     *
     * @param memberAddress the value for member.member_address
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress == null ? null : memberAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.member_price
     *
     * @return the value of member.member_price
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public BigDecimal getMemberPrice() {
        return memberPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.member_price
     *
     * @param memberPrice the value for member.member_price
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.last_time
     *
     * @return the value of member.last_time
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.last_time
     *
     * @param lastTime the value for member.last_time
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.register_time
     *
     * @return the value of member.register_time
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.register_time
     *
     * @param registerTime the value for member.register_time
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.update_time
     *
     * @return the value of member.update_time
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.update_time
     *
     * @param updateTime the value for member.update_time
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.member_tell
     *
     * @return the value of member.member_tell
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public String getMemberTell() {
        return memberTell;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.member_tell
     *
     * @param memberTell the value for member.member_tell
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public void setMemberTell(String memberTell) {
        this.memberTell = memberTell == null ? null : memberTell.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.member_status
     *
     * @return the value of member.member_status
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public Integer getMemberStatus() {
        return memberStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.member_status
     *
     * @param memberStatus the value for member.member_status
     *
     * @mbg.generated Sat Apr 20 15:54:13 CST 2019
     */
    public void setMemberStatus(Integer memberStatus) {
        this.memberStatus = memberStatus;
    }
}
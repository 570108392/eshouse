package it.qsbl.com.dao;


import it.qsbl.com.domain.SupportAddress;

public interface SupportAddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table support_address
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table support_address
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int insert(SupportAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table support_address
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int insertSelective(SupportAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table support_address
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    SupportAddress selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table support_address
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int updateByPrimaryKeySelective(SupportAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table support_address
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int updateByPrimaryKey(SupportAddress record);
}
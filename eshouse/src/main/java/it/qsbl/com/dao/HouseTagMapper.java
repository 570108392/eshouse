package it.qsbl.com.dao;


import it.qsbl.com.domain.HouseTag;

public interface HouseTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_tag
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_tag
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int insert(HouseTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_tag
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int insertSelective(HouseTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_tag
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    HouseTag selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_tag
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int updateByPrimaryKeySelective(HouseTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_tag
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int updateByPrimaryKey(HouseTag record);
}
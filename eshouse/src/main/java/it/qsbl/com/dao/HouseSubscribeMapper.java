package it.qsbl.com.dao;


import it.qsbl.com.domain.HouseSubscribe;

public interface HouseSubscribeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_subscribe
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_subscribe
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int insert(HouseSubscribe record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_subscribe
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int insertSelective(HouseSubscribe record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_subscribe
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    HouseSubscribe selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_subscribe
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int updateByPrimaryKeySelective(HouseSubscribe record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_subscribe
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int updateByPrimaryKey(HouseSubscribe record);
}
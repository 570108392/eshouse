package it.qsbl.com.dao;


import it.qsbl.com.domain.Subway;

public interface SubwayMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table subway
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table subway
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int insert(Subway record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table subway
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int insertSelective(Subway record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table subway
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    Subway selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table subway
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int updateByPrimaryKeySelective(Subway record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table subway
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int updateByPrimaryKey(Subway record);
}
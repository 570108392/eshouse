package it.qsbl.com.dao;


import it.qsbl.com.domain.HousePicture;

public interface HousePictureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_picture
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_picture
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int insert(HousePicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_picture
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int insertSelective(HousePicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_picture
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    HousePicture selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_picture
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int updateByPrimaryKeySelective(HousePicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_picture
     *
     * @mbg.generated Wed Apr 17 16:14:53 CST 2019
     */
    int updateByPrimaryKey(HousePicture record);
}
package it.qsbl.com.dao;

import it.qsbl.com.domain.MenuRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface MenuRoleMapper {

    int deleteByPrimaryKey(Integer id);

    @Select("delete from menu_role where rid = #{rid}")
    void deleteByRid(@Param("rid") Integer rid);

    int insert(MenuRole record);

    int insertBatch(@Param("list")List<MenuRole> list);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);

    @Select("select mid from menu_role where rid = #{id}")
    List<Integer> getAllMenuIdByRoleID(@Param("id") Integer id);
}
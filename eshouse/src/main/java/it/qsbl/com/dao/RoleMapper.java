package it.qsbl.com.dao;

import it.qsbl.com.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {

    /**
     * 获取指定用户拥有所有角色
     * @param userID
     * @return
     */
    @Select("select * from role where id = (SELECT uid FROM user_role where uid =#{userID}) ")
    List<Role> gatAllRolesByName(@Param("userID")Integer userID);

    /**
     * 获取所有的角色
     * @return
     */
    @Select("select * from role")
    List<Role> gatAllRolesList();

    /**
     * 根据角色id获取角色信息
     * @param id
     * @return
     */
    @Select("select * from role where id = #{id}")
    Role getRoleByID(@Param("id") Integer id);

    /**
     * 根据角色id批量删除角色
     * @param list
     */
    void deleteRoleBatchByids(@Param("list")List<Integer> list);


    /**
     * 根据角色id删除角色
     * @param id
     */
    @Delete("delete from role where id = ${id}")
    void deleteRoleByID(@Param("id")Integer id);

    /**
     * 根据角色id更新角色信息
     * @param role
     */
    @Update("update role set name = #{name} where id = #{id}")
    void updateRole(Role role);

    /**
     * 新增校色
     * @param role
     */
    @Insert("insert into role(name) values(#{name})")
    void insertRole(Role role);
}

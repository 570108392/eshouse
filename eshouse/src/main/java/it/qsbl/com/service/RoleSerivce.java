package it.qsbl.com.service;

import it.qsbl.com.domain.Role;

import java.util.List;

public interface RoleSerivce {
    List<Role> gatAllRolesByName(Integer userID) ;

    /**
     * 获取所有的角色列表
     * @return
     */
    List<Role> getAllRolesList();

    /**
     * 根据角色id获取角色信息
     * @param id
     * @return
     */
    Role getRoleByID(Integer id);

    /**
     * 根据角色id批量删除角色
     * @param list
     */
    void deleteRoleBatchByids(List<Integer> list);


    /**
     * 根据角色id删除角色
     * @param id
     */
    void deleteRoleByID(Integer id);

    /**
     * 根据角色id更新角色信息
     * @param role
     */
    void updateRole(Role role);

    /**
     * 新增校色
     * @param role
     */
    void insertRole(Role role);
}

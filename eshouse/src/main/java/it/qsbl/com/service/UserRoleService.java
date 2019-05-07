package it.qsbl.com.service;


import it.qsbl.com.domain.UserRole;


public interface UserRoleService {

    /**
     * 根据用户id 获取用户角色
     * @param uid
     * @return
     */
    UserRole getUserRoleByUID(Integer uid);

    /**
     * 根据用户ID修改用户角色
     * @param uid
     * @param rid
     * @return
     */
    int updateUserRoleByUID( Integer uid, Integer rid);
}

package it.qsbl.com.service;

import it.qsbl.com.domain.MenuRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuRoleService {

    void deleteByRid(Integer rid);

    int addMenuRole(List<MenuRole> menuRoles);

    List<Integer> getAllMenuIdByRoleID(Integer id);
}

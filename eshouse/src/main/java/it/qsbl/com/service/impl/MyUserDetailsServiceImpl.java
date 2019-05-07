package it.qsbl.com.service.impl;

import it.qsbl.com.dao.UserMapper;
import it.qsbl.com.domain.Role;
import it.qsbl.com.service.MyUserDetailsService;
import it.qsbl.com.service.RoleSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;


public class MyUserDetailsServiceImpl implements MyUserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleSerivce roleSerivce;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        it.qsbl.com.domain.User user = userMapper.FindByUserName(username);

        if(user == null)
            return null;

        /**设置用户权限*/
        List<Role> roles = roleSerivce.gatAllRolesByName(user.getId().intValue());
        List<GrantedAuthority> authorityList = new ArrayList<>();
        roles.forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_"+role.getUserId())));
        user.setAuthorityList(authorityList);

        return user;
//        return new User(username, user.getPassword(), true, true, true, true, AuthorityUtils.NO_AUTHORITIES);

    }
}

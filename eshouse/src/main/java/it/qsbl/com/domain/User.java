package it.qsbl.com.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by 瓦力.
 */
@Data
@Accessors(chain = true)
public class User implements Serializable ,UserDetails {
    private Integer id;

    private String name;

    private String password;

    private String email;

    private String phoneNumber;
    private Integer userRoleId;

    private int status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //从前台接受处理字符串转日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //处理从数据库接受日期格式化
    private Date createTime;

    private Date lastLoginTime;

    private Date lastUpdateTime;

    private String avatar;


    /**用于处理 security权限信息操作 封装**/
    private List<GrantedAuthority> authorityList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorityList;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

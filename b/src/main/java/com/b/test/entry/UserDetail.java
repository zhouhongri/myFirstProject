package com.b.test.entry;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author zhr
 * @description 封装实体类
 * @date 2018-12-10 11:03
 **/
public class UserDetail implements UserDetails {

    private UserLogin userLogin;

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        if (this.userLogin == null) {
            return null;
        }
        return this.userLogin.getPassword();
    }

    @Override
    public String getUsername() {
        if (this.userLogin == null) {
            return null;
        }
        return this.userLogin.getUsername();
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


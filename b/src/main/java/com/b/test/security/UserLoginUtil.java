package com.b.test.security;

import com.b.test.entry.UserDetail;
import com.b.test.entry.UserLogin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author hjl
 * @date 2018/6/8/008 11:21
 **/
public class UserLoginUtil {

    public static UserLogin getUserLogin() {
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (o instanceof UserDetail) {
            return ((UserDetail) o).getUserLogin();
        }
        return null;
    }
}

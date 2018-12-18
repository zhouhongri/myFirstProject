package com.b.test.security;

import com.b.test.common.SessionUtil;
import com.b.test.common.StringUtils;
import com.b.test.entry.UserDetail;
import com.b.test.entry.UserLogin;
import com.b.test.service.UserLoginService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhr
 * @description 获取账号密码
 * @date 2018-12-10 11:02
 **/
@Component
public class UserDetailService implements UserDetailsService {

    @Resource
    private UserLoginService userLoginService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SessionUtil.del("login");
        if (StringUtils.isEmpty(s)) {
            SessionUtil.put("login", "用户名为空");
            throw new UsernameNotFoundException("用户名为空");
        }
        UserLogin userLogin = new UserLogin();
        //别名作为登录账号使用
        userLogin.setUsername(s);
        List<UserLogin> userLogins = userLoginService.getByBean(userLogin);
        if (userLogins == null || userLogins.size() <= 0) {
            if (userLogins == null || userLogins.size() <= 0) {
                SessionUtil.put("login", "账号不存在");
                throw new UsernameNotFoundException("账号不存在");
            }
        }
        UserDetail userDetail = new UserDetail();
        userDetail.setUserLogin(userLogins.get(0));
        return userDetail;
    }

}

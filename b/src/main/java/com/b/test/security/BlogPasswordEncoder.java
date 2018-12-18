package com.b.test.security;

import com.b.test.common.CorsConfig;
import com.b.test.common.StringUtils;
import com.b.test.util.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义密码加密器
 *
 * @author hjl
 * @date 2018/6/8/008 9:54
 **/
public class BlogPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return MD5.md5Password(charSequence.toString() + CorsConfig.MD5_KEY);
    }

    /**
     * 密码检验
     *
     * @param charSequence 页面传值的密码
     * @param s            数据库中的密码
     * @return
     */
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        //快捷登录校验
        //校验规则：
        // 1、密码作为key 要在session中能拿到
        if (StringUtils.isEmpty(charSequence.toString()) || StringUtils.isEmpty(s)) {
            return false;
        }
        /*String token = (String) SessionUtil.get(charSequence.toString());
        if (StringUtils.isNotEmpty(token)) {
            SessionUtil.del(charSequence.toString());
            //验证通过
            return true;
        }*/
        //以下是正常校验
        return encode(charSequence).equals(s);
    }

}

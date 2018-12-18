package com.b.test.security;

import com.b.test.common.CorsConfig;
import com.b.test.common.SessionUtil;
import com.b.test.common.StringUtils;
import com.b.test.util.JsonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败处理器
 *
 * @author hjl
 * @date 2018/6/8/008 9:48
 **/
@Component
public class LoginFailHandler implements AuthenticationFailureHandler {

    /**
     * 前端服务器地址
     */
    @Value("${web.host.url}")
    public String WEB_HOST_URL;

    /**
     * 前端访问地址白名单
     */
    @Value("${web.host.white}")
    public String WHITE_LIST;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        CorsConfig.setCors(httpServletRequest, httpServletResponse,WHITE_LIST,WEB_HOST_URL);
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        String result = (String) SessionUtil.get("login");
        if (StringUtils.isEmpty(result)) {
            result = "密码错误";
        }
        JsonResult.err(result);
    }

}

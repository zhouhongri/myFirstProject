package com.b.test.security;

import com.b.test.common.CorsConfig;
import com.b.test.util.JsonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理器
 *
 * @author hjl
 * @date 2018/6/8/008 9:47
 **/
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

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
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        CorsConfig.setCors(httpServletRequest, httpServletResponse,WHITE_LIST,WEB_HOST_URL);
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        JsonResult.success();
    }

}

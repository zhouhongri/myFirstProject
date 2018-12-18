package com.b.test.common;

import com.b.test.entry.UserLogin;
import com.b.test.security.UserLoginUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;

    protected UserLogin userLogin;

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

    @ModelAttribute
    public void init(HttpServletResponse response, HttpServletRequest request) {
        CorsConfig.setCors(request, response, WHITE_LIST, WEB_HOST_URL);
        response.setHeader("Access-Control-Allow-Credentials", "true");
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        this.userLogin = UserLoginUtil.getUserLogin();
    }
}

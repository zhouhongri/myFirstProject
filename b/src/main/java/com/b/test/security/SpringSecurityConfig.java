package com.b.test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsUtils;

/**
 * spring security 配置器
 *
 * @author hjl
 * @date 2018/6/8/008 9:49
 **/
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 依赖注入自定义的登录成功处理器
     */
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    /**
     * 依赖注入自定义的登录失败处理器
     */
    @Autowired
    private LoginFailHandler loginFailHandler;

    /**
     * 向spring容器中创建一个Bean
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BlogPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                // 登录请求路径
                .loginProcessingUrl("/api/login")
                // 验证成功处理器
                .successHandler(loginSuccessHandler)
                // 验证失败处理器
                .failureHandler(loginFailHandler)
                .and().authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                // 登录请求路径不进行过滤
                .antMatchers("/api/login", "/api/blogs/page", "/api/labels/getByBlogId", "/api/labels/getGroupBeanByName", "/api/labels/getByBean", "/api/blogs/updateReadCount", "/api/labels/getByBean", "/api/comment/getByBean", "/api/comment/insert").permitAll()
                .anyRequest()
                .authenticated()
                // 取消跨站请求伪造防护
                .and().csrf().disable()
                //取消x-frame-options保护
                .headers().frameOptions().disable();
    }
}

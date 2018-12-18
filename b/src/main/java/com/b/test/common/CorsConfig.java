package com.b.test.common;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class CorsConfig {

    public final static String MD5_KEY = "blog";

    public static void setCors(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String WHITE_LIST, String WEB_HOST_URL) {
        String myOrigin = httpServletRequest.getHeader("origin");
        if (StringUtils.isNotEmpty(myOrigin)) {
            if (WHITE_LIST.indexOf(myOrigin) >= 0) {
                httpServletResponse.setHeader("Access-Control-Allow-Origin", myOrigin);
            }
        } else {
            httpServletResponse.setHeader("Access-Control-Allow-Origin", WEB_HOST_URL);
        }
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}

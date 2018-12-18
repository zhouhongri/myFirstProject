package com.b.test.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static void put(String key, Object value){
        HttpSession httpSession = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        httpSession.setAttribute(key, value);
    }

    public static Object get(String key){
        HttpSession httpSession = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        return httpSession.getAttribute(key);
    }

    public static void del(String key){
        HttpSession httpSession = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        httpSession.removeAttribute(key);
    }

    public static void put(String key, String value, Long timeOut){
        HttpSession httpSession = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        httpSession.setAttribute(key, value);
        SessionUtilTimeOut sessionUtilTimeOut = new SessionUtilTimeOut(timeOut, key, httpSession);
        Thread thread = new Thread(sessionUtilTimeOut);
        thread.start();
    }

    public static void del(String key, HttpSession httpSession){
        httpSession.removeAttribute(key);
    }
}

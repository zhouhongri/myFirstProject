package com.b.test.util;


import net.sf.json.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 返回json工具类
 *
 * @author zhr
 * 2017年12月26日12:39:22
 */
public class JsonResult {

    final static String SUCCESS = "0";

    final static String ERROR = "-1";

    public static String createResult(Object obj) {
        PrintWriter pw = null;
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setContentType("application/json;charset=UTF-8");
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.write(obj.toString());
        return null;
    }

    /**
     * {status:'0'}
     *
     * @return null
     */
    public static String success() {
        JSONObject json = new JSONObject();
        json.put("status", JsonResult.SUCCESS);
        return createResult(json);
    }

    /**
     * @param msg 错误信息
     * @return null
     */
    public static String err(String msg) {
        JSONObject res = new JSONObject();
        res.put("status", JsonResult.ERROR);
        res.put("msg", msg);
        return createResult(res);
    }

}

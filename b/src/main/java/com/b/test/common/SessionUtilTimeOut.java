package com.b.test.common;

import javax.servlet.http.HttpSession;

public class SessionUtilTimeOut implements Runnable{

    /**
     * 超时时间（毫秒）
     */
    private Long time;

    /**
     * 超时删除的key
     */
    private String key;

    /**
     * 托管session
     */
    private HttpSession httpSession;

    public SessionUtilTimeOut(Long time, String key, HttpSession httpSession) {
        this.time = time;
        this.key = key;
        this.httpSession = httpSession;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(time);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        SessionUtil.del(key, httpSession);
    }
}

package com.b.test.entry;

/**
 * @author zhr
 * @description 返回错误编码
 * @date 2018-11-30 10:46
 **/
public enum ErrorCode {

    STSTEM_ERROR("系统错误", 10000),
    NETWORK_ERROR("网络连接错误", 10001),
    DATABASE_ERROR("数据库错误", 10002),
    PARAM_NUM_ERROR("参数数量错误", 10003),
    PARAM_TYPE_ERROR("参数类型错误", 10004),
    PARAM_NULL_ERROR("参数为空", 10005),
    CONNECTION_OUT_ERROR("连接中断",10006),
    METHOD_ARGUMENT_TYPE_ERROR("方法参数类型错误",10007);

    private String name;
    private int index;

    ErrorCode(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

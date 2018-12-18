package com.b.test.common;

import java.util.List;

public class PageInfo<T> {
    public PageInfo(){
        this.pageNum = 0;
        this.pageSize = 10;
    }
    /**
     * 每页多少条数据
     */
    private Integer pageSize;

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 总数
     */
    private Long total;

    /**
     * 实际数据
     */
    private List<T> result;

    /**
     * 用作筛选条件
     */
    private T obj;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}

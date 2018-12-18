package com.b.test.common;


import java.util.Date;

/**
 * @author hjl
 * @date 2018-05-30 10:13
 **/
public class BaseBean {

    private Date createTime;

    private String createName;

    private Long createId;

    private Date updateTime;

    private String updateName;

    private Long updateId;

    private Date deleteTime;

    private String deleteName;

    private Long deleteId;

    /**
     * 逻辑字段 用于数据库排序
     */
    private String orderKey;

    /**
     * 逻辑字段 用于数据库排序 排序方式
     */
    private String orderType;

    /**
     * 逻辑字段 开始时间 用于时间段筛选
     */
    private Date startTime;

    /**
     * 逻辑字段 结束时间 用于时间段筛选
     */
    private Date endTime;

    /**
     * 逻辑字段 作为时间段筛选的字段 例如创建时间 直接填写为：create_time 不写驼峰
     */
    private String filterTimeKey;

    /**
     * 其他的sql（会在最终的where后的 AND(otherSql) 拼接）
     */
    private String otherSql;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getDeleteName() {
        return deleteName;
    }

    public void setDeleteName(String deleteName) {
        this.deleteName = deleteName;
    }

    public Long getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(Long deleteId) {
        this.deleteId = deleteId;
    }

    public String getOrderKey() {
        //驼峰规则
        if(StringUtils.isEmpty(orderKey)){
            return null;
        }
        for (int i=0;i<orderKey.length();i++){
            char t = orderKey.charAt(i);
            if (Character.isUpperCase(t)){
                orderKey = orderKey.replace(t+"","_"+Character.toLowerCase(t));
            }
        }
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getFilterTimeKey() {
        return filterTimeKey;
    }

    public void setFilterTimeKey(String filterTimeKey) {
        this.filterTimeKey = filterTimeKey;
    }

    public String getOtherSql() {
        return otherSql;
    }

    public void setOtherSql(String otherSql) {
        this.otherSql = otherSql;
    }
}

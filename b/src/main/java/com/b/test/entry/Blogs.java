package com.b.test.entry;

import com.b.test.common.BaseBean;

import java.io.Serializable;


/**
* 
* 2018-11-20 14:42:09
* @author Mr.Auto
*/
public class Blogs extends BaseBean implements Serializable{

    /**
    * 
    */
    private Long id;

    /**
     * 逻辑字段
     */
    private String ids;
    
    /**
    * 
    */
    private String title;
    
    /**
    * 
    */
    private String number;

    /**
     * 逻辑字段
     */
    private String keyword;

    /**
     * 逻辑字段
     */
    private String labelNames;

    /**
     *
     */
    private String content;

    /**
     *
     */
    private Long readCount;
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    
    public String getNumber() {
        return this.number;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public String getLabelNames() {
        return labelNames;
    }

    public void setLabelNames(String labelNames) {
        this.labelNames = labelNames;
    }
}
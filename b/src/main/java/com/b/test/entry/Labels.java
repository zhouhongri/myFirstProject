package com.b.test.entry;


import com.b.test.common.BaseBean;

import java.io.Serializable;


/**
* 
* 2018-11-20 15:55:52
* @author Mr.Auto
*/
public class Labels extends BaseBean implements Serializable{

    /**
    * 
    */
    private Long id;
    
    /**
    * 
    */
    private String name;
    
    /**
    * 
    */
    private String color;
    
    /**
    * 
    */
    private Long blogId;


    /**
     * 逻辑字段
     */
    private String blogIds;

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
    
    public Long getBlogId() {
        return this.blogId;
    }

    public String getBlogIds() {
        return blogIds;
    }

    public void setBlogIds(String blogIds) {
        this.blogIds = blogIds;
    }
}
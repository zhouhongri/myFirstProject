package com.b.test.entry;


import com.b.test.common.BaseBean;

import java.io.Serializable;
import java.util.Date;


/**
* 
* 2018-11-23 11:11:54
* @author Mr.Auto
*/
public class Comment extends BaseBean implements Serializable{

    /**
    * 
    */
    private Long id;
    
    /**
    * 
    */
    private Long blogId;
    
    /**
    * 
    */
    private String commentContent;
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
    
    public Long getBlogId() {
        return this.blogId;
    }
    
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
    
    public String getCommentContent() {
        return this.commentContent;
    }
    
}
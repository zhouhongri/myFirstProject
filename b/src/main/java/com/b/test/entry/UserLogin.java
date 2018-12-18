package com.b.test.entry;


import com.b.test.common.BaseBean;

import java.io.Serializable;


/**
* 
* 2018-12-03 10:08:32
* @author Mr.Auto
*/
public class UserLogin extends BaseBean implements Serializable{

    /**
    * 
    */
    private Long id;
    
    /**
    * 
    */
    private String username;
    
    /**
    * 
    */
    private String password;
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    
}
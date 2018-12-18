package com.b.test.dao;

import com.b.test.entry.UserLogin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* 
* 2018-12-03 10:08:32
* @author Mr.Auto
*/
 public interface UserLoginDao {

    String SET = "<if test = 'id != null'> id = #{id},</if>" +
                 "<if test = 'username != null'> username = #{username},</if>" +
                 "<if test = 'password != null'> password = #{password},</if>";


    String WHERE = "<if test = 'id != null'> AND id = #{id}</if>" +
                   "<if test = 'username != null'> AND username = #{username}</if>" +
                   "<if test = 'password != null'> AND password = #{password}</if>" +
                   "<if test='filterTimeKey != null and filterTimeKey.length>0 and startTime != null and endTime != null'> AND ${filterTimeKey} between #{startTime} and #{endTime}</if>" +
                   "<if test='otherSql != null and otherSql.length>0'> AND (${otherSql}) </if>" +
                   "<if test='orderKey != null and orderKey.length>0 and orderType != null and orderType.length>0 '> ORDER BY ${orderKey} ${orderType}</if>";

    @Update("<script>" +
            "UPDATE `USER_LOGIN`" + 
            "<set>" +
            SET +
            "</set>" +
            "WHERE id = #{id}" +
            "</script>")
    Integer update(UserLogin userLogin);

    @Select("<script>" +
            "SELECT * FROM `USER_LOGIN`" +
            "<where>" +
            "1=1" +
            WHERE +
            "</where>" +
            "</script>")
    List<UserLogin> getByBean(UserLogin userLogin);

    @Select("<script>" +
            "SELECT * FROM `USER_LOGIN`" +
            "where id = #{id} "+
            "</script>")
    UserLogin getById(@Param(value = "id") Long id);

    @Delete("DELETE FROM `USER_LOGIN` WHERE id = #{id}")
    Integer delete(@Param(value = "id") Long id);

    @Insert("INSERT INTO `USER_LOGIN` (username,password)" +
            " VALUES(#{username},#{password})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Integer insert(UserLogin userLogin);

}
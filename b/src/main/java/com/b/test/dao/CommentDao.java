package com.b.test.dao;

import com.b.test.entry.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* 
* 2018-11-23 11:11:54
* @author Mr.Auto
*/
 public interface CommentDao {

    String SET = "<if test = 'id != null'> id = #{id},</if>" +
                 "<if test = 'blogId != null'> blog_id = #{blogId},</if>" +
                 "<if test = 'commentContent != null'> comment_content = #{commentContent},</if>" +
                 "<if test = 'createTime != null'> create_time = #{createTime},</if>";


    String WHERE = "<if test = 'id != null'> AND id = #{id}</if>" +
                   "<if test = 'blogId != null'> AND blog_id = #{blogId}</if>" +
                   "<if test = 'commentContent != null'> AND comment_content = #{commentContent}</if>" +
                   "<if test = 'createTime != null'> AND create_time = #{createTime}</if>" +
                   "<if test='filterTimeKey != null and filterTimeKey.length>0 and startTime != null and endTime != null'> AND ${filterTimeKey} between #{startTime} and #{endTime}</if>" +
                   "<if test='otherSql != null and otherSql.length>0'> AND (${otherSql}) </if>" +
                   "<if test='orderKey != null and orderKey.length>0 and orderType != null and orderType.length>0 '> ORDER BY ${orderKey} ${orderType}</if>";

    @Update("<script>" +
            "UPDATE `COMMENT`" + 
            "<set>" +
            SET +
            "</set>" +
            "WHERE id = #{id}" +
            "</script>")
    Integer update(Comment comment);

    @Select("<script>" +
            "SELECT * FROM `COMMENT`" +
            "<where>" +
            "1=1" +
            WHERE +
            "</where>" +
            "</script>")
    List<Comment> getByBean(Comment comment);

    @Select("<script>" +
            "SELECT * FROM `COMMENT`" +
            "where id = #{id} "+
            "</script>")
    Comment getById(@Param(value = "id") Long id);

    @Delete("DELETE FROM `COMMENT` WHERE id = #{id}")
    Integer delete(@Param(value = "id") Long id);

    @Insert("INSERT INTO `COMMENT` (blog_id,comment_content,create_time)" +
            " VALUES(#{blogId},#{commentContent},#{createTime})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Integer insert(Comment comment);

}
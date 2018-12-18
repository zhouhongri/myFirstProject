package com.b.test.dao;

import com.b.test.entry.Blogs;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 2018-11-20 14:49:24
 *
 * @author Mr.Auto
 */
public interface BlogsDao {

    String SET = "<if test = 'id != null'> id = #{id},</if>" +
            "<if test = 'title != null'> title = #{title},</if>" +
            "<if test = 'number != null'> number = #{number},</if>" +
            "<if test = 'createTime != null'> create_time = #{createTime},</if>" +
            "<if test = 'content != null'> content = #{content},</if>" +
            "<if test = 'readCount != null'> read_count = #{readCount},</if>";


    String WHERE = "<if test = 'id != null'> AND id = #{id}</if>" +
            "<if test = 'title != null'> AND title = #{title}</if>" +
            "<if test = 'number != null'> AND number = #{number}</if>" +
            "<if test = 'createTime != null'> AND create_time = #{createTime}</if>" +
            "<if test = 'content != null'> AND content = #{content}</if>" +
            "<if test = 'readCount != null'> AND read_count = #{readCount}</if>" +
            "<if test='keyword != null and keyword.length>0'> AND (title like '%${keyword}%')</if>" +
            "<if test='ids != null and ids.length>0'> AND FIND_IN_SET(id, #{ids})</if>" +
            "<if test='filterTimeKey != null and filterTimeKey.length>0 and startTime != null and endTime != null'> AND ${filterTimeKey} between #{startTime} and #{endTime}</if>" +
            "<if test='otherSql != null and otherSql.length>0'> AND (${otherSql}) </if>" +
            "<if test='orderKey != null and orderKey.length>0 and orderType != null and orderType.length>0 '> ORDER BY ${orderKey} ${orderType}</if>";

    @Update("<script>" +
            "UPDATE `BLOGS`" +
            "<set>" +
            SET +
            "</set>" +
            "WHERE id = #{id}" +
            "</script>")
    Integer update(Blogs blogs);

    @Select("<script>" +
            "SELECT * FROM `BLOGS`" +
            "<where>" +
            "1=1" +
            WHERE +
            "</where>" +
            "</script>")
    List<Blogs> getByBean(Blogs blogs);

    @Select("<script>" +
            "SELECT * FROM `BLOGS`" +
            "where id = #{id} " +
            "</script>")
    Blogs getById(@Param(value = "id") Long id);

    @Delete("DELETE FROM `BLOGS` WHERE id = #{id}")
    Integer delete(@Param(value = "id") Long id);

    @Insert("INSERT INTO `BLOGS` (title,number,create_time,content,read_count)" +
            " VALUES(#{title},#{number},#{createTime},#{content},#{readCount})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Integer insert(Blogs blogs);

}
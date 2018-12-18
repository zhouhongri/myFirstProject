package com.b.test.dao;

import com.b.test.entry.Labels;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 2018-11-20 15:55:47
 *
 * @author Mr.Auto
 */
public interface LabelsDao {

    String SET = "<if test = 'id != null'> id = #{id},</if>" +
            "<if test = 'name != null'> name = #{name},</if>" +
            "<if test = 'color != null'> color = #{color},</if>" +
            "<if test = 'blogId != null'> blog_id = #{blogId},</if>";


    String WHERE = "<if test = 'id != null'> AND id = #{id}</if>" +
            "<if test = 'name != null'> AND name = #{name}</if>" +
            "<if test = 'color != null'> AND color = #{color}</if>" +
            "<if test = 'blogId != null'> AND blog_id = #{blogId}</if>" +
            "<if test = 'blogIds != null and blogIds.length>0'> AND FIND_IN_SET(blog_id, #{blogIds})</if>" +
            "<if test='filterTimeKey != null and filterTimeKey.length>0 and startTime != null and endTime != null'> AND ${filterTimeKey} between #{startTime} and #{endTime}</if>" +
            "<if test='otherSql != null and otherSql.length>0'> AND (${otherSql}) </if>" +
            "<if test='orderKey != null and orderKey.length>0 and orderType != null and orderType.length>0 '> ORDER BY ${orderKey} ${orderType}</if>";

    @Update("<script>" +
            "UPDATE `LABELS`" +
            "<set>" +
            SET +
            "</set>" +
            "WHERE id = #{id}" +
            "</script>")
    Integer update(Labels labels);

    @Select("<script>" +
            "SELECT * FROM `LABELS`" +
            "<where>" +
            "1=1" +
            WHERE +
            "</where>" +
            "</script>")
    List<Labels> getByBean(Labels labels);

    @Select("<script>" +
            "SELECT * FROM `LABELS`" +
            "where id = #{id} " +
            "</script>")
    Labels getById(@Param(value = "id") Long id);

    @Delete("DELETE FROM `LABELS` WHERE id = #{id}")
    Integer delete(@Param(value = "id") Long id);

    @Insert("INSERT INTO `LABELS` (name,color,blog_id)" +
            " VALUES(#{name},#{color},#{blogId})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Integer insert(Labels labels);

    @Select("<script>" +
            "SELECT * FROM `LABELS`" +
            "<where>" +
            "1=1" +
            WHERE +
            "</where>" +
            "GROUP BY name" +
            "</script>")
    List<Labels> getGroupBeanByName(Labels labels);
}
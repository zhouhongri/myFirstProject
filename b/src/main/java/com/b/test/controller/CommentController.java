package com.b.test.controller;

import com.b.test.common.BaseController;
import com.b.test.common.PageInfo;
import com.b.test.entry.Comment;
import com.b.test.service.CommentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.annotation.Resource;

/**
* 
* 2018-11-23 11:11:54
* @author Mr.Auto
*/
@RestController
@RequestMapping("/api/comment")
public class CommentController extends BaseController {

    @Resource
    private CommentService commentService;

    /**
     * 新增
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Comment insert(@RequestBody Comment comment){
        return commentService.insert(comment);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Integer delete(Long id){
        return  commentService.delete(id);
    }

    /**
     * 获取信息
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Comment getById(Comment comment){
        return commentService.getById(comment);
    }

    /**
     * 根据bean获取信息
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/getByBean", method = RequestMethod.GET)
    public List<Comment> getByBean(Comment comment){
        return commentService.getByBean(comment);
    }

    /**
     * 更新信息
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public Integer update(Comment comment){
        return commentService.update(comment);
    }

    /**
     * 分页查询
     *
     * @param pageInfo 分页封装类对象
     * @param comment
     * @return
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageInfo<Comment> page(PageInfo<Comment> pageInfo, Comment comment) {
        return commentService.pageByBean(pageInfo, comment);
    }
}
package com.b.test.service;

import com.b.test.common.PageInfo;
import com.b.test.dao.CommentDao;
import com.b.test.entry.Comment;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* 
* 2018-11-23 11:11:54
* @author Mr.Auto
*/
@Service
public class CommentService {

    @Resource
    private CommentDao commentDao;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Exception.class)
    public Comment insert(Comment comment) {
        if (comment == null) {
            return null;
        }
        comment.setCreateTime(new Date());
        commentDao.insert(comment);
        return comment;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Exception.class)
    public Integer delete(Long id) {
        if (id == null) {
            return null;
        }
        return commentDao.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Exception.class)
    public Integer update(Comment comment) {
        if (comment == null) {
            return -1;
        }
        return commentDao.update(comment);
    }

    public Comment getById(Comment comment) {
        if (comment == null) {
            return null;
        }
        return commentDao.getById(comment.getId());
    }

    /**
     * 分页查询
     *
     * @param pageInfo
     * @return
     */
    public PageInfo<Comment> pageByBean(PageInfo<Comment> pageInfo, Comment comment) {
        if (pageInfo == null) {
            return null;
        }
        pageInfo.setObj(comment);
        Page<Comment> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        commentDao.getByBean(pageInfo.getObj());
        pageInfo.setTotal(page.getTotal());
        pageInfo.setResult(page.getResult());
        return pageInfo;
    }

    /**
     * 获得所有符合条件的
     *
     * @param comment
     * @return
     */
    public List<Comment> getByBean(Comment comment) {
        return commentDao.getByBean(comment);
    }
}
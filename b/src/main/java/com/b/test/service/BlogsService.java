package com.b.test.service;

import com.b.test.common.PageInfo;
import com.b.test.common.SessionUtil;
import com.b.test.common.StringUtils;
import com.b.test.dao.BlogsDao;
import com.b.test.entry.Blogs;
import com.b.test.entry.Labels;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 2018-11-20 14:49:24
 *
 * @author Mr.Auto
 */
@Service
public class BlogsService {

    @Resource
    private BlogsDao blogsDao;

    @Resource
    private LabelsService labelsService;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Exception.class)
    public Integer insert(Blogs blogs) {
        if (blogs == null) {
            return -1;
        }
        if (blogs.getId() != null) {
            update(blogs);
        }
        blogs.setCreateTime(new Date());
        blogs.setReadCount(0L);
        blogsDao.insert(blogs);
        if (StringUtils.isNotEmpty(blogs.getLabelNames())) {
            Labels labels = new Labels();
            labels.setBlogId(blogs.getId());
            String[] strs = blogs.getLabelNames().split(",");
            for (String str : strs) {
                labels.setName(str);
                labels.setColor(StringUtils.randomLabelColor());
                labelsService.insert(labels);
            }
        }
        return 1;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Exception.class)
    public Integer delete(Long id) {
        if (id == null) {
            return null;
        }
        return blogsDao.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Exception.class)
    public Integer update(Blogs blogs) {
        if (blogs == null) {
            return -1;
        }
        return blogsDao.update(blogs);
    }

    public Blogs getById(Blogs blogs) {
        if (blogs == null) {
            return null;
        }
        return blogsDao.getById(blogs.getId());
    }

    /**
     * 分页查询
     *
     * @param pageInfo
     * @return
     */
    public PageInfo<Blogs> pageByBean(PageInfo<Blogs> pageInfo, Blogs blogs) {
        if (pageInfo == null) {
            return null;
        }
        pageInfo.setObj(blogs);
        Page<Blogs> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        blogsDao.getByBean(pageInfo.getObj());
        pageInfo.setTotal(page.getTotal());
        pageInfo.setResult(page.getResult());
        return pageInfo;
    }

    /**
     * 获得所有符合条件的
     *
     * @param blogs
     * @return
     */
    public List<Blogs> getByBean(Blogs blogs) {
        return blogsDao.getByBean(blogs);
    }
}
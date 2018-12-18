package com.b.test.controller;

import com.b.test.common.BaseController;
import com.b.test.common.PageInfo;
import com.b.test.common.SessionUtil;
import com.b.test.common.StringUtils;
import com.b.test.entry.Blogs;
import com.b.test.service.BlogsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.annotation.Resource;

/**
 * 2018-11-20 14:49:24
 *
 * @author Mr.Auto
 */
@RestController
@RequestMapping("/api/blogs")
public class BlogsController extends BaseController {

    @Resource
    private BlogsService blogsService;

    /**
     * 获取信息
     *
     * @param blogs
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Integer insert(@RequestBody Blogs blogs) {
        return blogsService.insert(blogs);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Integer delete(Long id) {
        return blogsService.delete(id);
    }

    /**
     * 获取信息
     *
     * @param blogs
     * @return
     */
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Blogs getById(Blogs blogs) {
        return blogsService.getById(blogs);
    }

    /**
     * 根据bean获取信息
     *
     * @param blogs
     * @return
     */
    @RequestMapping(value = "/getByBean", method = RequestMethod.GET)
    public List<Blogs> getByBean(Blogs blogs) {
        return blogsService.getByBean(blogs);
    }

    /**
     * 更新信息
     *
     * @param blogs
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public Integer update(Blogs blogs) {
        return blogsService.update(blogs);
    }

    /**
     * 分页查询
     *
     * @param pageInfo 分页封装类对象
     * @param blogs
     * @return
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageInfo<Blogs> page(PageInfo<Blogs> pageInfo, Blogs blogs) {
        return blogsService.pageByBean(pageInfo, blogs);
    }

    /**
     * 更新阅读数
     *
     * @param blogs
     * @return
     */
    @RequestMapping(value = "/updateReadCount", method = RequestMethod.GET)
    public Blogs updateReadCount(Blogs blogs, String tempId) {
        if (blogs == null || blogs.getId() == null) {
            return null;
        }
        Blogs obj = blogsService.getById(blogs);
        String temp = (String) SessionUtil.get("blog" + tempId);
        if (StringUtils.isEmpty(temp)) {
            SessionUtil.put("blog" + tempId, "1", 30 * 60 * 1000L);
            obj.setReadCount(obj.getReadCount() + 1);
            blogsService.update(obj);
        }
        return obj;
    }
}
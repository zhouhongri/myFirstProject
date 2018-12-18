package com.b.test.controller;

import com.b.test.common.BaseController;
import com.b.test.common.PageInfo;
import com.b.test.entry.Labels;
import com.b.test.service.LabelsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

/**
* 
* 2018-11-20 14:49:49
* @author Mr.Auto
*/
@RestController
@RequestMapping("/api/labels")
public class LabelsController extends BaseController {

    @Resource
    private LabelsService labelsService;

    /**
     * 新增
     *
     * @param labels
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Integer insert(@RequestBody Labels labels){
        return labelsService.insert(labels);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Integer delete(Long id){
        return  labelsService.delete(id);
    }

    /**
     * 获取信息
     *
     * @param labels
     * @return
     */
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Labels getById(Labels labels){
        return labelsService.getById(labels);
    }

    /**
     * 根据bean获取信息
     *
     * @param labels
     * @return
     */
    @RequestMapping(value = "/getByBean", method = RequestMethod.GET)
    public List<Labels> getByBean(Labels labels){
        return labelsService.getByBean(labels);
    }

    /**
     * 根据bean获取信息
     *
     * @param labels
     * @return
     */
    @RequestMapping(value = "/getGroupBeanByName", method = RequestMethod.GET)
    public List<Labels> getGroupBeanByName(Labels labels){
        return labelsService.getGroupBeanByName(labels);
    }

    /**
     * 根据bean获取信息
     *
     * @param labels
     * @return
     */
    @RequestMapping(value = "/getByBlogId", method = RequestMethod.GET)
    public Map<String, Object> getByBlogId(Labels labels){
        return labelsService.getByBlogId(labels);
    }

    /**
     * 更新信息
     *
     * @param labels
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public Integer update(Labels labels){
        return labelsService.update(labels);
    }

    /**
     * 分页查询
     *
     * @param pageInfo 分页封装类对象
     * @param labels
     * @return
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageInfo<Labels> page(PageInfo<Labels> pageInfo, Labels labels) {
        return labelsService.pageByBean(pageInfo, labels);
    }
}
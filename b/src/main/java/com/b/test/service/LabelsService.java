package com.b.test.service;

import com.b.test.common.PageInfo;
import com.b.test.dao.LabelsDao;
import com.b.test.entry.Labels;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2018-11-20 14:49:49
 *
 * @author Mr.Auto
 */
@Service
public class LabelsService {

    @Resource
    private LabelsDao labelsDao;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Exception.class)
    public Integer insert(Labels labels) {
        if (labels == null) {
            return -1;
        }
        return labelsDao.insert(labels);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Exception.class)
    public Integer delete(Long id) {
        if (id == null) {
            return null;
        }
        return labelsDao.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Exception.class)
    public Integer update(Labels labels) {
        if (labels == null) {
            return -1;
        }
        return labelsDao.update(labels);
    }

    public Labels getById(Labels labels) {
        if (labels == null) {
            return null;
        }
        return labelsDao.getById(labels.getId());
    }

    /**
     * 分页查询
     *
     * @param pageInfo
     * @return
     */
    public PageInfo<Labels> pageByBean(PageInfo<Labels> pageInfo, Labels labels) {
        if (pageInfo == null) {
            return null;
        }
        pageInfo.setObj(labels);
        Page<Labels> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        labelsDao.getByBean(pageInfo.getObj());
        pageInfo.setTotal(page.getTotal());
        pageInfo.setResult(page.getResult());
        return pageInfo;
    }

    /**
     * 获得所有符合条件的
     *
     * @param labels
     * @return
     */
    public List<Labels> getByBean(Labels labels) {
        return labelsDao.getByBean(labels);
    }

    /**
     * 获得所有符合条件的
     *
     * @param labels
     * @return
     */
    public List<Labels> getGroupBeanByName(Labels labels) {
        return labelsDao.getGroupBeanByName(labels);
    }

    /**
     * 获得所有符合条件的
     *
     * @param labels
     * @return
     */
    public Map<String, Object> getByBlogId(Labels labels) {
        String[] strs = labels.getBlogIds().split(",");
        Map<String, Object> map = new HashMap();
        for (String str : strs) {
            Labels tempObj = new Labels();
            tempObj.setBlogId(Long.parseLong(str));
            List<Labels> labelsList = labelsDao.getByBean(tempObj);
            map.put(str, labelsList);
        }
        return map;
    }
}
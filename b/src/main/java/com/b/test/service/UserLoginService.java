package com.b.test.service;

import com.b.test.common.PageInfo;
import com.b.test.dao.UserLoginDao;
import com.b.test.entry.UserLogin;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
* 
* 2018-12-03 10:08:32
* @author Mr.Auto
*/
@Service
public class UserLoginService {

    @Resource
    private UserLoginDao userLoginDao;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Exception.class)
    public Integer insert(UserLogin userLogin) {
        if (userLogin == null) {
            return -1;
        }
        return userLoginDao.insert(userLogin);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Exception.class)
    public Integer delete(Long id) {
        if (id == null) {
            return null;
        }
        return userLoginDao.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Exception.class)
    public Integer update(UserLogin userLogin) {
        if (userLogin == null) {
            return -1;
        }
        return userLoginDao.update(userLogin);
    }

    public UserLogin getById(UserLogin userLogin) {
        if (userLogin == null) {
            return null;
        }
        return userLoginDao.getById(userLogin.getId());
    }

    /**
     * 分页查询
     *
     * @param pageInfo
     * @return
     */
    public PageInfo<UserLogin> pageByBean(PageInfo<UserLogin> pageInfo) {
        if (pageInfo == null) {
            return null;
        }
        Page<UserLogin> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        userLoginDao.getByBean(pageInfo.getObj());
        pageInfo.setTotal(page.getTotal());
        pageInfo.setResult(page.getResult());
        return pageInfo;
    }

    /**
     * 获得所有符合条件的
     *
     * @param userLogin
     * @return
     */
    public List<UserLogin> getByBean(UserLogin userLogin) {
        return userLoginDao.getByBean(userLogin);
    }
}
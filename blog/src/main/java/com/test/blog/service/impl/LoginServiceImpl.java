package com.test.blog.service.impl;

import com.test.blog.dao.UserDao;
import com.test.blog.entity.domain.User;
import com.test.blog.entity.result.ActionResult;
import com.test.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author gw
 * @Date 2020/8/4 17:07
 */
@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;
    @Override
    public ActionResult reg(User user) {
        ActionResult result = new ActionResult();
        if (userDao.addUser(user) > 0){
            result.setCode(200);
        }
        return result;
    }
}

package com.test.blog.service;

import com.test.blog.entity.domain.User;
import com.test.blog.entity.result.ActionResult;

/**
 * @Description
 * @Author gw
 * @Date 2020/8/4 17:06
 */

public interface LoginService {

    /**
     * 注册
     * @param user
     * @return
     */
    ActionResult reg(User user);
}

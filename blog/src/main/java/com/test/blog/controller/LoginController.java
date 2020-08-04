package com.test.blog.controller;

import com.test.blog.entity.domain.User;
import com.test.blog.entity.result.ActionResult;
import com.test.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author gw
 * @Date 2020/8/4 16:56
 * 登录、注册控制器
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "reg", produces = "application/json")
    public ActionResult register(@PathVariable User user){
        return loginService.reg(user);
    }
}

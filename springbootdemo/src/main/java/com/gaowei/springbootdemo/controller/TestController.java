package com.gaowei.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/30 17:14
 */
@RestController(value = "test")
public class TestController {

    @RequestMapping(value = "hello")
    public String test1(){
        return "hello springboot";
    }
}

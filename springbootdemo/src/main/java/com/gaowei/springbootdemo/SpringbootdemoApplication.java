package com.gaowei.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 主要是开启组件扫描和自动配置的功能
 * 相当于三个注解的组合：@Configuration 表明该类基于java类配置
 * @ComponentScan 开启组件扫描
 * @EnableAutoConfiguration 开启自动配置
 */
@SpringBootApplication
public class SpringbootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

}

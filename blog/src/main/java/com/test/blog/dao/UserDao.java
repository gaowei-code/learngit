package com.test.blog.dao;

import com.test.blog.entity.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author gw
 * @Date 2020/8/4 16:57
 */
@Mapper
public interface UserDao {
    /**
     * 添加新用户
     * @param user 新用户信息
     * @return
     */
    int addUser(User user);
}

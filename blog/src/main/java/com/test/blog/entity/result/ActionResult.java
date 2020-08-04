package com.test.blog.entity.result;

import lombok.Data;

/**
 * @Description
 * @Author gw
 * @Date 2020/8/4 17:02
 */
@Data
public class ActionResult<T> {

    /**状态码*/
    private int code;
    /**错误信息*/
    private String errMsg;
    /**数据*/
    private T data;
}

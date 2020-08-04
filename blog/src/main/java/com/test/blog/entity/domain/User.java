package com.test.blog.entity.domain;

import lombok.Data;

/**
 * 用户
 * @author gaowei
 */
@Data
public class User {

  private long id;
  private String username;
  private String password;
  private String nickname;
  private String avatar;
  private long limitType;
  private long status;
  private long createTime;
  private long updateTime;
  private long updateIp;
}

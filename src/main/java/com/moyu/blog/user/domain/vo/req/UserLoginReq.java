package com.moyu.blog.user.domain.vo.req;

import lombok.Data;

/**
 * @author LiuRC
 * @date 2024/8/22
 * description 用户登录请求体
 */
@Data
public class UserLoginReq {
    private String name;
    private String password;
}

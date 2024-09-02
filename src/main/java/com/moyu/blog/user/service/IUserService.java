package com.moyu.blog.user.service;

import com.moyu.blog.user.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.moyu.blog.user.domain.vo.req.UserLoginReq;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author liurc
 * @since 2024-08-21
 */
public interface IUserService extends IService<User> {

    void login(UserLoginReq requestParam);
}

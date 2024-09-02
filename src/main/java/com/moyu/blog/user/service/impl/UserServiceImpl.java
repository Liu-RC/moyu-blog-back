package com.moyu.blog.user.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyu.blog.user.dao.UserDao;
import com.moyu.blog.user.domain.entity.User;
import com.moyu.blog.user.domain.vo.req.UserLoginReq;
import com.moyu.blog.user.mapper.UserMapper;
import com.moyu.blog.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author liurc
 * @since 2024-08-21
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserDao userDao;

    @Override
    public void login(UserLoginReq requestParam) {
        String username = requestParam.getName();
        String password = requestParam.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            throw new IllegalArgumentException("用户名或密码不能为空");
        }
        User user = userDao.getUserByNameAndPassword(username, password);
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("用户名或密码错误");
        }
        StpUtil.login(user.getId());
    }
}

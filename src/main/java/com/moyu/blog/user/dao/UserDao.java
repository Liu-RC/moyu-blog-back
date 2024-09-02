package com.moyu.blog.user.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyu.blog.user.domain.entity.User;
import com.moyu.blog.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author LiuRC
 * @date 2024/8/22
 * description
 */
@Service
public class UserDao extends ServiceImpl<UserMapper, User> {

    public User getUserByNameAndPassword(String username, String password) {
        return lambdaQuery().eq(User::getName, username)
                .eq(User::getPassword, password)
                .one();
    }
}

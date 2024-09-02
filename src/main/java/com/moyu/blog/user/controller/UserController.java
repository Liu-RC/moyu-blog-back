package com.moyu.blog.user.controller;

import com.moyu.blog.common.convention.result.Result;
import com.moyu.blog.common.convention.result.Results;
import com.moyu.blog.user.domain.vo.req.UserLoginReq;
import com.moyu.blog.user.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author liurc
 * @since 2024-08-21
 */

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "用户相关接口")
public class UserController {

    private final IUserService userService;

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Result<?> login(@RequestBody UserLoginReq requestParam) {
        userService.login(requestParam);
        return Results.success().setMessage("用户登录成功");
    }



}

package com.moyu.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.moyu.blog.**.mapper")
public class MoyuBlogBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoyuBlogBackApplication.class, args);
    }

}

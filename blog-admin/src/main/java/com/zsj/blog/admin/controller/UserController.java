package com.zsj.blog.admin.controller;

import com.zsj.blog.admin.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsj.blog.admin.mapper.UserMapper;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserMapper userMapper;
}

package com.zsj.blog.admin.controller;

import com.zsj.blog.common.business.bo.UserBO;
import com.zsj.blog.common.business.service.SysConfigService;
import com.zsj.blog.common.business.service.SysUserService;
import com.zsj.blog.common.persistence.mybatis.entity.SysConfigEntity;
import com.zsj.blog.common.persistence.mybatis.entity.SysUserEntity;
import com.zsj.blog.common.persistence.mybatis.mapper.SysConfigMapper;
import com.zsj.blog.common.persistence.mybatis.mapper.SysUserMapper;
import com.zsj.blog.common.persistence.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private SysConfigService sysConfigService;

    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("hello")
    public String hello() {
        log.info("/user/hello()");
        return "hello";
    }
    @RequestMapping("hello1")
    public String hello1() {
        log.info("/user/hello1()");
        return "hello1";
    }

    @RequestMapping("findUser")
    public String findUser(@RequestParam Long user_id) {
        System.out.println("用户ID=" + user_id);
        log.info("/user/findUser()");
        UserBO user = sysUserService.findUserWithRole(user_id);
        log.info(user.getSysUser().getUsername());
        return "findUser()";
    }
}

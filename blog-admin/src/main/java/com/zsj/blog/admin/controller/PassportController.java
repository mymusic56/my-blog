package com.zsj.blog.admin.controller;

import com.zsj.blog.common.business.bo.UserBO;
import com.zsj.blog.common.business.service.SysUserService;
import com.zsj.blog.common.framework.object.ResponseVO;
import com.zsj.blog.common.persistence.mybatis.entity.SysConfigEntity;
import com.zsj.blog.common.persistence.mybatis.mapper.SysConfigMapper;
import com.zsj.blog.common.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Slf4j
@Controller
@RequestMapping("/passport")
public class PassportController {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Resource
    private SysUserService userService;

    @RequestMapping("login")
    public ModelAndView login(Model mode) {
        SysConfigEntity sysConfigEntity = sysConfigMapper.getByConfigKey("siteName");
        mode.addAttribute("enableKaptcha", true);
        return ResultUtil.view("/login");
    }

    @RequestMapping("signin")
    @ResponseBody
    public ResponseVO signin(@RequestParam(name = "username") String user_name, String password, boolean rememberMe, String kaptcha) {

        log.info("username=" + user_name + ",password=" + password);
        UserBO user = userService.getByUsername(user_name);
        log.info("查询结果：" + user.getUsername());
        return ResultUtil.success(null, "http://www.baidu.com");
    }
}

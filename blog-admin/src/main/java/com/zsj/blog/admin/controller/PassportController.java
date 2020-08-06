package com.zsj.blog.admin.controller;

import com.zsj.blog.common.business.bo.UserBO;
import com.zsj.blog.common.business.service.SysUserService;
import com.zsj.blog.common.framework.holder.RequestHolder;
import com.zsj.blog.common.framework.object.ResponseVO;
import com.zsj.blog.common.framework.property.AdminProperty;
import com.zsj.blog.common.persistence.mybatis.entity.SysConfigEntity;
import com.zsj.blog.common.persistence.mybatis.mapper.SysConfigMapper;
import com.zsj.blog.common.util.ResultUtil;
import com.zsj.blog.common.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.websocket.Session;

@Slf4j
@Controller
@RequestMapping("/passport")
public class PassportController {

    @Autowired
    private AdminProperty config;

    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Resource
    private SysUserService userService;

    @RequestMapping("login")
    public ModelAndView login(Model mode) {
        Subject subject = SecurityUtils.getSubject();
        //已认证
        if (subject.isAuthenticated()) {
            return ResultUtil.redirect("/");
        }
        SysConfigEntity sysConfigEntity = sysConfigMapper.getByConfigKey("siteName");
        mode.addAttribute("enableKaptcha", config.isEnableKaptcha());
        return ResultUtil.view("/login");
    }

    @RequestMapping("signin")
    @ResponseBody
    public ResponseVO signin(@RequestParam(name = "username", required = true) String user_name,
                             @RequestParam(required = true) String password, boolean rememberMe,
                             @RequestParam(name = "kaptcha", required = true) String input_kaptcha) {
        //验证验证码
        if (config.isEnableKaptcha()) {
            String kaptcha = SessionUtil.getKaptcha();
            if (kaptcha == null || kaptcha.isEmpty()) {
                return ResultUtil.error("验证码失效");
            }
            if (!kaptcha.equals(input_kaptcha.toLowerCase())) {
                return ResultUtil.error("验证码错误");
            }
            log.info("验证码正确");
            SessionUtil.removeKaptcha();
        }
        log.info("username=" + user_name + ",password=" + password);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(user_name, password, rememberMe);
        subject.login(token);
        System.out.println("subject.isAuthenticated() = " + subject.isAuthenticated());
        if (!subject.isAuthenticated()) {
            log.info("密码验证失败");
            return ResultUtil.error("密码验证失败");
        }
        log.info("登录成功");

        SavedRequest savedRequest = WebUtils.getSavedRequest(RequestHolder.getRequest());

        //回到初始页面
        String historyUrl = null;
        if (null != savedRequest) {
            if (!savedRequest.getMethod().equals("POST")) {
                historyUrl = savedRequest.getRequestUrl();
            }
        }
        log.info("historyUrl = " + historyUrl);
        return ResultUtil.success(null, historyUrl);
    }

    @GetMapping("logout")
    public ModelAndView logout(RedirectAttributes redirectAttributes) {
        //zai
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
        redirectAttributes.addAttribute("message", "您已安全退出");
        return ResultUtil.redirect("index");
    }
}

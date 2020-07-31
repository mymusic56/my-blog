package com.zsj.blog.admin.controller;

import com.zsj.blog.common.plugin.kaptcha.Captcha;
import com.zsj.blog.common.plugin.kaptcha.GifCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Slf4j
public class KaptchaController {

    @RequestMapping("/getKaptcha")
    @ResponseBody
    public void getKaptcha(HttpServletResponse response) {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/gif");
        /**
         * gif格式动画验证码
         * 宽，高，位数。
         */
        Captcha captcha = new GifCaptcha(146,33,4);
        //输出
        try {
            captcha.out(response.getOutputStream());
            String captchaString = captcha.text();
            //TODO captcha存入session
            log.info(captchaString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

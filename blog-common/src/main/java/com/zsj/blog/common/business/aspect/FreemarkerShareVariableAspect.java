package com.zsj.blog.common.business.aspect;

import com.zsj.blog.common.business.enums.ConfigKeyEnum;
import com.zsj.blog.common.business.service.SysConfigService;
import com.zsj.blog.common.persistence.mybatis.entity.SysConfigEntity;
import com.zsj.blog.common.persistence.mybatis.mapper.SysConfigMapper;
import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Slf4j
@Order(1)
public class FreemarkerShareVariableAspect {

    private static volatile long configLastUpdateTime = 0L;

    @Autowired
    protected Configuration configuration;

    @Autowired
    SysConfigService sysConfigService;

    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.GetMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointcut(){

    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint){
        log.info("=====加载全部配置=====");
        Map<String, Object> configs = sysConfigService.getConfigs();
        if (configs == null) {
            log.error("config为空");
            return;
        }

        Long lastUpdateTime = ((Date) configs.get(ConfigKeyEnum.UPDATE_TIME.getKey())).getTime();
        if (lastUpdateTime >= configLastUpdateTime) {
            log.debug("config表未更新");
            return;
        }

        configLastUpdateTime = lastUpdateTime;
        try {
            configuration.setSharedVariable("config", configs);
        } catch (TemplateModelException e) {
            e.printStackTrace();
        }
    }
}

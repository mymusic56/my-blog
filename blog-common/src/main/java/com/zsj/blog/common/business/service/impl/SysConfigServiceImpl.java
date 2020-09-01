package com.zsj.blog.common.business.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.zsj.blog.common.business.consts.DateFormatConst;
import com.zsj.blog.common.business.enums.ConfigKeyEnum;
import com.zsj.blog.common.business.service.SysConfigService;
import com.zsj.blog.common.persistence.mybatis.entity.SysConfigEntity;
import com.zsj.blog.common.persistence.mybatis.mapper.SysConfigMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    SysConfigMapper sysConfigMapper;

    @Override
    public SysConfigEntity getByConfigKey(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        return sysConfigMapper.getByConfigKey(key);
    }

    @Override
    public Map<String, Object> getConfigs() {
        List<SysConfigEntity> configs = sysConfigMapper.getAll();
//        configs.forEach((sysConfig) -> {
//            log.info(sysConfig.getConfigKey() + "=" + sysConfig.getConfigValue());
//        });
        Map<String, Object> result = new HashMap<>();
        String lastUpdateKey = ConfigKeyEnum.UPDATE_TIME.getKey();
        //给一个默认时间
        result.put(lastUpdateKey, DateUtil.parse("2015-08-31 00:05:29", DateFormatConst.YYYY_MM_DD_HH_MM_SS_EN));
        configs.forEach((sysConfig) -> {
            result.put(String.valueOf(sysConfig.getConfigKey()), sysConfig.getConfigValue());
            //更新最后一次更新时间, sysConfig.getUpdateTime()为空，会有nullPointerException,导致程序执行异常
            if (sysConfig.getUpdateTime() != null && sysConfig.getUpdateTime().after(((Date) result.get(lastUpdateKey)))) {
                result.put(lastUpdateKey, sysConfig.getUpdateTime());
                log.info("更新时间" + sysConfig.getUpdateTime());
            }
        });
        return result;
    }
}

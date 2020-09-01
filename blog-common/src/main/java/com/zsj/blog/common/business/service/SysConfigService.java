package com.zsj.blog.common.business.service;

import com.zsj.blog.common.persistence.mybatis.entity.SysConfigEntity;

import java.util.Map;

public interface SysConfigService {

    public SysConfigEntity getByConfigKey(String key);
    public Map<String, Object> getConfigs();

}

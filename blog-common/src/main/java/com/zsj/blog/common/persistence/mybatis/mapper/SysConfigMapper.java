package com.zsj.blog.common.persistence.mybatis.mapper;

import com.zsj.blog.common.persistence.mybatis.entity.SysConfigEntity;

import java.util.List;

public interface SysConfigMapper {
    public List<SysConfigEntity> getAll();
    public SysConfigEntity getByConfigKey(String key);
}

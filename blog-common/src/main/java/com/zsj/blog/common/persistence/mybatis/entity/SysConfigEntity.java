package com.zsj.blog.common.persistence.mybatis.entity;

import com.zsj.blog.common.framework.object.AbstractDO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysConfigEntity extends AbstractDO {

    private String configKey;
    private String configValue;
}

package com.zsj.blog.common.persistence.mybatis.entity;

import com.zsj.blog.common.framework.object.AbstractDO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;

@Getter
@Setter
public class SysRoleEntity extends AbstractDO {
    private String name;
    private String description;
    private Boolean available;

    @Transient
    private Integer selected;
}

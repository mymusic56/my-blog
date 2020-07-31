package com.zsj.blog.common.business.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.zsj.blog.common.framework.object.AbstractBO;
import com.zsj.blog.common.persistence.mybatis.entity.SysRoleEntity;

import java.util.Date;

public class RoleBO extends AbstractBO {
    private SysRoleEntity sysRole;

    public RoleBO() {
        this.sysRole = new SysRoleEntity();
    }

    public RoleBO(SysRoleEntity sysRole) {
        this.sysRole = sysRole;
    }

    @JsonIgnore
    public SysRoleEntity getSysRole() {
        return this.sysRole;
    }

    public Long getId() {
        return this.sysRole.getId();
    }

    public void setId(Long id) {
        this.sysRole.setId(id);
    }

    public String getName() {
        return this.sysRole.getName();
    }

    public void setName(String name) {
        this.sysRole.setName(name);
    }


    public String getDescription() {
        return this.sysRole.getDescription();
    }

    public void setDescription(String description) {
        this.sysRole.setDescription(description);
    }

    public boolean isAvailable() {
        Boolean value = this.sysRole.getAvailable();
        return value != null ? value : false;
    }

    public void setAvailable(boolean available) {
        this.sysRole.setAvailable(available);
    }

    public Date getCreateTime() {
        return this.sysRole.getCreateTime();
    }

    public void setCreateTime(Date regTime) {
        this.sysRole.setCreateTime(regTime);
    }

    public Date getUpdateTime() {
        return this.sysRole.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.sysRole.setUpdateTime(updateTime);
    }

}

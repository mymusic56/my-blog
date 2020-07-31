package com.zsj.blog.common.persistence.mybatis.entity;

import com.zsj.blog.common.framework.object.AbstractDO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import java.util.List;

@Getter
@Setter
public class SysResourcesEntity extends AbstractDO {
    private String name;
    private String type;
    private String url;
    private String permission;
    private Long parentId;
    private Integer sort;
    private Boolean external;
    private Boolean available;
    private String icon;

    @Transient
    private String checked;
    @Transient
    private SysResourcesEntity parent;
    @Transient
    private List<SysResourcesEntity> nodes;
}

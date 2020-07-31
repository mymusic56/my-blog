package com.zsj.blog.common.framework.object;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class AbstractDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Date createTime;
    private Date updateTime;
}

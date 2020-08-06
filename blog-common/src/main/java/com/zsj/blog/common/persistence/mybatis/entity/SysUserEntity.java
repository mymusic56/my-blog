package com.zsj.blog.common.persistence.mybatis.entity;

import com.zsj.blog.common.framework.object.AbstractDO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Table(name = "sys_user")
public class SysUserEntity extends AbstractDO {
    private String username;
    private String password;
    private String nickname;
    private String mobile;
    private String email;
    private String qq;
    private Date birthday;
    private Integer gender;
    private String avatar;
    private String userType;
    private String company;
    private String blog;
    private String location;
    private String source;
    private String uuid;
    private Integer privacy;
    private Integer notification;
    private Integer score;
    private Integer experience;
    private String regIp;
    private String lastLoginIp;
    private Date lastLoginTime;
    private Integer loginCount;
    private String remark;
    private Integer status;
    private String salt;
}

package com.zsj.blog.common.business.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zsj.blog.common.framework.object.AbstractBO;
import com.zsj.blog.common.persistence.mybatis.entity.SysUserEntity;
import com.zsj.blog.common.util.PasswordUtil;
import org.springframework.util.StringUtils;

import java.util.Date;

public class UserBO extends AbstractBO {
    private SysUserEntity sysUserEntity;

    public UserBO() {
        this.sysUserEntity = new SysUserEntity();
    }

    public UserBO(SysUserEntity sysUserEntity) {
        this.sysUserEntity = sysUserEntity;
    }

    public UserBO(String loginname, String password) {
        this();
        setUsername(loginname);
        if (!StringUtils.isEmpty(password)) {
            try {
                String salt = "";
                setPassword(PasswordUtil.getEncryptPassword(salt, loginname));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @JsonIgnore
    public SysUserEntity getSysUser() {
        return this.sysUserEntity;
    }

    public Long getId() {
        return this.sysUserEntity.getId();
    }

    public void setId(Long id) {
        this.sysUserEntity.setId(id);
    }

    public String getNickname() {
        return this.sysUserEntity.getNickname();
    }

    public void setNickname(String nickname) {
        this.sysUserEntity.setNickname(nickname);
    }

    public String getMobile() {
        return this.sysUserEntity.getMobile();
    }

    public void setMobile(String mobile) {
        this.sysUserEntity.setMobile(mobile);
    }

    public String getUsername() {
        return this.sysUserEntity.getUsername();
    }

    public void setUsername(String username) {
        this.sysUserEntity.setUsername(username);
    }

    public String getPassword() {
        return this.sysUserEntity.getPassword();
    }

    public void setPassword(String password) {
        this.sysUserEntity.setPassword(password);
    }

    public String getEmail() {
        return this.sysUserEntity.getEmail();
    }

    public void setEmail(String email) {
        this.sysUserEntity.setEmail(email);
    }

    public String getQq() {
        return this.sysUserEntity.getQq();
    }

    public void setQq(String qq) {
        this.sysUserEntity.setQq(qq);
    }

    public Date getBirthday() {
        return this.sysUserEntity.getBirthday();
    }

    public void setBirthday(Date birthday) {
        this.sysUserEntity.setBirthday(birthday);
    }

    public Integer getGender() {
        return this.sysUserEntity.getGender();
    }


    public void setGender(Integer Gender) {
        this.sysUserEntity.setGender(Gender);
    }

    public String getAvatar() {
        return this.sysUserEntity.getAvatar();
    }

    public void setAvatar(String avatar) {
        this.sysUserEntity.setAvatar(avatar);
    }

    public Integer getPrivacy() {
        return this.sysUserEntity.getPrivacy();
    }

    public void setPrivacy(Integer privacy) {
        this.sysUserEntity.setPrivacy(privacy);
    }


    public Integer getNotification() {
        return this.sysUserEntity.getNotification();
    }

    public void setNotification(Integer notification) {
        this.sysUserEntity.setNotification(notification);
    }


    public String getUserType() {
        return this.sysUserEntity.getUserType();
    }

    public void setUserType(String userType) {
        this.sysUserEntity.setUserType(userType);
    }


    public String getCompany() {
        return this.sysUserEntity.getCompany();
    }

    public void setCompany(String company) {
        this.sysUserEntity.setCompany(company);
    }

    public String getBlog() {
        return this.sysUserEntity.getBlog();
    }

    public void setBlog(String blog) {
        this.sysUserEntity.setBlog(blog);
    }

    public String getLocation() {
        return this.sysUserEntity.getLocation();
    }

    public void setLocation(String location) {
        this.sysUserEntity.setLocation(location);
    }

    public String getSource() {
        return this.sysUserEntity.getSource();
    }

    public void setSource(String source) {
        this.sysUserEntity.setSource(source);
    }

    public void setUuid(String uuid) {
        this.sysUserEntity.setUuid(uuid);
    }

    public String getUuid() {
        return this.sysUserEntity.getUuid();
    }

    public Integer getScore() {
        return this.sysUserEntity.getScore();
    }

    public void setScore(Integer score) {
        this.sysUserEntity.setScore(score);
    }

    public Integer getExperience() {
        return this.sysUserEntity.getExperience();
    }

    public void setExperience(Integer experience) {
        this.sysUserEntity.setExperience(experience);
    }

    public String getRegIp() {
        return this.sysUserEntity.getRegIp();
    }

    public void setRegIp(String regIp) {
        this.sysUserEntity.setRegIp(regIp);
    }

    public String getLastLoginIp() {
        return this.sysUserEntity.getLastLoginIp();
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.sysUserEntity.setLastLoginIp(lastLoginIp);
    }

    public Date getLastLoginTime() {
        return this.sysUserEntity.getLastLoginTime();
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.sysUserEntity.setLastLoginTime(lastLoginTime);
    }

    public Integer getLoginCount() {
        return this.sysUserEntity.getLoginCount();
    }

    public void setLoginCount(Integer loginCount) {
        this.sysUserEntity.setLoginCount(loginCount);
    }

    public String getRemark() {
        return this.sysUserEntity.getRemark();
    }

    public void setRemark(String remark) {
        this.sysUserEntity.setRemark(remark);
    }

    public Integer getStatus() {
        return this.sysUserEntity.getStatus();
    }

    public void setStatus(Integer status) {
        this.sysUserEntity.setStatus(status);
    }

    public Date getCreateTime() {
        return this.sysUserEntity.getCreateTime();
    }

    public void setCreateTime(Date regTime) {
        this.sysUserEntity.setCreateTime(regTime);
    }

    public Date getUpdateTime() {
        return this.sysUserEntity.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.sysUserEntity.setUpdateTime(updateTime);
    }

    public String getSalt(){
        return this.sysUserEntity.getUsername() + this.sysUserEntity.getSalt();
    }
}

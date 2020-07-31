package com.zsj.blog.common.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.zsj.blog.common.business.bo.UserBO;
import com.zsj.blog.common.business.service.SysUserService;
import com.zsj.blog.common.business.vo.UserVO;
import com.zsj.blog.common.persistence.mybatis.entity.SysUserEntity;
import com.zsj.blog.common.persistence.mybatis.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 用户
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public PageInfo<UserBO> findPageBreakByCondition(UserVO vo) {
        return null;
    }

    @Override
    public UserBO getByUsername(String username) {
        SysUserEntity userEntity = sysUserMapper.findByUsername(username);
        return userEntity == null ? null : new UserBO(userEntity);
    }


    @Override
    public UserBO insert(UserBO entity) {
        return null;
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean updateSelective(UserBO user) {
        return false;
    }

    @Override
    public UserBO getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不能为空！");
        SysUserEntity user = sysUserMapper.selectByPrimaryKey(primaryKey);
        return user == null ? null : new UserBO(user);
    }
}

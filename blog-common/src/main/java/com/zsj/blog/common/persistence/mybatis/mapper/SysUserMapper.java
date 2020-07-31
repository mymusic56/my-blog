package com.zsj.blog.common.persistence.mybatis.mapper;

import com.zsj.blog.common.business.vo.UserVO;
import com.zsj.blog.common.persistence.mybatis.entity.SysUserEntity;
import com.zsj.blog.common.plugin.BaseMapper;

import java.util.List;

public interface SysUserMapper {

    List<SysUserEntity> findPageBreakByCondition(UserVO vo);

    List<SysUserEntity> listByRoleId(Long roleId);

    SysUserEntity selectByPrimaryKey(Long id);

    SysUserEntity findByUsername(String username);
}

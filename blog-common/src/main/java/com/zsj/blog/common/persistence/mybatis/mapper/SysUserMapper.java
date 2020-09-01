package com.zsj.blog.common.persistence.mybatis.mapper;

import com.zsj.blog.common.business.vo.UserVO;
import com.zsj.blog.common.persistence.mybatis.entity.SysUserEntity;
import com.zsj.blog.common.plugin.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysUserMapper {

    List<SysUserEntity> findPageBreakByCondition(UserVO vo);

    List<SysUserEntity> listByRoleId(Long roleId);

    SysUserEntity findUserWithRole(Long userId);

    SysUserEntity selectByPrimaryKey(Long id);

    SysUserEntity findByUsername(String username);

    @Select("select * from sys_user where username=#{username}")
    SysUserEntity findByUsernameV2(String username);
}

package com.zsj.blog.common.persistence.mybatis.mapper;

import com.zsj.blog.common.business.vo.RoleVO;
import com.zsj.blog.common.persistence.mybatis.entity.SysRoleEntity;

import java.util.List;

public interface SysRoleMapper {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    List<SysRoleEntity> findPageBreakByCondition(RoleVO vo);

    List<SysRoleEntity> queryRoleListWithSelected(Integer userId);

    List<SysRoleEntity> listRolesByUserId(Long userId);
}

package com.zsj.blog.common.business.service;


import com.github.pagehelper.PageInfo;
import com.zsj.blog.common.business.bo.UserBO;
import com.zsj.blog.common.business.vo.UserVO;
import com.zsj.blog.common.framework.object.AbstractService;

public interface SysUserService extends AbstractService<UserBO, Long> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<UserBO> findPageBreakByCondition(UserVO vo);

    UserBO getByUsername(String username);
}

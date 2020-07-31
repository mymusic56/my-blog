package com.zsj.blog.common.persistence.mybatis.mapper;

import com.zsj.blog.common.business.vo.ResourceVO;
import com.zsj.blog.common.persistence.mybatis.entity.SysResourcesEntity;

import java.util.List;
import java.util.Map;

public interface SysResourceMapper {
    /**
     * 分页查询
     * @param vo
     * @return
     */
    List<SysResourcesEntity> findPageBreakByCondition(ResourceVO vo);

    List<SysResourcesEntity> listUserResources(Map<String, Object> map);

    List<SysResourcesEntity> queryResourcesListWithSelected(Long rid);

    List<SysResourcesEntity> listUrlAndPermission();

    List<SysResourcesEntity> listAllAvailableMenu();

    List<SysResourcesEntity> listByUserId(Long userId);
}

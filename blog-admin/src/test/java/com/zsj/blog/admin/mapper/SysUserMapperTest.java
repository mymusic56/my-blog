package com.zsj.blog.admin.mapper;

import com.zsj.blog.common.business.bo.UserBO;
import com.zsj.blog.common.business.service.SysUserService;
import com.zsj.blog.common.persistence.mybatis.entity.SysUserEntity;
import com.zsj.blog.common.persistence.mybatis.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SysUserMapperTest {

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysUserMapper userMapper;

    @Test
    public void testUserService() {
        UserBO user = userService.getByPrimaryKey(3L);
        if (user != null) {
            System.out.println(user.getNickname());
        } else {
            //使用
            System.out.println("查询失败");
        }
    }

    @Test
    public void testSelectByPrimaryKey() {
        SysUserEntity user = userMapper.selectByPrimaryKey(2L);
        if (user != null) {
            System.out.println(user.getNickname());
        } else {
            System.out.println("查询失败");
        }
    }

}

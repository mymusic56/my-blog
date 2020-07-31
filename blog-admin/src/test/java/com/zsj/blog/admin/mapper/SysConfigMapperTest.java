package com.zsj.blog.admin.mapper;

import com.zsj.blog.common.persistence.mybatis.entity.SysConfigEntity;
import com.zsj.blog.common.persistence.mybatis.mapper.SysConfigMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SysConfigMapperTest {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Test
    public void testGetAll() {
        List<SysConfigEntity> sysConfigEntityList = sysConfigMapper.getAll();
        for (SysConfigEntity a : sysConfigEntityList) {
            System.out.println(a.getConfigKey() + ", value=" + a.getConfigValue());
        }
    }
}

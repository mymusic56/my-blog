package com.zsj.blog.admin.mapper;

import com.zsj.blog.admin.entity.UserEntity;
import com.zsj.blog.common.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("wangwu");
        userEntity.setNickName("王五");
        userEntity.setName("王五");
        userEntity.setPassword("123456");
        userEntity.setUserSex(1);
        userEntity.setRole_id(1);
        userEntity.setCreated_at(DateUtil.getTimestamp());
        userMapper.insert(userEntity);
        System.out.println("新插入用户ID："+userEntity.getId());
    }

    @Test
    public void getAll(){
        List<UserEntity> userList = userMapper.getAll();
        for (UserEntity u: userList) {
            System.out.println(u.toString());
        }
    }
}

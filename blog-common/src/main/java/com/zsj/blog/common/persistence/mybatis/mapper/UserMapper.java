package com.zsj.blog.common.persistence.mybatis.mapper;


import com.zsj.blog.common.persistence.mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    List<UserEntity> getAll();

    UserEntity getById(Long id);

    @Select("select * from users where user_name=#{username}")
    UserEntity getByUsername(String username);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);
}

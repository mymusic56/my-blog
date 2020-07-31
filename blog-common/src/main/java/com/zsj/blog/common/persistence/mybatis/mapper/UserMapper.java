package com.zsj.blog.common.persistence.mybatis.mapper;


import com.zsj.blog.common.persistence.mybatis.entity.UserEntity;

import java.util.List;

public interface UserMapper {
    List<UserEntity> getAll();

    UserEntity getById(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);
}

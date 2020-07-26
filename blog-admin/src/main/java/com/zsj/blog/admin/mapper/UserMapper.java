package com.zsj.blog.admin.mapper;

import com.zsj.blog.admin.entity.UserEntity;

import java.util.List;

public interface UserMapper {
    List<UserEntity> getAll();

    UserEntity getById(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);
}

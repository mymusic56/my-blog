package com.zsj.blog.common.persistence.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String userName;
    private String name;

    private String nickName;
    private String password;

    private int userSex;

    private String email;

    private int role_id;

    private int created_at;
    private int updated_at;

    public UserEntity(){

    }

    public UserEntity(String userName, String name, String password, int sex){
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.userSex = sex;
    }

    public Date getDateTime (int created_at){
        return new Date(created_at);
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("id=").append(id);
        sb.append(", user_name=").append(userName);
        sb.append(", name=").append(name);
        sb.append(", nickName=").append(nickName);
        sb.append(", created_at=").append(getDateTime(created_at));
        sb.append(", user_sex=").append(userSex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}

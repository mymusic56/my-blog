package com.zsj.blog.common.business.enums;

public enum ConfigKeyEnum {
    /**
     * 系统最后一次更新的日期
     */
    UPDATE_TIME("updateTime");

    private String key;

    ConfigKeyEnum(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}

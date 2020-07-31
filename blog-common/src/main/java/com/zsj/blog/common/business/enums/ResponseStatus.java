package com.zsj.blog.common.business.enums;

public enum ResponseStatus {

    SUCCESS(200, "操作成功"),
    ERROR(500, "服务器未知错误!");

    private Integer code;
    private String message;

    ResponseStatus (Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

package com.zsj.blog.common.util;

import com.zsj.blog.common.business.enums.ResponseStatus;
import com.zsj.blog.common.framework.object.ResponseVO;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public class ResultUtil {

    public static ModelAndView view(String view) {
        return new ModelAndView(view);
    }

    public static ResponseVO vo(int code, String message, Object data) {
        return new ResponseVO<>(code, message, data);
    }

    public static ResponseVO success(String message, Object data) {
        return vo(ResponseStatus.SUCCESS.getCode(), message == null ? ResponseStatus.SUCCESS.getMessage() : message, data);
    }
    public static ResponseVO    error(String message) {
        return vo(ResponseStatus.ERROR.getCode(), message, null);
    }
    public static ResponseVO error(String message, Object data) {
        return vo(ResponseStatus.ERROR.getCode(), message, data);
    }
    public static ResponseVO error(String message, int code) {
        return vo(code, message, null);
    }
    public static ResponseVO error(String message, int code, Object data) {
        return vo(code, message, data);
    }

    public static ModelAndView redirect(String view){
        return new ModelAndView("redirect:" + view);
    }
}

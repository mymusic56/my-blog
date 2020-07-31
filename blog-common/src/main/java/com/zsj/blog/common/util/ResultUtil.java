package com.zsj.blog.common.util;

import com.zsj.blog.common.business.enums.ResponseStatus;
import com.zsj.blog.common.framework.object.ResponseVO;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public class ResultUtil {

    public static ModelAndView view(String view){
        return new ModelAndView(view);
    }
    public static ResponseVO vo(int code, String message, Object data) {
        return new ResponseVO<>(code, message, data);
    }
    public static ResponseVO success(String message, Object data){
        return vo(ResponseStatus.SUCCESS.getCode(), message == null ? ResponseStatus.SUCCESS.getMessage() : message, data);
    }
}

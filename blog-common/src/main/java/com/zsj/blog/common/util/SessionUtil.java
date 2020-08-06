package com.zsj.blog.common.util;

import com.zsj.blog.common.business.consts.SessionConst;
import com.zsj.blog.common.framework.holder.RequestHolder;

public class SessionUtil {

    public static String getKaptcha(){
        return (String)RequestHolder.getSession(SessionConst.KAPTCHA_SESSION_KEY);
    }

    public static void setKaptcha(String kaptcha){
        RequestHolder.setSession(SessionConst.KAPTCHA_SESSION_KEY, kaptcha);
    }

    public static void removeKaptcha(){
        RequestHolder.removeSession(SessionConst.KAPTCHA_SESSION_KEY);
    }
}

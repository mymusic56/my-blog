package com.zsj.blog.admin.core.shiro.realm;

import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroUtil {
    public static String enpcrytPassword(String pwd, String salt, int hashIterations) {
        SimpleHash hash = new SimpleHash("md5", pwd,  salt, hashIterations);
        return hash.toString();
    }
}

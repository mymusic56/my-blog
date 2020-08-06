package com.zsj.blog.admin.mapper;

import com.zsj.blog.admin.core.shiro.realm.ShiroRealm;
import com.zsj.blog.admin.core.shiro.realm.ShiroUtil;
import com.zsj.blog.common.persistence.mybatis.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {
        "com.zsj.blog.admin",
        "com.zsj.blog.common"
})
public class UsernamePasswordTest {

    @Autowired
    private ShiroRealm shiroRealm;

    @Test
    public void generatePwd() {
        String username = "admin";
        String pwd = "123456";
        String salt = "9x2Kx";
        String hash2 = ShiroUtil.enpcrytPassword(pwd, username + salt, 2);
        System.out.println("hash2 = " + hash2);
    }

    @Test
    public void loginTest() {
        String username = "admin";
        String pwd = "123456";
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        defaultSecurityManager.setRealm(shiroRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();


        UsernamePasswordToken token = new UsernamePasswordToken(username, pwd, false);
        subject.login(token);

        SysUserEntity u = (SysUserEntity)subject.getPrincipal();
        System.out.println("user_name = " + u.getUsername());

        boolean isAuthenticated = subject.isAuthenticated();
        System.out.println("isAuthenticated = " + subject.isAuthenticated());

        //退出操作
        subject.logout();

        // 是否认证通过
        isAuthenticated = subject.isAuthenticated();
        System.out.println("是否认证通过：" + isAuthenticated);
    }
}

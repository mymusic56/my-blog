package com.zsj.blog.admin.core.shiro.realm;

import com.zsj.blog.common.business.bo.UserBO;
import com.zsj.blog.common.business.service.SysUserService;
import com.zsj.blog.common.persistence.mybatis.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class ShiroRealm extends AuthorizingRealm {
    @Resource
    private SysUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->ShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        Long userId = (Long) SecurityUtils.getSubject().getPrincipal();
        UserBO user = userService.getByPrimaryKey(userId);

        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("----->>ShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
        System.out.println("----->>username=" + username);
        System.out.println("----->>getCredentials=" + token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserBO userBO = userService.getByUsername(username);
        SysUserEntity userInfo = userBO != null ? userBO.getSysUser() : null;
        if (userInfo == null) {
            System.out.println("----->>getName=【" + username + "】不存在");
            return null;
        }
        System.out.println("----->>getName=" + userInfo.getNickname());
        //明文认证
//        SimpleAuthenticationInfo authenticationInfo1 = new SimpleAuthenticationInfo(
//                userInfo, //用户名
//                userInfo.getPassword(), //密码
//                getName()  //realm name
//        );
        System.out.println("getName() = " + getName());
        System.out.println("salt:" + userInfo.getSalt() + ",pwd:" + userInfo.getPassword());
        //hash加密认证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getUsername() + userInfo.getSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

}
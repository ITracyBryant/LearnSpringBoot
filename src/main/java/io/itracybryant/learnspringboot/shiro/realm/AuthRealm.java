package io.itracybryant.learnspringboot.shiro.realm;

import io.itracybryant.learnspringboot.shiro.entity.ShiroUser;
import io.itracybryant.learnspringboot.shiro.service.ShiroUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName AuthRealm
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/27 15:31
 * @Version 1.0
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private ShiroUserService shiroUserService;

    /**
     * 权限校验相关
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    /**
     * 身份认证相关
     * <p>
     * 1.从Token中获取用户名和密码
     * 2.通过输入的用户名查询数据库得到密码
     * 3.调用Authentication进行密码校验
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名和密码
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        ShiroUser shiroUser = shiroUserService.findByUsername(username);
        if (shiroUser == null) {
            throw new UnknownAccountException();
        } else if (!password.equals(shiroUser.getPassword())) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(shiroUser, password, getName());
    }
}

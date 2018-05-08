package com.lk.play.common.security;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.lk.play.common.service.SystemService;
import com.lk.play.user.entity.User;
import com.lk.play.user.service.RoleService;
import com.lk.play.user.service.UserService;

/**
 * 自定义realm
 * 测试git有没有提交
 * @author Administrator
 *
 */
public class MyRealm extends AuthorizingRealm {
	
	@Resource
	private UserService userService;
	
	@Resource
	private RoleService rolerService;
	
	@Resource
	private SystemService systemService;
    
	/**
	 * 权限验证时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取用户名
        String userName=(String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        User user = userService.getByUserName(userName);
        //进行授权角色
        authorizationInfo.addRole(rolerService.getRole(user.getId()));
        System.out.println("角色："+rolerService.getRole(user.getId()));
        //进行授权权限       
        return authorizationInfo;

	}

	/**
	 * 登陆时验证时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken ustoken=(UsernamePasswordToken)token;
		String userName = ustoken.getUsername();
        //根据用户名查找用户信息
            User user=userService.getByUserName(userName);
            if(user!=null){
            	String salt = user.getId();
                AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getAccount(),
                		user.getPassword(), ByteSource.Util.bytes(salt), getName());               
                return authcInfo;
            }else{
            	throw new UnknownAccountException();//没有找到账号                            
           }

	}

}

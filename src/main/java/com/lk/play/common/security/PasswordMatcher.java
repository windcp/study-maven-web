package com.lk.play.common.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.util.ByteSource;

import com.lk.play.common.service.SystemService;

/**
 * �Զ���������֤
 * 
 * @author Administrator
 *
 */
/*public class PasswordMatcher extends SimpleCredentialsMatcher {
		

	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        Boolean result = false;
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		SimpleAuthenticationInfo asinfo = (SimpleAuthenticationInfo)info;
		//��ȡ�û����������
		String password = String.valueOf(token.getPassword());
		//��ȡ��
		ByteSource credentialsSalt = asinfo.getCredentialsSalt();
		String salt = credentialsSalt.toString();
		Object oldEncodePassword = getCredentials(info);
		String newEncodePassword = SystemService.encodePassword(password, salt);
		//��֤�û�����
		if(oldEncodePassword.equals(newEncodePassword)) {			
			return result;
		}
		//Object salt
		// String pwd =encrypt32(String.valueOf(token.getPassword()));//md5 32λ����
		String pwdType = String.valueOf(token.getPassword());// �ж�һ�������Ƿ����û�����ģ�����JCIS��������
		if (pwdType.length() == 32) {
			return equals(pwdType, accountCredentials); // ���볤��=32λ��˵����md5���ܹ����Ǵ�xx�������� 32λ���ܡ�
		}
		//String pwdUser = encrypt32(String.valueOf(token.getPassword()));// ������32 ���û���������롣 ����û���������볤��λ32��ô�������һ��bug
        //return equals(pwdUser, accountCredentials);
		// �����������ϵͳ���ܺ������У�飬����һ�¾ͷ���true,��һ�¾ͷ���false
		// return super.doCredentialsMatch(token, info) ;
		return result ;
	}

}*/

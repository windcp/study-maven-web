package com.lk.play.common.service;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.play.common.security.Digests;
import com.lk.play.common.util.Encodes;
import com.lk.play.user.dao.MenuDao;
import com.lk.play.user.dao.RoleDao;
import com.lk.play.user.dao.UserDao;


/**
 * 系统管理类
 * @author Administrator
 *
 */
@Service
public class SystemService implements InitializingBean{
	//迭代次数
	public static final int HASH_INTERATIONS = 1024;
	//盐的位数
	public static final int SALT_SIZE = 8;
	//散列算法
	private static final String SHA1 = "SHA-1";
	private static final String MD5 = "md5";
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private MenuDao menuDao;
	
	/**
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 * @param plainPassword
	 * @return
	 */
	public static String entryptPassword(String plainPassword) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
	}
	
	
	/**
	 * md5加密1024次,使用主键id值为盐
	 * @param password 密码
	 * @param salt 盐
	 * @return
	 */
	public static String encodePassword(String password,String salt) {
		String hash = new SimpleHash(MD5, password, salt, HASH_INTERATIONS).toString();
		return hash;
	}
	

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		return;
	}
	
	

}

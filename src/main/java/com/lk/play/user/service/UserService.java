package com.lk.play.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.play.common.service.SystemService;
import com.lk.play.user.dao.UserDao;
import com.lk.play.user.entity.User;
/**
 * 用户service
 * @author Administrator
 *
 */
@Service
public class UserService implements UserDao{
	
	@Autowired
	protected UserDao userDao;

	/**
	 * 添加用户
	 */
	@Override
	public void insert(User user) {
		if(user.getId() == "") {
			// uuid自动生成主键
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			if(user.getId() == "") {
				user.setId(id);	
			}		
			// 密码加密存储
			if (user.getPassword() != null) {
				user.setPassword(SystemService.encodePassword(user.getPassword(),user.getId()));
			}
			userDao.insert(user);
			//将用户id与角色id存入到中间库
			insertUserRole(user);
		}else {
			// 密码加密存储
			if (user.getPassword() != null) {
				user.setPassword(SystemService.encodePassword(user.getPassword(),user.getId()));
			}
			update(user);
			//更新中间库
			updateUserRole(user);
		}		
	}
	
	
	/**
	 * 删除用户
	 */
	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userDao.deleteUserRole(user);
		userDao.delete(user);
	}

	/**
	 * 获取用户
	 */
	@Override
	public User get(User user) {
		// TODO Auto-generated method stub
		return userDao.get(user);
	}

	/**
	 * 获取所有用户
	 */
	@Override
	public List<User> findAllList() {
		// TODO Auto-generated method stub
		return userDao.findAllList();
	}

	/**
	 * 根据账号获取用户
	 */
	@Override
	public User getByUserName(String name) {
		// TODO Auto-generated method stub
		return userDao.getByUserName(name);
	}

	/**
	 * 将用户id与角色id存入到中间库
	 */
	@Override
	public void insertUserRole(User user) {
		// TODO Auto-generated method stub
		 userDao.insertUserRole(user);
	}

	@Override
	public void deleteUserRole(User user) {
		// TODO Auto-generated method stub
		userDao.deleteUserRole(user);
	}

	/**
	 * 更新用户
	 */
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}


	@Override
	public void updateUserRole(User user) {
		// TODO Auto-generated method stub
		userDao.updateUserRole(user);
	}

	

}

package com.lk.play.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.play.common.service.SystemService;
import com.lk.play.user.dao.UserDao;
import com.lk.play.user.entity.User;
/**
 * �û�service
 * @author Administrator
 *
 */
@Service
public class UserService implements UserDao{
	
	@Autowired
	protected UserDao userDao;

	/**
	 * ����û�
	 */
	@Override
	public void insert(User user) {
		if(user.getId() == "") {
			// uuid�Զ���������
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			if(user.getId() == "") {
				user.setId(id);	
			}		
			// ������ܴ洢
			if (user.getPassword() != null) {
				user.setPassword(SystemService.encodePassword(user.getPassword(),user.getId()));
			}
			userDao.insert(user);
			//���û�id���ɫid���뵽�м��
			insertUserRole(user);
		}else {
			// ������ܴ洢
			if (user.getPassword() != null) {
				user.setPassword(SystemService.encodePassword(user.getPassword(),user.getId()));
			}
			update(user);
			//�����м��
			updateUserRole(user);
		}		
	}
	
	
	/**
	 * ɾ���û�
	 */
	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userDao.deleteUserRole(user);
		userDao.delete(user);
	}

	/**
	 * ��ȡ�û�
	 */
	@Override
	public User get(User user) {
		// TODO Auto-generated method stub
		return userDao.get(user);
	}

	/**
	 * ��ȡ�����û�
	 */
	@Override
	public List<User> findAllList() {
		// TODO Auto-generated method stub
		return userDao.findAllList();
	}

	/**
	 * �����˺Ż�ȡ�û�
	 */
	@Override
	public User getByUserName(String name) {
		// TODO Auto-generated method stub
		return userDao.getByUserName(name);
	}

	/**
	 * ���û�id���ɫid���뵽�м��
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
	 * �����û�
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

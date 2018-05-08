package com.lk.play.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.play.user.dao.RoleDao;
import com.lk.play.user.entity.Role;

/**
 * ��ɫservice
 * 
 * @author Administrator
 *
 */
@Service
public class RoleService implements RoleDao {

	@Autowired
	private RoleDao roleDao;

	/**
	 * ��ӽ�ɫ
	 */
	@Override
	public void insert(Role role) {
		// TODO Auto-generated method stub
		//uuid�Զ���������
		if(role.getId() == null || role.getId() == "") {
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			role.setId(id);
			roleDao.insert(role);
		}else {
			roleDao.update(role);
		}
		
	}

	/**
	 * ɾ����ɫ
	 */
	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		roleDao.delete(role);
	}

	/**
	 * ��ȡ��ɫ
	 */
	@Override
	public Role get(Role role) {
		// TODO Auto-generated method stub
		return roleDao.get(role);
	}

	/**
	 * ��ȡ���н�ɫ
	 */
	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return roleDao.getAll();
	}

	/**
	 * ����ɫ�˵��м������Ӽ�¼
	 */
	@Override
	public void insertRoleMenu(Role role) {
		// TODO Auto-generated method stub
		roleDao.insertRoleMenu(role);
	}

	/**
	 * ���½�ɫ��Ϣ
	 */
	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		roleDao.update(role);
	}

	/**
	 * ����id��ȡ��ɫӢ������
	 */
	@Override
	public String getRole(String id) {
		// TODO Auto-generated method stub

		return roleDao.getRole(id);
	}

}

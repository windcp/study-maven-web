package com.lk.play.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.play.user.dao.RoleDao;
import com.lk.play.user.entity.Role;

/**
 * 角色service
 * 
 * @author Administrator
 *
 */
@Service
public class RoleService implements RoleDao {

	@Autowired
	private RoleDao roleDao;

	/**
	 * 添加角色
	 */
	@Override
	public void insert(Role role) {
		// TODO Auto-generated method stub
		//uuid自动生成主键
		if(role.getId() == null || role.getId() == "") {
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			role.setId(id);
			roleDao.insert(role);
		}else {
			roleDao.update(role);
		}
		
	}

	/**
	 * 删除角色
	 */
	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		roleDao.delete(role);
	}

	/**
	 * 获取角色
	 */
	@Override
	public Role get(Role role) {
		// TODO Auto-generated method stub
		return roleDao.get(role);
	}

	/**
	 * 获取所有角色
	 */
	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return roleDao.getAll();
	}

	/**
	 * 往角色菜单中间表中添加记录
	 */
	@Override
	public void insertRoleMenu(Role role) {
		// TODO Auto-generated method stub
		roleDao.insertRoleMenu(role);
	}

	/**
	 * 更新角色信息
	 */
	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		roleDao.update(role);
	}

	/**
	 * 根据id获取角色英文名称
	 */
	@Override
	public String getRole(String id) {
		// TODO Auto-generated method stub

		return roleDao.getRole(id);
	}

}

package com.lk.play.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.play.user.dao.MenuDao;
import com.lk.play.user.entity.Menu;

@Service
public class MenuService implements MenuDao {

	@Autowired
	private MenuDao menuDao;

	/**
	 * 添加权限
	 */
	@Override
	public void insert(Menu menu) {
		// TODO Auto-generated method stub
		// uuid自动生成主键
		if (menu.getId() == null || menu.getId() == "") {
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			menu.setId(id);
			menuDao.insert(menu);
		} else {
			menuDao.update(menu);
		}

	}

	@Override
	public void delete(Menu menu) {
		// TODO Auto-generated method stub
		menuDao.delete(menu);
	}

	@Override
	public void update(Menu Menu) {
		// TODO Auto-generated method stub
		menuDao.update(Menu);
	}

	@Override
	public Menu get(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.get(menu);
	}

	@Override
	public List<Menu> getAll() {
		// TODO Auto-generated method stub
		return menuDao.getAll();
	}

}

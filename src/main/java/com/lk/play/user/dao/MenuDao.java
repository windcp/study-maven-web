package com.lk.play.user.dao;

import java.util.List;

import com.lk.play.user.entity.Menu;
/**
 * 权限接口
 * @author Administrator
 *
 */
public interface MenuDao {
	
	public void insert(Menu menu);
	
	public void delete(Menu menu);
	
	public void update(Menu menu);
	
	public Menu get(Menu menu);
	
	public List<Menu> getAll();

}

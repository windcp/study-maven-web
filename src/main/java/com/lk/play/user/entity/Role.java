package com.lk.play.user.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ½ÇÉ«entity
 * @author Administrator
 *
 */
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String enName;
    
	private User user;
	
	private List<Menu> menuList = new ArrayList<Menu>(); 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
		

}

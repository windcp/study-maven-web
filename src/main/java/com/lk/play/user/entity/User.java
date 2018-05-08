package com.lk.play.user.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户entity
 * @author Administrator
 * 
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;         //用户编号
	private String name;       //用户名
	private String account;    //用户账号
	private String password;   //用户密码
	private String delFlag;    //删除标记：1代表存在，0代表删除
	private String salt;
	
	private Role role;	// 根据角色查询用户条件
	
	private List<Role> roleList = new ArrayList<Role>(); // 拥有角色列表

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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
		
	
}

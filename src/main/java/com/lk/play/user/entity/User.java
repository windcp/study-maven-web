package com.lk.play.user.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * �û�entity
 * @author Administrator
 * 
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;         //�û����
	private String name;       //�û���
	private String account;    //�û��˺�
	private String password;   //�û�����
	private String delFlag;    //ɾ����ǣ�1������ڣ�0����ɾ��
	private String salt;
	
	private Role role;	// ���ݽ�ɫ��ѯ�û�����
	
	private List<Role> roleList = new ArrayList<Role>(); // ӵ�н�ɫ�б�

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

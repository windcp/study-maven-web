package com.lk.play.user.entity;

import java.io.Serializable;
/**
 * �˵�ʵ��
 * @author Administrator
 *
 */
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	//private Menu parent; // �����˵�
	//private String parentId; //�������
	//private String parentIds; // ���и������
	private String name; // ����
	//private String href; // ����
	// private String target; // Ŀ�꣨ mainFrame��_blank��_self��_parent��_top��
	// private String icon; // ͼ��
	// private Integer sort; // ����
	// private String isShow; // �Ƿ��ڲ˵�����ʾ��1����ʾ��0������ʾ��
	private String permission; // Ȩ�ޱ�ʶ

	private String userId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
/*
	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
*/
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
/*
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	*/
	

}

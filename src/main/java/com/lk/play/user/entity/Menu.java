package com.lk.play.user.entity;

import java.io.Serializable;
/**
 * 菜单实体
 * @author Administrator
 *
 */
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	//private Menu parent; // 父级菜单
	//private String parentId; //父级编号
	//private String parentIds; // 所有父级编号
	private String name; // 名称
	//private String href; // 链接
	// private String target; // 目标（ mainFrame、_blank、_self、_parent、_top）
	// private String icon; // 图标
	// private Integer sort; // 排序
	// private String isShow; // 是否在菜单中显示（1：显示；0：不显示）
	private String permission; // 权限标识

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

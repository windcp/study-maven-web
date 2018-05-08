package com.lk.play.user.web;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lk.play.user.entity.Menu;
import com.lk.play.user.entity.Role;
import com.lk.play.user.service.MenuService;
import com.lk.play.user.service.RoleService;
import com.lk.play.user.service.UserService;
/**
 * ��ɫ������
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "role")
//@RequiresRoles(value="admin")
public class RoleController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MenuService menuService;
	
/*	@ModelAttribute
	public Role get(Role role) {
		if(!StringUtils.isEmpty(role)) {
			return roleService.get(role);
		}return new Role() ;
	}*/
	
	/**
	 * ɾ��
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String delete(@ModelAttribute("role") Role role) {
		roleService.delete(role);
		return "userList";
	}
	
	/**
	 * ����
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/save")
	public String save(@ModelAttribute("role") Role role,Model model) {		
		roleService.insert(role);
		return "redirect:list";
	}
	
	/**
	 * ���/�޸�
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/form")
	public String form(@ModelAttribute("role") Role role,Model model) {		
		Role roleObj = roleService.get(role);
		model.addAttribute("role",roleObj);
		return "roleForm";
	}
	
	/**
	 * ��ɫ�б�
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String list(Model model) {
		List<Role> roleList = roleService.getAll();
		model.addAttribute("roleList",roleList);
		return "roleList";
	}
	
	/**
	 * ��ɫȨ���б�
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/roleMenuForm")
	public String roleMenuList(Model model) {
		List<Role> roleList = roleService.getAll();
		List<Menu> menuList = menuService.getAll();
		model.addAttribute("roleList", roleList);
		model.addAttribute("menuList", menuList);
		return "roleMenuForm";
	}
	
	/**
	 * �����û���ɫ��ϵ���м��
	 * @return
	 */
	@RequestMapping(value = "/roleMenuSave")
	public String roleMenuSave(Role role) {
		return "roleMenuForm";
	}

}

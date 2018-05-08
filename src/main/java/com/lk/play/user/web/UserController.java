package com.lk.play.user.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lk.play.common.service.SystemService;
import com.lk.play.common.util.JedisUtil;
import com.lk.play.user.entity.Role;
import com.lk.play.user.entity.User;
import com.lk.play.user.service.RoleService;
import com.lk.play.user.service.UserService;

/**
 * 用户控制器
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private SystemService systemService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private JedisUtil jedis;

	/**
	 * 删除用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String delete(@ModelAttribute("user") User user) {
		userService.delete(user);
		return "userList";
	}

	/**
	 * 保存用户
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/save")
	public String save(@ModelAttribute("user") User user, Model model) {
		userService.insert(user);
		jedis.jedisObjectPut("user1", user.getId(), user);				
		return "redirect:list";
	}

	/**
	 * 获取所有用户
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String list(Model model) {
		List<User> userList = userService.findAllList();
		jedis.jedisListPush("userList", userList);
		List<User> uList = jedis.jedisObjectPop("userList", User.class);
		for(User u:uList) {
			System.out.println(u.getName());
		}
		model.addAttribute("userList", userList);
		return "userList";
	}

	/**
	 * 新增/修改用户
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/form")
	public String form(@ModelAttribute("user") User user, Model model) {
		List<Role> roleList = roleService.getAll();
		User userObj = userService.get(user);
		model.addAttribute("user", userObj);
		model.addAttribute("roleList", roleList);
		return "userForm";
	}

	/**
	 * 查看用户信息
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("user") User user, Model model) {
		String roleName = roleService.getRole(user.getId());
		User userObj = userService.get(user);
		User user2 = (User) jedis.jedisObjectGet("user1", user.getId(), user.getClass());
		System.out.println(user2.getName());
		model.addAttribute("user", userObj);
		model.addAttribute("roleName", roleName);
		return "userView";
	}

}

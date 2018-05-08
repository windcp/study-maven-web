package com.lk.play.user.web;

import java.util.List;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lk.play.user.entity.Menu;
import com.lk.play.user.entity.Role;
import com.lk.play.user.service.MenuService;

/**
 * 权限控制器
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "list")
	public String list(Model model) {
		List<Menu> menuList = menuService.getAll();
		model.addAttribute("menuList", menuList);
		return "menuList";
	}
	
	/**
	 * 保存
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/save")
	public String save(Menu menu,Model model) {		
		menuService.insert(menu);
		return "redirect:list";
	}
	
	/**
	 * 添加/修改
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/form")
	public String form(Menu menu,Model model) {	
		//System.out.println(menu);		
		if(menu.getId() != null) {
			Menu menuObj = menuService.get(menu);
			model.addAttribute("menu", menuObj);
		}		
		return "menuForm";
	}
	
	/**
	 * 删除
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String delete(Menu menu) {
		menuService.delete(menu);
		return "menuList";
	}
}

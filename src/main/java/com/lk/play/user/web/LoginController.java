package com.lk.play.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lk.play.user.entity.User;
import com.lk.play.user.service.UserService;

/**
 * µÇÂ½
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/loginIn")
	public String loginIn() {
		return "login";
	}
	
	/**
	 * µÇÂ½µ÷ÓÃ
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/loginOn")
	public String loginOn(@ModelAttribute("user") User user,Model model) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassword());
	    List<User> userList = userService.findAllList();
		model.addAttribute("userList",userList);
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}	
		Session session = subject.getSession();
		session.setAttribute("user", user);
		return "userList";
	}
	
	/**
	 * ÍË³ö
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/loginOut")
	public String loginOut(HttpServletResponse response, HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}
}

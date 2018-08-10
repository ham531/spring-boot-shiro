package com.demo.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountInfoController {

	@RequiresRoles("admin")
	@RequestMapping
	public String adminConfig(Model model) {
		return "view";
	}

	@RequestMapping(value = "toLogin", method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String username, String password) {
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			System.out.println("UnknownAccountException");
		} catch (IncorrectCredentialsException e) {
			System.out.println("IncorrectCredentialsException");
		}
		return "login";
	}

	@RequestMapping(value = "guest/a", method = RequestMethod.GET)
	public String guest() {
		return "guest";
	}

}

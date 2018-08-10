package com.demo.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
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

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "guest/a", method = RequestMethod.GET)
	public String guest() {
		return "guest";
	}

}

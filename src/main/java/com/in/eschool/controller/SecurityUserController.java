package com.in.eschool.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.eschool.SecurityUserDetailsService;
import com.in.eschool.model.SecurityUser;
import com.in.eschool.model.User;

@RestController
@CrossOrigin("*")
public class SecurityUserController {

	private Logger logger = LoggerFactory.getLogger(SecurityUserController.class);

	@Autowired
	private SecurityUserDetailsService securityUserDetailsService;

	@RequestMapping("/findUserByFname")
	public UserDetails loadUserByUsername(@PathParam("username") String username) {
		logger.info("@findUserByName username:{}", username);
		return securityUserDetailsService.loadUserByUsername(username);
	}

	

	public SecurityUserController() {
		// TODO Auto-generated constructor stub
	}

}

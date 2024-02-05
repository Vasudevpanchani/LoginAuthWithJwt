package com.example.loginwithjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.loginwithjwt.ResponseDTO;
import com.example.loginwithjwt.jwt.JwtUtils;
import com.example.loginwithjwt.model.UserData;
import com.example.loginwithjwt.service.UserDataService;

@RestController
public class MainController {
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserDataService userDataService;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("/login");
	}
	
	@GetMapping("/register")
	public ModelAndView registerPage() {
		return new ModelAndView("register");
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	
	@PostMapping("/addUser")
	public ModelAndView register(@ModelAttribute UserData userData) {
		ResponseEntity<ResponseDTO> result = userDataService.register(userData);
		ModelAndView m1 = new ModelAndView("redirect:/login");
		if (result.getBody().getStatus() == 400) {
			m1 = new ModelAndView("redirect:/register");
			m1.addObject("result", result.getBody().getMessage());
		}
		m1.addObject("result", result.getBody().getMessage());
		return m1;

	}
	
	@PostMapping("/loginauth")
	public String loginAuth(@RequestParam("username") String email, @RequestParam("password") String password) {
		ResponseEntity<ResponseDTO> result = userDataService.loginAuth(email, password);
//		if (jwtUtils.extractRole(result.getBody().getData().toString()).equals("Admin")) {
//			return new ModelAndView("redirect:/admin/dashboard");
//		} else {
//			return new ModelAndView("redirect:/user/dashboard");
//		}
		return result.getBody().getData().toString();
	}



}

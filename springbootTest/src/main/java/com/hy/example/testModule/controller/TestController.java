package com.hy.example.testModule.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testController")
public class TestController {
	
	@RequestMapping("/test")
	public String getAppDesc(HttpServletRequest request, @RequestParam String key) {
		String value2 = request.getParameter("key");
		return "Hello world, this is spring boot demo." + key + value2;
	}
}

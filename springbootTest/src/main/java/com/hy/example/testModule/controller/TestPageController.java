package com.hy.example.testModule.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hy.example.testModule.entity.City;
import com.hy.example.testModule.entity.Country;
import com.hy.example.testModule.service.CityService;
import com.hy.example.testModule.service.CountryService;

@Controller
@RequestMapping("/test")
public class TestPageController {
	
	@Autowired
	private CityService cityService;
	private CountryService countryService;
	@RequestMapping("/index")
	public String testIndexPage(ModelMap modelMap) {
		
		int countryId = 522;
		//Country country = countryService.getCountryById(countryId);
		List<City> cities = cityService.getCitiesByCountryId(countryId);
		cities = cities.stream().limit(10).collect(Collectors.toList());
		City city = cities.get(0);

		modelMap.addAttribute("thymeleafTitle", "thymeleaf Title");
		modelMap.addAttribute("checked", true);
		modelMap.addAttribute("currentNumber", 99);
		modelMap.addAttribute("changeType", "checkbox");
		modelMap.addAttribute("baiduUrl", "http://www.baidu.com");
		modelMap.addAttribute("shopLogo", "http://cdn.duitang.com/uploads"
				+ "/item/201308/13/20130813115619_EJCWm.thumb.700_0.jpeg");
		//modelMap.addAttribute("country", country);
		modelMap.addAttribute("city", city);
		modelMap.addAttribute("updateCityUri", "/api/city");
		modelMap.addAttribute("cities", cities);
		//modelMap.addAttribute("template", "test/index");
		
		return "index";
	}
	
	
}

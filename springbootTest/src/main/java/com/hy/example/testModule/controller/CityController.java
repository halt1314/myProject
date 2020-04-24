package com.hy.example.testModule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.hy.example.common.vo.Result;
import com.hy.example.testModule.entity.City;
import com.hy.example.testModule.service.CityService;
import com.hy.example.testModule.service.impl.CityServiceImpl;

@RestController
@RequestMapping("/cityController")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping("/cities/{countryId}")
	public List<City> getCitiesByCountryId(@PathVariable int countryId) {
		
		return cityService.getCitiesByCountryId(countryId);
		
		
	}
	
	@RequestMapping("/cities")
 	public PageInfo<City> getCitiesByPage(@RequestParam int currentPage, 
 			@RequestParam int pageSize, @RequestParam int countryId) {
 		return cityService.getCitiesByPage(currentPage, pageSize, countryId);
 	}

 	@PostMapping(value="/city", consumes="application/json")
 	public Result<City> insertCity(@RequestBody City city) {
 		return cityService.insertCity(city);
 	}
	
	
}

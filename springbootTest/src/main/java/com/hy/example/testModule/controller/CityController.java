package com.hy.example.testModule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hy.example.testModule.entity.City;
import com.hy.example.testModule.service.impl.CityServiceImpl;

@RestController
@RequestMapping("/cityController")
public class CityController {
	
	@Autowired
	private CityServiceImpl cityServiceImpl;
	
	@RequestMapping("/cities/{countryId}")
	public List<City> getCitiesByCountryId(@PathVariable int countryId) {
		
		return cityServiceImpl.getCitiesByCountryId(countryId);
		
		
	}
	
	
}

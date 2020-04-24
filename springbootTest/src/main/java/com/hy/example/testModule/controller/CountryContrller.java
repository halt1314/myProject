package com.hy.example.testModule.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hy.example.testModule.entity.Country;
import com.hy.example.testModule.service.CountryService;

@RestController
@RequestMapping("/countryController")
public class CountryContrller {
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/country/{countryId}")
	public Country getCountryById(@PathVariable int countryId) {
		return countryService.getCountryById(countryId);
	}

	@RequestMapping("/country")
	public Country getCountryByName(@RequestParam String countryName) {
		return countryService.getCountryByName(countryName);
	}
}

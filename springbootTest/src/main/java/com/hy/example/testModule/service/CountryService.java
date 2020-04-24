package com.hy.example.testModule.service;

import com.hy.example.testModule.entity.Country;

public interface CountryService {
	
	
	Country getCountryById(int countryId);

	Country getCountryByName(String countryName);
}

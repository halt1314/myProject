package com.hy.example.testModule.service;

import java.util.List;

import com.hy.example.testModule.entity.City;

public interface CityService {
	
	List<City> getCitiesByCountryId(int countryId);
}

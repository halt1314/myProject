package com.hy.example.testModule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.example.testModule.dao.CityDao;
import com.hy.example.testModule.entity.City;
import com.hy.example.testModule.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityDao cityDao;
	@Override
	public List<City> getCitiesByCountryId(int countryId) {
	
		return cityDao.getCitiesByCountryId(countryId);
	}

}

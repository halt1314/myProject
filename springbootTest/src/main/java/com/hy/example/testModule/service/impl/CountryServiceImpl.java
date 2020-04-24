package com.hy.example.testModule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.example.testModule.dao.CountryDao;
import com.hy.example.testModule.entity.Country;
import com.hy.example.testModule.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {
	
	
	@Autowired
	private CountryDao countryDao;

	@Override
	public Country getCountryById(int countryId) {
		return countryDao.getCountryById(countryId);
	}

	@Override
	public Country getCountryByName(String countryName) {
		return countryDao.getCountryByName(countryName);
	}
}

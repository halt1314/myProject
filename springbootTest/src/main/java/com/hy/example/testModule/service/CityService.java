package com.hy.example.testModule.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hy.example.common.vo.Result;
import com.hy.example.testModule.entity.City;

public interface CityService {
	
	List<City> getCitiesByCountryId(int countryId);

	PageInfo<City> getCitiesByPage(int currentPage, int pageSize, int countryId);

	Result<City> insertCity(City city);
}

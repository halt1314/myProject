package com.hy.example.testModule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.example.common.vo.Result;
import com.hy.example.common.vo.Result.ResultEnum;
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
	
	@Override
 	public PageInfo<City> getCitiesByPage(int currentPage, int pageSize, int countryId) {
 		PageHelper.startPage(currentPage, pageSize);
 		List<City> cities = cityDao.getCitiesByCountryId(countryId);
 		return new PageInfo<City>(cities);
 	}

 	@Override
 	public Result<City> insertCity(City city) {
 		Result<City> result = new Result<>(ResultEnum.SUCCESS.status, "Insert success.");

 		try {
 			cityDao.insertCity(city);
 			result.setObject(city);
 		} catch (Exception e) {
 			result.setStatus(ResultEnum.FAILD.status);
 			result.setMessage(e.getMessage());
 		}

 		return result;
 	}

	@Override
	public City getCityByName(String cityName, String localCityName) {
		return cityDao.getCityByName2(cityName, localCityName);
	}

	@Override
	public Result<City> updateCity(City city) {
		Result<City> result = new Result<>(ResultEnum.SUCCESS.status, "Update success.");
		cityDao.updateCity(city);
		result.setObject(city);
		return result;
	}

	@Override
	public Result<Object> deleteCity(int cityId) {
		Result<Object> result = new Result<>(ResultEnum.SUCCESS.status, "Delete success.");

		try {
			cityDao.deleteCity(cityId);
		} catch (Exception e) {
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}

		return result;
	
	}

}

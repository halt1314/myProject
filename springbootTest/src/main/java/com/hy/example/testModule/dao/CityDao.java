package com.hy.example.testModule.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.hy.example.testModule.entity.City;

@Mapper
public interface CityDao {
	
	@Select("select * from m_city where country_id = #{countryId}")
	List<City> getCitiesByCountryId(int countryId);

	
	@Insert("insert into m_city (city_name, local_city_name, country_id, date_created) "
 			+ "values (#{cityName}, #{localCityName}, #{countryId}, #{dateCreated})")
 	@Options(useGeneratedKeys=true, keyColumn="city_id", keyProperty="cityId")
 	void insertCity(City city);
	
	
}

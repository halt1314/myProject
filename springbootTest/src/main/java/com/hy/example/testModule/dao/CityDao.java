package com.hy.example.testModule.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hy.example.testModule.entity.City;

@Mapper
public interface CityDao {
	
	@Select("select * from m_city where country_id = #{countryId}")
	List<City> getCitiesByCountryId(int countryId);

	
	@Insert("insert into m_city (city_name, local_city_name, country_id, date_created) "
 			+ "values (#{cityName}, #{localCityName}, #{countryId}, #{dateCreated})")
 	@Options(useGeneratedKeys=true, keyColumn="city_id", keyProperty="cityId")
 	void insertCity(City city);
	
	
	@Select("select * from m_city where city_name = #{cityName} and local_city_name = #{localCityName}")
	City getCityByName(@Param("cityName") String cityName, @Param("localCityName") String localCityName);

	@Select("<script>" + 
			"select * from m_city "
			+ "<where> "
			+ "<if test='cityName != \"\" and cityName != null'>"
			+ "and city_name = #{cityName} "
			+ "</if>"
			+ "<if test='localCityName != \"\" and localCityName != null'>"
			+ "and local_city_name = #{localCityName} "
			+ "</if>"
			+ "</where>"
			+ "limit 1"
			+ "</script>")
	City getCityByName2(@Param("cityName") String cityName, @Param("localCityName") String localCityName);
	
	@Update("update m_city set local_city_name = #{localCityName} where city_id = #{cityId}")
	void updateCity(City city);

	@Delete("delete from m_city where city_id = #{cityId}")
	void deleteCity(int cityId);
}

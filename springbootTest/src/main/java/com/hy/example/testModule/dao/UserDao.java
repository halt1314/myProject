package com.hy.example.testModule.dao;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.hy.example.testModule.entity.User;

@Mapper
public interface UserDao {
	
	@Select("select * from user where user_id = #{userId}")
	List<User> getUsersByUserId(int userId);
	
	
	@Insert("insert into user (create_date, password, user_name) "
 			+ "values (#{createDate}, #{password}, #{userName},)")
 	@Options(useGeneratedKeys=true, keyColumn="user_id", keyProperty="userId")
 	void insertUser(User user);
	
	@Update("update user set password = #{password} where user_id = #{userId}")
	void updateUser(User user);

	@Delete("delete from user where user_id = #{userId}")
	void deleteUser(int userId);
}

package com.example.its.domain.auth;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.its.domain.auth.User.Authority;

@Mapper
public interface UserRepository {
	
	@Select("select username, email, password, enabled, authority from users where email = #{email}")
	Optional<User> findByUsername(String email);
	
	@Select("select username, email, password, enabled, authority from users")
	List<User> findAll();
	
	@Insert("insert into users(username, email, password, enabled, authority, tempkey) values(#{username}, 'test4@gmail.com', #{password}, 1, #{authority}::authority, '1')")
	void insert(@Param("username") String username, @Param("password") String password, @Param("authority") String authority);

}

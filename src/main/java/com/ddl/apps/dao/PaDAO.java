package com.ddl.apps.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ddl.apps.model.po.User;

@Repository
public interface PaDAO {

	@Insert("insert into user (name,mobile,create_time) values (#{name},#{mobile},#{createTime})")
	void insertUser(final User user) throws Exception;

	@Select("select id,name,mobile,create_time from user where 1=1 and mobile=#{mobile} order by id desc limit 1")
	User getUserByMobile(@Param("mobile") final String mobile) throws Exception;
	
	@Select("select id,name,mobile,create_time from user where 1=1 order by id desc limit 10")
	List<User> getAllUserList();
}
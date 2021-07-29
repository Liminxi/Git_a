package com.yr.entry;
import java.util.List;

public interface UserMapper {
	// Ìí¼Ó
	//@Insert("insert into users(name,account,pd,age,sex,tel,email,addr)values(#{name},#{account},#{pd},#{age},#{sex},#{tel},#{email},#{addr})")
	public Integer addUser(User user);

	// É¾³ı
	//@Delete("delete from users where id = #{id}")
	public Integer delUser(Integer id);

	// ĞŞ¸Ä
	//@Update("update users set name=#{name},account=#{account},pd=#{pd},age=#{age},sex=#{sex},tel=#{tel},email=#{email},addr=#{addr} where id=#{id}")
	public Integer updateUser(User user);

	// ²éÑ¯
	//@Select("select * from users")
	public List<User> getUserList();
	
	//@Select("select * from users where id= #{id}")
	public User getUser(Integer id);
}
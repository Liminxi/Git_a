package com.yr.entry;
import java.util.List;

public interface UserMapper {
	// ���
	//@Insert("insert into users(name,account,pd,age,sex,tel,email,addr)values(#{name},#{account},#{pd},#{age},#{sex},#{tel},#{email},#{addr})")
	public Integer addUser(User user);

	// ɾ��
	//@Delete("delete from users where id = #{id}")
	public Integer delUser(Integer id);

	// �޸�
	//@Update("update users set name=#{name},account=#{account},pd=#{pd},age=#{age},sex=#{sex},tel=#{tel},email=#{email},addr=#{addr} where id=#{id}")
	public Integer updateUser(User user);

	// ��ѯ
	//@Select("select * from users")
	public List<User> getUserList();
	
	//@Select("select * from users where id= #{id}")
	public User getUser(Integer id);
}
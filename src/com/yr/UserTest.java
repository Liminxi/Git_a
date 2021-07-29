package com.yr;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yr.entry.User;


public class UserTest {

	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("com.yr.UserTest");
		UserTest test = (UserTest) c.newInstance();
		test.query();
	}

	public void query() throws Exception {
		// mybatis的配置文件
		String resource = "conf.xml";
		/**
		 * 使用类加载器加载mybatis的配置文件(包括相关的映射文件) 
		 * InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
		 * 构建sqlSession的工厂 
		 * SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		 */
		// 使用MyBatis提供的Resource类加载mybatis的配置文件(包括相关的映射文件)
		Reader reader = Resources.getResourceAsReader(resource);
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		// 映射sql的表示字符串
		String statement = "com.yr.entry.mapper.userMapper.getUserList";
		String statement1 = "com.yr.entry.mapper.userMapper.getUser";

		/**
		 * selectOne:根据id查询一条记录
		 */
		User user1 = session.selectOne(statement1, 1);
		System.out.println("根据id查询一条:" + user1);

		System.out.println("=============");

		/**
		 * selectList:查询所有返回list
		 */
		List<User> userList = session.selectList(statement);
		for (User user : userList) {
			System.out.println(user);
		}
	}
}
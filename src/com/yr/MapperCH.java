package com.yr;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yr.entry.User;
import com.yr.entry.UserMapper;

public class MapperCH {
	public static void main(String[] args) throws IOException {
		String resource = "conf.xml";
		// 加载mybatis的配置文件(它也加载关联的映射文件)
		Reader reader = Resources.getResourceAsReader(resource);
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 创建能执行映射文件中sql的sqlSession
		SqlSession session1 = sessionFactory.openSession();
		// 映射sql的标识字符串
        
		UserMapper	mapper = session1.getMapper(UserMapper.class);	// 执行查询返回一个唯一user对象的sql
		User user1 = mapper.getUser(1);
		System.out.println("第一次:   " + user1.toString());

		// 这里一定要提交或close(),提交或关闭后数据才会缓存到二级缓存中去,否则二级缓存不生效
		session1.commit();
		//session1.close();

		SqlSession session2 = sessionFactory.openSession();
		User user2 = mapper.getUser(1);
		System.out.println("第二次:   " + user2.toString());
	//	session2.commit();// 这里可以不提交或关闭

	}
}


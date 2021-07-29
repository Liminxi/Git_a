package com.yr;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yr.entry.User;
import com.yr.entry.UserMapper;

public class SessinHC {
	public static void main(String[] args) throws IOException {
			String resource = "conf.xml";
			// 加载mybatis的配置文件(它也加载关联的映射文件)
			Reader reader = Resources.getResourceAsReader(resource);
			// 构建sqlSession的工厂
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			// 创建能执行映射文件中sql的sqlSession
			SqlSession session = sessionFactory.openSession();
			// 映射sql的标识字符串
			UserMapper mapper = session.getMapper(UserMapper.class);
			// 执行查询返回一个唯一user对象的sql
			User user;
			user =mapper.getUser(1);
			System.out.println("第一次:   " + user.toString());
	
			user =mapper.getUser(1);//不用到數據庫裏查，直接從session裏拿
			System.out.println("第二次:   " + user.toString());
			//清除缓存
			//session.clearCache();
			// 这里执行增删改操作也会删除缓存
	        mapper.addUser(new User("lmx", "333", "333",23, "男", "131113331", "111@qq.com", "深圳"));
			user =mapper.getUser(1);
			System.out.println("第三次:   " + user.toString());
	
		}
}


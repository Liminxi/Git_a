package com.yr.dao.oneToduo;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yr.entry.Classes;
import com.yr.entry.Student;
import com.yr.entry.Teacher;

public class ClassesTest {
	private SqlSession session;

	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("com.yr.dao.oneToduo.ClassesTest");
		ClassesTest test = (ClassesTest) c.newInstance();
		test.ontToManyQuery();
	}

	/**
	 * 得到SessionFactory
	 * 
	 * @return
	 */
	private SqlSessionFactory getFactory() {
		// mybatis的配置文件
		String resource = "conf.xml";
		Reader reader;// 使用MyBatis提供的Resource类加载mybatis的配置文件,也加载关联的映射文件
		SqlSessionFactory sessionFactory = null;// 构建sqlSession的工厂
		try {
			reader = Resources.getResourceAsReader(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

	/**
	 * 一对多查询
	 */
	public void ontToManyQuery() throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// 创建能执行映射文件中sql的sqlSession
		session = sessionFactory.openSession(true);
		// 映射sql的表示字符串
		ClassesMapper mapper = session.getMapper(ClassesMapper.class);
		Classes a1 = mapper.getClass3(1);
		System.out.println(a1.toString());
		Classes a2 = mapper.getClass4(2);
		System.out.println(a2.toString());
		Teacher t1 = mapper.getTeacher2(2);
		System.out.println(t1.toString());
//		Student s1 = mapper.getStudent(3);
//		System.out.println(s1.toString());

		session.close();
	}

}
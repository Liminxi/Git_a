package com.yr.dao.oneToone;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yr.entry.Classes;
import com.yr.entry.Teacher;


/**
 * 测试:一对一关联表查询
 * 
 * @author liucong
 *
 * @date 2017年7月25日
 */
public class ClassesTest {
	private SqlSession session;

	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("com.yr.dao.oneToone.ClassesTest");
		ClassesTest test = (ClassesTest) c.newInstance();
		test.query();
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
	 * 查询
	 * 
	 * @throws Exception
	 */
	public void query() throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// 创建能执行映射文件中sql的sqlSession
		session = sessionFactory.openSession(true);
		// 映射sql的表示字符串
//		String statement = "com.yr.mapper.classesMapper.getClass";
//		String statement1 = "com.yr.mapper.classesMapper.getClass2";
//		String statement2 = "com.yr.mapper.classesMapper.getTeacher";
		ClassesMapper classesMapper = session.getMapper(ClassesMapper.class);
		
		Classes classes = classesMapper.getClass(1);
		System.out.println("=========" + classes);

		Classes classes2 = classesMapper.getClass2(1);
		System.out.println("=========" + classes2);

		Teacher teacher = classesMapper.getTeacher(1);
		System.out.println("=========" + teacher);

		session.close();
	}
}
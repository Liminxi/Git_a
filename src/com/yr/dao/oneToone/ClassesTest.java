package com.yr.dao.oneToone;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yr.entry.Classes;
import com.yr.entry.Teacher;


/**
 * ����:һ��һ�������ѯ
 * 
 * @author liucong
 *
 * @date 2017��7��25��
 */
public class ClassesTest {
	private SqlSession session;

	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("com.yr.dao.oneToone.ClassesTest");
		ClassesTest test = (ClassesTest) c.newInstance();
		test.query();
	}

	/**
	 * �õ�SessionFactory
	 * 
	 * @return
	 */
	private SqlSessionFactory getFactory() {
		// mybatis�������ļ�
		String resource = "conf.xml";
		Reader reader;// ʹ��MyBatis�ṩ��Resource�����mybatis�������ļ�,Ҳ���ع�����ӳ���ļ�
		SqlSessionFactory sessionFactory = null;// ����sqlSession�Ĺ���
		try {
			reader = Resources.getResourceAsReader(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

	/**
	 * ��ѯ
	 * 
	 * @throws Exception
	 */
	public void query() throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// ������ִ��ӳ���ļ���sql��sqlSession
		session = sessionFactory.openSession(true);
		// ӳ��sql�ı�ʾ�ַ���
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
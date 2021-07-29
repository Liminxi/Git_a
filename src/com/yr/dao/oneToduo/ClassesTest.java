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
	 * һ�Զ��ѯ
	 */
	public void ontToManyQuery() throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// ������ִ��ӳ���ļ���sql��sqlSession
		session = sessionFactory.openSession(true);
		// ӳ��sql�ı�ʾ�ַ���
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
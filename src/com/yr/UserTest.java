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
		// mybatis�������ļ�
		String resource = "conf.xml";
		/**
		 * ʹ�������������mybatis�������ļ�(������ص�ӳ���ļ�) 
		 * InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
		 * ����sqlSession�Ĺ��� 
		 * SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		 */
		// ʹ��MyBatis�ṩ��Resource�����mybatis�������ļ�(������ص�ӳ���ļ�)
		Reader reader = Resources.getResourceAsReader(resource);
		// ����sqlSession�Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// ������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session = sessionFactory.openSession();
		// ӳ��sql�ı�ʾ�ַ���
		String statement = "com.yr.entry.mapper.userMapper.getUserList";
		String statement1 = "com.yr.entry.mapper.userMapper.getUser";

		/**
		 * selectOne:����id��ѯһ����¼
		 */
		User user1 = session.selectOne(statement1, 1);
		System.out.println("����id��ѯһ��:" + user1);

		System.out.println("=============");

		/**
		 * selectList:��ѯ���з���list
		 */
		List<User> userList = session.selectList(statement);
		for (User user : userList) {
			System.out.println(user);
		}
	}
}
package com.yr;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yr.entry.User;
import com.yr.entry.UserMapper;
//ע��Č��F�ͽӿ�+xml���F
public class Test2{
	private SqlSession session;

	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("com.yr.Test2");
		Test2 test = (Test2) c.newInstance();
		test.add();
		test.update();
		test.del();
		test.queryID();
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
		session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> userList = mapper.getUserList();
		for (User user : userList) {
			System.out.println(user);
		}
		session.close();
	}
    public void queryID() {
    	SqlSessionFactory sessionFactory = getFactory();
    	session = sessionFactory.openSession();
    	UserMapper mapper = session.getMapper(UserMapper.class);
    	User user = mapper.getUser(3);
    	System.out.println(user.toString());
    	session.close();
    }
	/**
	 * ���
	 */
	public void add() {
		SqlSessionFactory sessionFactory = getFactory();
		// Ĭ�����ֶ��ύ��
		session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int insert = mapper.addUser(new User("aaa", "333", "333",20, "��", "131113331", "111@qq.com", "����"));
		session.commit();
		session.close();
		System.out.println("�ɹ����" + insert + "������");
	}

	/**
	 * �޸�
	 */

	public void update() {
		SqlSessionFactory sessionFactory = getFactory();
		session = sessionFactory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		int update = mapper.updateUser(new User(3,"aaa", "333", "333",20, "��", "131113331", "111@qq.com", "����"));
		session.close();
		System.out.println("�ɹ��޸�" + update + "������");
	}

	/**
	 * ɾ��
	 */
	public void del() {
		SqlSessionFactory sessionFactory = getFactory();
		// Ĭ�����ֶ��ύ,��Ϊtrue��ʾ�Զ��ύ
		session = sessionFactory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		int delete = mapper.delUser(6);
		session.close();
		System.out.println("�ɹ�ɾ��" + delete + "������");
	}
}
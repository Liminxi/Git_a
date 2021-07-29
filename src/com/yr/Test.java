package com.yr;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.yr.entry.User;
// XML��ʵ��
public class Test {
	private SqlSession session;

	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("com.yr.Test");
		Test test = (Test) c.newInstance();
		 test.add();
	     test.update();
		test.del();
		test.query();
		test.queryId();

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
                System.out.println(e.getMessage());		}
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
		// ӳ��sql�ı�ʾ�ַ���
		String statement = "com.yr.entry.mapper.userMapper.getUserList";
		// selectList:��ѯ���з���list
		List<User> userList = session.selectList(statement);
		for (User user : userList) {
			System.out.println(user);
		}
		session.close();
	}
	/**
	 * ��ѯ
	 * 
	 * @throws Exception
	 */
	public void queryId() throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// ������ִ��ӳ���ļ���sql��sqlSession
		session = sessionFactory.openSession();
		// ӳ��sql�ı�ʾ�ַ���
		String statement = "com.yr.entry.mapper.userMapper.getUser";
		// selectList:��ѯ���з���list
		User user = session.selectOne(statement,1);
		
			System.out.println(user);
		
		session.close();
	}

	/**
	 * ���
	 */
	public void add() {
		SqlSessionFactory sessionFactory = getFactory();
		// Ĭ�����ֶ��ύ��
		session = sessionFactory.openSession();
		String statement = "com.yr.entry.mapper.userMapper.addUser";
		int insert = session.insert(statement, new User("aaa", "333", "333",20, "��", "131113331", "111@qq.com", "����"));
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
		String statement = "com.yr.entry.mapper.userMapper.updateUser";
	
		int update = session.update(statement, new User(3, "ccc", "333", "333", 20, "��", "131113331", "111@qq.com", "����"));
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
		String statement = "com.yr.entry.mapper.userMapper.delUser";
		int delete = session.delete(statement, 4);
		session.close();
		System.out.println("�ɹ�ɾ��" + delete + "������");
	}
}
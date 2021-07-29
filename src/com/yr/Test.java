package com.yr;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.yr.entry.User;
// XML的实现
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
                System.out.println(e.getMessage());		}
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
		session = sessionFactory.openSession();
		// 映射sql的表示字符串
		String statement = "com.yr.entry.mapper.userMapper.getUserList";
		// selectList:查询所有返回list
		List<User> userList = session.selectList(statement);
		for (User user : userList) {
			System.out.println(user);
		}
		session.close();
	}
	/**
	 * 查询
	 * 
	 * @throws Exception
	 */
	public void queryId() throws Exception {
		SqlSessionFactory sessionFactory = getFactory();
		// 创建能执行映射文件中sql的sqlSession
		session = sessionFactory.openSession();
		// 映射sql的表示字符串
		String statement = "com.yr.entry.mapper.userMapper.getUser";
		// selectList:查询所有返回list
		User user = session.selectOne(statement,1);
		
			System.out.println(user);
		
		session.close();
	}

	/**
	 * 添加
	 */
	public void add() {
		SqlSessionFactory sessionFactory = getFactory();
		// 默认是手动提交的
		session = sessionFactory.openSession();
		String statement = "com.yr.entry.mapper.userMapper.addUser";
		int insert = session.insert(statement, new User("aaa", "333", "333",20, "男", "131113331", "111@qq.com", "深圳"));
		session.commit();
		session.close();
		System.out.println("成功添加" + insert + "条数据");
	}

	/**
	 * 修改
	 */

	public void update() {
		SqlSessionFactory sessionFactory = getFactory();
		session = sessionFactory.openSession(true);
		String statement = "com.yr.entry.mapper.userMapper.updateUser";
	
		int update = session.update(statement, new User(3, "ccc", "333", "333", 20, "男", "131113331", "111@qq.com", "深圳"));
		session.close();
		System.out.println("成功修改" + update + "条数据");
	}

	/**
	 * 删除
	 */
	public void del() {
		SqlSessionFactory sessionFactory = getFactory();
		// 默认是手动提交,设为true表示自动提交
		session = sessionFactory.openSession(true);
		String statement = "com.yr.entry.mapper.userMapper.delUser";
		int delete = session.delete(statement, 4);
		session.close();
		System.out.println("成功删除" + delete + "条数据");
	}
}
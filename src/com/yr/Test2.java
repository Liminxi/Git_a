package com.yr;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yr.entry.User;
import com.yr.entry.UserMapper;
//注解的實現和接口+xml實現
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
	 * 添加
	 */
	public void add() {
		SqlSessionFactory sessionFactory = getFactory();
		// 默认是手动提交的
		session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int insert = mapper.addUser(new User("aaa", "333", "333",20, "男", "131113331", "111@qq.com", "深圳"));
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
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		int update = mapper.updateUser(new User(3,"aaa", "333", "333",20, "男", "131113331", "111@qq.com", "深圳"));
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
		UserMapper mapper = session.getMapper(UserMapper.class);
		int delete = mapper.delUser(6);
		session.close();
		System.out.println("成功删除" + delete + "条数据");
	}
}
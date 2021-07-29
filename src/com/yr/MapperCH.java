package com.yr;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yr.entry.User;
import com.yr.entry.UserMapper;

public class MapperCH {
	public static void main(String[] args) throws IOException {
		String resource = "conf.xml";
		// ����mybatis�������ļ�(��Ҳ���ع�����ӳ���ļ�)
		Reader reader = Resources.getResourceAsReader(resource);
		// ����sqlSession�Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// ������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session1 = sessionFactory.openSession();
		// ӳ��sql�ı�ʶ�ַ���
        
		UserMapper	mapper = session1.getMapper(UserMapper.class);	// ִ�в�ѯ����һ��Ψһuser�����sql
		User user1 = mapper.getUser(1);
		System.out.println("��һ��:   " + user1.toString());

		// ����һ��Ҫ�ύ��close(),�ύ��رպ����ݲŻỺ�浽����������ȥ,����������治��Ч
		session1.commit();
		//session1.close();

		SqlSession session2 = sessionFactory.openSession();
		User user2 = mapper.getUser(1);
		System.out.println("�ڶ���:   " + user2.toString());
	//	session2.commit();// ������Բ��ύ��ر�

	}
}


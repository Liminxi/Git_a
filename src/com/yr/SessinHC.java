package com.yr;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yr.entry.User;
import com.yr.entry.UserMapper;

public class SessinHC {
	public static void main(String[] args) throws IOException {
			String resource = "conf.xml";
			// ����mybatis�������ļ�(��Ҳ���ع�����ӳ���ļ�)
			Reader reader = Resources.getResourceAsReader(resource);
			// ����sqlSession�Ĺ���
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			// ������ִ��ӳ���ļ���sql��sqlSession
			SqlSession session = sessionFactory.openSession();
			// ӳ��sql�ı�ʶ�ַ���
			UserMapper mapper = session.getMapper(UserMapper.class);
			// ִ�в�ѯ����һ��Ψһuser�����sql
			User user;
			user =mapper.getUser(1);
			System.out.println("��һ��:   " + user.toString());
	
			user =mapper.getUser(1);//���õ��������Y�飬ֱ�ӏ�session�Y��
			System.out.println("�ڶ���:   " + user.toString());
			//�������
			//session.clearCache();
			// ����ִ����ɾ�Ĳ���Ҳ��ɾ������
	        mapper.addUser(new User("lmx", "333", "333",23, "��", "131113331", "111@qq.com", "����"));
			user =mapper.getUser(1);
			System.out.println("������:   " + user.toString());
	
		}
}


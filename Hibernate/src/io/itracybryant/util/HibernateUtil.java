/**
 * 
 */
package io.itracybryant.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @XinCheng 2018��4��5�� Administrator
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;

	static {
		// ����Configuration���󣬶�ȡhibernate.cfg.xml�ļ�����ɳ�ʼ��
		// Configuration config = new Configuration().configure();
		// hibernate5���ϻ�ȡSessionFactory����

		// ��������ע�����
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
		// �����Ự��������
		sessionFactory = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
	}

	// ��ȡSessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// ��ȡSession
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}

	// �ر�Session
	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}

}

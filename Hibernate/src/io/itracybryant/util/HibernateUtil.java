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
 * @XinCheng 2018年4月5日 Administrator
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;

	static {
		// 创建Configuration对象，读取hibernate.cfg.xml文件，完成初始化
		// Configuration config = new Configuration().configure();
		// hibernate5以上获取SessionFactory方法

		// 创建服务注册对象
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
		// 创建会话工厂对象
		sessionFactory = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
	}

	// 获取SessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// 获取Session
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}

	// 关闭Session
	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}

}

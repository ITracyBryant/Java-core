package io.itracybryant.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import io.itracybryant.entity.Grade;
import io.itracybryant.util.HibernateUtil;

public class TestCache {
	public static void main(String[] args) {
		Session session1 = HibernateUtil.getSession();
		Transaction tx1 = session1.beginTransaction();
		// 加载id为1的对象
		Grade grade1 = (Grade) session1.get(Grade.class, 1);
		System.out.println("session1：" + grade1.getGname());
		tx1.commit();
		HibernateUtil.closeSession(session1);

		// 加载同样id为1的对象
		Session session2 = HibernateUtil.getSession();
		Transaction tx2 = session2.beginTransaction();
		Grade grade2 = (Grade) session2.get(Grade.class, 1);
		System.out.println("session2：" + grade2.getGname());
		tx2.commit();
		HibernateUtil.closeSession(session2);
	}

}

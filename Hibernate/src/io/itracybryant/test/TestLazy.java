package io.itracybryant.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import io.itracybryant.entity.Student;
import io.itracybryant.util.HibernateUtil;

public class TestLazy {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		// Grade grade = (Grade) session.get(Grade.class, 1);
		Student student = (Student) session.get(Student.class, 2);
		System.out.println(student.getSname());
		// System.out.println(grade.getGname());

	}

}

package io.itracybryant.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import io.itracybryant.entity.Grade;
import io.itracybryant.entity.Student;
import io.itracybryant.util.HibernateUtil;

/*
 * 单向多对一（学生--->班级）
 * 实际上已经建立以双向一对多(双向多对一)的关联关系
 * 既可以由学生查找到对应的班级信息，也可以由班级查找到所包含的学生信息(自动导航查询)
 */
public class Test02 {
	public static void main(String[] args) {
		// save();
		findGradeByStudent();
	}

	// 保存
	public static void save() {
		Grade g = new Grade("电子一班", "电子通信与工程一班");
		Student stu1 = new Student("li", "女");
		Student stu2 = new Student("zhang", "男");

		// 设置关联关系
		g.getStudents().add(stu1);
		g.getStudents().add(stu2);
		stu1.setGrade(g);
		stu2.setGrade(g);

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(g);// 自动级联操作
		// session.save(stu1);
		// session.save(stu2);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	// 查询学生所在班级信息
	public static void findGradeByStudent() {
		Session session = HibernateUtil.getSession();
		Student stu = (Student) session.get(Student.class, 2);
		System.out.println(stu.getSid() + "," + stu.getSname() + "," + stu.getSex());

		Grade g = stu.getGrade();
		System.out.println(g.getGid() + "," + g.getGname() + "," + g.getGdesc());
		HibernateUtil.closeSession(session);
	}
}

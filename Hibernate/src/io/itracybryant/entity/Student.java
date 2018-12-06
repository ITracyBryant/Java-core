/**
 * 
 */
package io.itracybryant.entity;

import java.io.Serializable;

/**
 * @XinCheng 2018��4��5�� Administrator
 *
 */
@SuppressWarnings("serial")
public class Student implements Serializable {
	private int sid;
	private String sname;
	private String sex;
	// �ڶ෽����һ��һ��������
	private Grade grade;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 
	 */
	public Student() {
		super();
	}

	/**
	 * @param sname
	 * @param sex
	 */
	public Student(String sname, String sex) {
		super();
		this.sname = sname;
		this.sex = sex;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

}

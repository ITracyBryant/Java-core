/**
 * 
 */
package io.itracybryant.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @XinCheng 2018年4月5日 Administrator
 *
 */
@SuppressWarnings("serial")
public class Grade implements Serializable {
	private int gid;
	private String gname;
	private String gdesc;
	// 在一方定义多方的集合 一对多
	private Set<Student> students = new HashSet<Student>();

	/**
	 * 
	 */
	public Grade() {
		super();
	}

	/**
	 * @param gid
	 * @param gname
	 * @param gdesc
	 * @param students
	 */
	public Grade(int gid, String gname, String gdesc, Set<Student> students) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gdesc = gdesc;
		this.students = students;
	}

	/**
	 * @param gname
	 * @param gdesc
	 */
	public Grade(String gname, String gdesc) {
		super();
		this.gname = gname;
		this.gdesc = gdesc;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGdesc() {
		return gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}

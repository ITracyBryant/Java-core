package entity;

import java.io.Serializable;

public class Fly_plan implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String area;
	private String apply_city;
	private String plan_use;
	private Float max_hight;
	private String start_index;
	private String end_index;
	private String start_time;
	private String end_time;
	private String user_name;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getApply_city() {
		return apply_city;
	}
	public void setApply_city(String apply_city) {
		this.apply_city = apply_city;
	}
	public String getPlan_use() {
		return plan_use;
	}
	public void setPlan_use(String plan_use) {
		this.plan_use = plan_use;
	}
	public Float getMax_hight() {
		return max_hight;
	}
	public void setMax_hight(Float max_hight) {
		this.max_hight = max_hight;
	}
	public String getStart_index() {
		return start_index;
	}
	public void setStart_index(String start_index) {
		this.start_index = start_index;
	}
	public String getEnd_index() {
		return end_index;
	}
	public void setEnd_index(String end_index) {
		this.end_index = end_index;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Fly_plan(String area, String apply_city, String plan_use, Float max_hight, String start_index, String end_index, String start_time,
			String end_time, String user_name) {
		super();
		this.area = area;
		this.apply_city = apply_city;
		this.plan_use = plan_use;
		this.max_hight = max_hight;
		this.start_index = start_index;
		this.end_index = end_index;
		this.start_time = start_time;
		this.end_time = end_time;
		this.user_name = user_name;
	}
	@Override
	public String toString() {
		return "Fly_plan [id=" + id + ", area=" + area + ", apply_city=" + apply_city + ", plan_use=" + plan_use + ", max_hight=" + max_hight
				+ ", start_index=" + start_index + ", end_index=" + end_index + ", start_time=" + start_time + ", end_time=" + end_time
				+ ", user_name=" + user_name + ", status=" + status + "]";
	}
	public Fly_plan() {
		super();
	}
	
}

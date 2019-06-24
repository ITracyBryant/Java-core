package entity;

import java.io.Serializable;

public class No_fly implements Serializable{
	private Integer id;
	private String type;
	private String info;
	private Long startime;
	private Long endtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Long getStartime() {
		return startime;
	}
	public void setStartime(Long startime) {
		this.startime = startime;
	}
	public Long getEndtime() {
		return endtime;
	}
	public void setEndtime(Long endtime) {
		this.endtime = endtime;
	}
	public No_fly(String type, String info, Long startime, Long endtime) {
		super();
		this.type = type;
		this.info = info;
		this.startime = startime;
		this.endtime = endtime;
	}
	public No_fly() {
		super();
	}
	
}

package entity;

public class No_Fly {
	private Integer id;
	private Integer pointnum;
	private String type;
	private String info;
	private String time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPointnum() {
		return pointnum;
	}
	public void setPointnum(Integer pointnum) {
		this.pointnum = pointnum;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public No_Fly(Integer id, Integer pointnum, String type, String info, String time) {
		super();
		this.id = id;
		this.pointnum = pointnum;
		this.type = type;
		this.info = info;
		this.time = time;
	}
	public No_Fly(Integer pointnum, String type, String info, String time) {
		super();
		this.pointnum = pointnum;
		this.type = type;
		this.info = info;
		this.time = time;
	}
	public No_Fly() {
		super();
	}
	
}

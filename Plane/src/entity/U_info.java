package entity;

public class U_info {
	private Integer id;
	private String user;
	private String startime;
	private String endtime;
	private Float start_lat;
	private Float start_lon;
	private Float end_lat;
	private Float end_lon;
	
	public Float getStart_lat() {
		return start_lat;
	}
	public void setStart_lat(Float start_lat) {
		this.start_lat = start_lat;
	}
	public Float getStart_lon() {
		return start_lon;
	}
	public void setStart_lon(Float start_lon) {
		this.start_lon = start_lon;
	}
	public Float getEnd_lat() {
		return end_lat;
	}
	public void setEnd_lat(Float end_lat) {
		this.end_lat = end_lat;
	}
	public Float getEnd_lon() {
		return end_lon;
	}
	public void setEnd_lon(Float end_lon) {
		this.end_lon = end_lon;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getStartime() {
		return startime;
	}
	public void setStartime(String startime) {
		this.startime = startime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
}

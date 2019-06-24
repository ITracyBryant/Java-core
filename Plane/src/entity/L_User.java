package entity;

import java.io.Serializable;

public class L_User implements Serializable{
	private Integer id;
	private String user;
	private String euq;
	private Float row;
	private Float yaw;
	private Float lon;
	private Float lat;
	private Float alt;
	private Float pit;
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
	public String getEuq() {
		return euq;
	}
	public void setEuq(String euq) {
		this.euq = euq;
	}
	public Float getRow() {
		return row;
	}
	public void setRow(Float row) {
		this.row = row;
	}
	public Float getYaw() {
		return yaw;
	}
	public void setYaw(Float yaw) {
		this.yaw = yaw;
	}
	public Float getLon() {
		return lon;
	}
	public void setLon(Float lon) {
		this.lon = lon;
	}
	public Float getLat() {
		return lat;
	}
	public void setLat(Float lat) {
		this.lat = lat;
	}
	public Float getAlt() {
		return alt;
	}
	public void setAlt(Float alt) {
		this.alt = alt;
	}
	public Float getPit() {
		return pit;
	}
	public void setPit(Float pit) {
		this.pit = pit;
	}
	public L_User(Integer id, String user, String euq, Float row, Float yaw, Float lon, Float lat, Float alt, Float pit) {
		super();
		this.id = id;
		this.user = user;
		this.euq = euq;
		this.row = row;
		this.yaw = yaw;
		this.lon = lon;
		this.lat = lat;
		this.alt = alt;
		this.pit = pit;
	}
	public L_User() {
		super();
	}
	public L_User(String user, Float row, Float yaw, Float lon, Float lat, Float alt, Float pit) {
		super();
		this.user = user;
		this.row = row;
		this.yaw = yaw;
		this.lon = lon;
		this.lat = lat;
		this.alt = alt;
		this.pit = pit;
	}
	
}

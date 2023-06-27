package com.scuderiabigballs.evaluator.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "alert")
public class Alert {
	@Id
	@Column(name = "code")
	private Integer code;
	@Column(name = "type")
	private String type;
	@Column(name = "area")
	private String area;
	@Column(name = "floor")
	private Integer floor;
	@Column(name = "date")
	private Date date;
	public Alert(Integer code, String type, String area, Integer floor, Date date) {
		super();
		this.code = code;
		this.type = type;
		this.area = area;
		this.floor = floor;
		this.date = date;
	}
	public Alert() {
		super();
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}

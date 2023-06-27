package com.scuderiabigballs.evaluator.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "personnel_report")
public class PersonnelReport {
	@Id
	@Column(name = "code")
	private Integer code;
	@Column(name = "name")
	private String name;
	@Column(name = "details")
	private String details;
	@Column(name = "state")
	private String state;
	@Column(name = "date")
	private Date date;
	public PersonnelReport(Integer code, String name, String details, String state, Date date) {
		super();
		this.code = code;
		this.name = name;
		this.details = details;
		this.state = state;
		this.date = date;
	}
	public PersonnelReport() {
		super();
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}

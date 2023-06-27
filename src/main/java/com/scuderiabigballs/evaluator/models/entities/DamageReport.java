package com.scuderiabigballs.evaluator.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "damage_report")
public class DamageReport {
	@Id
	@Column(name = "code")
	private Integer code;
	@Column(name = "type")
	private String type;
	@Column(name = "details")
	private String details;
	@Column(name = "date")
	private Date date;
	@Column(name = "losses")
	private Double losses;
	@Column(name = "losses_details")
	private String lossesDetails;
	@Column(name = "helpers")
	private String helpers;
	public DamageReport(Integer code, String type, String details, Date date, Double losses, String lossesDetails,
			String helpers) {
		super();
		this.code = code;
		this.type = type;
		this.details = details;
		this.date = date;
		this.losses = losses;
		this.lossesDetails = lossesDetails;
		this.helpers = helpers;
	}
	public DamageReport() {
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
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getLosses() {
		return losses;
	}
	public void setLosses(Double losses) {
		this.losses = losses;
	}
	public String getLossesDetails() {
		return lossesDetails;
	}
	public void setLossesDetails(String lossesDetails) {
		this.lossesDetails = lossesDetails;
	}
	public String getHelpers() {
		return helpers;
	}
	public void setHelpers(String helpers) {
		this.helpers = helpers;
	}
}

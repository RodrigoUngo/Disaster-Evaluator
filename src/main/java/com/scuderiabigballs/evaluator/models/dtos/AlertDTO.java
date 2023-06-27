package com.scuderiabigballs.evaluator.models.dtos;

import javax.validation.constraints.NotBlank;

public class AlertDTO {
	@NotBlank
	private String type;
	@NotBlank
	private String area;
	private Integer floor;
	public AlertDTO(String type, String area, Integer floor) {
		super();
		this.type = type;
		this.area = area;
		this.floor = floor;
	}
	public AlertDTO() {
		super();
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
}

package com.scuderiabigballs.evaluator.models.dtos;

import javax.validation.constraints.NotBlank;

public class PersonnelReportDTO {
	@NotBlank
	private String person;
	@NotBlank
	private String details;
	public PersonnelReportDTO(String person, String details) {
		super();
		this.person = person;
		this.details = details;
	}
	public PersonnelReportDTO() {
		super();
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}

package com.scuderiabigballs.evaluator.models.dtos;

import javax.validation.constraints.NotBlank;

public class DamageReportDTO {
	@NotBlank
	private String type;
	@NotBlank
	private String details;
	private Double losses;
	@NotBlank
	private String lossesDetails;
	@NotBlank
	private String helpers;
	public DamageReportDTO(String type, String details, Double losses, String lossesDetails, String helpers) {
		super();
		this.type = type;
		this.details = details;
		this.losses = losses;
		this.lossesDetails = lossesDetails;
		this.helpers = helpers;
	}
	public DamageReportDTO() {
		super();
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

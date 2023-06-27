package com.scuderiabigballs.evaluator.services;

import com.scuderiabigballs.evaluator.models.dtos.AlertDTO;
import com.scuderiabigballs.evaluator.models.dtos.DamageReportDTO;
import com.scuderiabigballs.evaluator.models.dtos.PersonnelReportDTO;

public interface ReportsService {
	void createAlert(AlertDTO alertInfo) throws Exception;
	void createDamageReport(DamageReportDTO reportInfo) throws Exception;
	void createInjuredReport(PersonnelReportDTO personnelInfo) throws Exception;
	void createMissingReport(PersonnelReportDTO personnelInfo) throws Exception;
	void createDeceasedReport(PersonnelReportDTO personnelInfo) throws Exception;
}

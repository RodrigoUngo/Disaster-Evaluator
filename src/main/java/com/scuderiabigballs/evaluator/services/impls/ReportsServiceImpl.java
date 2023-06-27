package com.scuderiabigballs.evaluator.services.impls;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scuderiabigballs.evaluator.models.dtos.AlertDTO;
import com.scuderiabigballs.evaluator.models.dtos.DamageReportDTO;
import com.scuderiabigballs.evaluator.models.dtos.PersonnelReportDTO;
import com.scuderiabigballs.evaluator.models.entities.Alert;
import com.scuderiabigballs.evaluator.models.entities.DamageReport;
import com.scuderiabigballs.evaluator.models.entities.PersonnelReport;
import com.scuderiabigballs.evaluator.repositories.AlertRepository;
import com.scuderiabigballs.evaluator.repositories.DamageReportRepository;
import com.scuderiabigballs.evaluator.repositories.PersonnelReportRepository;
import com.scuderiabigballs.evaluator.services.ReportsService;

@Service
public class ReportsServiceImpl implements ReportsService {
	
	@Autowired
	AlertRepository alertRepository;
	
	@Autowired
	DamageReportRepository damageReportRepository;
	
	@Autowired
	PersonnelReportRepository personnelReportRepository;
	
	@Override
	public void createAlert(AlertDTO alertInfo) throws Exception {
		Random random = new Random();
		Integer code = random.nextInt(999999 + 100000) + 100000;
		Date today = new Date();
		Alert alert = new Alert();
		alert.setCode(code);
		alert.setArea(alertInfo.getArea());
		alert.setFloor(alertInfo.getFloor());
		alert.setType(alertInfo.getType());
		alert.setDate(today);
		
		alertRepository.save(alert);
	}

	@Override
	public void createDamageReport(DamageReportDTO reportInfo) throws Exception {
		Random random = new Random();
		Integer code = random.nextInt(999999 + 100000) + 100000;
		Date today = new Date();
		DamageReport damageReport = new DamageReport();
		damageReport.setCode(code);
		damageReport.setType(reportInfo.getType());
		damageReport.setDetails(reportInfo.getDetails());
		damageReport.setDate(today);
		damageReport.setLosses(reportInfo.getLosses());
		damageReport.setLossesDetails(reportInfo.getLossesDetails());
		damageReport.setHelpers(reportInfo.getHelpers());
		
		damageReportRepository.save(damageReport);
	}

	@Override
	public void createInjuredReport(PersonnelReportDTO personnelInfo) throws Exception {
		Random random = new Random();
		Integer code = random.nextInt(999999 + 100000) + 100000;
		Date today = new Date();
		PersonnelReport personnelReport = new PersonnelReport();
		personnelReport.setCode(code);
		personnelReport.setName(personnelInfo.getPerson());
		personnelReport.setDetails(personnelInfo.getDetails());
		personnelReport.setState("Lesionado");
		personnelReport.setDate(today);
		
		personnelReportRepository.save(personnelReport);
	}

	@Override
	public void createMissingReport(PersonnelReportDTO personnelInfo) throws Exception {
		Random random = new Random();
		Integer code = random.nextInt(999999 + 100000) + 100000;
		Date today = new Date();
		PersonnelReport personnelReport = new PersonnelReport();
		personnelReport.setCode(code);
		personnelReport.setName(personnelInfo.getPerson());
		personnelReport.setDetails(personnelInfo.getDetails());
		personnelReport.setState("Desaparecido");
		personnelReport.setDate(today);
		
		personnelReportRepository.save(personnelReport);
	}

	@Override
	public void createDeceasedReport(PersonnelReportDTO personnelInfo) throws Exception {
		Random random = new Random();
		Integer code = random.nextInt(999999 + 100000) + 100000;
		Date today = new Date();
		PersonnelReport personnelReport = new PersonnelReport();
		personnelReport.setCode(code);
		personnelReport.setName(personnelInfo.getPerson());
		personnelReport.setDetails(personnelInfo.getDetails());
		personnelReport.setState("Fallecido");
		personnelReport.setDate(today);
		
		personnelReportRepository.save(personnelReport);
	}

}

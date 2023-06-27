package com.scuderiabigballs.evaluator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scuderiabigballs.evaluator.models.dtos.AlertDTO;
import com.scuderiabigballs.evaluator.models.dtos.DamageReportDTO;
import com.scuderiabigballs.evaluator.models.dtos.LoginDTO;
import com.scuderiabigballs.evaluator.models.dtos.PersonnelReportDTO;
import com.scuderiabigballs.evaluator.models.dtos.UserInfoDTO;
import com.scuderiabigballs.evaluator.models.entities.User;
import com.scuderiabigballs.evaluator.services.ReportsService;
import com.scuderiabigballs.evaluator.services.UserService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ReportsService reportsService;
	
	@GetMapping("/")
	public String getMainPage(Model model) {
		return "user/main";
	}
	
	@GetMapping("/signup")
	public String getRegisterPage(Model model) {
		model.addAttribute("register", new UserInfoDTO("", "", "", ""));
		return "user/register";
	}
	
	@PostMapping("/signup")
	public String registerUser(
			@ModelAttribute(name="register")
			@Valid UserInfoDTO userInfo,
			BindingResult result) {
		try {
			if(result.hasErrors()) {
				if(result.hasErrors()) {
					return "errors/bad-request";
				}
			}
			
			User foundUser = userService.findOneByEmail(userInfo.getEmail());
			
			if(foundUser != null) {
				return "user/user-alreadyRegistered";
			}
			
			userService.register(userInfo);
			
			return "user/user-registered";
			
		} catch (Exception e) {
			return "errors/internalServerError";
		}
	}
	
	@GetMapping("/signin")
	public String getLoginPage(Model model) {
		model.addAttribute("login", new LoginDTO("", ""));
		return "user/login";
	}
	
	@PostMapping("/signin")
	public String login(
			@ModelAttribute(name="login")
			@Valid LoginDTO loginInfo,
			BindingResult result) {
			try {
				
				if(result.hasErrors()) {
					return "errors/bad-request";
				}
				
				User user = userService.findOneByEmail(loginInfo.getEmail());
				
				if(!userService.comparePassword(user, loginInfo.getPassword())) {
					return "errors/unauthorized";
				}
				
				return "redirect:/project/menu";
				
			} catch (Exception e) {
				return "errors/internalServerError";
			}
	}
	
	@GetMapping("/menu")
	public String getAdminMenu(Model model) {
		return "admin-menu/admin";
	}
	
	@GetMapping("/admin/hurt")
	public String getHurtPersonnelForm(Model model) {
		model.addAttribute("report", new PersonnelReportDTO("", ""));
		return "reportForms/hurtEmp";
	}
	
	@PostMapping("/admin/hurt")
	public String createHurtPersonnelReport(
			@ModelAttribute(name="report")
			@Valid PersonnelReportDTO personnelInfo,
			BindingResult result) {
		try {
			if(result.hasErrors()) {
				//String errors = result.getAllErrors().toString();
				return "errors/bad-request";
			}
			reportsService.createInjuredReport(personnelInfo);
			return "reportForms/report-created";
		} catch (Exception e) {
			return "errors/internalServerError";
		}
	}
	
	@GetMapping("/admin/missing")
	public String getMissingPersonnelForm(Model model) {
		model.addAttribute("report", new PersonnelReportDTO("", ""));
		return "reportForms/missingEmp";
	}
	
	@PostMapping("/admin/missing")
	public String createMissingPersonnelReport(
			@ModelAttribute(name="report")
			@Valid PersonnelReportDTO personnelInfo,
			BindingResult result) {
		try {
			if(result.hasErrors()) {
				//String errors = result.getAllErrors().toString();
				return "errors/bad-request";
			}
			reportsService.createMissingReport(personnelInfo);
			return "reportForms/report-created";
		} catch (Exception e) {
			return "errors/internalServerError";
		}
	}
	
	@GetMapping("/admin/deceased")
	public String getDeadPersonnelForm(Model model) {
		model.addAttribute("report", new PersonnelReportDTO("", ""));
		return "reportForms/deadEmp";
	}
	
	@PostMapping("/admin/deceased")
	public String createDeceasedPersonnelReport(
			@ModelAttribute(name="report")
			@Valid PersonnelReportDTO personnelInfo,
			BindingResult result) {
		try {
			if(result.hasErrors()) {
				//String errors = result.getAllErrors().toString();
				return "errors/bad-request";
			}
			reportsService.createDeceasedReport(personnelInfo);
			return "reportForms/report-created";
		} catch (Exception e) {
			return "errors/internalServerError";
		}
	}
	
	@GetMapping("/admin/damages")
	public String getMaterialDamageForm(Model model) {
		model.addAttribute("report", new DamageReportDTO("", "", 0.0, "", ""));
		return "reportForms/damageReport";
	}
	
	@PostMapping("/admin/damages")
	public String createDamageReport(
			@ModelAttribute(name="report")
			@Valid DamageReportDTO damageInfo,
			BindingResult result) {
		try {
			if(result.hasErrors()) {
				//String errors = result.getAllErrors().toString();
				return "errors/bad-request";
			}
			reportsService.createDamageReport(damageInfo);
			return "reportForms/report-created";
		} catch (Exception e) {
			return "errors/internalServerError";
		}
	}
	
	@GetMapping("/admin/history")
	public String getReportHistory(Model model) {
		return "admin-menu/HistReports";
	}
	
	@GetMapping("/admin/map")
	public String getMap(Model model) {
		return "admin-menu/CroquisAdm";
	}
	
	@GetMapping("/admin/generate")
	public String getGenerateEmergency(Model model) {
		model.addAttribute("alert", new AlertDTO("", "", 0));
		return "admin-menu/GenEmergencia";
	}
	
	@PostMapping("/admin/generate")
	public String GenerateEmergency(
			@ModelAttribute(name="alert")
			@Valid AlertDTO alertInfo,
			BindingResult result) {
		try {
			if(result.hasErrors()) {
				//String errors = result.getAllErrors().toString();¿
				return "errors/bad-request";
			}
			reportsService.createAlert(alertInfo);
			return "reportForms/report-created";
		} catch (Exception e) {
			return "errors/internalServerError";
		}
	}
}

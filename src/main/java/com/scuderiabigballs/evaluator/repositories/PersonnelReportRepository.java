package com.scuderiabigballs.evaluator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scuderiabigballs.evaluator.models.entities.PersonnelReport;

public interface PersonnelReportRepository extends JpaRepository<PersonnelReport, Integer> {

}

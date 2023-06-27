package com.scuderiabigballs.evaluator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scuderiabigballs.evaluator.models.entities.DamageReport;

public interface DamageReportRepository extends JpaRepository<DamageReport, Integer> {
	DamageReport findOneByCode(Integer code);
}

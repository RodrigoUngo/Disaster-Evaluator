package com.scuderiabigballs.evaluator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scuderiabigballs.evaluator.models.entities.Alert;

public interface AlertRepository extends JpaRepository<Alert, Integer> {
	Alert findOneByCode(Integer code);
}

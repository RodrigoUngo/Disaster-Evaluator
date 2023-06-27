package com.scuderiabigballs.evaluator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scuderiabigballs.evaluator.models.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByEmail(String email);
}

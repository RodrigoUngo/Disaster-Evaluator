package com.scuderiabigballs.evaluator.services;

import com.scuderiabigballs.evaluator.models.dtos.UserInfoDTO;
import com.scuderiabigballs.evaluator.models.entities.User;

public interface UserService {
	void register(UserInfoDTO userInfo) throws Exception;
	User findOneByEmail(String email) throws Exception;
	Boolean comparePassword(User user, String passToCompare) throws Exception;
}

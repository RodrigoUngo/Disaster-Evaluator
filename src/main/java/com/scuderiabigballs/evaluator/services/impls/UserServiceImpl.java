package com.scuderiabigballs.evaluator.services.impls;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scuderiabigballs.evaluator.repositories.UserRepository;
import com.scuderiabigballs.evaluator.models.dtos.LoginDTO;
import com.scuderiabigballs.evaluator.models.dtos.UserInfoDTO;
import com.scuderiabigballs.evaluator.models.entities.User;
import com.scuderiabigballs.evaluator.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void register(UserInfoDTO userInfo) throws Exception {
		User user = new User();
		
		String encryptedPassword = passEncoder.encode(userInfo.getPassword());
		
		user.setName(userInfo.getName());
		user.setLastname(userInfo.getLastname());
		user.setEmail(userInfo.getEmail());
		user.setPassword(encryptedPassword);
		
		userRepository.save(user);
	}

	@Override
	public User findOneByEmail(String email) throws Exception {
		User foundUser = userRepository	
				.findOneByEmail(email);
		
		return foundUser;
	}

	@Override
	public Boolean comparePassword(User user, String passToCompare) throws Exception {
		return passEncoder.matches(passToCompare, user.getPassword());
	}
	
}

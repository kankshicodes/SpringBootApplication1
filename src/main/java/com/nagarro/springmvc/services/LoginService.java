/**
 * 
 */
package com.nagarro.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.springmvc.dao.UserRepository;
import com.nagarro.springmvc.entity.UserModel;

/**
 * This class is use for login service  for user request
 * @author ravikumar05
 *
 */
@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserModel login(Integer userid, String password) {
		UserModel user = userRepository.findByUserIdAndPassword(userid, password);
		return user;
	}
	
	public List<UserModel> getUserDetails(){
		List<UserModel> userlist = (List<UserModel>) userRepository.findAll();
		return userlist;
	}

}

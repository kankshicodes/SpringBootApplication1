package com.nagarro.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//
//import com.nagarro.springmvc.dao.UserRepository;
//import com.nagarro.springmvc.entity.UserModel;

@SpringBootApplication
public class SpringmvcWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcWebApplication.class, args);
//		 ApplicationContext context = 
//		UserRepository userRepository = context.getBean(UserRepository.class);
//		
//		UserModel usermodel = new UserModel();
//		usermodel.setUserid(2125);
//		usermodel.setPassword("nagarro@123");
//		UserModel user = userRepository.save(usermodel);
//		System.out.print(user);
	}

}

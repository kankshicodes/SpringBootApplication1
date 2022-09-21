package com.nagarro.springmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.nagarro.springmvc.entity.UserModel;
/**
 * This class use for UserRespsotory interface  finding userId and user name of the user.
 * @author ravikumar05
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
	@Query("FROM UserModel ul WHERE ul.userid = ?1 and ul.password = ?2")
	UserModel findByUserIdAndPassword(Integer userid, String password);
}

/**
 * 
 */
package com.nagarro.springmvc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * This class is use for user login model
 * @author ravikumar05
 *
 */
@Entity
@Component
public class UserModel {
	
	@Id
	private int userid;
	private String password;
	
	/**
	 * 
	 */
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param userid
	 * @param password
	 */
	public UserModel(int userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserModel [userid=" + userid + ", password=" + password + "]";
	}
	
	
}

package services.service;

import java.util.List;

import models.Users;
import play.exceptions.BaseException;

public interface UsersServiceI {

	Users createUser(String userType) throws BaseException;
	
	Users findUserById(Long userId) throws BaseException;
	
	List<Users> users() throws BaseException;
	
	void deleteUser(Long userId) throws BaseException;
}

package services.service;

import controllers.requestdto.UsersRequestDto;
import models.Users;
import models.UsersFrugal;
import play.exceptions.BaseException;

public interface UsersFrugalServiceI {

	UsersFrugal createUser(UsersRequestDto userRequestDto, Users user) throws BaseException;
	
	UsersFrugal findUserById(Long userId) throws BaseException;
	
	UsersFrugal login(UsersRequestDto userRequestDto) throws BaseException;
	
	UsersFrugal findUserByEmailId(String emailId) throws BaseException;
}

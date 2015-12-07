package services.service;

import controllers.requestdto.UsersRequestDto;
import models.Users;
import models.UsersSocial;
import play.exceptions.BaseException;

public interface UsersSocialServiceI {

	UsersSocial createUser(UsersRequestDto userRequestDto, Users user) throws BaseException;
	
	UsersSocial login(UsersRequestDto userRequestDto) throws BaseException;
	
	UsersSocial findUserById(Long userId) throws BaseException;
}

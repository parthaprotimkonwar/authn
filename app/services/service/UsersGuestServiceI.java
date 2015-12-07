package services.service;

import controllers.requestdto.UsersRequestDto;
import models.Users;
import models.UsersGuest;
import play.exceptions.BaseException;

public interface UsersGuestServiceI {

	UsersGuest createUser(UsersRequestDto userRequestDto, Users user) throws BaseException;
	
	UsersGuest login(UsersRequestDto userRequestDto) throws BaseException;
	
	UsersGuest findUserById(Long userId) throws BaseException;
}

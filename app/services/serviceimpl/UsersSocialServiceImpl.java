package services.serviceimpl;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import controllers.requestdto.UsersRequestDto;
import models.Users;
import models.UsersSocial;
import play.exceptions.BaseException;
import play.exceptions.ErrorConstants;
import repository.UsersSocialRepository;
import services.service.UsersSocialServiceI;
import utilities.AppConstants;

@Named
@Singleton
public class UsersSocialServiceImpl implements UsersSocialServiceI{

	@Inject
	UsersSocialRepository usersSocialRepository;

	@Override
	public UsersSocial createUser(UsersRequestDto request, Users user) throws BaseException{
		try {
			Date now = new Date();
			UsersSocial userSocial = new UsersSocial(user.userId, request.name, now, now, request.email, request.phoneNo, AppConstants.Status.ACTIVE.name());
			return usersSocialRepository.save(userSocial);
			
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	
	@Override
	public UsersSocial findUserById(Long userId) throws BaseException{
		try {
			return usersSocialRepository.findOne(userId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}


	@Override
	public UsersSocial login(UsersRequestDto userRequestDto) throws BaseException{
		try {
			return usersSocialRepository.findByEmailId(userRequestDto.email);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}
}

package services.serviceimpl;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

import controllers.requestdto.UsersRequestDto;
import models.Users;
import models.UsersGuest;
import play.exceptions.BaseException;
import play.exceptions.ErrorConstants;
import repository.UsersGuestRepository;
import services.service.UsersGuestServiceI;
import utilities.AppConstants;

@Named
@Singleton
public class UsersGuestServiceImpl implements UsersGuestServiceI{

	@Inject
	UsersGuestRepository userGuestRepository;
	
	@Override
	public UsersGuest createUser(UsersRequestDto request, Users user) throws BaseException {
		try {
			Date now = new Date();
			UsersGuest userGuest = new UsersGuest(user.userId, request.email, now, now, request.phoneNo, AppConstants.Status.ACTIVE.name());
			return userGuestRepository.save(userGuest);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public UsersGuest findUserById(@NotNull Long userId) throws BaseException{
		try {
			return userGuestRepository.findOne(userId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public UsersGuest login(UsersRequestDto userRequestDto) throws BaseException {
		try {
			return userGuestRepository.findByEmailId(userRequestDto.email);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}
}

package services.serviceimpl;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

import controllers.requestdto.UsersRequestDto;
import models.Users;
import models.UsersFrugal;
import play.exceptions.BaseException;
import play.exceptions.ErrorConstants;
import repository.UsersFrugalRepository;
import services.service.UsersFrugalServiceI;
import utilities.AppConstants.Status;

@Named
@Singleton
public class UsersFrugalServiceImpl implements UsersFrugalServiceI{

	@Inject
	UsersFrugalRepository userFrugalRepository;

	@Override
	public UsersFrugal createUser(UsersRequestDto request, @NotNull Users user) throws BaseException{
		try {
			Date now = new Date();
			UsersFrugal userFrugal = new UsersFrugal(user.userId, request.name, request.password, now, now, request.email, request.phoneNo, Status.CONFIRMATION_PENDING.name());
			return userFrugalRepository.save(userFrugal);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public UsersFrugal findUserById(@NotNull Long userId) throws BaseException {
		try {
			return userFrugalRepository.findOne(userId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public UsersFrugal login(UsersRequestDto userRequestDto) throws BaseException {
		try {
			return userFrugalRepository.findByEmailIdAndPassword(userRequestDto.email, userRequestDto.password);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public UsersFrugal findUserByEmailId(String emailId) throws BaseException {
		try {
			return userFrugalRepository.findByEmailId(emailId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
		
	}

}

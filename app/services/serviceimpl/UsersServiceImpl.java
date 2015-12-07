package services.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

import models.Users;
import play.exceptions.BaseException;
import play.exceptions.ErrorConstants;
import repository.UsersRepository;
import services.service.UsersServiceI;

@Named
@Singleton
public class UsersServiceImpl implements UsersServiceI{

	@Inject
	UsersRepository usersRepository;
	
	@Override
	public Users createUser(String userType) throws BaseException{
		try {
			Users user = new Users(userType);
			usersRepository.save(user);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public Users findUserById(@NotNull Long userId) throws BaseException{
		try {
			return usersRepository.findOne(userId); 
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public List<Users> users() throws BaseException{
		try {
			return usersRepository.findAll();
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public void deleteUser(Long userId) throws BaseException {
		try {
			usersRepository.delete(userId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_REMOVAL_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

}

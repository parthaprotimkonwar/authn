package services.serviceimpl;

import static play.utilities.Util.addTimeToDate;
import static play.utilities.Util.getSystemTimeInMillis;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

import models.UserToken;
import models.Users;
import play.exceptions.BaseException;
import play.exceptions.ErrorConstants;
import play.utilities.Crypto;
import static play.utilities.Util.*;
import repository.UserTokenRepository;
import services.service.UserTokenServiceI;

@Named
@Singleton
public class UserTokenServiceImpl implements UserTokenServiceI{

	@Inject
	UserTokenRepository userTokenRepository;

	@Override
	public UserToken createToken(Long userId) throws BaseException {
		try {
			String token = Crypto.generateUniqueRandomString();
			Long time = addTimeToDate(getSystemTimeInMillis(), 20);
			Users user = new Users(userId);
			UserToken userToken = new UserToken(token, time , user);
			UserToken theToken = userTokenRepository.save(userToken);
			return theToken;
			
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public Boolean tokenExist(@NotNull String tokenId) throws BaseException{
		try {
			return userTokenRepository.exists(tokenId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	
	@Override
	public UserToken tokenExistForUser(@NotNull Long userId) throws BaseException{
		try {
			return userTokenRepository.findByUserUserId(userId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public UserToken createOrupdateToken(Long userId) throws BaseException{
		try {
			UserToken previousToken = tokenExistForUser(userId);
			if(previousToken != null) {
				removeToken(previousToken.tokenId);
			}
			UserToken userToken = createToken(userId);
			return userToken;
		} catch (BaseException ex) {
			throw ex;							//throws an existing exception thrown by other method
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	public void removeToken(@NotNull String tokenId) throws BaseException {
		try {
			userTokenRepository.delete(tokenId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_REMOVAL_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public Users findUserAttachedToToken(String tokenId) throws BaseException {
		try {
			
			if(tokenId == null) {
				ErrorConstants error = ErrorConstants.INVALID_TOKEN;
				throw new BaseException(error.errorCode, error.errorMessage);
			}
			UserToken userToken = userTokenRepository.findOne(tokenId);
			if(userToken == null || !validTime(userToken.expiryDateTime, 120)) {
				ErrorConstants error = ErrorConstants.INVALID_TOKEN;
				throw new BaseException(error.errorCode, error.errorMessage);
			}
			return userToken.user;
			
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}
}
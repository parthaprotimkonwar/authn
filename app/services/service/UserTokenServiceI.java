package services.service;

import models.UserToken;
import models.Users;
import play.exceptions.BaseException;

public interface UserTokenServiceI {

	UserToken createToken(Long userId) throws BaseException;
	
	Boolean tokenExist(String tokenId) throws BaseException;
	
	UserToken createOrupdateToken(Long userId) throws BaseException;
	
	void removeToken(String tokenId) throws BaseException;
	
	UserToken tokenExistForUser(Long userId) throws BaseException;
	
	/**
	 * Find a user which has the token
	 * @return
	 * @throws BaseException
	 */
	Users findUserAttachedToToken(String tokenId) throws BaseException;
	
}

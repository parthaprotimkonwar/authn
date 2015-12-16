package services.service;

import java.util.List;

import controllers.requestdto.AddressRequestDto;
import controllers.responsedto.AddressDto;
import models.UserAddress;
import models.Users;
import play.exceptions.BaseException;

public interface UserAddressServiceI {
	
	/**
	 * Create a new UserAddress
	 * @return
	 * @throws BaseException
	 */
	UserAddress createUserAddress(Users user, AddressRequestDto address) throws BaseException;

	/**
	 * Find UserAddress for a User
	 * @return
	 * @throws BaseException
	 */
	List<AddressDto> findUserAddress(Users user) throws BaseException;
}

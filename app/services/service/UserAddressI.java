package services.service;

import java.util.List;

import controllers.responsedto.AddressDto;
import models.Address;
import models.UserAddress;
import models.Users;
import play.exceptions.BaseException;

public interface UserAddressI {
	
	/**
	 * Create a new UserAddress
	 * @return
	 * @throws BaseException
	 */
	UserAddress createUserAddress(Users user, Address address) throws BaseException;

	/**
	 * Find UserAddress for a User
	 * @return
	 * @throws BaseException
	 */
	List<AddressDto> findUserAddress(Users user) throws BaseException;
}

package services.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import controllers.responsedto.AddressDto;
import models.Address;
import models.UserAddress;
import models.UserIdAddressId;
import models.Users;
import play.exceptions.BaseException;
import play.exceptions.ErrorConstants;
import repository.UserAddressRepository;
import services.service.UserAddressI;

@Named
@Singleton
public class UserAddressServiceImpl implements UserAddressI{

	@Inject
	UserAddressRepository userAddressRepository;

	@Override
	public UserAddress createUserAddress(Users user, Address address) throws BaseException {
		try {
			UserIdAddressId userIdAddressId = new UserIdAddressId(user, address);
			UserAddress userAddress = new UserAddress(userIdAddressId);
			return userAddressRepository.save(userAddress);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public List<AddressDto> findUserAddress(Users user) throws BaseException {
		try {
			List<UserAddress> userAddresses = userAddressRepository.findAllByUserIdAddressIdUserUserId(user.userId);
			List<AddressDto> addressDto = new ArrayList<>();
			for(UserAddress userAddress : userAddresses) {
				Address a = userAddress.userIdAddressId.address;
				AddressDto address = new AddressDto(a.addressId, a.addressHeading, a.pincode, a.address, a.landmark, a.phoneNo, a.city, a.state, a.country);
				addressDto.add(address);
			}
			return addressDto;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}
}

package services.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.transaction.annotation.Transactional;

import controllers.requestdto.AddressRequestDto;
import controllers.responsedto.AddressDto;
import models.Address;
import models.UserAddress;
import models.UserIdAddressId;
import models.Users;
import play.exceptions.BaseException;
import play.exceptions.ErrorConstants;
import repository.AddressRepository;
import repository.UserAddressRepository;
import repository.UsersRepository;
import services.service.UserAddressServiceI;

@Named
@Singleton
@Transactional
public class UserAddressServiceImpl implements UserAddressServiceI{

	@Inject
	UserAddressRepository userAddressRepository;
	
	@Inject
	UsersRepository usersRepository;
	
	@Inject
	AddressRepository addressRepository;
	
	@Override
	public UserAddress createUserAddress(Users user, AddressRequestDto address) throws BaseException {
		try {
			Address completeAddress = new Address(address.addressHeading, address.pincode, address.address, address.landmark, address.phoneNo, address.city, address.state, address.country);
			addressRepository.save(completeAddress);
			
			UserIdAddressId userIdAddressId = new UserIdAddressId(user, completeAddress);
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

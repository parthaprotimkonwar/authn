package services.serviceimpl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import controllers.requestdto.AddressRequestDto;
import models.Address;
import play.exceptions.BaseException;
import play.exceptions.ErrorConstants;
import repository.AddressRepository;
import services.service.AddressServiceI;

@Named
@Singleton
public class AddressServiceImpl implements AddressServiceI{

	@Inject
	AddressRepository addressRepository;

	@Override
	public Address createAddress(AddressRequestDto address) throws BaseException {
		try {
			Address completeAddress = new Address(address.addressHeading, address.pincode, address.address, address.landmark, address.phoneNo, address.city, address.state, address.country);
			return addressRepository.save(completeAddress);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	
	@Override
	public Address retrieveAddress(Long addressId) throws BaseException {
		try {
			return addressRepository.findOne(addressId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}
	
}

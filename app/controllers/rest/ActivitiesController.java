package controllers.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.transaction.annotation.Transactional;

import controllers.base.BaseController;
import controllers.requestdto.AddressRequestDto;
import controllers.responsedto.AddressDto;
import controllers.responsedto.AddressResponseDto;
import controllers.responsedto.ErrorResponse;
import controllers.responsedto.ListsAddressResponseDto;
import models.UserAddress;
import models.Users;
import play.exceptions.BaseException;
import play.exceptions.ErrorConstants;
import play.mvc.BodyParser;
import play.mvc.Result;
import services.serviceimpl.ServicesFactory;

@Named
@Singleton
public class ActivitiesController extends BaseController{

	@Inject
	ServicesFactory servicesFactory;
	
	/**
	 * Creates a new Address and Attaches it to a user
	 * @return
	 */
	@BodyParser.Of(BodyParser.Json.class)
	public Result createNewAddress() {
		
		AddressResponseDto response = null;
		try {
			AddressRequestDto addressRequest = convertRequestBodyToObject(request().body(), AddressRequestDto.class);
			Users user = servicesFactory.userTokenService.findUserAttachedToToken(addressRequest.token);
			UserAddress userAddress = servicesFactory.userAddressService.createUserAddress(user, addressRequest);
			response = new AddressResponseDto(addressRequest.token, userAddress.userIdAddressId.address.addressId, utilities.AppConstants.Status.SUCCESS.name());
			
		} catch (BaseException ex) {
			ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
			return errorObjectToJsonResponse(errorResponse);
		} catch (Exception e) {
			ErrorResponse errorResponse = unknownErrorResponse();
			return errorObjectToJsonResponse(errorResponse);
		}
		return convertObjectToJsonResponse(response);
	}
	
	@BodyParser.Of(BodyParser.Json.class)
	public Result listsAddress() {
		
		ListsAddressResponseDto response = null;
		try {
			AddressRequestDto addressRequest = convertRequestBodyToObject(request().body(), AddressRequestDto.class);
			Users user = servicesFactory.userTokenService.findUserAttachedToToken(addressRequest.token);
			List<AddressDto> addresses = servicesFactory.userAddressService.findUserAddress(user);
			response = new ListsAddressResponseDto(addressRequest.token, addresses, utilities.AppConstants.Status.SUCCESS.name());
			
		} catch (BaseException ex) {
			ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
			return errorObjectToJsonResponse(errorResponse);
		} catch (Exception e) {
			ErrorResponse errorResponse = unknownErrorResponse();
			return errorObjectToJsonResponse(errorResponse);
		}
		return convertObjectToJsonResponse(response);
	}
}

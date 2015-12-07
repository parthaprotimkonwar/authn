package services.serviceimpl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import services.service.AddressServiceI;
import services.service.PersonServiceI;
import services.service.UserAddressI;
import services.service.UserTokenServiceI;
import services.service.UsersFrugalServiceI;
import services.service.UsersGuestServiceI;
import services.service.UsersServiceI;
import services.service.UsersSocialServiceI;

@Named
@Singleton
public class ServicesFactory {

	@Inject
	public PersonServiceI personService;
	
	@Inject
	public AddressServiceI addressService;
	
	@Inject
	public UserAddressI userAddressService;
	
	@Inject
	public UsersFrugalServiceI usersFrugalService;
	
	@Inject
	public UsersServiceI usersService;
	
	@Inject
	public UsersSocialServiceI usersSocialService;
	
	@Inject
	public UsersGuestServiceI usersGuestService;
	
	@Inject
	public UserTokenServiceI userTokenService;
}

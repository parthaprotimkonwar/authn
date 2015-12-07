package services.serviceimpl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import repository.UserCommunicationRepository;
import services.service.UserCommunicationServiceI;

@Named
@Singleton
public class UserCommunicationServiceImpl implements UserCommunicationServiceI{

	@Inject
	UserCommunicationRepository userCommunicationRepository;
}

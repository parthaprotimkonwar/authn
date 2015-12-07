package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.UsersFrugal;

@Repository
public interface UsersFrugalRepository extends JpaRepository<UsersFrugal, Long>{

	UsersFrugal findByEmailIdAndPassword(String emailId, String password);
	
	UsersFrugal findByEmailId(String emailId);
}

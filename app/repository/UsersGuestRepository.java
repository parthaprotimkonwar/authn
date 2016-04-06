package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.UsersGuest;

@Repository
public interface UsersGuestRepository extends JpaRepository<UsersGuest, Long>{
	
	UsersGuest findByEmailId(String emailId);
}

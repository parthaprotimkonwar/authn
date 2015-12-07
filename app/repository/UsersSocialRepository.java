package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.UsersSocial;

@Repository
public interface UsersSocialRepository extends JpaRepository<UsersSocial, Long>{

	UsersSocial findByEmailId(String emailId);
}

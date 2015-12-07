package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}

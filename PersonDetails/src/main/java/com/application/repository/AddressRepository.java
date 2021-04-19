package com.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.application.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	List<Address> findByPersonId(Long personId);

	Optional<Address> findByIdAndPersonId(int id, Long personId);
}

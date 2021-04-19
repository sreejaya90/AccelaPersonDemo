package com.application.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.application.entity.Address;
import com.application.entity.Person;
import com.application.repository.AddressRepository;
import com.application.repository.PersonRepository;

@Component
public class AddressDao {
	Logger logger = LoggerFactory.getLogger(AddressDao.class);
	private final AddressRepository addressRepository;

	public AddressDao(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@Autowired
	private PersonRepository personRepository;

	public List<Address> getAddressByPerson() {
		return null;

	}

	public Address addAddress(Long personId, Address address) {
		try{
			Optional<Person> personPresent = personRepository.findById(personId);
			address.setId(new Random().nextInt());
			address.setPerson(personPresent.get());
			
		}
		catch(Exception e){
			logger.error("error is "+e.getMessage());
		}
		return addressRepository.save(address);
	}

	public Address updateAddress(Long personId, int addressId, Address adddressRequest) {
		if (!personRepository.existsById(personId)) {
			try {
				throw new Exception("Person not found");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Optional<Address> updateAddress = addressRepository.findById(addressId);
		updateAddress.get().setState(adddressRequest.getState());
		updateAddress.get().setCity(adddressRequest.getCity());
		updateAddress.get().setPostalCode(adddressRequest.getPostalCode());
		updateAddress.get().setStreet(adddressRequest.getStreet());
		return addressRepository.save(updateAddress.get());
	}

	public Map<String, Boolean> deleteAddress(Long personId, Integer addressId) {
		Optional<Address> deleteAddress = addressRepository.findByIdAndPersonId(addressId, personId);
		addressRepository.delete(deleteAddress.get());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}
}

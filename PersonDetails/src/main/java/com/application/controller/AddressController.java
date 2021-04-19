package com.application.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dao.AddressDao;
import com.application.entity.Address;

@RestController
@RequestMapping("/api/")
public class AddressController {
	Logger logger = LoggerFactory.getLogger(AddressController.class);
	@Autowired
	AddressDao dao;

	@PostMapping("/persons/{personId}/address")
	public Address addAddress(@PathVariable(value = "personId") Long personId, @RequestBody Address address) {
		logger.info("Address -> "+address);
		Address addr = dao.addAddress(personId, address);
		return addr;
	}

	@PutMapping("/persons/{personId}/address/{addressId}")
	public Address updateAddress(@PathVariable(value = "personId") Long personId,
			@PathVariable(value = "addressId") Integer addressId, @RequestBody Address addressRequest) {
		return dao.updateAddress(personId, addressId, addressRequest);

	}

	@DeleteMapping("/persons/{personId}/address/{addressId}")
	    public Map<String, Boolean> deleteAddress(@PathVariable(value = "personId") Long personId,
	        @PathVariable(value = "addressId") Integer addressId) {
		Map<String, Boolean> response = dao.deleteAddress(personId,addressId);
		return response;
	      
	    }
}

package com.application.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.customExceptions.ResourceNotFoundException;
import com.application.dao.PersonDao;
import com.application.entity.Person;

@RestController
@RequestMapping("/api/")
public class PersonController {
	@Autowired
	PersonDao dao;

	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		return dao.getPersons();
	}

	@GetMapping("/persons/{id}")
	public ResponseEntity<ResponseEntity<Optional<Person>>> getPersonById(@PathVariable(value = "id") Long personId) throws ResourceNotFoundException{
		ResponseEntity<Optional<Person>> person = dao.findPersonById(personId);
		return ResponseEntity.ok().body(person);
	}

	@PostMapping("/persons")
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		return dao.savePerson(person);
	}

	@PutMapping("/persons/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId, @RequestBody Person personDetails) {
		Person updatedPerson = dao.updatePerson(personId, personDetails);
		return ResponseEntity.ok(updatedPerson);
	}

	@DeleteMapping("/persons/{id}")
	public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long id) {
		Map<String, Boolean> response = dao.deletePerson(id);		
		return response;
	}
	
	@GetMapping("/persons/count")
	public Long getCountOfPersons(){
		return dao.countOfPersons();
	}
}

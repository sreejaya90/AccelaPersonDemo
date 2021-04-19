package com.application.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.application.customExceptions.ResourceNotFoundException;
import com.application.entity.Person;
import com.application.repository.PersonRepository;

@Component
public class PersonDao {
	private final PersonRepository repository;

	public PersonDao(PersonRepository repository) {
		this.repository = repository;
	}

	public List<Person> getPersons() {
		return repository.findAll();
	}

	public ResponseEntity<Optional<Person>> findPersonById(long personId) throws ResourceNotFoundException{
		
			Optional<Person> person = repository.findById(personId);
			if(person==null){
				throw new ResourceNotFoundException("Person not found");
			}
			return ResponseEntity.ok().body(person);
		
	        
	}

	public ResponseEntity<Person> savePerson(Person person) {
		person.setId(new Random().nextLong());
		repository.save(person);
		return ResponseEntity.ok().body(person);
	}

	public Person updatePerson(long id,Person person) {
		Optional<Person> p = repository.findById(id);
		p.get().setFirstName(person.getFirstName());	
		p.get().setLastName(person.getLastName());
		return repository.save(p.get());
	}
	
	public Map<String, Boolean> deletePerson(long id) {
		Optional<Person> p  = repository.findById(id);
		repository.delete(p.get());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public Long countOfPersons(){
		return repository.count();		
		
	}
}

package com.application.repository;


import org.springframework.stereotype.Repository;
import com.application.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{

}

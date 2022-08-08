package com.roommatefinder.demo.model;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public interface PersonRepository  extends CrudRepository<Person, Integer> {

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

    
   Person findByEmailId(String emailId);
   
   
}

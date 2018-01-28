package com.posc.service;

import com.posc.model.Person;

import java.util.List;

public interface PersonService {

  Person findOnePerson(String firstName);

  List<Person> findByFirstName(String firstName);

  Person addPerson(Person person);
}

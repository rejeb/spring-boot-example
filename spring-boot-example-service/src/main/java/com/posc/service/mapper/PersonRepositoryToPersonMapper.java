package com.posc.service.mapper;

import com.posc.model.Person;

import java.util.function.Function;

public class PersonRepositoryToPersonMapper implements Function<com.posc.repository.model.Person,Person> {


  @Override
  public Person apply(com.posc.repository.model.Person person) {

    return Person.builder().firstName(person.getKey().getFirstName())
      .dateOfBirth(person.getKey().getDateOfBirth())
      .id(person.getKey().getId())
      .lastName(person.getLastName())
      .gender(person.getGender())
      .build();
  }
}

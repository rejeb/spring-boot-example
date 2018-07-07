package com.posc.service.mapper;

import com.posc.repository.model.Person;
import com.posc.repository.model.PersonKey;

import java.util.function.Function;

public class PersonToRepositoryPersonMapper implements Function<com.posc.model.Person,Person> {


  @Override
  public Person apply(com.posc.model.Person person) {
    PersonKey personKey=new PersonKey(person.getFirstName(),person.getDateOfBirth(),person.getId());

    return new Person(personKey,person.getLastName(),person.getGender());
  }
}

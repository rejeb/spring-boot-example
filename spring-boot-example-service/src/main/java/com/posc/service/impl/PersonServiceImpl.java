package com.posc.service.impl;

import com.posc.model.Person;
import com.posc.repository.PersonRepository;
import com.posc.service.PersonService;
import com.posc.service.mapper.PersonRepositoryToPersonMapper;
import com.posc.service.mapper.PersonToRepositoryPersonMapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;
  private final PersonToRepositoryPersonMapper personToRepositoryPersonMapper;
  private final PersonRepositoryToPersonMapper personRepositoryToPersonMapper;

  public PersonServiceImpl(PersonRepository personRepository,
                           PersonToRepositoryPersonMapper personToRepositoryPersonMapper,
                           PersonRepositoryToPersonMapper personRepositoryToPersonMapper) {
    this.personRepository = personRepository;
    this.personToRepositoryPersonMapper = personToRepositoryPersonMapper;
    this.personRepositoryToPersonMapper = personRepositoryToPersonMapper;
  }

  @Override
  public Person findOnePerson(String firstName) {
    return personRepositoryToPersonMapper.apply(personRepository.findFirstByKeyFirstName(firstName));
  }

  @Override
  public List<Person> findByFirstName(String firstName) {
    return personRepository.findByKeyFirstName(firstName)
                           .stream()
                           .map(personRepositoryToPersonMapper)
                           .collect(Collectors.toList());
  }

  @Override
  public Person addPerson(Person person) {


    return Stream.of(person)
                 .map(personToRepositoryPersonMapper)
                 .map(personRepository::save)
                 .map(personRepositoryToPersonMapper)
                 .findFirst()
                 .get();
  }
}

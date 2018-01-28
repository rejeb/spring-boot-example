package com.posc.repository;

import com.posc.repository.model.Person;
import com.posc.repository.model.PersonKey;
import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;

import java.util.List;

public interface PersonRepository extends TypedIdCassandraRepository<Person, PersonKey> {

  List<Person> findByKeyFirstName(String firstName);

  Person findFirstByKeyFirstName(String firstName);
}

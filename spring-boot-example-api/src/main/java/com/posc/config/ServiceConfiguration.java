package com.posc.config;

import com.posc.repository.cassandra.PersonRepository;
import com.posc.service.PersonService;
import com.posc.service.impl.PersonServiceImpl;
import com.posc.service.mapper.PersonRepositoryToPersonMapper;
import com.posc.service.mapper.PersonToRepositoryPersonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

  @Bean
  public PersonService personService(PersonRepository personRepository) {
    return new PersonServiceImpl(personRepository,
                                 new PersonToRepositoryPersonMapper(),
                                 new PersonRepositoryToPersonMapper());
  }

}

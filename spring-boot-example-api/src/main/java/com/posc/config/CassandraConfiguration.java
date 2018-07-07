package com.posc.config;

import com.posc.repository.cassandra.PersonRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackageClasses = PersonRepository.class)
public class CassandraConfiguration{

}

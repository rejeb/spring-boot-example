package com.posc.controller;

import com.posc.model.Person;
import com.posc.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping("/persons")
  public ResponseEntity<Person> addPerson(
    @RequestBody
      Person person) {
    return ResponseEntity.ok(personService.addPerson(person));
  }


  @RequestMapping(value = "/persons/{firstName}", method = RequestMethod.GET)
  public ResponseEntity<List<Person>> findByFirstName(@PathVariable("firstName") String firstName){
    return ResponseEntity.ok(personService.findByFirstName(firstName));
  }

  @RequestMapping(value = "/persons/{firstName}/one", method = RequestMethod.GET)
  public ResponseEntity<Person> findFirst(@PathVariable("firstName") String firstName){
    return ResponseEntity.ok(personService.findOnePerson(firstName));
  }

}

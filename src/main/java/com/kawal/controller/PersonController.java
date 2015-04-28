package com.kawal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kawal.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kawal.service.PersonService;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/person/{id}")
    public String personName(@PathVariable Long id) throws JsonProcessingException {
        Person person = personService.findById(id);
        return objectMapper.writeValueAsString(person);
    }

    @RequestMapping("/findAllPersons")
    public String findAllPersons() throws JsonProcessingException {
        Iterable<Person> persons = personService.findAll();
        return objectMapper.writeValueAsString(persons);
    }

}

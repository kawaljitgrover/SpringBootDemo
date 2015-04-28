package com.kawal.service;

import com.kawal.domain.Person;
import com.kawal.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @PreAuthorize("@myPermissionEvaluator.hasPermission(#id, 'admin')")
    public Person findById(Long id) {
        return personRepository.findById(id);
    }

    public Person findByName(String name) {
        return personRepository.findByName(name);
    }

    @PreAuthorize("@myPermissionEvaluator.hasPermissions('toAddPerson')")
    @PostFilter("@myPermissionEvaluator.hasPermission(filterObject, 30)")
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

}

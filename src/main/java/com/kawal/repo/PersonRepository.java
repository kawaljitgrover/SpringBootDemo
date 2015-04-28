package com.kawal.repo;

import com.kawal.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findById(Long id);
    Person findByName(String name);
}

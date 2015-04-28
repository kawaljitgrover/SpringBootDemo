package com.kawal.repo;

import com.kawal.domain.Person;
import com.kawal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Long id);
    User findByUserName(String userName);
}

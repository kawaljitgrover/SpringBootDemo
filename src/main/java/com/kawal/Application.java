package com.kawal;

import com.kawal.domain.Person;
import com.kawal.domain.Phone;
import com.kawal.domain.User;
import com.kawal.repo.PersonRepository;
import com.kawal.repo.PhoneRepository;
import com.kawal.repo.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringBootDemoConfig.class, args);

        PersonRepository personRepository = ctx.getBean(PersonRepository.class);
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        PhoneRepository phoneRepository = ctx.getBean(PhoneRepository.class);

        Phone phone1 = phoneRepository.save(new Phone(1L, "Home", "123-456-789"));
        Phone phone2 = phoneRepository.save(new Phone(2L, "Cell", "983-421-732"));
        Phone phone3 = phoneRepository.save(new Phone(3L, "Office", "567-124-567"));

        personRepository.deleteAll();

        Person john = new Person(1L, "John", 30);
        john.setPhones(Collections.singleton(phone1));
        Person tom = new Person(2L, "Tom", 25);
        tom.setPhones(Collections.singleton(phone2));
        Person jack = new Person(3L, "Jack", 35);
        jack.setPhones(Collections.singleton(phone3));

        personRepository.save(Arrays.asList(john, tom, jack));

        userRepository.deleteAll();
        String password = new Md5PasswordEncoder().encodePassword("abc123", null);
        userRepository.save(new User(1L, "Kawaljit Grover", "ROLE_USER", "kawaljit.grover", password));
    }

}
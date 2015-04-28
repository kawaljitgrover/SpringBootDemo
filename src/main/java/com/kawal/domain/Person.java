package com.kawal.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name = "person")
@Entity
public class Person extends AbstractEntity implements Serializable {

    @Column(nullable =  false)
    private String name;

    @Column(nullable =  false)
    private int age;

    @OneToMany(targetEntity = Phone.class)
    private Set<Phone> phones;

    public Person() {
    }

    public Person(Long id, String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

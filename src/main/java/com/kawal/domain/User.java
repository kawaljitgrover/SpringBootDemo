package com.kawal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "user")
@Entity
public class User extends AbstractEntity implements Serializable {

    @Column(nullable =  false)
    private String name;

    @Column(nullable =  false)
    private String role;

    @Column(nullable =  false)
    private String userName;

    @Column(nullable =  false)
    private String password;

    public User() {
    }

    public User(Long id, String name, String role, String userName, String password) {
        this.name = name;
        this.role = role;
        this.userName = userName;
        this.password = password;
        setId(id);
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

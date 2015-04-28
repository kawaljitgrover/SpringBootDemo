package com.kawal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "phone")
@Entity
public class Phone extends AbstractEntity implements Serializable {

    @Column(nullable =  false)
    private String type;

    @Column(nullable =  false)
    private String number;

    public Phone() {
    }

    public Phone(Long id, String type, String number) {
        this.type = type;
        this.number = number;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

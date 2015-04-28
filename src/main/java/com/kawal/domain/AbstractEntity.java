package com.kawal.domain;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public class AbstractEntity {

    @Id
    protected Long id;

    protected void generateId() {
        this.id = UUID.randomUUID().getMostSignificantBits();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

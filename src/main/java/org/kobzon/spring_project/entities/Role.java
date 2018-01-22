package org.kobzon.spring_project.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    private Long Id;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(String name) {

        this.name = name;
    }
}

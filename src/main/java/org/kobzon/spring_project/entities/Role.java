package org.kobzon.spring_project.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Role {

    @org.springframework.data.annotation.Id
    private String Id;
    private String name;

    Role() {}

    public Role(String name) { this.name = name; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}

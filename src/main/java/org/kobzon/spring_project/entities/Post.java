package org.kobzon.spring_project.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Post {

    @org.springframework.data.annotation.Id
    private String Id;
    private String title;
    private String body;
    private Date dateCreated;
    private User creator;

    public Post() {
    }

    public User getCreator() {return creator; }

    public void setCreator(User creator) { this.creator = creator; }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}

package org.kobzon.spring_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {

    @org.springframework.data.annotation.Id
    private String Id;
    private String username;
    @JsonIgnore
    private String password;
    private List<Role> roles;
    private List<Post> posts;

    User() {}

    public User(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getId() { return Id; }

    public void setId(String id) { Id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public List<Role> getRoles() {return roles; }

    public void setRoles(List<Role> roles) {this.roles = roles; }

    public List<Post> getPosts() {return posts; }

    public void setPosts(List<Post> posts) { this.posts = posts; }
}

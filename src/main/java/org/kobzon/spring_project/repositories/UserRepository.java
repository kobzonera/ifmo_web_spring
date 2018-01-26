package org.kobzon.spring_project.repositories;

import org.kobzon.spring_project.entities.Post;
import org.kobzon.spring_project.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}

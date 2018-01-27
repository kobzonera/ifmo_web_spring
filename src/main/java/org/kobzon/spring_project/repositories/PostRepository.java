package org.kobzon.spring_project.repositories;

import org.kobzon.spring_project.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByCreatorUsername(String username);
}

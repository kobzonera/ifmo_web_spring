package org.kobzon.spring_project.repositories;

import org.kobzon.spring_project.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
}

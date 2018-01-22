package org.kobzon.spring_project.services;

import org.kobzon.spring_project.entities.Post;
import org.kobzon.spring_project.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public void insert(@RequestBody Post post) {
        postRepository.save(post);
    }
}

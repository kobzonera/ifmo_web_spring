package org.kobzon.spring_project.services;

import org.kobzon.spring_project.entities.Post;
import org.kobzon.spring_project.entities.User;
import org.kobzon.spring_project.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void insert(@RequestBody Post post) {
        postRepository.save(post);
    }

    public Post getPost(String id) {
        return postRepository.findOne(id);
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public List<Post> findByUserUsername(User user){
        return postRepository.findByCreatorUsername(user.getUsername());
    }

}

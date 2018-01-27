package org.kobzon.spring_project.controllers;

import org.kobzon.spring_project.config.CustomUserDetails;
import org.kobzon.spring_project.entities.Post;
import org.kobzon.spring_project.services.PostService;
import org.kobzon.spring_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @PostMapping(value="/create")
    public String publishPost(@RequestBody Post post){
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(post.getDateCreated() == null)
            post.setDateCreated(new Date());
        post.setCreator(userService.findByUsername(userDetails.getUsername()));
        postService.insert(post);
        return "Post was created";
    }

    @GetMapping(value="/posts/{username}")
    public List<Post> getPostsByUser(@PathVariable String username){
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!username.equals(userDetails.getUsername()))
            return postService.findByUserUsername(userService.findByUsername(username));
        else
            return null;
    }

    @GetMapping(value="/posts/{title}")
    public Post getPostById(@PathVariable String title){
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!postService.getPost(title).getCreator().equals(userDetails.getUsername()))
            return postService.getPost(title);
        else
            return null;
    }

}

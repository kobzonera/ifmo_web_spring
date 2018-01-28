package org.kobzon.spring_project.controllers;

import org.kobzon.spring_project.config.CustomUserDetails;
import org.kobzon.spring_project.entities.Post;
import org.kobzon.spring_project.services.PostService;
import org.kobzon.spring_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @PostMapping(value="/create")
    public String publishPost(@RequestBody Post post){
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(post.getDateCreated() == null)
            post.setDateCreated(new Date());
        post.setCreator(userService.getUser(userDetails.getUsername()));
        postService.insert(post);
        return "Post was created";
    }

    @GetMapping(value="/posts")
    public List<Post> posts(){
        return postService.getAllPosts();
    }

    @GetMapping(value="/post/{id}")
    public Post getPostById(@PathVariable Long id){
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails.getAuthorities().contains("ROLE_ADMIN") || userDetails.getUsername().equals(postService.getPost(id).getCreator().getUsername())) {
            return postService.getPost(id);
        }
        else return null;
    }

    @GetMapping(value="/posts/{username}")
    public List<Post> postsByUser(@PathVariable String username){
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails.getAuthorities().contains("ROLE_ADMIN") || userDetails.getUsername().equals(userService.getUser(username).getUsername())) {
            return postService.findByUser(userService.getUser(username));
        }
        else return null;
    }

    @DeleteMapping(value = "/post/{id}")
    public boolean deletePost(@PathVariable Long id){
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails.getAuthorities().contains("ROLE_ADMIN") || userDetails.getUsername().equals(postService.getPost(id).getCreator().getUsername())) {
            return postService.deletePost(id);
        }
        else return false;
    }
}
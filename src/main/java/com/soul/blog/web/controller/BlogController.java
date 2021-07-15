package com.soul.blog.web.controller;

import com.soul.blog.exceptions.NoSuchPostException;
import com.soul.blog.model.Post;
import com.soul.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class BlogController {

    @Autowired
    PostService postService;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to my Blog, enjoy !";
    }

    @GetMapping("/Posts")
    public List<Post> allPosts() {
        return postService.readAll();
    }

    @GetMapping("/Posts/{id}")
    public Post onePost(@PathVariable int id) throws NoSuchPostException {
        return postService.read(id);
    }

    @PostMapping("/Posts")
    public Post newPost(@Valid @RequestBody Post post) {
        return postService.create(post);
    }

    @PutMapping("/Posts")
    public Post updatePost(@Valid @RequestBody Post post) {
        return postService.update(post);
    }

    @DeleteMapping("/Posts")
    public void deletePost(@RequestParam int id) {
        postService.delete(id);
    }
}

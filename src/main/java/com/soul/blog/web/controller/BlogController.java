package com.soul.blog.web.controller;

import com.soul.blog.model.Post;
import com.soul.blog.repository.IPostRepository;
import com.soul.blog.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    IPostRepository repository = new PostRepository();

    @GetMapping("/")
    public String welcome() {
        return "Welcome to my Blog, enjoy !";
    }

    @GetMapping("/Posts")
    public List<Post> allPosts() {
        return repository.findAll();
    }

    @GetMapping("/Posts/{id}")
    public Post onePost(@PathVariable int id){
        return repository.findById(id);
    }

    @PostMapping("/Posts")
    public Post newPost(@RequestBody Post post) {
        return repository.save(post);
    }

    @PutMapping("/Posts")
    public Post updatePost(@RequestBody Post post) {
        return repository.update(post);
    }

    @DeleteMapping("/Posts")
    public Post deletePost(@RequestParam int id) {
        return repository.delete(id);
    }
}

package com.soul.blog.web.controller;

import com.soul.blog.exceptions.NoSuchPostException;
import com.soul.blog.model.Post;
import com.soul.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BlogController {

    @Autowired
    PostService postService;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to my Blog, enjoy !";
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.readAll();
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable int id) throws NoSuchPostException {
        return postService.read(id);
    }

    @GetMapping("/find")
    public List<Post> findPosts(@RequestParam String keyWord) {
        return postService.find(keyWord);
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createNewPost(@Valid @RequestBody Post post) {
        return new ResponseEntity<>(postService.create(post), HttpStatus.CREATED);
    }

    @PutMapping("/posts")
    public ResponseEntity<Post> updatePost(@Valid @RequestBody Post post) throws NoSuchPostException {
        return new ResponseEntity<>(postService.update(post), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/posts")
    public void deletePost(@RequestBody Map<String, Integer> payload) throws NoSuchPostException {
        postService.delete(payload.get("id"));
    }

}

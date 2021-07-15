package com.soul.blog.service;

import com.soul.blog.exceptions.NoSuchPostException;
import com.soul.blog.model.Post;
import com.soul.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post>  readAll() {
        return (List<Post>) postRepository.findAll();
    }

    public Post read(int id) throws NoSuchPostException {
        try {
            return postRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new NoSuchPostException("The post with the id " + id + " does not exist");
        }
    }

    public Post create(Post post) {
        return postRepository.save(post);
    }

    public Post update(Post post) throws NoSuchPostException {
        try {
            postRepository.findById(post.getId()).get();
        } catch (NoSuchElementException e) {
            throw new NoSuchPostException("The post with the id " + post.getId() + " does not exist");
        }
        return postRepository.save(post);
    }

    public void delete(int id) {
        try {
            postRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchPostException("The post with the id " + id + " does not exist");
        }
    }
}

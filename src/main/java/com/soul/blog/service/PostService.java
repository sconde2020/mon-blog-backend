package com.soul.blog.service;

import com.soul.blog.exceptions.NoSuchPostException;
import com.soul.blog.model.Post;
import com.soul.blog.repository.PostRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Log4j2
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
            throw new NoSuchPostException("There is no post with the id " + id);
        }
    }

    public Post create(Post post) {
        return postRepository.save(post);
    }

    public Post update(Post post) throws NoSuchPostException {
        try {
            log.debug("Post to update Id: " + post.getId());
            postRepository.findById(post.getId()).get();
            return postRepository.save(post);
        } catch (NoSuchElementException e) {
            throw new NoSuchPostException("The post with the id " + post.getId() + " does not exist");
        }
    }

    public void delete(int id) {
        try {
            log.debug("Post to delete Id: " + id);
            postRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchPostException("The post with the id " + id + " does not exist");
        }
    }

    public List<Post> find(String keyWord) {
        log.debug("Key Word to search: " + keyWord);
        return postRepository.findByTitleAndContent(keyWord);
    }
}

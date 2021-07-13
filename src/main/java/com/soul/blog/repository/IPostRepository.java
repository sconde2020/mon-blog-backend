package com.soul.blog.repository;

import com.soul.blog.model.Post;

import java.util.List;

public interface IPostRepository {

    public List<Post> findAll();

    public Post findById(int id);

    public Post save(Post post);

    public Post update(Post post);

    public Post delete(int id);
}

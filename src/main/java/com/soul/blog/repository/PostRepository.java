package com.soul.blog.repository;

import com.soul.blog.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepository implements IPostRepository {
    public static List<Post> posts = new ArrayList<>();
    static {
        posts.add(new Post(1, "My first Posts", "Hello fiend!"));
        posts.add(new Post(2, "My second Posts", "Hello fiend!"));
        posts.add(new Post(3, "My third Posts", "Hello fiend!"));
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(int id) {
        for(Post post : posts) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    @Override
    public Post save(Post post) {
        posts.add(post);
        return post;
    }

    @Override
    public Post update(Post post) {
       for(int i = 0; i < posts.size(); i++) {
           if (post.getId() == posts.get(i).getId()){
               posts.set(i, post);
               return post;
           }
       }
       return null;
    }

    @Override
    public Post delete(int id) {
        for(int i = 0; i < posts.size(); i++) {
            if (id == posts.get(i).getId()){
                return posts.remove(i);
            }
        }
        return null;
    }

}

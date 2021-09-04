package com.soul.blog.repository;

import com.soul.blog.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{

    @Query("SELECT p FROM Post p WHERE " +
            "LOWER(p.title) LIKE LOWER(CONCAT('%',:keyWord, '%')) OR " +
            "LOWER(p.content) LIKE LOWER(CONCAT('%',:keyWord, '%'))")
    public List<Post> findByTitleAndContent(String keyWord);

}

package com.sapient.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.blog.model.Post;

@Repository(value = "postRepo")
public interface PostRepository extends CrudRepository<Post, Long>{

}

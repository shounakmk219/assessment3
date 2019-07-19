package com.sapient.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.blog.model.User;

@Repository(value = "userRepo")
public interface UserRepository extends CrudRepository<User, Long>{

}

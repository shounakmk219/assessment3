package com.sapient.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.blog.model.Post;
import com.sapient.blog.model.User;
import com.sapient.blog.service.PostService;
import com.sapient.blog.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping(value = "/api/v1/user/")
public class BlogController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public User getById(@PathVariable("id")long id) {
		System.out.println(userService.getUserById(id));
		return userService.getUserById(id);
	}
	
	@GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public List<User> getAll() {
		return userService.getAll();
	}
	
	@PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PostMapping(value = "/update/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public User updateUser(@RequestBody User user, @PathVariable long id) {
		return userService.updateUser(user, id);
	}

	@DeleteMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public User deleteUser(@PathVariable("id")long id) {
		return userService.deleteUser(id);
	}
	
	
	
	@GetMapping(value = "/{uid}/{pid}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Post getPostById(@PathVariable("uid")long uid, @PathVariable("pid")long pid) {
		return postService.getPostById(pid, uid);
	}
	
	@GetMapping(value = "/{uid}/posts", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public List<Post> getAllPostByUser(@PathVariable("uid")long uid) {
		return postService.getAllPostByUser(uid);
	}
	
	@PostMapping(value = "/{uid}/save", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Post createPost(@RequestBody Post post, @PathVariable("uid")long uid) {
		return postService.createPost(post, uid);
	}
	
	@DeleteMapping(value = "/{uid}/delete/{pid}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Post deletePost(@PathVariable("uid")long uid, @PathVariable("pid")long pid) {
		return postService.deletePost(uid, pid);
	}
}

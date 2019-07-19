package com.sapient.blog.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sapient.blog.service.PostService;
import com.sapient.blog.service.UserService;

public class BlogTest {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;

	@Test
	public void testGetUserById() {
		
	}

}

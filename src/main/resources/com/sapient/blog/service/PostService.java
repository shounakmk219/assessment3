package com.sapient.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.blog.dao.BlogDAO;
import com.sapient.blog.model.Post;
import com.sapient.blog.model.User;

@Service("postService")
public class PostService {
	@Autowired
	@Qualifier(value = "hibernateDAO")
	private BlogDAO dao;
	
	@Transactional
	public Post getPostById(long pid, long uid) {
		return dao.getPostById(pid,uid);
	}
	
	@Transactional
	public Post createPost(Post post, long uid) {
		return dao.createPost(post, uid);
	}
	
	@Transactional
	public Post deletePost(long uid, long pid) {
		return dao.deletePost(uid,pid);
	}
	@Transactional
	public List<Post> getAllPostByUser(long id){
		return dao.getAllPostByUser(id);
	}
}

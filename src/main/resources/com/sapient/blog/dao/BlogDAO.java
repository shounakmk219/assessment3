package com.sapient.blog.dao;

import java.util.List;

import com.sapient.blog.model.Post;
import com.sapient.blog.model.User;


public interface BlogDAO {

	public User saveUser(User user);
	public User deleteUser(long id);
	public User updateUser(User user, long id);
	public User getUserById(long id);
	public List<User> getAllUser();
	
	public Post createPost(Post post, long uid);
	public Post deletePost(long uid, long pid);
	public List<Post> getAllPostByUser(long id);
	public Post getPostById(long pid, long uid);
}

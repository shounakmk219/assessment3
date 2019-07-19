package com.sapient.blog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sapient.blog.model.Post;
import com.sapient.blog.model.User;

@Repository("hibernateDAO")
public class HibernateDAOImpl implements BlogDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	public User saveUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		return user;
	}

	public User deleteUser(long id) {
		Session session=sessionFactory.getCurrentSession();
		User obj=session.byId(User.class).load(id);
		session.delete(obj);
		return obj;
	}

	public User updateUser(User user, long id) {
		System.out.println(user);
		Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(user);
			return user;

	}

	public User getUserById(long id) {
		Session session=sessionFactory.getCurrentSession();
		return session.byId(User.class).load(id);
	}

	public List<User> getAllUser() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from User").list();
	}

	public Post createPost(Post post, long uid) {
		Session session=sessionFactory.getCurrentSession();
		User obj=session.byId(User.class).load(uid);
		obj.getPosts().add(post);
		obj.setPosts(obj.getPosts());
		session.save(obj);
		return post;
	}

	public Post deletePost(long uid, long pid) {
		Session session=sessionFactory.getCurrentSession();
		Post post=session.byId(Post.class).load(pid);
		User user=session.byId(User.class).load(uid);
		user.getPosts().remove(post);
		session.saveOrUpdate(user);
		return post;
	}

	public List<Post> getAllPostByUser(long id) {
		Session session=sessionFactory.getCurrentSession();
		return session.byId(User.class).load(id).getPosts();
	}

	public Post getPostById(long pid, long uid) {
		Session session=sessionFactory.getCurrentSession();
		Post post=session.byId(Post.class).load(pid);
		User user=session.byId(User.class).load(uid);
		if(user.getPosts().contains(post))
			return post;
		return new Post();
	}


}

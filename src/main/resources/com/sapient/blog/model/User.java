package com.sapient.blog.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private String name;
	private String userName;
	private String email;
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Address address;
	
	 @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	 @JoinColumn(name="user_id")
	 private List<Post> posts;
	
	public void setId(long id) {
		this.id = id;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(long id, String name, String userName, String email) {
		super();
		this.id=id;
		this.name = name;
		this.userName = userName;
		this.email=email;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userName=" + userName + ", email=" + email + ", address="
				+ address + ", posts=" + posts + "]";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getId() {
		return id;
	}
	
	
}

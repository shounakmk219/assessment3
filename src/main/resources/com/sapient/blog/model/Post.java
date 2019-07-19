package com.sapient.blog.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Post")
public class Post implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private String title;
	private String body;
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Post(long id, String title, String body) {
		super();
		this.id=id;
		this.title = title;
		this.body = body;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + "]";
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public long getId() {
		return id;
	}
	
}

package com.ebooks.timeline.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table  
public class timeline {
	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Post;
	private String emailid;
	private byte[] image;
	private Integer likes;
	
	public void setId(Integer id){
		this.id=id;
	}
	
	public Integer getId(){
		return id;
	}
	public void setLikes(Integer likes){
		this.likes=id;
	}
	
	public Integer getLikes(){
		return likes;
	}
	
	public void setPost(String post){
		this.Post=post;
	}
	public String getPost(){
		return Post;
	}
	
	public void setEmailid(String emailid){
		this.emailid=emailid;
	}
	public String getEmailid(){
		return emailid;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public byte[] getImage() {
		return this.image;
	}
}

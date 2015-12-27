package com.ebooks.timeline.comment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table 
public class comment {
	
	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Integer id;
	private Integer hash;
	private String emailid;
	private String comment;
	
	public void setId(Integer id){
		this.id=id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void sethash(Integer hash){
		this.hash=hash;
	}
	
	public Integer gethash(){
		return hash;
	}
	public void setEmailid(String emailid){
		this.emailid=emailid;
	}
	public String getEmailid(){
		return emailid;
	}
	
	public void setComment(String comment){
		this.comment=comment;
	}
	public String getComment(){
		return comment;
	}
	
}

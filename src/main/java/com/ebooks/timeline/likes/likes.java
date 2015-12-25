package com.ebooks.timeline.likes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table 
public class likes {
	
	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Integer id;
	private Integer hash;
	private String emailid;
	
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
}

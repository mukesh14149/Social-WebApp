package com.ebooks.database.save;  
  
//Login object can save data in this format.

import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;  
  
@Entity  
@Table  
public class Login {  
      
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Integer id=0;   
    private String emailid; 
    private String name;
    private String expirydate;
    private String password;
    private String hash;
    private Integer active;
    private Integer Amount;  
    
    public Login() {};  
      
    public Login(Integer id, String emailid, String Name, Integer amount,String hash, String password,String expirydate,Integer active) {  
        this.id = id;  
        this.emailid = emailid;
        this.name=Name;
        this.Amount = amount;  
		this.password=password;
		this.expirydate=expirydate;
		this.hash=hash;
		this.active=active;
    }

    public Integer getId() {
		return id;
	}
    
	public void setEmailid(String emailid) {
			// TODO Auto-generated method stub
			this.emailid=emailid;
	}
	
	
	public String getEmailid() {
		// TODO Auto-generated method stub
		return emailid;
	}
	
	
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
	public void setAmount(int amount) {
		// TODO Auto-generated method stub
		this.Amount=amount;
	} 
	
	
	public Integer getAmount() {
		return Amount;
	} 
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setHash(String hash){
		this.hash=hash;
	}
	
	public String getHash(){
		return hash;
	}
	
	public void setExpirydate(String expirydate){
		this.expirydate=expirydate;
	}
	
	public String getExpairydate(){
		return expirydate;
	}
	
	public void setActive(Integer active){
		this.active=active;
	}
	
	public Integer getActive(){
		return active;
	}
		 
		
       
  
} 
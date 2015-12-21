package com.ebooks.database.save;  
  
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
    private Integer Amount;  
    private String password;
    
    public Login() {};  
      
    public Login(Integer id, String emailid, String Name, Integer amount, String password) {  
        this.id = id;  
        this.emailid = emailid;
        this.name=Name;
        this.Amount = amount;  
		this.password=password;

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
	
	
	
	
		 
		
       
  
} 
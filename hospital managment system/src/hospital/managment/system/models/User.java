/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system.models;

import java.io.File;

/**
 *
 * @author Sangeerthana
 */
public abstract class User {
    
    private String userName;
    private String name;
    private String gender;
    private String phoneNumber;
    private String idCardNo;
    private String dateOfBirth;
    private String address;
    private String  maritalStatus;
    private  String password;
   
    
    // Default constructor
    public User(){
        
        
    }  
    
    // Constructor with parameters
  
       
      
    // Getter and Setter methods (Accessors and Mutators)

    public abstract String getUserName();
    public abstract String getName();
    public abstract String getGender();
    public abstract String getphoneNumber();
    public abstract String getIdCardNo();
    public abstract String getDateOfBirth();
    public abstract String getAddress();
    public abstract String getMaritalStatus();
    public abstract String getPassword();
    public abstract File getPhoto();
    
    
    public abstract void  setUserName(String userName);
    public abstract void setName(String name);
    public abstract void setGender(String gender);
    public abstract void setphoneNumber(String phoneNumber);
    public abstract void setIdCardNo(String idCardNo);
    public abstract void setDateOfBirth(String dateOfBirth);
    public abstract void setAddress(String address);
    public abstract void setMaritalStatus(String status);
    public abstract void setStrPassword(String password);
    public abstract void setPhoto(File file);
    
    public abstract String toString();
    public abstract String toString2();
    
    
    }
     
    
    
    

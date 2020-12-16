/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

/**
 *
 * @author Sangeerthana
 */
public class User {
    
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
    public User(String userName,String name,String gender,String mobile,String idNumber,String dob,String address,String martialStatus,String password){
        this.setUserName(userName);
        this.setName(name);
        this.setGender(gender);
        this.setphoneNumber(mobile);
        this.setAddress(address);
        setIdCardNo(idNumber);
        setDateOfBirth(dob);
        setMaritalStatus(martialStatus);
        this.setStrPassword(password);
        
    }  
    
    // Constructor with parameters
  
       
      
    // Getter and Setter methods (Accessors and Mutators)

    public String getUserName(){
        return userName;
    }
    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public String getphoneNumber(){
        return phoneNumber;
    }
    public String getIdCardNo(){
        return idCardNo;
    }
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    public String getAddress(){
        return address;
    }
    public String getMaritalStatus(){
        return maritalStatus;
    }
    public String getPassword(){
        return this.password;
    }
    
    
   public void  setUserName(String userName){
        this. userName=userName;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setGender(String gender){
         this.gender=gender;
    }
    public void setphoneNumber(String phoneNumber){
         this.phoneNumber=phoneNumber;
    }
    public void setIdCardNo(String idCardNo){
          this.idCardNo=idCardNo;
    }
    public void setDateOfBirth(String dateOfBirth){
         this.dateOfBirth=dateOfBirth;
    }
    public void setAddress(String address){
         this.address=address;
    }
    public void setMaritalStatus(String status){
         this.maritalStatus=status;
    }
    public void setStrPassword(String password){
        this.password=password;
    }
      public String toString() {
        return getUserName()+","+getName()+","+getGender()+","+getphoneNumber()+","+getIdCardNo()+","+getDateOfBirth()+","+getAddress()+","+getMaritalStatus()+","+getPassword();
    }
    
    
}

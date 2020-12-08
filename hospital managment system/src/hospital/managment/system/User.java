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
    private int phoneNumber;
    private int idCardNo;
    private String dateOfBirth;
    private String address;
    private boolean maritalStatus;
    private  String password;
   
    
    // Default constructor
    public User(){
        this.userName = "";
        this.name = "";
        this.gender = "";
        this.dateOfBirth = "";
        this.address = "";
        this.password="";
        
    }  
    
    // Constructor with parameters
    public User(String u,String n,String g,String d,String a,int p,int i,boolean m){
        
    }
       
      
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
    public int getphoneNumber(){
        return phoneNumber;
    }
    public int getIdCardNo(){
        return idCardNo;
    }
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    public String getAddress(){
        return address;
    }
    public boolean getMaritalStatus(){
        return maritalStatus;
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
    public void setphoneNumber(int phoneNumber){
         this.phoneNumber=phoneNumber;
    }
    public void setIdCardNo(int idCardNo){
          this.idCardNo=idCardNo;
    }
    public void setDateOfBirth(String dateOfBirth){
         this.dateOfBirth=dateOfBirth;
    }
    public void setAddress(String address){
         this.address=address;
    }
    public void setMaritalStatus(boolean maritalstatus){
         this.maritalStatus=maritalStatus;
    }
    
    
}

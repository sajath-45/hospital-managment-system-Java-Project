/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system.models;

import hospital.managment.system.models.User;
import java.io.File;

/**
 *
 * @author Sangeerthana
 */
public class Receptionist extends User {
    private String userName;
    private String name;
    private String gender;
    private String phoneNumber;
    private String idCardNo;
    private String dateOfBirth;
    private String address;
    private String  maritalStatus;
    private  String password;
    private String staffId;
    private String strMailAddress;
    private String strDateOfJoining;
    private File fileCv;
    private File photo;
    
    
    
    public Receptionist(String userName,String name,String gender,String mobile,String idNumber,String dob,String address,String martialStatus,String password,String id,String email,String date,File cv,File image){
        setUserName(userName);
        setName(name);
        setGender(gender);
        setphoneNumber(mobile);
        setAddress(address);
        setIdCardNo(idNumber);
        setDateOfBirth(dob);
        setMaritalStatus(martialStatus);
        setStrPassword(password);
        setStaffId(id);
        setStrMailAddress(email);
        setStrDateOfJoining(date);
        setFileCv(cv);
        setPhoto(image);
   
    }
     // getters setters 
      public void  setUserName(String userName){//method to set the user name of receptionist
        this. userName=userName;
    }
    public void setName(String name){//method to set the name of receptionist
        this.name=name;
    }
    public void setGender(String gender){//method to set the gender of receptionist
         this.gender=gender;
    }
    public void setphoneNumber(String phoneNumber){//method to set the phone number of receptionist
         this.phoneNumber=phoneNumber;
    }
    public void setIdCardNo(String idCardNo){//method to set the id card no of receptionist
          this.idCardNo=idCardNo;
    }
    public void setDateOfBirth(String dateOfBirth){//method to set the date of birth of receptionist
         this.dateOfBirth=dateOfBirth;
    }
    public void setAddress(String address){//method to set the address of receptionist
         this.address=address;
    }
    public void setMaritalStatus(String status){//method to set the marital status of receptionist
         this.maritalStatus=status;
    }
    public void setStrPassword(String password){//method to set the password of receptionist
        this.password=password;
    }
    public void setStaffId(String id){//method to set the staff id of receptionist
        this.staffId=id;
    }
    public void setStrMailAddress(String mail){//method to set the mail address of receptionist
        this.strMailAddress=mail;
    }
    public void setStrDateOfJoining(String date){//method to set the date of joining of receptionist
        this.strDateOfJoining=date;
    }
    public void setFileCv(File cv){//method to set the file cv of receptionist
        this.fileCv=cv;
    }
    
     public void setPhoto(File photo){//method to set the photo of receptionist
        this.photo=photo;
    }
    //getters
       public  String getUserName(){//get method to get the user name of receptionist
        return userName;
    }
    public String getName(){//get method to get the name of receptionist
        return name;
    }
    public String getGender(){//get method to get the gender of receptionist
        return gender;
    }
    public String getphoneNumber(){//get method to get the phone number of receptionist
        return phoneNumber;
    }
    public String getIdCardNo(){//get method to get the id card no of receptionist
        return idCardNo;
    }
    public String getDateOfBirth(){//get method to get the date of birth of receptionist
        return dateOfBirth;
    }
    public String getAddress(){//get method to get the address of receptionist
        return address;
    }
    public String getMaritalStatus(){//get method to get the marital status of receptionist
        return maritalStatus;
    }
    public String getPassword(){//get method to get the password of receptionist
        return this.password;
    }
    public String getStrStaffId(){//get method to get the staff id of receptionist
        return staffId;
    }
    
    public String getStrEmailAddress(){//get method to get the email address of receptionist
        return strMailAddress;
        
    }
    public String getStrDateOfJoining(){//get method to get the date of joining of receptionist
        return strDateOfJoining;
    }
    public File getCvFile(){//get method to get the cv file of receptionist
        return fileCv;
    }
     public File getPhoto(){//get method to get the photo of receptionist
        return photo;
    }
   
    
    public String toString2(){
        return   getUserName()+","+getName()+","+getGender()+","+getphoneNumber()+","+getIdCardNo()+","+getDateOfBirth()+","+getAddress()+","+getMaritalStatus()+","+getPassword()+","+getStrStaffId()+","+getStrEmailAddress()+","+getStrDateOfJoining()+","+getCvFile() +","+getPhoto()  ;
    }
   public static Receptionist readReceptionistUser(String line){
  String[] data=line.split(",");

  String userName=data[0];
   String name=data[1];
    String gender=data[2];
    String mobile=data[3];
    String idCard=data[4];
    String dob=data[5];
    String address=data[6];
    String status=data[7];
     String password=data[8];
      String staffId=data[9];
       String email=data[10];
       String date=data[11];
        String cv=data[12];
        String image=data[13];
        File cvFile = new File(cv);
         File staffImage = new File(image);

       return new Receptionist(userName,name,gender,mobile,idCard,dob,address,status,password,staffId,email,date,cvFile,staffImage);
}  

    @Override
    public String toString() {
        return null;
    }
}

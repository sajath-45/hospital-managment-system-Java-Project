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
public class MedicalOfficer extends User {
    private String userName;
    private String name;
    private String gender;
    private String phoneNumber;
    private String idCardNo;
    private String dateOfBirth;
    private String address;
    private String  maritalStatus;
    private  String password;
    private String strStaffId;
    private String strEmailAddress;
    private String strDateOfJoining;
    private File photo;
    private File cv;
    private String strSpecialityArea;
    
    
    public MedicalOfficer(String userName,String name,String gender,String mobile,String idNumber,String dob,String address,String martialStatus,String password,String id,String email,String date,File cv,String speciality,File photo){
       // super(userName,name,gender,mobile,idNumber,dob,address,martialStatus,password);
        this.setUserName(userName);
        this.setName(name);
        this.setGender(gender);
        this.setphoneNumber(mobile);
        this.setAddress(address);
        setIdCardNo(idNumber);
        setDateOfBirth(dob);
        setMaritalStatus(martialStatus);
        this.setStrPassword(password);
        this.setStrStaffId(id);
        setStrEmailAddress(email);
        setStrDateOfJoining(date);
        setCvFile(cv);
        setStrSpecialityArea(speciality);
        setPhoto(photo);
        
    }
    
    
     public void  setUserName(String userName){//method to set the user name of medical officer
        this. userName=userName;
    }
    public void setName(String name){//method to set the name of medical officer
        this.name=name;
    }
    public void setGender(String gender){//method to set the gender of medical officer
         this.gender=gender;
    }
    public void setphoneNumber(String phoneNumber){//method to set the phone number of medical officer
         this.phoneNumber=phoneNumber;
    }
    public void setIdCardNo(String idCardNo){//method to set the id card no of medical officer
          this.idCardNo=idCardNo;
    }
    public void setDateOfBirth(String dateOfBirth){//method to set the date of birth of medical officer
         this.dateOfBirth=dateOfBirth;
    }
    public void setAddress(String address){//method to set the address of medical officer
         this.address=address;
    }
    public void setMaritalStatus(String status){//method to set the marital status of medical officer
         this.maritalStatus=status;
    }
    public void setStrPassword(String password){//method to set password of medical officer
        this.password=password;
    }
    public void setStrStaffId(String id){//method to set the staff id of medical officer
        this.strStaffId=id;
        
    }
    public void setStrEmailAddress(String email){//method to set the email address of medical officer
        this.strEmailAddress=email;
    }
    public void setStrDateOfJoining(String date){//method to set the date of joining of medical officer
        this.strDateOfJoining=date;
    }
    public void setCvFile(File cv){//method to set the cv file of medical officer
        this.cv=cv;
    }
     public void setPhoto(File file){//method to set the photo of medical officer
        this.photo=file;
    }
    public void setStrSpecialityArea(String speciality){//method to set the speciality area of medical officer
        this.strSpecialityArea=speciality;
    }
    
    
    
    //setters
    public  String getUserName(){//get method to get the user name of medical officer
        return userName;
    }
    public String getName(){//get method to get the name of medical officer
        return name;
    }
    public String getGender(){//get method to get the gender of medical officer
        return gender;
    }
    public String getphoneNumber(){//get method to get the phone number of medical officer
        return phoneNumber;
    }
    public String getIdCardNo(){//get method to get the id card no of medical officer
        return idCardNo;
    }
    public String getDateOfBirth(){////get method to get the date of birth of medical officer
        return dateOfBirth;
    }
    public String getAddress(){//get method to get the address of medical officer
        return address;
    }
    public String getMaritalStatus(){////get method to get the marital status of medical officer
        return maritalStatus;
    }
    public String getPassword(){//get method to get the password of medical officer
        return this.password;
    }
    public String getStrStaffId(){//get method to get the staff id of medical officer
        return strStaffId;
    }
    public String getStrEmailAddress(){//get method to get the email address of medical officer
        return strEmailAddress;
    }
    public String getStrDateOfJoining(){//get method to get the date of joining of medical officer
        return strDateOfJoining;
    }
    public File getCvFile(){//get method to get the cv file of medical officer
        return cv;
    }
    public File getPhoto(){//get method to get the photo of medical officer
        return photo;
    }
    public String getStrSpecialityArea(){//get method to get the speciality area of medical officer
        return strSpecialityArea;
    }
        
     public String moName() {
         return "DR."+getName();
     }
    
    
    @Override
     public String toString() {
         return "DR."+getName()+"--"+getStrStaffId();
     }
     
     public String toString2() {
        return getUserName()+","+getName()+","+getGender()+","+getphoneNumber()+","+getIdCardNo()+","+getDateOfBirth()+","+getAddress()+","+getMaritalStatus()+","+getPassword()+","+getStrStaffId()+","+getStrEmailAddress()+","+getStrDateOfJoining()+","+getCvFile()+","+getStrSpecialityArea()+","+getPhoto();
    }
     public static MedicalOfficer readMoUser(String line){
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
            String speciality=data[13];
            String image=data[14];

            File cvFile = new File(cv);
             File staffImage = new File(image);

           return new MedicalOfficer(userName,name,gender,mobile,idCard,dob,address,status,password,staffId,email,date,cvFile,speciality,staffImage);
  } 
}

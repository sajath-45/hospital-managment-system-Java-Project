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
public class Patient extends User {
    private String userName;
    private String name;
    private String gender;
    private String phoneNumber;
    private String idCardNo;
    private String dateOfBirth;
    private String address;
    private String  maritalStatus;
    private  String password;
    private String strBloodGrp;
    private String strAllergies;
    private File photo;

    
    public Patient(String userName,String name,String gender,String mobile,String idNumber,String dob,String address,String martialStatus,String password,String bloodGrp, String allergies,File image){
         //super(userName,name,gender,mobile,idNumber,dob,address,martialStatus,password);
         this.setUserName(userName);
        this.setName(name);
        this.setGender(gender);
        this.setphoneNumber(mobile);
        setAddress(address);
        setIdCardNo(idNumber);
        setDateOfBirth(dob);
        setMaritalStatus(martialStatus);
        setStrPassword(password);
        setStrBloodGrp(bloodGrp);
        setStrAllergies(allergies);
        setPhoto(image);
    }
    
    //getters and setters
    public void setStrBloodGrp(String blood){//method to set the blood grp of patient
        this.strBloodGrp=blood;
    }
    public void setStrAllergies(String allergy){//method to set the allergies of patient
        this.strAllergies=allergy;
    }
    public void  setUserName(String userName){//method to set the user name of patient
        this. userName=userName;
    }
    public void setName(String name){//method to set the name of patient
        this.name=name;
    }
    public void setGender(String gender){//method to set the gender of patient
         this.gender=gender;
    }
    public void setphoneNumber(String phoneNumber){//method to set the phone number of patient
         this.phoneNumber=phoneNumber;
    }
    public void setIdCardNo(String idCardNo){//method to set the id card no of patient
          this.idCardNo=idCardNo;
    }
    public void setDateOfBirth(String dateOfBirth){//method to set the date of birth of patient
         this.dateOfBirth=dateOfBirth;
    }
    public void setAddress(String address){//method to set the address of patient
         this.address=address;
    }
    public void setMaritalStatus(String status){//method to set the marital status of patient
         this.maritalStatus=status;
    }
    public void setStrPassword(String password){//method to set the password of patient
        this.password=password;
    }
     public void setPhoto(File file){//method to set the photo of patient
        this.photo=file;
    }
    
    //getters
    
    
     public  String getUserName(){//get method to get the user name of patient
        return userName;
    }
    public String getName(){//get method to get the name of patient
        return name;
    }
    public String getGender(){//get method to get the gender of patient
        return gender;
    }
    @Override
    public String getphoneNumber(){//get method to get the phone number of patient
        return phoneNumber;
    }
    @Override
    public String getIdCardNo(){//get method to get the id card no of patient
        return idCardNo;
    }
    @Override
    public String getDateOfBirth(){//get method to get the date of birth of patient
        return dateOfBirth;
    }
    @Override
    public String getAddress(){//get method to get the address of patient
        return address;
    }
    @Override
    public String getMaritalStatus(){//get method to get the marital status of patient
        return maritalStatus;
    }
    @Override
    public String getPassword(){//get method to get the password of patient
        return this.password;
    }
    public String getStrBloodGrp(){//get method to get the bloodgrp of patient
        return strBloodGrp;
    }
    public String getStrAllergies(){//get method to get the allergies of patient
        return strAllergies;
    }
    @Override
     public File getPhoto(){//get method to get the photo of patient
        return photo;
    }
    
    @Override
      public String toString() {
        return getName()+"--"+getIdCardNo();
    }
      
    @Override
      public String toString2() {
        return getUserName()+","+getName()+","+getGender()+","+getphoneNumber()+","+getIdCardNo()+","+getDateOfBirth()+","+getAddress()+","+getMaritalStatus()+","+getPassword()+","+getStrBloodGrp()+","+getStrAllergies()+","+getPhoto();
    }
      
    public static Patient readPatientUser(String line){
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
              String bldGroup=data[9];
               String allergy=data[10];
               File image=new File(data[11]);
 
               return new Patient(userName,name,gender,mobile,idCard,dob,address,status,password,bldGroup,allergy,image);
      }
}

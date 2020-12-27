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
    public void setStaffId(String id){
        this.staffId=id;
    }
    public void setStrMailAddress(String mail){
        this.strMailAddress=mail;
    }
    public void setStrDateOfJoining(String date){
        this.strDateOfJoining=date;
    }
    public void setFileCv(File cv){
        this.fileCv=cv;
    }
    
     public void setPhoto(File photo){
        this.photo=photo;
    }
    //getters
       public  String getUserName(){
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
    public String getStrStaffId(){
        return staffId;
    }
    
    public String getStrEmailAddress(){
        return strMailAddress;
        
    }
    public String getStrDateOfJoining(){
        return strDateOfJoining;
    }
    public File getCvFile(){
        return fileCv;
    }
     public File getPhoto(){
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

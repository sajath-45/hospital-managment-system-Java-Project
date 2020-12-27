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
    public void setStrBloodGrp(String blood){
        this.strBloodGrp=blood;
    }
    public void setStrAllergies(String allergy){
        this.strAllergies=allergy;
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
     public void setPhoto(File file){
        this.photo=file;
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
    @Override
    public String getphoneNumber(){
        return phoneNumber;
    }
    @Override
    public String getIdCardNo(){
        return idCardNo;
    }
    @Override
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    @Override
    public String getAddress(){
        return address;
    }
    @Override
    public String getMaritalStatus(){
        return maritalStatus;
    }
    @Override
    public String getPassword(){
        return this.password;
    }
    public String getStrBloodGrp(){
        return strBloodGrp;
    }
    public String getStrAllergies(){
        return strAllergies;
    }
    @Override
     public File getPhoto(){
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

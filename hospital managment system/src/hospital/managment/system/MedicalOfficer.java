/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import java.io.File;

/**
 *
 * @author Sangeerthana
 */
public class MedicalOfficer extends User {
    private String strStaffId;
    private String strEmailAddress;
    private String strDateOfJoining;
    private File photo;
    private File cv;
    private String strSpecialityArea;
    
    
    public MedicalOfficer(String userName,String name,String gender,String mobile,String idNumber,String dob,String address,String martialStatus,String password,String id,String email,String date,File cv,String speciality,File photo){
        super(userName,name,gender,mobile,idNumber,dob,address,martialStatus,password);
        this.setStrStaffId(id);
        this.setStrEmailAddress(email);
        this.setStrDateOfJoining(date);
        this.setCvFile(cv);
        this.setStrSpecialityArea(speciality);
        setPhoto(photo);
        
    }
    
    //getters and setters
    
    public String getStrStaffId(){
        return strStaffId;
    }
    public String getStrEmailAddress(){
        return strEmailAddress;
    }
    public String getStrDateOfJoining(){
        return strDateOfJoining;
    }
    public File getCvFile(){
        return cv;
    }
    public File getPhoto(){
        return photo;
    }
    public String getStrSpecialityArea(){
        return strSpecialityArea;
    }
    
    
    public void setStrStaffId(String id){
        this.strStaffId=id;
        
    }
    public void setStrEmailAddress(String email){
        this.strEmailAddress=email;
    }
    public void setStrDateOfJoining(String date){
        this.strDateOfJoining=date;
    }
    public void setCvFile(File cv){
        this.cv=cv;
    }
     public void setPhoto(File file){
        this.photo=file;
    }
    public void setStrSpecialityArea(String speciality){
        this.strSpecialityArea=speciality;
    }
    
    
     public String moName() {
         return "DR."+super.getName();
     }
    
    
     public String toString() {
         return "DR."+super.getName()+"--"+getStrStaffId();
     }
     
     public String toString2() {
        return super.toString()+","+getStrStaffId()+","+getStrEmailAddress()+","+getStrDateOfJoining()+","+getCvFile()+","+getStrSpecialityArea()+","+getPhoto();
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

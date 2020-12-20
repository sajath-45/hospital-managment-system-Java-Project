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
public class Receptionist extends User {
    private String intStaffId;
    private String strMailAddress;
    private String strDateOfJoining;
    private File fileCv;
    private File staffPhoto;
    
    
    public Receptionist(String userName,String name,String gender,String mobile,String idNumber,String dob,String address,String martialStatus,String password,String id,String email,String date,File cv,File image){
         super(userName,name,gender,mobile,idNumber,dob,address,martialStatus,password);
        this.setIntStaffId(id);
        this.setStrMailAddress(email);
        this.setStrDateOfJoining(date);
        this.setFileCv(cv);
        setStaffPhoto(image);
   
    }
     // getters setters 
     
    public void setIntStaffId(String id){
        this.intStaffId=id;
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
    
     public void setStaffPhoto(File photo){
        this.staffPhoto=photo;
    }
    
    public String getStrStaffId(){
        return intStaffId;
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
        return staffPhoto;
    }
   
    
    public String toString(){
        return  super.toString()+","+getStrStaffId()+","+getStrEmailAddress()+","+getStrDateOfJoining()+","+getCvFile() +","+getPhoto()  ;
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
}

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
    
    public String getIntStaffId(){
        return intStaffId;
    }
    
    public String getStrMailAddress(){
        return strMailAddress;
        
    }
    public String getStrDateOfJoining(){
        return strDateOfJoining;
    }
    public File getFileCv(){
        return fileCv;
    }
     public File getStaffPhoto(){
        return staffPhoto;
    }
   
    
    public String toString(){
        return  super.toString()+","+getIntStaffId()+","+getStrMailAddress()+","+getStrDateOfJoining()+","+getFileCv().getName() +","+getStaffPhoto()  ;
    }
    
}

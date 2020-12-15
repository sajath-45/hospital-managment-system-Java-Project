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
public class MedicalOfficer extends User {
    private String strStaffId;
    private String strEmailAddress;
    private String strDateOfJoining;
    private String strCv;
    private String strSpecialityArea;
    
    
    public MedicalOfficer(String userName,String name,String gender,String mobile,String idNumber,String dob,String address,String martialStatus,String password,String id,String email,String date,String cv,String speciality){
        super(userName,name,gender,mobile,idNumber,dob,address,martialStatus,password);
        this.setStrStaffId(id);
        this.setStrEmailAddress(email);
        this.setStrDateOfJoining(date);
        this.setStrCv(cv);
        this.setStrSpecialityArea(speciality);
        
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
    public String getStrCv(){
        return strCv;
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
    public void setStrCv(String cv){
        this.strCv=cv;
    }
    public void setStrSpecialityArea(String speciality){
        this.strSpecialityArea=speciality;
    }
     public String toString() {
        return "DR."+super.toString();
    }
}

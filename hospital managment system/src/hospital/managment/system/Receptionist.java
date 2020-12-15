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
public class Receptionist extends User {
    private String intStaffId;
    private String strMailAddress;
    private String strDateOfJoining;
    private String strCV;
    
    
    public Receptionist(String userName,String name,String gender,String mobile,String idNumber,String dob,String address,String martialStatus,String password,String id,String email,String date,String cv){
         super(userName,name,gender,mobile,idNumber,dob,address,martialStatus,password);
        this.setIntStaffId(id);
        this.setStrMailAddress(email);
        this.setStrDateOfJoining(date);
        this.setStrCV(cv);
        
        
    }
     // getters setters 
    
    public String getIntStaffId(){
        return intStaffId;
    }
    
    public String getStrMailAddress(){
        return strMailAddress;
        
    }
    public String getStrDateOfJoining(){
        return strDateOfJoining;
    }
    public String getStrCV(){
        return strCV;
    }
    
    
    
    
    public void setIntStaffId(String id){
        this.intStaffId=id;
    }
    public void setStrMailAddress(String mail){
        this.strMailAddress=mail;
    }
    public void setStrDateOfJoining(String date){
        this.strDateOfJoining=date;
    }
    public void setStrCV(String cv){
        this.strCV=cv;
    }
    
    
}

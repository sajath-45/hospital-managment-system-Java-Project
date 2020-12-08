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
public class Receptionist {
    private int intStaffId;
    private String strMailAddress;
    private String strDateOfJoining;
    private String strCV;
    
    
    public Receptionist(){
        this.strMailAddress="";
        this.strDateOfJoining="";
        this.strCV="";
        
        
    }
     // getters setters 
    
    public int getIntStaffId(){
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
    
    
    
    
    public void setIntStaffId(int id){
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

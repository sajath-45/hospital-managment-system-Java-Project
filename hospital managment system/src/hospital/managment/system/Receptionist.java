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
    
    
    
    
    public void setIntStaffId(int i){
        this.intStaffId=i;
    }
    public void setStrMailAddress(String m){
        this.strMailAddress=m;
    }
    public void setStrDateOfJoining(String d){
        this.strDateOfJoining=d;
    }
    public void setStrCV(String c){
        this.strCV=c;
    }
    
    
}

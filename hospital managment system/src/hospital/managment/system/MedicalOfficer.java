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
public class MedicalOfficer {
    private String strStaffId;
    private String strEmailAddress;
    private String strDateOfJoining;
    private String strCv;
    private String strSpecialityArea;
    
    
    public MedicalOfficer(){
        
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
    
    
    public void setStrStaffId(String i){
        this.strStaffId=i;
        
    }
    public void setStrEmailAddress(String e){
        this.strEmailAddress=e;
    }
    public void setStrDateOfJoining(String d){
        this.strDateOfJoining=d;
    }
    public void setStrCv(String c){
        this.strCv=c;
    }
    public void setStrSpecialityArea(String s){
        this.strSpecialityArea=s;
    }
}

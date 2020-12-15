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
public class Patient extends User {
    private String strBloodGrp;
    private String strAllergies;
    
    public Patient(String userName,String name,String gender,String mobile,String idNumber,String dob,String address,String martialStatus,String password,String bloodGrp, String allergies){
         super(userName,name,gender,mobile,idNumber,dob,address,martialStatus,password);
        this.setStrBloodGrp(bloodGrp);
        this.setStrAllergies(allergies);
    }
    
    //getters and setters
    
    
    public String getStrBloodGrp(){
        return strBloodGrp;
    }
    public String getStrAllergies(){
        return strAllergies;
    }
    
    
    public void setStrBloodGrp(String blood){
        this.strBloodGrp=blood;
    }
    public void setStrAllergies(String allergy){
        this.strAllergies=allergy;
    }
      public String toString() {
        return super.toString();
    }
}

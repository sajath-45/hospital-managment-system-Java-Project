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
public class Patient {
    private String strBloodGrp;
    private String strAllergies;
    
    public Patient(){
        
    }
    
    //getters and setters
    
    
    public String getStrBloodGrp(){
        return strBloodGrp;
    }
    public String getStrAllergies(){
        return strAllergies;
    }
    
    
    public void setStrBloodGrp(String b){
        this.strBloodGrp=b;
    }
    public void setStrAllergies(String a){
        this.strAllergies=a;
    }
}

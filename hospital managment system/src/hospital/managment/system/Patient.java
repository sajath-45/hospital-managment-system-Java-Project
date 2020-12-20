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
        return super.getName()+"--"+super.getIdCardNo();
    }
      
      public String toString2() {
        return super.toString()+","+getStrBloodGrp()+","+getStrAllergies();
    }
      
    public static Patient readPatientUser(String line){
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
              String bldGroup=data[9];
               String allergy=data[10];
 
               return new Patient(userName,name,gender,mobile,idCard,dob,address,status,password,bldGroup,allergy);
      }
}

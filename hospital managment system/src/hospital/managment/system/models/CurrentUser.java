/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system.models;

/**
 *
 * @author sajath
 */ //used factory design pattern here
public class CurrentUser {
    private static User user;
    private static String userRole;

    

   
   public  CurrentUser(String role,String line){
       setUserRole(role);
        if("Admin".equalsIgnoreCase(role)){
            //setUser()
        }
        else if("MedicalOfficer".equalsIgnoreCase(role)){
            setUser(MedicalOfficer.readMoUser(line));
        }
        else if("Patient".equalsIgnoreCase(role)){
                setUser(Patient.readPatientUser(line));
        }
        else if("Receptionist".equalsIgnoreCase(role)){
                setUser(Receptionist.readReceptionistUser(line));
        }
   }
    private void setUser(User newUser){
        user=newUser;
        
    }
    private void setUserRole(String role){
        userRole=role;
    }
	
   public static User getUser(){
       return user;
       
   }
   public static String getUserRole(){
       return userRole;
   }
   //methods
  
   
    
   
 }  
    
    
    
    
    
    


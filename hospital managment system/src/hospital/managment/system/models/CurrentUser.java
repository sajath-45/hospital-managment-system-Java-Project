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
    private void setUser(User newUser){//method to set the user of current user
        user=newUser;
        
    }
    private void setUserRole(String role){//method to set the role of current user
        userRole=role;
    }
	
   public static User getUser(){//get method to get the user of current user
       return user;
       
   }
   public static String getUserRole(){//get method to get the role of current user
       return userRole;
   }
   //methods
  
   
    
   
 }  
    
    
    
    
    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system.models;

/**
 *
 * @author sajath
 */
public class UserLogin {
     private String date;
   private String time;
   private String role;
   private String userName;
   
   public UserLogin(String name,String role,String date,String time){
       setUserName(name);
       setRole(role);
       setDate(date);
       setTime(time);
   }
            
            
            
    public void setUserName(String name){
        this.userName=name;
    }
    public void setDate(String date){
         this.date=date;
        
    }
    public void setTime(String time){
        this.time=time;
    }
    public void setRole(String role){
           this.role=role;
        
    }
    public String getUserName(){
           return userName;
       }
    public String getDate(){
            return date;
           
       }
    public String getTime(){
           return time;
       }
    public String getRole(){
               return role;
       }
    public String toString(){
        return this.getUserName()+","+getRole()+","+getDate()+","+getTime();
    }
   public static  UserLogin readLogin(String line){
     String[] data=line.split(",");
         
          String userName=data[0];
           String role=data[1];
            String date=data[2];
            String time=data[3];
            
    return new UserLogin(userName,role,date,time);
}    
 
}

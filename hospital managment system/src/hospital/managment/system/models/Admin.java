/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system.models;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author sajath
 */
public class Admin {
    private String userName;
    private String password;
    
    public Admin(String name,String password){
        setUserName(name);
        setPassword(password);
    }
    
    public void setUserName(String name){//Method to set the user name of admin
        this.userName=name;
    }
    public void setPassword(String password){//Method to set the password of admin
        this.password=password;
    }
    public String getUserName(){//get method to get the user name of admin
        return this.userName;
    }
     public String getPassword(){//get method to get the password of admin
        return this.password;
    }
    static Admin read(BufferedReader reader) throws IOException {
          String line = reader.readLine();
         if(line!=null){
              return new Admin(line,reader.readLine());
         }
         else{
             return null;
         } 
    } 
    
}

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
    
    public void setUserName(String name){
        this.userName=name;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getUserName(){
        return this.userName;
    }
     public String getPassword(){
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

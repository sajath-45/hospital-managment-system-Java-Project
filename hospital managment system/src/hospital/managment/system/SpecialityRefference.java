/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author sajath
 */
public class SpecialityRefference {
     private final String USER_FILE_PATH = "files/specialityRefference.txt";
    private final File USER_FILE = new File(USER_FILE_PATH);
    
    private  ArrayList<String> specialityTypes;
    
    
    public SpecialityRefference(){
         this.setSpecialityTypes(new ArrayList<String>());
         this.loadAllRefference();
       
    }
    
    
    public void setSpecialityTypes(ArrayList<String>  types){
        this.specialityTypes=types;
        
    }
    public ArrayList<String> getSpecialityTypes(){
        return this.specialityTypes;
    }
    
    public void loadAllRefference(){
        System.out.println("works");
         try {System.out.println("works");
             BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));
             
            String line;
            while ((line = reader.readLine()) != null) {
                 System.out.println("added"+line);
               this.specialityTypes.add(line);
              
            }
            reader.close();
            
        } 
         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    
    }
    
    public void addRefference(String type){
        
        this.specialityTypes.add(type);
        
        
    }
    
    
}

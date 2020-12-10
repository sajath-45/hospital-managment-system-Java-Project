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
public class ComplainRefference {
     private final String COMPLAIN_REFFERENCE_FILE_PATH = "files/complainRefference.txt";
    private final File COMPLAIN_REFFERENCE_FILE = new File(COMPLAIN_REFFERENCE_FILE_PATH);
    
    private static ArrayList<String> complainTypes;
    
    
    public ComplainRefference(){
        this.setComplainTypes(new ArrayList<String>());
         this.loadAllRefference();
    }
    
    
    public void setComplainTypes(ArrayList<String>  types){
        this.complainTypes=types;
        
    }
    public ArrayList<String> getComplainTypes(){
        return this.complainTypes;
    }
    
    
       public void loadAllRefference(){
        System.out.println("works");
         try {
             BufferedReader reader = new BufferedReader(new FileReader(COMPLAIN_REFFERENCE_FILE));
             System.out.println("works");
            String line;
            
            while ((line = reader.readLine()) != null) {
                 System.out.println("added"+line);
               this.complainTypes.add(line);
              
            }
            reader.close();
            
        } 
         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import java.util.ArrayList;

/**
 *
 * @author sajath
 */
public class ComplainRefference {
    private static ArrayList<String> complainTypes;
    
    
    public ComplainRefference(){
        
    }
    
    
    public void setComplainTypes(ArrayList<String>  types){
        this.complainTypes=types;
        
    }
    public ArrayList<String> getComplainTypes(){
        return this.complainTypes;
    }
    
}

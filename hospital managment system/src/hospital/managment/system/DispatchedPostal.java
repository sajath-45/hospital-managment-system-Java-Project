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
public class DispatchedPostal {
    private String strToName;
    private String strToAddress;
    
    
    public DispatchedPostal(){
        
    }
    
    public String getStrToName(){
        return strToName;
    }
    public String getStrToAddress(){
        return strToAddress;
    }
    
    
    
    public void setStrToName(String name){
        this.strToName=name;
    }
    public void setStrToAddress(String address){
        this.strToAddress=address;
    }
}

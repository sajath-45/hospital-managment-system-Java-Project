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
public class ReceivedPostal {
    private String strFromName;
    private String strFromAddress;
    
    
    
    public ReceivedPostal(){
        
    }
    public String getStrFromName(){
        return strFromName;
    }
    public String getStrFromAddress(){
        return strFromAddress;
    }
    
    
    public void setStrFromName(String name){
        this.strFromName=name;
    }
    public void setStrFromAddress(String address){
        this.strFromAddress=address;
    }
}

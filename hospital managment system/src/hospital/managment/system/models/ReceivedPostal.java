/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system.models;

import hospital.managment.system.models.PostalMail;
import java.io.File;

/**
 *
 * @author Sangeerthana
 */
public class ReceivedPostal extends PostalMail{
    private String strFromName;
    private String strFromAddress;
    
    
    
    public ReceivedPostal(String number,String note,String date,File file,String fromName,String address){
         super(number,note,date,file);
        this.setStrFromAddress(address);
        this.setStrFromName(fromName);
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
    public String toString(){
        return super.toString();
    }
}

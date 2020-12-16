/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import java.io.File;

/**
 *
 * @author Sangeerthana
 */
public class DispatchedPostal extends PostalMail {
    private String strToName;
    private String strToAddress;
    
    
    public DispatchedPostal(String note,String date,File file,String toName,String address){
        super(note,date,file);
        this.setStrToName(toName);
        this.setStrToAddress(address);
        
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
    
    public String toString(){
        return  super.getIntReferenceNo()+","+super.getStrDate()+","+getStrToName()+","+ getStrToAddress()+","+super.getStrNote()+","+super.getAttachment().getName();
    }

   
}

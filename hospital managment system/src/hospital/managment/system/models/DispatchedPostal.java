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
public class DispatchedPostal extends PostalMail {
    private String strToName;
    private String strToAddress;
    
    
    
    public DispatchedPostal(String number,String note,String date,File file,String toName,String address){
        super(number,note,date,file);
        this.setStrToName(toName);
        this.setStrToAddress(address);
        
    }
    
    public String getStrToName(){//get method to get the name of dispatched postal
        return strToName;
    }
    public String getStrToAddress(){//get method to get the address of dispatched postal
        return strToAddress;
    }
    
    
    
    public void setStrToName(String name){//method to set the name of dispatched postal
        this.strToName=name;
    }
    public void setStrToAddress(String address){//method to set the address of dispatched postal
        this.strToAddress=address;
    }
    
    @Override
    public String toString(){
        return  super.getReferenceNo()+","+super.getStrDate()+","+getStrToName()+","+ getStrToAddress()+","+super.getStrNote()+","+super.getAttachment();
    }

  public static DispatchedPostal readMail(String line){
         String[] data=line.split(",");
         
          String refferenceNumber=data[0];
           String date=data[1];
            String toName=data[2];
            String toAddress=data[3];
            String note=data[4];
            String attachment=data[5];
            
            

               return new DispatchedPostal(refferenceNumber,note,date,new File(attachment),toName,toAddress);
    }    
 
}

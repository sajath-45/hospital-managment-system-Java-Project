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
    
    
    public DispatchedPostal(String number,String note,String date,File file,String toName,String address){
        super(number,note,date,file);
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
    
    @Override
    public String toString(){
        return  super.getReferenceNo()+","+super.getStrDate()+","+getStrToName()+","+ getStrToAddress()+","+super.getStrNote()+","+super.getAttachment().getName();
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

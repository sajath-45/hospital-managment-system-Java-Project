/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system.models;

import java.io.File;

/**
 *
 * @author Sangeerthana
 */
public class PostalMail {
    private  String referenceNo;
    private String strNote;
    private String strDate;
    private File strAttachment;
   
    
    
    public PostalMail(String number,String note,String date,File file){
       setReferenceNo(number);
        this.setAttachment(file);
        this.setStrDate(date);
        this.setStrNote(note);
        
    }
    
    public String getReferenceNo(){
        return referenceNo;
    }
    public String getStrNote(){
        return strNote;    
     }
    public String getStrDate(){
        return strDate;
        
    }
    public File getAttachment(){
        return strAttachment;
    }
  
   public void setReferenceNo(String reference){
       this.referenceNo=reference;
   }
    
    public void setStrNote(String note){
        this.strNote = note;
    }
    public void setStrDate(String date){
        this.strDate=date;
    }
    public void setAttachment(File attach){
        this.strAttachment=attach;
    }
    
   
    
}    

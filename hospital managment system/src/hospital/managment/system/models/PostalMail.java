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
    
    public String getReferenceNo(){//get method to get the reference no of postal mail
        return referenceNo;
    }
    public String getStrNote(){//get method to get the note of postal mail
        return strNote;    
     }
    public String getStrDate(){//get method to get the date of postal mail
        return strDate;
        
    }
    public File getAttachment(){//get method to get the attachment of postal mail
        return strAttachment;
    }
  
   public void setReferenceNo(String reference){//method to set the reference no of postal mail
       this.referenceNo=reference;
   }
    
    public void setStrNote(String note){//method to set the note of postal mail
        this.strNote = note;
    }
    public void setStrDate(String date){//method to set the date of postal mail
        this.strDate=date;
    }
    public void setAttachment(File attach){//method to set the attachment of postal mail
        this.strAttachment=attach;
    }
    
   
    
}    

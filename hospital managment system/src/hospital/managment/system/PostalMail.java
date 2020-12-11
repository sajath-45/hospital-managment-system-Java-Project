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
public class PostalMail {
    private  int intReferenceNo;
    private String strNote;
    private String strDate;
    private File strAttachment;
    private static int refferenceCount=1;
    
    
    public PostalMail(String note,String date,File file){
        this.setIntReferenceNo(refferenceCount);
        this.setAttachment(file);
        this.setStrDate(date);
        this.setStrNote(note);
        
    }
    
    public int getIntReferenceNo(){
        return intReferenceNo;
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
  
   public void setIntReferenceNo(int reference){
       this.intReferenceNo=reference;
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
    
    public static void incrementRefferenceCount(){
        refferenceCount++;
    }
    
}    

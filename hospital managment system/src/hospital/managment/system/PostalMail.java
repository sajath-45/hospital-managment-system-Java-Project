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
public class PostalMail {
    private int intReferenceNo;
    private String strNote;
    private String strDate;
    private String strAttachment;
    
    
    public PostalMail(){
        
    }
    
    private int getIntReferenceNo(){
        return intReferenceNo;
    }
    public String getStrNote(){
        return strNote;    
     }
    public String getStrDate(){
        return strDate;
        
    }
    public String getStrAttachment(){
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
    public void setStrAttachment(String attach){
        this.strAttachment=attach;
    }
    
}    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.managment.system;

/**
 *
 * @author siva lathu
 */
public class Complaint {
    private String strType;
    private String strComplaintBy;
    private int intPhoneNumber;
    private String strDate;
    private String strDescription;
    private String strActionTaken;
    private String strNote;
    private String strAttachment;
    
    public Complaint() {
    
    }
    
    public String getStrType() {
            return strType;
    }
    public String getStrComplaintBy() {
        return strComplaintBy;
    }
    public int getIntPhonrNumber() {
            return intPhoneNumber;
    }
    public String getStrDate() {
            return strDate;
    }
    public String getStrDescription() {
            return strDescription;
    }
    public String getStrActionTaken() {
            return strActionTaken;
    }
    public String getStrNote() {
            return strNote;
    }
    public String getStrAttachment() {
            return strAttachment;
    }
    
    public void setStrType(String Type){
        this.strType=Type;
    }
    public void setStrComplaintBy(String ComplaintBy){
        this.strComplaintBy=ComplaintBy;
    }
    public void setIntPhoneNumber(int PhoneNumber){
        this.intPhoneNumber=PhoneNumber;
    }
    public void setStrDate(String Date){
        this.strDate=Date;
    }
    public void setStrDescription(String Description){
        this.strDescription=Description;
    }
    public void setStrActionTaken(String ActionTaken){
        this.strActionTaken=ActionTaken;
    }
    public void setStrNote(String Note){
        this.strNote=Note;
    }
    public void setStrAttachment(String Attachment){
        this.strAttachment=Attachment;
    }
    
}
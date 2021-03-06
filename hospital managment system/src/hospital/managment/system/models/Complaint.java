/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.managment.system.models;

import java.io.File;

/**
 *
 * @author siva lathu
 */
public class Complaint {
    private String strType;
    private String strComplaintBy;
    private String phoneNumber;
    private String strDate;
    private String strDescription;
    private String strActionTaken;
    private String strNote;
    private File attachment;
    
    public Complaint(){
    
    }
    public Complaint(String type,String date,String complainBy,String number,String description,String actionTaken,String note,File file ) {
        setStrType(type);
           setStrComplaintBy(complainBy);
           setPhoneNumber(number);
           setStrDate(date);
           setStrDescription(description);
           setStrActionTaken(actionTaken);
           setStrNote(note);
           setAttachment(file);
           
    }
    
    public String getStrType() {
            return strType;
    }
    public String getStrComplaintBy() {
        return strComplaintBy;
    }
    public String getPhoneNumber() {
            return phoneNumber;
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
    public File getAttachment() {
            return attachment;
    }
    
    public void setStrType(String type){
        this.strType=type;
    }
    public void setStrComplaintBy(String ComplaintBy){
        this.strComplaintBy=ComplaintBy;
    }
    public void setPhoneNumber(String PhoneNumber){
        this.phoneNumber=PhoneNumber;
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
    public void setAttachment(File attachment){
        this.attachment=attachment;
    }
    
     
     
     public String toString(){
         return this.getStrType()+","+getStrDate()+","+getStrComplaintBy()+","+getPhoneNumber()+","+getStrDescription()+","+getStrActionTaken()+","+getStrNote()+","+getAttachment();
         
     }
    public static Complaint readComplaint(String line){
String[] data=line.split(",");
String type=data[0];
String date=data[1];
String complainBy=data[2];
String description=data[3];
String mobile=data[4];
String actionTaken=data[5];
String note=data[6];
String attachment=data[7];

 return new Complaint(type,date,complainBy,description,mobile,actionTaken,note,new File(attachment));
}
}

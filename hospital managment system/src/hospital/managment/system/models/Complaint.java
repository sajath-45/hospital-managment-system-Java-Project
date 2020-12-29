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
    
    public Complaint(){//default constructor to complaint method
    
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
    
    public String getStrType() {//get method to get the type of complaint
            return strType;
    }
    public String getStrComplaintBy() {//get method to get the by of complaint
        return strComplaintBy;
    }
    public String getPhoneNumber() {//get method to get the phone number of complaint
            return phoneNumber;
    }
    public String getStrDate() {//get method to get the date of complaint
            return strDate;
    }
    public String getStrDescription() {//get method to get the description of complaint
            return strDescription;
    }
    public String getStrActionTaken() {//get method to get the action taken of complaint
            return strActionTaken;
    }
    public String getStrNote() {//get method to get the note of complaint
            return strNote;
    }
    public File getAttachment() {//get method to get the attachment of complaint
            return attachment;
    }
    
    public void setStrType(String type){//method to set the type of complaint
        this.strType=type;
    }
    public void setStrComplaintBy(String ComplaintBy){//method to set the by of complaint
        this.strComplaintBy=ComplaintBy;
    }
    public void setPhoneNumber(String PhoneNumber){//method to set the phone number of complaint
        this.phoneNumber=PhoneNumber;
    }
    public void setStrDate(String Date){//method to set the date of complaint
        this.strDate=Date;
    }
    public void setStrDescription(String Description){//method to set the description of complaint
        this.strDescription=Description;
    }
    public void setStrActionTaken(String ActionTaken){//method to set the action taken of complaint
        this.strActionTaken=ActionTaken;
    }
    public void setStrNote(String Note){//method to set the note of complaint
        this.strNote=Note;
    }
    public void setAttachment(File attachment){//method to set the attachment of complaint
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

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
public class Visitor {
    private String strPurpose;
    private String strName;
    private String intId;
    private String phoneNo;
    private String strDate;
    private String  strInTime;
    private String  strOutTime;
    private String  strNote;
    private File  attachment;
    
    
    
    public Visitor(String purpose,String name,String date,String id,String number,String inTime,String outTime,String note,File file){
        this.setStrPurpose(purpose);
        this.setStrName(name);
        this.setId(id);
        this.setPhoneNo(number);
        this.setStrDate(date);
        this.setStrInTime(inTime);
        this.setStrOutTime(outTime);
        this.setStrNote(note);
        this.setStrAttachment(file);
    }
    
    
    public String getStrPurpose(){//get method to get the purpose of visitor
        return strPurpose;
    }
    public String getStrName(){//get method to get the name of visitor
        return strName;
    }
    public String getStrDate(){//get method to get the date of visitor
        return strDate;
    }
    public String getId(){//get method to get the id of visitor
        return intId;
    }
    public String getPhoneNo(){//get method to get the phone no of visitor
        return phoneNo;
    }
    public String getStrInTime(){//get method to get the intime of visitor
        return strInTime;
    }
    public String getStrOutTime(){//get method to get the outtime of visitor
        return strOutTime;
    }
    public String getStrNote(){//get method to get the note of visitor
        return strNote;
    }
    public File getAttachment(){//get method to get the attachment of visitor
        return attachment;
    }
    
    
    public void setStrPurpose(String purpose){//method to set the purpose of visitor
        this .strPurpose=purpose;
    }
    public void setStrName(String name){//method to set the name of visitor
        this .strName=name;
    }
    public void setStrDate(String date){//method to set the date of visitor
        this .strDate=date;
    }
    public void setId(String id){//method to set the id of visitor
        this. intId=id;
    }
    public void setPhoneNo(String phone){//method to set the phone no of visitor
        this .phoneNo=phone;
    }
    public void setStrInTime(String in){//method to set the intime of visitor
        this. strInTime=in;
    }
    public void setStrOutTime(String out){//method to set the outtime of visitor
        this. strOutTime=out;
    }
    public void setStrNote(String note){//method to set the note of visitor
        this. strNote=note;
    }
    public void setStrAttachment(File attach){//method to set the attachment of visitor
        this. attachment=attach;
    }
    
    public String toString(){
        return getStrDate()+","+getId()+","+getStrName()+","+getStrPurpose()+","+getPhoneNo()+","+getStrInTime()+","+getStrOutTime()+","+getStrNote()+","+getAttachment();
        
    }
   public static Visitor readVisitor(String line){
         String[] data=line.split(",");
          String date=data[0];
           String visitorId=data[1];
            String visitorName=data[2];
            String purpose=data[3];
            String mobile=data[4];
            String inTime=data[5];
             String outTime=data[6];
            String note=data[7];
             String attachment=data[8];

               return new Visitor(purpose,visitorName,date,visitorId,mobile,inTime,outTime,note,new File(attachment));
    } 
}

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
public class Visitor {
    private String strPurpose;
    private String strName;
    private String intId;
    private String intPhoneNo;
    private String strDate;
    private String  strInTime;
    private String  strOutTime;
    private String  strNote;
    private File  attachment;
    
    
    
    public Visitor(String purpose,String name,String date,String id,String number,String inTime,String outTime,String note,File file){
        this.setStrPurpose(purpose);
        this.setStrName(name);
        this.setIntId(id);
        this.setIntPhoneNo(number);
        this.setStrDate(date);
        this.setStrInTime(inTime);
        this.setStrOutTime(outTime);
        this.setStrNote(note);
        this.setStrAttachment(file);
    }
    
    
    public String getStrPurpose(){
        return strPurpose;
    }
    public String getStrName(){
        return strName;
    }
    public String getStrDate(){
        return strDate;
    }
    public String getIntId(){
        return intId;
    }
    public String getIntPhoneNo(){
        return intPhoneNo;
    }
    public String getStrInTime(){
        return strInTime;
    }
    public String getStrOutTime(){
        return strOutTime;
    }
    public String getStrNote(){
        return strNote;
    }
    public File getAttachment(){
        return attachment;
    }
    
    
    public void setStrPurpose(String purpose){
        this .strPurpose=purpose;
    }
    public void setStrName(String name){
        this .strName=name;
    }
    public void setStrDate(String date){
        this .strDate=date;
    }
    public void setIntId(String id){
        this. intId=id;
    }
    public void setIntPhoneNo(String phone){
        this .intPhoneNo=phone;
    }
    public void setStrInTime(String in){
        this. strInTime=in;
    }
    public void setStrOutTime(String out){
        this. strOutTime=out;
    }
    public void setStrNote(String note){
        this. strNote=note;
    }
    public void setStrAttachment(File attach){
        this. attachment=attach;
    }
    
    public String toString(){
        return getStrDate()+","+getIntId()+","+getStrName()+","+getStrPurpose()+","+getIntPhoneNo()+","+getStrInTime()+","+getStrOutTime()+","+getStrNote()+","+getAttachment().getName();
        
    }
    
}

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
public class Visitors {
    private String strPurpose;
    private String strName;
    private int intId;
    private int intPhoneNo;
    private String strDate;
    private String  strInTime;
    private String  strOutTime;
    private String  strNote;
    private String  strAttachment;
    
    
    
    public Visitors(){
        
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
    public int getIntId(){
        return intId;
    }
    public int getIntPhoneNo(){
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
    public String getStrAttachment(){
        return strAttachment;
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
    public void setIntId(int id){
        this. intId=id;
    }
    public void setIntPhoneNo(int phone){
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
    public void setStrAttachment(String attach){
        this. strAttachment=attach;
    }
    
}

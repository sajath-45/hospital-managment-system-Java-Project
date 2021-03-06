/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system.models;

import static hospital.managment.system.models.FileService.getPatientById;
import static hospital.managment.system.models.FileService.getMoById;

/**
 *
 * @author sajath
 */
public class Appointment {
    private Patient patient;
    private MedicalOfficer officer;
    private String appointmentDate;
    private String appointmentTime;
    private String status;
    private String appointmentNumber;
    private String symtomps;
    private String speciality;

    public Appointment(){//default constructor
        
    }
    
    
    public Appointment(String number,Patient patient,MedicalOfficer officer,String appointmentDate,String appointmentTime,String status,String symtomps,String speciality)
    {
        this.setPatient(patient);
        this.setMedicalOfficer(officer);
        this.setAppointmentDate(appointmentDate);
        this.setAppointmentTime(appointmentTime);
        this.setAppointmentNumber(number);
        this.setStatus(status);
        this.setSymtomps(symtomps);
        this.setSpeciality(speciality);
    }
    
    
    public void setPatient(Patient patient){//method to set the patient of appoinment
        this.patient=patient;
        
    }
    public void setMedicalOfficer(MedicalOfficer officer){//method to set the Medical Officer of appointment
        this.officer=officer;
        
    }
    public void setAppointmentDate(String appointmentDate){
        this.appointmentDate=appointmentDate;
        
    }
    public void setAppointmentTime(String appointmentTime){
        this.appointmentTime=appointmentTime;
        
    }
    public void setStatus(String status){
        this.status=status;  
    }
    public void setAppointmentNumber(String appointmentNumber){
        this.appointmentNumber=appointmentNumber;
        
    }
    public void setSymtomps(String symtomps){
        this.symtomps=symtomps;
        
    }
    public void setSpeciality(String speciality){
        this.speciality=speciality;
    }
    
    
    public Patient getPatient(){//get method to get the patient of appointment
        return this.patient;
    }
      public MedicalOfficer getMedicalOfficer(){
        return this.officer;
    }
      public String getAppointmentDate(){
        return this.appointmentDate;
    }
      public String getAppointmentTime(){
        return this.appointmentTime;
    }
      public String getStatus(){
        return this.status;
    }
      public String getAppointmentNumber(){
        return this.appointmentNumber;
    }      
     public String getSymtomps(){
        return this.symtomps;
    }
     public String getSpeciality(){
         return this.speciality;
     }
     
    @Override
    public String toString(){
        return getAppointmentNumber()+","+getAppointmentDate()+","+ getAppointmentTime()+","+getStatus()+","+getPatient().getName()+","+getPatient().getIdCardNo()+","+getMedicalOfficer().getName()+","+getSpeciality()+","+getSymtomps()+","+getMedicalOfficer().getIdCardNo();
    }  
   public static Appointment readAppoinment(String line){// method to return the new appoinment after reading from file
String[] data=line.split(",");
String appoinmentNo=data[0];
String date=data[1];
 String time=data[2];
 String status=data[3];
 String patientName=data[4];
 String patientId=data[5];
 String moName=data[6];
 String speciality=data[7];
  String sysmtomps=data[8];
   String moId=data[9];

 return new Appointment(appoinmentNo,getPatientById ( patientId ),getMoById(moId),date,time,status,sysmtomps,speciality);
}  
}

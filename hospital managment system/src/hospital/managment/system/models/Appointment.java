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

    public Appointment(){//default constructor to appointment method
        
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
    public void setMedicalOfficer(MedicalOfficer officer){//method to set the Medical officer of appoinment
        this.officer=officer;
        
    }
    public void setAppointmentDate(String appointmentDate){//method to set the date of appoinment
        this.appointmentDate=appointmentDate;
        
    }
    public void setAppointmentTime(String appointmentTime){//method to set the time of appoinment
        this.appointmentTime=appointmentTime;
        
    }
    public void setStatus(String status){//method to set the status of appoinment
        this.status=status;  
    }
    public void setAppointmentNumber(String appointmentNumber){//method to set the number of appoinment
        this.appointmentNumber=appointmentNumber;
        
    }
    public void setSymtomps(String symtomps){//method to set the symtomps of appoinment
        this.symtomps=symtomps;
        
    }
    public void setSpeciality(String speciality){//method to set the speciality of appoinment
        this.speciality=speciality;
    }
    
    
    public Patient getPatient(){//get method to get the patient of appoinment
        return this.patient;
    }
      public MedicalOfficer getMedicalOfficer(){//get method to get the medical officer of appoinment
        return this.officer;
    }
      public String getAppointmentDate(){//get method to get the date of appoinment
        return this.appointmentDate;
    }
      public String getAppointmentTime(){//get method to get the time of appoinment
        return this.appointmentTime;
    }
      public String getStatus(){//get method to get the status of appoinment
        return this.status;
    }
      public String getAppointmentNumber(){//get method to get the number of appoinment
        return this.appointmentNumber;
    }      
     public String getSymtomps(){//get method to get the symtomps of appoinment
        return this.symtomps;
    }
     public String getSpeciality(){//get method to get the speciality of appoinment
         return this.speciality;
     }
     
    @Override
    public String toString(){
        return getAppointmentNumber()+","+getAppointmentDate()+","+ getAppointmentTime()+","+getStatus()+","+getPatient().getName()+","+getPatient().getIdCardNo()+","+getMedicalOfficer().getName()+","+getSpeciality()+","+getSymtomps()+","+getMedicalOfficer().getIdCardNo();
    }  
   public static Appointment readAppoinment(String line){
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

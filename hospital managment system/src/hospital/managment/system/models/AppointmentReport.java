package hospital.managment.system.models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import hospital.managment.system.models.MedicalOfficer;
import hospital.managment.system.models.Appointment;
import java.util.ArrayList;

/**
 *
 * @author siva lathu
 */
public class AppointmentReport {
    private ArrayList<Appointment> appointmentList;
    private String strDate;
    private MedicalOfficer medicalOfficer;
    
    public AppointmentReport(ArrayList<Appointment> appointmentList, String date, MedicalOfficer medicalOfficer){
        setAppointment(appointmentList);
        setStrDate(date);
        setMedicalOfficer(medicalOfficer);
    }
    
    public ArrayList getAppoinmentList(){
        return appointmentList;
    }
    public String getStrDate(){
        return strDate;
    }
    public MedicalOfficer getMedicalOfficer(){
        return medicalOfficer;
    }
    
    public void setAppointment(ArrayList<Appointment> appointmentList) {
        this.appointmentList=appointmentList;
    }
    public void setStrDate(String Date) {
        this.strDate=Date;
    }
    public void setMedicalOfficer(MedicalOfficer medicalOfficer) {
        this.medicalOfficer=medicalOfficer;
    }
    
}

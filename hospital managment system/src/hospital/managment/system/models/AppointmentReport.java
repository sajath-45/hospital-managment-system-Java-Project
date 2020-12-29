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
    
    public ArrayList getAppoinmentList(){//get method to get the list of appointment report
        return appointmentList;
    }
    public String getStrDate(){//get method to get the date of appointment report
        return strDate;
    }
    public MedicalOfficer getMedicalOfficer(){//get method to get the medical officer of appointment report
        return medicalOfficer;
    }
    
    public void setAppointment(ArrayList<Appointment> appointmentList) {//method to set the list of appointment report
        this.appointmentList=appointmentList;
    }
    public void setStrDate(String Date) {//method to set the date of appointment report
        this.strDate=Date;
    }
    public void setMedicalOfficer(MedicalOfficer medicalOfficer) {//method to set the medical officer of appointment report
        this.medicalOfficer=medicalOfficer;
    }
    
}

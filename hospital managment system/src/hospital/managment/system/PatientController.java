/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import hospital.managment.system.models.FileService;
import hospital.managment.system.models.Patient;
import hospital.managment.system.models.PipeService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author sajath
 */
public class PatientController implements ActionListener {
     private Patient model;
    private AddPatient view;
    public PatientController(Patient model,AddPatient view){
        setModel(model);
        setView(view);
        
    }
    
    public void initController(){
        
    }
     public void setModel(Patient model){
        this.model=model;
    }
    public void setView(AddPatient view){
        this.view=view;
    }
    public Patient getModel(){
        return this.model;
    }
    public AddPatient getView(){
        return this.view;
        
    }

  

    
    //methods
   
     

    
    public void addPatient(){
        String name=getView().getNameField().getText();
        String gender=getView().getGenderComboBox().getSelectedItem().toString();
        String mobile=getView().getPhoneNumberField().getText();
        String id=getView().getIdCardField().getText();
        String address=getView().getAddressField().getText();
        String userName=getView().getUserNameField().getText();
        String martialStatus=getView().getMartialStatusComboBox().getSelectedItem().toString();
        String dob=PipeService.getDateSimpleFormat(getView().getDobDateChooser().getDate());
        String blood=getView().getBloodComboBox().getSelectedItem().toString();
        String allergy=getView().getAllergiesField().getText();
        
        Patient patient =new Patient(userName,name,gender,mobile,id,dob,address,martialStatus,id,blood,allergy,null);
        FileService.addLine(FileService.getPatientsFilePath(), patient.toString2());
    }
    public void deletePatient(){
           if(AlertService.optionalPlane("Would you like to Delete Patient  Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
             FileService.deleteRecord(FileService.getPatientsFilePath(),getModel().toString2());   
            }
       this.closeView(); 
        
    }
    public void editPatient(){
        if(AlertService.optionalPlane("Would you like to Edit the Patient Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getPatientsFilePath(),getModel().toString2());     
        addPatient();    
      }   
        closeView();
        
    }
    
     public void resetMedicalOfficerPassword(){
        if(AlertService.optionalPlane("Would you like to Reset Password of the Patient Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getPatientsFilePath(),getModel().toString2());  
        getModel().setStrPassword(getModel().getIdCardNo());
          FileService.addLine(FileService.getPatientsFilePath(), getModel().toString2());  
      }   
        closeView();
        
    }
    
    
    
     @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print(e.getActionCommand());
        if(e.getActionCommand().equalsIgnoreCase("add")){
            addPatient();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Save")){
            editPatient();
        }
        
          
         }
    
     public void closeView(){
        this.getView().dispose();
        
    }
    
    
}
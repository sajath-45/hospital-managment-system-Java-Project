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
     private DashboardController dashboard;
    public PatientController(Patient model,AddPatient view,DashboardController dashboard){
        setModel(model);
        setView(view);
         setDashboardController(dashboard);
        
    }
    
    public void initController(){
        
    }
     public void setModel(Patient model){
        this.model=model;
    }
    public void setView(AddPatient view){
        this.view=view;
    }
     public void setDashboardController(DashboardController dash){
        this.dashboard=dash;
    }
    public Patient getModel(){
        return this.model;
    }
    public AddPatient getView(){
        return this.view;
        
    }
    public DashboardController getDashboardController(){
        return dashboard;
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
        this.updateView(); 
    }
    public void deletePatient(){
           if(AlertService.optionalPlane("Would you like to Delete Patient  Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
             FileService.deleteRecord(FileService.getPatientsFilePath(),getModel().toString2());   
            }
       this.updateView(); 
        
    }
    public void editPatient(){
        if(AlertService.optionalPlane("Would you like to Edit the Patient Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getPatientsFilePath(),getModel().toString2());     
        addPatient();    
      }   
        updateView();
        
    }
    
     public void resetMedicalOfficerPassword(){
        if(AlertService.optionalPlane("Would you like to Reset Password of the Patient Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getPatientsFilePath(),getModel().toString2());  
        getModel().setStrPassword(getModel().getIdCardNo());
          FileService.addLine(FileService.getPatientsFilePath(), getModel().toString2());  
      }   
        updateView();
        
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
    
     public void updateView(){ // updates the patients table if a new record is added or edited or deleted
          getDashboardController().getAllPatients();
         
        this.getView().dispose();//close the view
        
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import hospital.managment.system.models.ComplainRefference;
import hospital.managment.system.models.Complaint;
import hospital.managment.system.models.CurrentUser;
import hospital.managment.system.models.FileService;
import hospital.managment.system.models.PipeService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author sajath
 */
public class ComplaintController implements ActionListener{
    private AddComplaint view;
    private Complaint model;
    private DashboardController dashboard;
    
    public ComplaintController(Complaint model,AddComplaint view,DashboardController dashboard){
        setModel(model);
        setView(view);
        setDashboardController(dashboard);
    }
    
    public void setModel(Complaint model){
        this.model=model;
    }
    public void setView(AddComplaint view){
        this.view=view;
    }
     public void setDashboardController(DashboardController dash){
        this.dashboard=dash;
    }
    public AddComplaint getView(){
        return this.view;
    }
    public Complaint getModel(){
        return this.model;
    }
    public DashboardController getDashboardController(){
        return dashboard;
    }
    public void initController(){
        setData();
        setComplainTypeComboBox();
        getView().setFileChooser();
        getView().getOpenFileChooserBtn().addActionListener ((ActionEvent e) -> {
            
            openFileBtn();
        });
    }
    
    
    private void setData(){
        if(getView().getUserRole().equalsIgnoreCase("Patient")){
            getView().getComplainByTextField().setText(CurrentUser.getUser().getName());
             getView().getComplainActionTaken().setEditable(false);

        }
    }
    private void setComplainTypeComboBox(){
        ComplainRefference refference = new ComplainRefference();
        DefaultComboBoxModel newModel = new DefaultComboBoxModel(refference.getComplainTypes().toArray());
         getView().getComplainTypeComboBox().setModel( newModel );
        
    }
    
      @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print(e.getActionCommand());
        if(e.getActionCommand().equalsIgnoreCase("add")){
            addComplaint();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Save")){
           editComplaint();
        }
        else if(e.getActionCommand().equalsIgnoreCase("update")){
            
        }
        
          
         }
    //methods
    public void addComplaint() {                                                
        // TODO add your handling code here:
        String complainType=getView().getComplainTypeComboBox().getSelectedItem().toString();
        String complainBy=getView().getComplainByTextField().getText();
        String mobile=getView().getPhoneNumberTextField().getText();
        String description=getView().getDescriptionTextField().getText();
         String date=PipeService.getDateSimpleFormat(getView().getComplainDateChooser().getDate());  
         String actionTaken=getView().getComplainActionTaken().getText();
         String note=getView().getComplainNoteField().getText();
         File file=getView().getAttachment();
         
         //validate needed
         Complaint complain =new Complaint(complainType,date,complainBy,mobile,description,actionTaken,note,file);
         FileService.addLine(FileService.getComplaintsFilePath(),complain.toString());
         
          updateView();
    } 
    public void editComplaint(){
        if(AlertService.optionalPlane("Would you like to Edit the Complaint Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getComplaintsFilePath(),getModel().toString());     
        addComplaint();    
      }   
        updateView();
    }
    public void deleteComplaint(){
        if(AlertService.optionalPlane("Would you like to Delete the Complaint Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getComplaintsFilePath(),getModel().toString());                  
      }
       this.updateView(); 
    }
    public void changeActionTakenComplaint(){  
         String action=JOptionPane.showInputDialog("Update  Action Taken");
         if( action != null){
            FileService.deleteRecord(FileService.getComplaintsFilePath(),getModel().toString());
            getModel().setStrActionTaken(action);
            FileService.addLine(FileService.getComplaintsFilePath(),getModel().toString());
         }
       
       
    }
    public void openFileBtn(){
          int returnValue =getView().getFileChooser().showOpenDialog(getView());
            if(returnValue==JFileChooser.APPROVE_OPTION){
                 getView().setAttachment(getView().getFileChooser().getSelectedFile());
                getView().getFileLabel().setText(getView().getAttachment().getName());
            }
            else{
                getView().setAttachment(null);
                 
                 getView().getFileLabel().setText("no file choosen");
            }
    }
    
    
    public void updateView(){
       if(CurrentUser.getUserRole().equalsIgnoreCase("Patient")){
            getDashboardController().getAllComplaints();
        }
         else {
             getDashboardController().getAllComplaints();
            
        }
          
        
        this.getView().dispose();
        
        
        
    }
    
}

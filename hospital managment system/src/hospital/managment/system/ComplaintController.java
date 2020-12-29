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
        getView().getOpenFileChooserBtn().addActionListener ((ActionEvent e) -> {//actionListeners check if the open file btn is pressed
            
            openFileBtn();
        });
    }
    
    
    private void setData(){
        if(getView().getUserRole().equalsIgnoreCase("Patient")){//the complain by is default set to patients name if the user role is patient
            getView().getComplainByTextField().setText(CurrentUser.getUser().getName());
             getView().getComplainActionTaken().setEditable(false);

        }
    }
    private void setComplainTypeComboBox(){//populates the complain combo box with all the complain refference types
        ComplainRefference refference = new ComplainRefference();
        DefaultComboBoxModel newModel = new DefaultComboBoxModel(refference.getComplainTypes().toArray());
         getView().getComplainTypeComboBox().setModel( newModel );
        
    }
    
      @Override
    public void actionPerformed(ActionEvent e) {//this function listens to a action preformed in the view eg: adding new Complaint or editing it
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
    public void addComplaint() {     //this fucntion gets the all information for new Complaint from the  view and create a new Complaint object                                           
        String complainType=getView().getComplainTypeComboBox().getSelectedItem().toString();
        String complainBy=getView().getComplainByTextField().getText();
        String mobile=getView().getPhoneNumberTextField().getText();
        String description=getView().getDescriptionTextField().getText();
         String date=PipeService.getDateSimpleFormat(getView().getComplainDateChooser().getDate());  
         String actionTaken=getView().getComplainActionTaken().getText();
         String note=getView().getComplainNoteField().getText();
         File file=getView().getAttachment();//gets the attached file from view
         
       
         Complaint complain =new Complaint(complainType,date,complainBy,mobile,description,actionTaken,note,file);
         FileService.addLine(FileService.getComplaintsFilePath(),complain.toString());
         
          updateView();//update table
    } 
    public void editComplaint(){
        if(AlertService.optionalPlane("Would you like to Edit the Complaint Record?", "Warning!")==JOptionPane.YES_NO_OPTION){//prompt for confirmation of editrecord and checks if its a yes or no
        FileService.deleteRecord(FileService.getComplaintsFilePath(),getModel().toString());  //delete prevoius record      
        addComplaint();    //add new record
      }   
        updateView();//update table
    }
    public void deleteComplaint(){//deletes complaint from the complaint.txt file
        if(AlertService.optionalPlane("Would you like to Delete the Complaint Record?", "Warning!")==JOptionPane.YES_NO_OPTION){//prompt for confirmation of edit record and checks if its a yes or no
        FileService.deleteRecord(FileService.getComplaintsFilePath(),getModel().toString());                  
      }
       this.updateView(); //update table
    }
    public void changeActionTakenComplaint(){ //updates the action taken field for th complaint onlu done by admin 
         String action=JOptionPane.showInputDialog("Update  Action Taken");//stores value of action taken
         if( action != null){//if value of action taken is not null then tha action taken is updated
            FileService.deleteRecord(FileService.getComplaintsFilePath(),getModel().toString());
            getModel().setStrActionTaken(action);
            FileService.addLine(FileService.getComplaintsFilePath(),getModel().toString());
         }
       
       
    }
    public void openFileBtn(){//function to open the file chooser plane to select attachment file for complaint
          int returnValue =getView().getFileChooser().showOpenDialog(getView());
            if(returnValue==JFileChooser.APPROVE_OPTION){//checks if a file is choosen
                 getView().setAttachment(getView().getFileChooser().getSelectedFile());
                getView().getFileLabel().setText(getView().getAttachment().getName());//showing the name of file in the view
            }
            else{
                getView().setAttachment(null);//attachment set to null if file not choosen or attached
                 
                 getView().getFileLabel().setText("no file choosen");
            }
    }
    
    
    public void updateView(){//updates the complaint table after a new complaint is added or a complaint is edited
       if(CurrentUser.getUserRole().equalsIgnoreCase("Patient")){
            getDashboardController().getAllComplaints();
        }
         else {
             getDashboardController().getAllComplaints();
            
        }
          
        
        this.getView().dispose();
        
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import hospital.managment.system.models.FileService;
import hospital.managment.system.models.PipeService;
import hospital.managment.system.models.Visitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author sajath
 */
public class VisitorController implements ActionListener {
    private Visitor model;
    private AddVisitors view;
    private DashboardController dashboard;
    
    public VisitorController(Visitor model,AddVisitors view,DashboardController dashboard){
        setModel(model);
        setView(view);
        setDashboardController(dashboard);
    }
    
     public void setModel(Visitor model){
        this.model=model;
    }
    public void setView(AddVisitors view){
        this.view=view;
    }
    public void setDashboardController(DashboardController dash){
        this.dashboard=dash;
    }
    public AddVisitors getView(){
        return this.view;
    }
    public Visitor getModel(){
        return this.model;
    }
    public DashboardController getDashboardController(){
        return dashboard;
    }
    
    public void initController(){
        getView().setFileChooser();//intialzing the file chooser
         getView().getOpenFileChooserBtn().addActionListener ((ActionEvent e) -> {
            
            openFileBtn();
        });
    }
    
    
    public void addVisitor(){//adding new visitor record by obtaining the details from the view
         String purpose= getView().getPurposeField().getText();
        String idCard= getView().getIdCardField().getText();
        String name= getView().getNameField().getText();
        String mobile= getView().getPhoneNumberField().getText();
        String note= getView().getNoteField().getText();
        String inTime= getView().getInTimeField().getText();
        String outTime= getView().getOutTimeField().getText();
        String date=PipeService.getDateSimpleFormat( getView().getDateChooser().getDate()); 
        File file= getView().getAttachment();
        Visitor newVisitor= new Visitor(purpose,name,date,idCard,mobile,inTime,outTime,note,file);            
        FileService.addLine(FileService.getVisitorsFilePath(),newVisitor.toString());
       
        updateView();
    }
    public void editVisitor(){//function to edit a Visitor record 
        if(AlertService.optionalPlane("Would you like to Edit the Visitor Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getVisitorsFilePath(),getModel().toString());     
            addVisitor();    
      }   
        updateView();
        
        
    }
    public void deleteVisitor(){//function to deletes a Visitor record
          if(AlertService.optionalPlane("Would you like to Delete the Visitor Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getVisitorsFilePath(),getModel().toString());                  
      }
       this.updateView(); 
        
    }
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {//this function listens to a action preformed in the view eg: adding new Visitor or editing it
        System.out.print(e.getActionCommand());
        if(e.getActionCommand().equalsIgnoreCase("add")){
            addVisitor();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Save")){
           editVisitor();
        }
       
     }
      
    public void openFileBtn(){//function opens up the file chooser panel to select the visitor record attachment
          int returnValue =getView().getFileChooser().showOpenDialog(getView());
            if(returnValue==JFileChooser.APPROVE_OPTION){
                 getView().setAttachment(getView().getFileChooser().getSelectedFile());
                getView().getFileLabel().setText(getView().getAttachment().getName());
            }
            else{
                getView().setAttachment(null);//attachmentt set to null if no attachment is selected
                 
                 getView().getFileLabel().setText("no file choosen");
            }
    }  
    public void updateView(){//functions updates the visitor table after a new visitor recordhas been added or edited or deleted
        getDashboardController().getVisitorRecords();
        this.getView().dispose();//closes the view
        
        
        
    }
    
    
}

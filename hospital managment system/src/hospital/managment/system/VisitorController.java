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
        getView().setFileChooser();
         getView().getOpenFileChooserBtn().addActionListener ((ActionEvent e) -> {
            
            openFileBtn();
        });
    }
    
    
    public void addVisitor(){
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
    public void editVisitor(){
        if(AlertService.optionalPlane("Would you like to Edit the Visitor Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getVisitorsFilePath(),getModel().toString());     
            addVisitor();    
      }   
        updateView();
        
        
    }
    public void deleteVisitor(){
          if(AlertService.optionalPlane("Would you like to Delete the Visitor Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getVisitorsFilePath(),getModel().toString());                  
      }
       this.updateView(); 
        
    }
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print(e.getActionCommand());
        if(e.getActionCommand().equalsIgnoreCase("add")){
            addVisitor();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Save")){
           editVisitor();
        }
        else if(e.getActionCommand().equalsIgnoreCase("update")){
            
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
        getDashboardController().getVisitorRecords();
        this.getView().dispose();
        
        
        
    }
    
    
}

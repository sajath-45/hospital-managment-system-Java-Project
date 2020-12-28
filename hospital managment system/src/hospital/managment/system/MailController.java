/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import hospital.managment.system.models.DispatchedPostal;
import hospital.managment.system.models.FileService;
import hospital.managment.system.models.PipeService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author sajath
 */
public class MailController implements ActionListener {
   private DispatchedPostal model;
   private AddMail view;
   private DashboardController dashboard;
   
   public MailController(DispatchedPostal model,AddMail view,DashboardController dashboard){
       this.setModel(model);
       this.setView(view);
        setDashboardController(dashboard);
   }
   public void setModel(DispatchedPostal model){
       this.model=model;
   }
   public void setView(AddMail view){
       this.view=view;  
   }
    public void setDashboardController(DashboardController dash){
        this.dashboard=dash;
    }
   public DispatchedPostal getModel(){
       return model;
   }
   public AddMail getView(){
       return view;
   }
   public DashboardController getDashboardController(){
        return dashboard;
    }
   
   public void initController(){
        getView().getchooseFileBtn().addActionListener ((ActionEvent e) -> {
            
            openFileBtn();
        });
       
   }
     public void openFileBtn(){
          int returnValue =getView().getFileChooser().showOpenDialog(getView());
            if(returnValue==JFileChooser.APPROVE_OPTION){
                 getView().setAttachment(getView().getFileChooser().getSelectedFile());
                getView().getAttachmentName().setText(getView().getAttachment().getName());
            }
            else{
                getView().setAttachment(null);
                 
                 getView().getAttachmentName().setText("no file choosen");
            }
    }
     
   @Override
     public void actionPerformed(ActionEvent e) {
        System.out.print(e.getActionCommand());
        if(e.getActionCommand().equalsIgnoreCase("add")){
            addMail();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Save")){
           editMail();
        }
        else if(e.getActionCommand().equalsIgnoreCase("update")){
            
        }
        
          
         }
   public void addMail(){
       String refferenceNumber=getView().getReferenceField().getText();
        String name=getView().getNoteField().getText();
        String address=getView().getAddressField().getText();
        String note=getView().getNoteField().getText();
        String date=PipeService.getDateSimpleFormat(getView().getDateChooser().getDate());  
        File file=getView().getAttachment();
        DispatchedPostal mail=new DispatchedPostal(refferenceNumber,note,date,file,name,address); 
        FileService.addLine(FileService.getMailsFilePath(),mail.toString());
        
       updateView();
   }
   public void editMail(){
       if(AlertService.optionalPlane("Would you like to Edit the Mail Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getMailsFilePath(),getModel().toString());     
        addMail();    
      }   
        updateView();
       
   }
   public void deleteMail(){
        if(AlertService.optionalPlane("Would you like to Delete the Mail Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getMailsFilePath(),getModel().toString());   
        
      }
       this.updateView(); 
    }
   
   public void updateView(){
       getDashboardController().getDispatchedMails();
        this.getView().dispose();
        
        
        
    }
   
}

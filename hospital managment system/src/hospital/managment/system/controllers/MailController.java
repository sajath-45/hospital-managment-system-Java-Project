/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system.controllers;

import hospital.managment.system.AddMail;
import hospital.managment.system.AlertService;
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
        getView().getchooseFileBtn().addActionListener ((ActionEvent e) -> {//getting the getChooseBtn and adding a action listener to it
            
            openFileBtn();
        });
       
   }
     public void openFileBtn(){//function to open the file chooser plane to select attachment file for mail
          int returnValue =getView().getFileChooser().showOpenDialog(getView());
            if(returnValue==JFileChooser.APPROVE_OPTION){//checks if a file is choosen
                 getView().setAttachment(getView().getFileChooser().getSelectedFile());
                getView().getAttachmentName().setText(getView().getAttachment().getName());//showing the name of file in the view
            }
            else{
                getView().setAttachment(null);//attachment set to null if file not choosen or attached
                 
                 getView().getAttachmentName().setText("no file choosen");
            }
    }
     
   @Override
     public void actionPerformed(ActionEvent e) {//this function listens to a action preformed in the view eg: adding new Mail or editing it
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
   public void addMail(){  //this fucntion gets the all information for new Mail from the  view and create a new Mail object 
       String refferenceNumber=getView().getReferenceField().getText();
        String name=getView().getNoteField().getText();
        String address=getView().getAddressField().getText();
        String note=getView().getNoteField().getText();
        String date=PipeService.getDateSimpleFormat(getView().getDateChooser().getDate());  
        File file=getView().getAttachment();
        DispatchedPostal mail=new DispatchedPostal(refferenceNumber,note,date,file,name,address); 
        FileService.addLine(FileService.getMailsFilePath(),mail.toString());//add the new mail to DispatchedMail.txt
        
       updateView();
   }
   public void editMail(){//function which edit a mail and save its
       if(AlertService.optionalPlane("Would you like to Edit the Mail Record?", "Warning!")==JOptionPane.YES_NO_OPTION){//prompt for confirmation of editrecord and checks if its a yes or no
        FileService.deleteRecord(FileService.getMailsFilePath(),getModel().toString());  //delete prevoius record   
        addMail();    //add new record
      }   
        updateView();
       
   }
   public void deleteMail(){//function to deletes a mail
        if(AlertService.optionalPlane("Would you like to Delete the Mail Record?", "Warning!")==JOptionPane.YES_NO_OPTION){//prompt for confirmation of delete
        FileService.deleteRecord(FileService.getMailsFilePath(),getModel().toString());   
        
      }
       this.updateView(); 
    }
   
   public void updateView(){//updates the Mails table after a new Mail is added or a Mail is edited
       getDashboardController().getDispatchedMails();
        this.getView().dispose();
        //close the view
        
        
    }
   
}

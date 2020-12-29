/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import hospital.managment.system.models.FileService;
import hospital.managment.system.models.MedicalOfficer;
import hospital.managment.system.models.PipeService;
import hospital.managment.system.models.SpecialityRefference;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author sajath
 */
public class MedicalOfficerController implements ActionListener {
    private MedicalOfficer model;
    private AddMedicalOfficer view;
    private DashboardController dashboard;
    
    public MedicalOfficerController(MedicalOfficer model,AddMedicalOfficer view,DashboardController dashboard){
        setModel(model);
        setView(view);
         setDashboardController(dashboard);
        
    }
    public void setModel(MedicalOfficer model){
        this.model=model;
    }
    public void setView(AddMedicalOfficer view){
        this.view=view;
    }
    public void setDashboardController(DashboardController dash){
        this.dashboard=dash;
    }
    public MedicalOfficer getModel(){
        return this.model;
    }
    public AddMedicalOfficer getView(){
        return this.view;
        
    }
     public DashboardController getDashboardController(){
        return dashboard;
    }

    public void initController(){//this is called when this controller is created and this method contains all the functions required to display the view
        getView().getChooseFileBtn().addActionListener(e->openFileChooser());//adding action listner to buttons
        getView().getPhotoAddBtn().addActionListener(e->addPhoto());
         getView().getphotoLabel().addMouseListener(labelListner);
       getView().getphotoLabel().setName("changePhoto");//

}

    
    //other methods
    
     MouseListener labelListner =new MouseAdapter(){//methods checks and run if any mouse event has occured in the view eg:mouse clicked or mouse pressed
     @Override
     public void mouseClicked(MouseEvent e) { 
     if( ((JLabel)e.getSource()).getName().equalsIgnoreCase("changePhoto")){
            addPhoto();
       }
     
     
    
 }
   };
   
    
    
    
     public void createSpecialityComboBox(){//populates the speciality combo box dropdown with avaiable speciality refferences and the user will be able to select the speciality of the medical officer
        SpecialityRefference refference=new SpecialityRefference();//creating a new specialoty reffrence object and obtaining all the specilaity reffrences
        DefaultComboBoxModel newModel = new DefaultComboBoxModel(refference.getSpecialityTypes().toArray());
         getView().getspecialityComboBox().setModel( newModel );
    }
     
    public void openFileChooser(){//opens the file chooser panel to choose cv attachment for the user
        
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
    public void addPhoto(){//opens the file chooser panel to choose photo for the user
         int returnValue =getView().getFileChooser().showOpenDialog(getView());
            if(returnValue==JFileChooser.APPROVE_OPTION){
                getView().setPhotoAttachment(getView().getFileChooser().getSelectedFile());//sets the selected photo in the view
               
               getView().setphotoChoosen(true);//sets the boolean value true if a photo is choosen 
               
            }
            else{
                getView().setPhotoAttachment(null);
               
                 getView().setphotoChoosen(false);
            }
             checkPhoto();
        
    }
    public void checkPhoto(){//this function checks if a photo is already selected
        if(getView().getphotoChoosen()){ //if a photo attachment is choosen the icon is binded to the photo label in the view
           getView().getPhotoAddBtn().setVisible(false);
           setStaffPhoto( getView().getphotoLabel(),getView().getPhotoAttachment());
           
        }
    }
    public void setStaffPhoto(JLabel label,File imageFile){
       //this function helps to bind the image as a icon to the photo label

        BufferedImage img = null;
            try {
                img = ImageIO.read(imageFile);//Image I/O recognises the contents of the file as a JPEG format image, and decodes it into a BufferedImage which can be directly used by Java 2D.
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
        Image.SCALE_SMOOTH);// sets the photos image height and width to same a the size of label
        
        
            ImageIcon icon = new ImageIcon(dimg);
            icon.getImage().flush();
            label.setIcon(icon);//the photo attachment is set as a icon to the label
        
    }
    
    public void addMedicalOfficer(){//function to gett all the fields from view and create a new medical officer user
        String name=getView().getNameField().getText();
        String gender=getView().getGenderComboBox().getSelectedItem().toString();
        String mobile=getView().getPhoneNumberField().getText();
        String id=getView().getIdCardField().getText();
        String address=getView().getAddressField().getText();
        String userName=getView().getUserNameField().getText();
        String martialStatus=getView().getMartialStatusComboBox().getSelectedItem().toString();
        String dob=PipeService.getDateSimpleFormat(getView().getDobDateChooser().getDate());
        String speciality=getView().getspecialityComboBox().getSelectedItem().toString();
        String staffId=getView().getStaffIdField().getText();
        String staffEmail=getView().getStaffMailField().getText();
        String dateJoined= PipeService.getDateSimpleFormat(getView().getDateJoinDateChooser().getDate());
        File file=getView().getAttachment();
        File imageFile=getView().getPhotoAttachment();  
        MedicalOfficer medicalOfficer =new MedicalOfficer(userName,name,gender,mobile,id,dob,address,martialStatus,id,staffId,staffEmail,dateJoined,file,speciality,imageFile);
        FileService.addLine(FileService.getMoFilePath(), medicalOfficer.toString2());
        this.updateView();
    }
    public void deleteMedicalOfficer(){//deletes the selected medical officer record
           if(AlertService.optionalPlane("Would you like to Delete the Medical officer Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
             FileService.deleteRecord(FileService.getMoFilePath(),getModel().toString2());   
            }
       this.updateView(); 
        
    }
    public void editMedicalOfficer(){//function to edit the values of the medical officer 
        if(AlertService.optionalPlane("Would you like to Edit the Medical officer Record?", "Warning!")==JOptionPane.YES_NO_OPTION){//prompt for confirmation of edit record and checks if its a yes or no
        FileService.deleteRecord(FileService.getMoFilePath(),getModel().toString2());  //removes prevois record   
        addMedicalOfficer();    //adding the latest records
      }   
        updateView();
        
    }
    public void resetMedicalOfficerPassword(){//resets the password of the user to his id card number
        if(AlertService.optionalPlane("Would you like to Reset Password of the Medical officer Record?", "Warning!")==JOptionPane.YES_NO_OPTION){//prompt for confirmation of reset password of user record and checks if its a yes or no
        FileService.deleteRecord(FileService.getMoFilePath(),getModel().toString2());  //remove the previos record
        getModel().setStrPassword(getModel().getIdCardNo());
          FileService.addLine(FileService.getMoFilePath(), getModel().toString2());  //add new record with new password
      }   
        updateView();
        
    }
    
    
    
      @Override
    public void actionPerformed(ActionEvent e) {//this function listens to a action preformed in the view eg: adding new Medical Officer or editing it
        System.out.print(e.getActionCommand());
        if(e.getActionCommand().equalsIgnoreCase("add")){
            addMedicalOfficer();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Save")){
            editMedicalOfficer();
        }        
        }
    
     public void updateView(){// updates the medical officer table if a new record is added or edited or deleted
         getDashboardController().getAllMedicalOfficers();
        this.getView().dispose();//close the view
        
    }
    
    
    
    
}



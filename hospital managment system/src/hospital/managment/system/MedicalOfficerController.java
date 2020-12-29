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

    public void initController(){
        getView().getChooseFileBtn().addActionListener(e->openFileChooser());
        getView().getPhotoAddBtn().addActionListener(e->addPhoto());
         getView().getphotoLabel().addMouseListener(labelListner);
       getView().getphotoLabel().setName("changePhoto");

}

    
    //methods
    
     MouseListener labelListner =new MouseAdapter(){
     @Override
     public void mouseClicked(MouseEvent e) { 
     if( ((JLabel)e.getSource()).getName().equalsIgnoreCase("changePhoto")){
            addPhoto();
       }
     
     
    
 }
   };
   
    
    
    
     public void createSpecialityComboBox(){
        SpecialityRefference refference=new SpecialityRefference();
        DefaultComboBoxModel newModel = new DefaultComboBoxModel(refference.getSpecialityTypes().toArray());
         getView().getspecialityComboBox().setModel( newModel );
    }
     
    public void openFileChooser(){
        
        int returnValue =getView().getFileChooser().showOpenDialog(getView());
            if(returnValue==JFileChooser.APPROVE_OPTION){
                getView().setAttachment(getView().getFileChooser().getSelectedFile());
               // attachment = getFileChooser().getSelectedFile();
                getView().getAttachmentName().setText(getView().getAttachment().getName());
            }
            else{
                getView().setAttachment(null);
                 //attachment = null;
                 getView().getAttachmentName().setText("no file choosen");
                  
            }
        
    }
    public void addPhoto(){
         int returnValue =getView().getFileChooser().showOpenDialog(getView());
            if(returnValue==JFileChooser.APPROVE_OPTION){
                getView().setPhotoAttachment(getView().getFileChooser().getSelectedFile());
               // this. photoAttachment = getFileChooser().getSelectedFile();
               getView().setphotoChoosen(true);
               
            }
            else{
                getView().setPhotoAttachment(null);
               // this. photoAttachment = null;
                 getView().setphotoChoosen(false);
            }
             checkPhoto();
        
    }
    public void checkPhoto(){
        if(getView().getphotoChoosen()){ 
           getView().getPhotoAddBtn().setVisible(false);
           setStaffPhoto( getView().getphotoLabel(),getView().getPhotoAttachment());
           
        }
    }
    public void setStaffPhoto(JLabel label,File imageFile){
       

        BufferedImage img = null;
            try {
                img = ImageIO.read(imageFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
        Image.SCALE_SMOOTH);
        
        
            ImageIcon icon = new ImageIcon(dimg);
            icon.getImage().flush();
            label.setIcon(icon);
        
    }
    
    public void addMedicalOfficer(){
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
        this.closeView();
    }
    public void deleteMedicalOfficer(){
           if(AlertService.optionalPlane("Would you like to Delete the Medical officer Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
             FileService.deleteRecord(FileService.getMoFilePath(),getModel().toString2());   
            }
       this.closeView(); 
        
    }
    public void editMedicalOfficer(){
        if(AlertService.optionalPlane("Would you like to Edit the Medical officer Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getMoFilePath(),getModel().toString2());     
        addMedicalOfficer();    
      }   
        closeView();
        
    }
    public void resetMedicalOfficerPassword(){
        if(AlertService.optionalPlane("Would you like to Reset Password of the Medical officer Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getMoFilePath(),getModel().toString2());  
        getModel().setStrPassword(getModel().getIdCardNo());
          FileService.addLine(FileService.getMoFilePath(), getModel().toString2());  
      }   
        closeView();
        
    }
    
    
    
      @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print(e.getActionCommand());
        if(e.getActionCommand().equalsIgnoreCase("add")){
            addMedicalOfficer();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Save")){
            editMedicalOfficer();
        }        
        }
    
     public void closeView(){
         getDashboardController().getAllMedicalOfficers();
        this.getView().dispose();
        
    }
    
    
    
    
}



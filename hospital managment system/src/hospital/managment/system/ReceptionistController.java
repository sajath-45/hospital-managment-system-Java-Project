/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import hospital.managment.system.models.FileService;
import hospital.managment.system.models.PipeService;
import hospital.managment.system.models.Receptionist;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author sajath
 */
public class ReceptionistController implements ActionListener {
    private Receptionist model;
    private AddReceptionist view;
    private DashboardController dashboard;
    
    public ReceptionistController(Receptionist model,AddReceptionist view,DashboardController dashboard){
        setModel(model);
        setView(view);
        setDashboardController(dashboard);
        
    }
    public void setModel(Receptionist model){
        this.model=model;
    }
    public void setView(AddReceptionist view){
        this.view=view;
    }
    public void setDashboardController(DashboardController dash){
        this.dashboard=dash;
    }
    public Receptionist getModel(){
        return this.model;
    }
    public AddReceptionist getView(){
        return this.view;
        
    }
    public DashboardController getDashboardController(){
        return dashboard;
    }

    public void initController(){
        getView().getChooseFileBtn().addActionListener(e->openFileChooser());
        getView().getPhotoAddBtn().addActionListener(e->addPhoto());

}

    
    //methods
   
     
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
    
    public void addReceptionist(){
        String name=getView().getNameField().getText();
        String gender=getView().getGenderComboBox().getSelectedItem().toString();
        String mobile=getView().getPhoneNumberField().getText();
        String id=getView().getIdCardField().getText();
        String address=getView().getAddressField().getText();
        String userName=getView().getUserNameField().getText();
        String martialStatus=getView().getMartialStatusComboBox().getSelectedItem().toString();
        String dob=PipeService.getDateSimpleFormat(getView().getDobDateChooser().getDate());
        String staffId=getView().getStaffIdField().getText();
        String staffEmail=getView().getStaffMailField().getText();
        String dateJoined= PipeService.getDateSimpleFormat(getView().getDateJoinDateChooser().getDate());
        File file=getView().getAttachment();
        File imageFile=getView().getPhotoAttachment();  
        Receptionist receptionist =new Receptionist(userName,name,gender,mobile,id,dob,address,martialStatus,id,staffId,staffEmail,dateJoined,file,imageFile);
        FileService.addLine(FileService.getReceptionistFilePath(), receptionist.toString2());
    
        this.closeView(); 
    }
    public void deleteReceptionist(){
           if(AlertService.optionalPlane("Would you like to Delete the Receptionist Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
             FileService.deleteRecord(FileService.getReceptionistFilePath(),getModel().toString2());   
            }
       this.closeView(); 
        
    }
    public void editReceptionist(){
        if(AlertService.optionalPlane("Would you like to Edit the Receptionist Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getReceptionistFilePath(),getModel().toString2());     
        addReceptionist();    
      }   
        closeView();
        
    }
    public void resetReceptionistPassword(){
        if(AlertService.optionalPlane("Would you like to Reset Password of the Receptionist Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getReceptionistFilePath(),getModel().toString2());  
        getModel().setStrPassword(getModel().getIdCardNo());
          FileService.addLine(FileService.getReceptionistFilePath(), getModel().toString2());  
      }   
        closeView();
        
    }
    
      @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print(e.getActionCommand());
        if(e.getActionCommand().equalsIgnoreCase("add")){
            addReceptionist();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Save")){
            editReceptionist();
        }
        
          
         }

    
     public void closeView(){
         getDashboardController().getAllReceptionist();
        this.getView().dispose();
        
    }
     
    
    
    
    
}

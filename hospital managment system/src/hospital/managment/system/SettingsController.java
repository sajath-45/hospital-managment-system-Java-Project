/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import hospital.managment.system.models.CurrentUser;
import hospital.managment.system.models.FileService;
import hospital.managment.system.models.PipeService;
import hospital.managment.system.models.User;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sajath
 */
public class SettingsController {
    private User model;
   private Dashboard view;
   private DashboardController dashboard;
   private File photoAttachment;
    private JFileChooser openFileChooser;
    private boolean photoChoosen;
    
   public SettingsController(User user,Dashboard view){
       this.setModel(user);
       this.setView(view);
        
   }
   private void setModel(User model){
       this.model=model;
   }
   private void setView(Dashboard view){
       this.view=view;  
   }
    public void setDashboardController(DashboardController dash){
        this.dashboard=dash;
    }
      public void setPhotoAttachment(File file){
        this.photoAttachment=file;
    }
    private void setFileChooser(){
        openFileChooser =new JFileChooser();   
    }
      public void setphotoChoosen(boolean value){
        this.photoChoosen=value;
    }
    
    
   public User getModel(){
       return model;
   }
   public Dashboard getView(){
       return view;
   }
   public DashboardController getDashboardController(){
        return dashboard;
    }
   public File getPhotoAttachment(){
       return this.photoAttachment;
    }
    public JFileChooser getFileChooser(){
        return this.openFileChooser;
    }
    public boolean getphotoChoosen(){
        return this.photoChoosen;
    }
   
   public void initController(){
       addActionListners();
       setFileChooser();
      // loadUserDetails();
       
       
   }
   public void addActionListners(){
       
       getView().getPhotoAddBtn().addActionListener(e->addPhoto());
       getView().getSaveUserBtn().addActionListener(e->saveUser());
       
       
       getView().getReceptionistSettingBtnPanel().addMouseListener(listner);
        getView().getMoSettingBtnPanel().addMouseListener(listner);
        getView().getPatientSettingBtnPanel().addMouseListener(listner);
        getView().getReceptionistSettingBtnPanel().setName("settingBtn");
        getView().getMoSettingBtnPanel().setName("settingBtn");
        getView().getPatientSettingBtnPanel().setName("settingBtn");
       getView().getUserPhotoLabel().addMouseListener(labelListner);
       getView().getUserPhotoLabel().setName("changePhoto");

   }
   MouseListener listner =new MouseAdapter(){
     @Override
     public void mouseClicked(MouseEvent e) { 
      if( ((JPanel)e.getSource()).getName().equalsIgnoreCase("settingBtn")){
         loadUserDetails();
         
     }
     
    
 }
   };
   
    MouseListener labelListner =new MouseAdapter(){
     @Override
     public void mouseClicked(MouseEvent e) { 
     if( ((JLabel)e.getSource()).getName().equalsIgnoreCase("changePhoto")){
            addPhoto();
       }
     
     
    
 }
   };
   
   
   
   
   
    public void addPhoto(){
         int returnValue =getFileChooser().showOpenDialog(getView());
            if(returnValue==JFileChooser.APPROVE_OPTION){
                setPhotoAttachment(getFileChooser().getSelectedFile());
               // this. photoAttachment = getFileChooser().getSelectedFile();
              setphotoChoosen(true);
               
            }
            else{
                setPhotoAttachment(null);
               
                 setphotoChoosen(false);
            }
             checkPhoto();
        
    }
    public void checkPhoto(){
        if(getphotoChoosen()){ 
           getView().getPhotoAddBtn().setVisible(false);
           setStaffPhoto( getView().getUserPhotoLabel(),getPhotoAttachment());
           
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
     
     
     
     
    public void loadUserDetails(){
       
       getView().getUserNameField().setText(getModel().getUserName());
       getView().getPasswordField().setText(getModel().getPassword());
        getView().getPhoneNumberField().setText(getModel().getphoneNumber());
        getView().getNameField().setText(getModel().getName());
        getView().getNicField().setText(getModel().getIdCardNo());
        getView().getGenderComboBox().setSelectedItem(getModel().getGender());
        getView().getMartialStatusComboBoxField().setSelectedItem(getModel().getMaritalStatus());
        getView().getAddressField().setText(getModel().getAddress());
        Date dob=PipeService.getStringToDateFormat(getModel().getDateOfBirth());
        getView().getDobDateChooser().setDate(dob);
        setPhotoAttachment(getModel().getPhoto());
        System.out.println("phot of user"+getModel().getPhoto());
        
        if(getModel().getPhoto().isFile()){
            setphotoChoosen(true);
            checkPhoto();
            
           
        }
        else {
             
             setphotoChoosen(false);
            
         
        }
        
        
     }
 public  void saveUser(){
         String role=CurrentUser.getUserRole();
         String path=null;
          if(role.equalsIgnoreCase("Patient")){
              path=FileService.getPatientsFilePath();
             
         }
         else if(role.equalsIgnoreCase("MedicalOfficer")){
               path=FileService.getMoFilePath();
         }
         else if(role.equalsIgnoreCase("Receptionist")){
               path=FileService.getReceptionistFilePath();
         }
        
         FileService.deleteRecord(path, CurrentUser.getUser().toString2());
         
         
        getModel().setIdCardNo( getView().getNicField().getText());
        getModel().setGender( getView().getGenderComboBox().getSelectedItem().toString());
        getModel().setName( getView().getNameField().getText());
        getModel().setUserName( getView().getUserNameField().getText());
        getModel().setMaritalStatus( getView().getMartialStatusComboBoxField().getSelectedItem().toString());
        getModel().setAddress( getView().getAddressField().getText());
        getModel().setStrPassword( getView().getPasswordField().getText());
        getModel().setphoneNumber( getView().getPhoneNumberField().getText());
        getModel().setDateOfBirth(PipeService.getDateSimpleFormat( getView().getDobDateChooser().getDate()));
        getModel().setPhoto(getPhotoAttachment());
         
         FileService.addLine(path,  getModel().toString2());
     }
    
}

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    public void initController(){//this is called when this controller is created and this method contains all the functions required to display the view
        getView().getChooseFileBtn().addActionListener(e->openFileChooser());//adding function listner s to buttons available in the view
        getView().getPhotoAddBtn().addActionListener(e->addPhoto());
         getView().getphotoLabel().addMouseListener(labelListner);
       getView().getphotoLabel().setName("changePhoto");
}

    
    //methods
    
      MouseListener labelListner =new MouseAdapter(){//methods checks and run if any mouse event has occured in the view eg:mouse clicked or mouse pressed
     @Override
     public void mouseClicked(MouseEvent e) { 
     if( ((JLabel)e.getSource()).getName().equalsIgnoreCase("changePhoto")){
            addPhoto();
       }
     
     
    
 }
   };
   
     
    public void openFileChooser(){//opens the file chooser panel to choose cv attachment for the user
        
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
    public void addPhoto(){//opens the file chooser panel to choose photo for the user
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
    public void checkPhoto(){//this function checks if a photo is already selected
        if(getView().getphotoChoosen()){ 
           getView().getPhotoAddBtn().setVisible(false);
           setStaffPhoto( getView().getphotoLabel(),getView().getPhotoAttachment());
           
        }
    }
    public void setStaffPhoto(JLabel label,File imageFile){//this function helps to bind the image as a icon to the photo label
       

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
    
    public void addReceptionist(){//function to gett all the fields from view and create a new Rceptionist user
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
    
        this.updateView(); 
    }
    public void deleteReceptionist(){//function to delete  the Receptionist record
           if(AlertService.optionalPlane("Would you like to Delete the Receptionist Record?", "Warning!")==JOptionPane.YES_NO_OPTION){//prompt for confirmation of delete receptionist record and checks if its a yes or no
             FileService.deleteRecord(FileService.getReceptionistFilePath(),getModel().toString2());   
            }
       this.updateView(); 
        
    }
    public void editReceptionist(){//function to edit the values of the Receptionist
        if(AlertService.optionalPlane("Would you like to Edit the Receptionist Record?", "Warning!")==JOptionPane.YES_NO_OPTION){//prompt for confirmation of edit receptionist record and checks if its a yes or no
        FileService.deleteRecord(FileService.getReceptionistFilePath(),getModel().toString2());     
        addReceptionist();    //adding the latest records
      }   
        updateView();
        
    }
    public void resetReceptionistPassword(){//resets the password of the user to his id card number
        if(AlertService.optionalPlane("Would you like to Reset Password of the Receptionist Record?", "Warning!")==JOptionPane.YES_NO_OPTION){//prompt for confirmation of reset password of user record and checks if its a yes or no
        FileService.deleteRecord(FileService.getReceptionistFilePath(),getModel().toString2()); //remove the previos record 
        getModel().setStrPassword(getModel().getIdCardNo());
          FileService.addLine(FileService.getReceptionistFilePath(), getModel().toString2());  //add new record with new password
      }   
        updateView();
        
    }
    
      @Override
    public void actionPerformed(ActionEvent e) {//this function listens to a action preformed in the view eg: adding new Receptionist or editing it
        System.out.print(e.getActionCommand());
        if(e.getActionCommand().equalsIgnoreCase("add")){
            addReceptionist();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Save")){
            editReceptionist();
        }
        
          
         }

    
     public void updateView(){// updates the Receptionist table if a new record is added or edited or deleted
         getDashboardController().getAllReceptionist();
        this.getView().dispose();
        
    }
     
    
    
    
    
}

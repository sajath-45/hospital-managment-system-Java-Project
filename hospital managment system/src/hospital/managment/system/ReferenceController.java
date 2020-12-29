/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import hospital.managment.system.models.FileService;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sajath
 */
public  class ReferenceController  {
    private AddReference view;
    private String model;
    private DashboardController dashboard;
    public ReferenceController(AddReference view,String model,DashboardController dashboard){
        setView(view);
        setModel(model);
        setDashboardController(dashboard);
    }  
    
    public void setView(AddReference view){
        this.view=view;
    }
    public void setModel(String model){
        this.model=model;
    }
    public void setDashboardController(DashboardController dash){
        this.dashboard=dash;
    }
    public AddReference getView(){
       return this.view;
    }
    public String getModel(){
        return this.model;
    }
    public DashboardController getDashboardController(){
        return dashboard;
    }
    
    public void initController(){//this function contain the actions to inialize the action and mouse listners
        getView().setSelectionType(1);
        setSpecialityOption();
        getView().getJpanel5().setName("specialityOption");// adding mouse listner to panel to handle functions to each mouse click
        getView().getJpanel4().setName("complainOption");//adding mouselistners to buttons in the view and setting up names to group them up easily
        getView().getJpanel4().addMouseListener((MouseListener) listener);
        getView().getJpanel5().addMouseListener((MouseListener) listener);
        getView().getEnterReferenceBtn().addActionListener(e->addSpeciality());
        getView().getCancelBtn().addActionListener(e->getView().dispose());
    }
    
     MouseListener listener = new MouseAdapter() {//mouse click listner runs when each of the speciality pr complain reference segment is clicked in the view
                    @Override
                    public void mouseClicked(MouseEvent e) {
                       System.out.println( ((JPanel)e.getSource()).getName());
                      if( ((JPanel)e.getSource()).getName().equals("specialityOption")){
                           setSpecialityOption();
                       }
                       else if(((JPanel)e.getSource()).getName().equals("complainOption")){
                           setComplainOption();
                       }
             }
     
     };
        
 
    public void addSpeciality(){//adds speciality reference according to selection type 
        if(getView().getSelectionType()==1){//selection type 1 is for complain refference and selection type 2 is for speciality reference
             if(!FileService.isRecordExist(FileService.getSpecialityRefferenceFilePath(), getView().getReferenceTextField().getText().toLowerCase())){
            FileService.addLine(FileService.getSpecialityRefferenceFilePath(), getView().getReferenceTextField().getText());
            
             }
            else{//shows a alert plane if the reference already exist
                JOptionPane.showMessageDialog(null, "Refference Alread Exist!");

            }
        }
        else if(getView().getSelectionType()==2){
            if(!FileService.isRecordExist(FileService.getComplainRefferenceFilePath(), getView().getReferenceTextField().getText().toLowerCase())){
             FileService.addLine(FileService.getComplainRefferenceFilePath(), getView().getReferenceTextField().getText());
             
            }
            else{
                JOptionPane.showMessageDialog(null, "Refference Alread Exist!");//shows a alert plane if the reference already exist

            }
        }
         
        
    }
    public void editComplaintReference(String line){// function which gives a prompt with a text field to edit the speciality reference
        String action=JOptionPane.showInputDialog("Edit Complaint Reference",line);
         if( action != null){//while editing the reference checks if the new reference entered is not null or null if its null the reference will be not chnaged
        FileService.deleteRecord(FileService.getComplainRefferenceFilePath(),getModel() );//delete the old reference
        FileService.addLine(FileService.getComplainRefferenceFilePath(),action );//write the new complain reference
         }
        
    }
    public void editSpecialityReference(String line){// function which gives a prompt with a text field to edit the complain reference
        
        String action=JOptionPane.showInputDialog("Edit Speciality Reference",line);
         if( action != null){//while editing the reference checks if the new reference entered is not null or null if its null the reference will be not chnaged
         FileService.deleteRecord(FileService.getSpecialityRefferenceFilePath(),getModel() );//delete the old reference
         FileService.addLine(FileService.getSpecialityRefferenceFilePath(),action );//write the new speciality reference
         
         }
    }
    public void deleteComplaintReference(){//function to delete the selected complain reffrence f
    if(AlertService.optionalPlane("Would you like to Delete the Complaint Reference Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
        FileService.deleteRecord(FileService.getComplainRefferenceFilePath(),getModel() );}
    }
    public void deleteSpecialityReference(){//function to delete the selected speciality reffrence f
        if(AlertService.optionalPlane("Would you like to Delete the Speciality Reference Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
         FileService.deleteRecord(FileService.getSpecialityRefferenceFilePath(),getModel() );
        }
    }
    
    
    public void setSpecialityOption(){//function sets up the view with the specilaity reference list
        resetHoverColor(getView().getJpanel4(),getView().getJlabel4());//change the color of the top panel according to selected option
        setHoverColor(getView().getJpanel5(),getView().getJlabel5());      
        getView().setSelectionType(1);
        getView().getReferenceLabel().setText("Enter New Speciality Refference");//set the name of the top panel label to speciality IN THE VIEW
                   
        
    }
    public void setComplainOption(){//function sets up the view with the complain reference list
        resetHoverColor(getView().getJpanel5(),getView().getJlabel5());
        setHoverColor(getView().getJpanel4(),getView().getJlabel4());
        getView().setSelectionType(2);
        getView().getReferenceLabel().setText("Enter New Complain Refference");//set the name of the top panel label to complain IN THE VIEW
       
        
    }
     public void setHoverColor(JPanel panel,JLabel label){//function to change colors of panel when clicked
                panel.setBackground(new Color(85,65,118));
                label.setForeground(Color.white);

    }
    
    public void resetHoverColor(JPanel panel,JLabel label){//function to change colors of panel when clicked
                panel.setBackground(new Color(255,255,255));
                label.setForeground(new Color(102,0,102));

    }

   

    

  
    
}

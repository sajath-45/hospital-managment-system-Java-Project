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
    public ReferenceController(AddReference view){
        setView(view);
    }  
    public AddReference getView(){
        return this.view;
    }
    public void setView(AddReference view){
        this.view=view;
    }
    
    public void initController(){
        getView().setSelectionType(1);
        setSpecialityOption();
        getView().getJpanel5().setName("specialityOption");
        getView().getJpanel4().setName("complainOption");
        getView().getJpanel4().addMouseListener((MouseListener) listener);
        getView().getJpanel5().addMouseListener((MouseListener) listener);
        getView().getEnterReferenceBtn().addActionListener(e->addSpeciality());
        getView().getCancelBtn().addActionListener(e->getView().dispose());
    }
    
     MouseListener listener = new MouseAdapter() {
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
     
    
   
    
    
    
    
    
 
    public void addSpeciality(){
        if(getView().getSelectionType()==1){
             if(!FileService.isRecordExist(FileService.getSpecialityRefferenceFilePath(), getView().getReferenceTextField().getText().toLowerCase())){
            FileService.addLine(FileService.getSpecialityRefferenceFilePath(), getView().getReferenceTextField().getText());
            
             }
            else{
                JOptionPane.showMessageDialog(null, "Refference Alread Exist!");

            }
        }
        else if(getView().getSelectionType()==2){
            if(!FileService.isRecordExist(FileService.getComplainRefferenceFilePath(), getView().getReferenceTextField().getText().toLowerCase())){
             FileService.addLine(FileService.getComplainRefferenceFilePath(), getView().getReferenceTextField().getText());
             
            }
            else{
                JOptionPane.showMessageDialog(null, "Refference Alread Exist!");

            }
        }
        
        
        
        
        
        
        
    }
    
    
    public void setSpecialityOption(){
        resetHoverColor(getView().getJpanel4(),getView().getJlabel4());
        setHoverColor(getView().getJpanel5(),getView().getJlabel5());      
        getView().setSelectionType(1);
        getView().getReferenceLabel().setText("Enter New Speciality Refference");
                   
        
    }
    public void setComplainOption(){
        resetHoverColor(getView().getJpanel5(),getView().getJlabel5());
        setHoverColor(getView().getJpanel4(),getView().getJlabel4());
        getView().setSelectionType(2);
        getView().getReferenceLabel().setText("Enter New Complain Refference");
       
        
    }
     public void setHoverColor(JPanel panel,JLabel label){
                panel.setBackground(new Color(85,65,118));
                label.setForeground(Color.white);

    }
    
    public void resetHoverColor(JPanel panel,JLabel label){
                panel.setBackground(new Color(255,255,255));
                label.setForeground(new Color(102,0,102));

    }

   

    

  
    
}

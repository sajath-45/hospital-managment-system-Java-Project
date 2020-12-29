/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;
   
import hospital.managment.system.models.Complaint;
import hospital.managment.system.models.DispatchedPostal;
import hospital.managment.system.models.FileService;
import hospital.managment.system.models.MedicalOfficer;
import hospital.managment.system.models.Patient;
import hospital.managment.system.models.Appointment;
import hospital.managment.system.models.ComplainRefference;
import hospital.managment.system.models.CurrentUser;
import hospital.managment.system.models.PipeService;
import hospital.managment.system.models.Receptionist;
import hospital.managment.system.models.SpecialityRefference;
import hospital.managment.system.models.User;
import hospital.managment.system.models.UserLogin;
import hospital.managment.system.models.Visitor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author sajath
 */
public class DashboardController {
     private Dashboard view;
    private DefaultTableModel model;
    
public  DashboardController(DefaultTableModel model,Dashboard view){
    setModel(model);
    setView(view);
}
    
public void setModel(DefaultTableModel model){
    this.model=model;
}
public void setView( Dashboard view){
    this.view=view;

}
public Dashboard getView(){
    return view;
}
public DefaultTableModel getModel(){
    return model;
}
public void initController(String role){//this function adds action listeners to buttons and panel avvailabe in the dashboard view 
    setSidePanel(role);
    setTables();
    setSideBarPanels();
    setHome();
    
    //user
    getView().getAddUsersBtn().addActionListener(e->addUser());
    getView().getAddUsersBtn2().addActionListener(e->addUser());
    getView().getEditUsersBtn().addActionListener(e->editUser());
    getView().getEditUsersBtn2().addActionListener(e->editUser());
    getView().getDeleteUsersBtn().addActionListener(e->deleteUser());
    getView().getDeleteUsersBtn2().addActionListener(e->deleteUser());
    getView().getResetPasswordBtn().addActionListener(e->resetPassword());
    getView().getResetPasswordBtn2().addActionListener(e->resetPassword());
    //appoinments
    getView().getAddAppointmentBtn().addActionListener(e -> addNewAppointment());
    getView().getAddAppointmentBtn2().addActionListener(e -> addNewAppointment());
    getView().getEditAppointmentBtn().addActionListener(e -> editAppointment());
    getView().getDeleteAppointmentBtn().addActionListener(e -> deleteAppointment());
    getView().getApproveAppoinmentBtn().addActionListener(e -> approveAppointment("Approved"));
    getView().getCompleteAppointmentBtn().addActionListener(e -> approveAppointment("Completed"));
      getView().getGeneratePdfBtn().addActionListener(e -> generateApprovedAppointmentPdf());
    //compalint
     getView().getAddComplaintBtn().addActionListener(e -> addNewComplaint());
    getView().getAddComplaintBtn2().addActionListener(e -> addNewComplaint());
    getView().getEditComplaintBtn().addActionListener(e -> editComplaint());
    getView().getDeleteComplaintBtn().addActionListener(e -> deleteComplaint());
    getView().getApproveComplaintBtn().addActionListener(e -> editActionTaken());
    //mails
     getView().getAddMailBtn().addActionListener(e -> addDispatchedPostal());
    getView().getEditMailBtn().addActionListener(e -> editMail());
    getView().getDeleteMailBtn().addActionListener(e -> deleteMail());
    getView().getDeleteMailBtn2().addActionListener(e -> deleteMail());
    //visitors
    getView().getAddVisitorBtn().addActionListener(e -> addNewVisitorRecord());
    getView().getEditVisitorBtn().addActionListener(e -> editVisitorRecord());
    getView().getDeleteVisitorBtn().addActionListener(e -> deleteVisitorRecord());
    getView().getDeleteVisitorBtn2().addActionListener(e -> deleteVisitorRecord());
    //refference btns
    getView().getAddReferenceBtn().addActionListener(e->addNewReference());
    getView().getEditReferenceBtn().addActionListener(e->editReference());
    getView().getdeleteReferenceBtn().addActionListener(e->deleteReference());
    //report btns
    getView().getAppointmentReportPrepareBtn().addActionListener(e->setAppointmentReportTable());
    getView().getUserLogPrepareBtn().addActionListener(e->setUserLoginReportTable());
    getView().getGenerateAppointmentReportPdfBtn().addActionListener(e->generateAppointmentsPdf());
    getView().getGeneratePatientCredintialPdfBtn().addActionListener(e->generatePatientCredintialReportPdf());
    getView().getGenerateUserLogReportPdfBtn().addActionListener(e->generateUserLoginReportPdf());
    getView().getGenerateAppointmentReportCsvBtn().addActionListener(e->generateAppointmentsReportCsv());
    getView().getGeneratePatientCredintialCsvBtn().addActionListener(e->generatePatientCredintialReportCsv());
    getView().getGenerateUserLogReportCsvBtn().addActionListener(e->generateUserLoginReportCsv());
    //settings btne
   // getView().getSaveUserBtn().addActionListener(e->saveUser());
    
    
}
 
 public void initTables(){
        if(getView().getUserRole().equals("Admin")){
            getAllAppointment();
            getAllComplaints();
            getDispatchedMails();
            getVisitorRecords();
            getAllUsers();
            getComplainRefference();
            getSpecialityRefference();
        }
        else if(getView().getUserRole().equals("Receptionist")){
        getAllAppointment();
        getAllComplaints();
        getDispatchedMails();
        getVisitorRecords();
        getAllPatients();
        
    }
        else if(getView().getUserRole().equals("Patient")){
            getPatientAppointmentTable("199829003939");
            getAllComplaints();
            
    }
        else if(getView().getUserRole().equals("MedicalOfficer")){
        getMOAppointmentTable("dr001");
    }
        
    }
 //other methods
public void setSidePanel(String role){
        if(getView().getUserRole().equals("Admin")){
            getView().getReceptionSidePanel().setVisible(false);
            getView().getAdminSidePanel().setVisible(true);
            getView().getPatientSidePanel().setVisible(false);
            getView().getMoSidePanel().setVisible(false);
            
        }
        else if(getView().getUserRole().equals("Receptionist")){
            getView().getReceptionSidePanel().setVisible(true);
            getView().getAdminSidePanel().setVisible(false);
            getView().getPatientSidePanel().setVisible(false);
            getView().getMoSidePanel().setVisible(false);
            

        }
        else if(getView().getUserRole().equals("Patient")){
            getView().getPatientSidePanel().setVisible(true);
            getView().getMoSidePanel().setVisible(false);
            getView().getReceptionSidePanel().setVisible(false);
            getView().getAdminSidePanel().setVisible(false);

        }
        else if(getView().getUserRole().equals("MedicalOfficer")){
            getView().getPatientSidePanel().setVisible(false);
            getView().getMoSidePanel().setVisible(true);
            getView().getReceptionSidePanel().setVisible(false);
            getView().getAdminSidePanel().setVisible(false);
            
           

        }
        
    }
public void  setHome(){//
         resetAllMainPanels();
        getView().getHomePanel().setVisible(true);
        getView().getComplaintsMainOptionPanel().setVisible(false);
        getView().getAppoinmentsMainOptionsPanel().setVisible(false);
        getView().getVisitorsMainOptionPanel().setVisible(false);
        getView().getMailsMainOptionsPanel().setVisible(false);
        getView().getUsersMainOptionsPanel().setVisible(false);
        getView().getRefferenceOptionsMainPanel().setVisible(false);
       
    }
public void setSideBarPanels(){//add mouse listener to the panels in all side bar panels and grouping them by setting names
        getView().getHomeBtnPanel1().addMouseListener(sideBarPanelListener);
        getView().getHomeBtnPanel2().addMouseListener(sideBarPanelListener);
        getView().getHomeBtnPanel3().addMouseListener(sideBarPanelListener);
        getView().getHomeBtnPanel4().addMouseListener(sideBarPanelListener);
        getView().getAppointmentBtnPanel4().addMouseListener(sideBarPanelListener);
        getView().getMoSettingBtnPanel().addMouseListener(sideBarPanelListener);
        getView().getAppointmentBtnPanel3().addMouseListener(sideBarPanelListener);
        getView().getComplaintBtnPanel2().addMouseListener(sideBarPanelListener);
        getView().getPatientSettingBtnPanel().addMouseListener(sideBarPanelListener);
        getView().getAppointmentBtnPanel2().addMouseListener(sideBarPanelListener);
        getView().getMailBtnPanel2().addMouseListener(sideBarPanelListener);
        getView().getComplaintBtnPanel1().addMouseListener(sideBarPanelListener);
        getView().getVisitorBtnPanel2().addMouseListener(sideBarPanelListener);
        getView().getReceptionistSettingBtnPanel().addMouseListener(sideBarPanelListener);
        getView().getUserBtnPanel2().addMouseListener(sideBarPanelListener);
        getView().getUserBtnPanel().addMouseListener(sideBarPanelListener);
        getView().getReportBtnPanel().addMouseListener(sideBarPanelListener);
        getView().getAppointmentBtnPanel1().addMouseListener(sideBarPanelListener);
        getView().getMailBtnPanel1().addMouseListener(sideBarPanelListener);
        getView().getComplaintBtnPanel3().addMouseListener(sideBarPanelListener);
        getView().getVisitorBtnPanel1().addMouseListener(sideBarPanelListener);
        getView().getRefferenceBtnPanel().addMouseListener(sideBarPanelListener);
        getView().getLogOutBtnPanel1().addMouseListener(sideBarPanelListener);
        getView().getLogOutBtnPanel2().addMouseListener(sideBarPanelListener);
        getView().getLogOutBtnPanel3().addMouseListener(sideBarPanelListener);
        getView().getLogOutBtnPanel4().addMouseListener(sideBarPanelListener);
        getView().getappointmentReportOptionPanel().addMouseListener(reportsOptionsListener);
        getView(). getUserLogReportOptionPanel().addMouseListener(reportsOptionsListener);
        getView().getPatientCredentialReportOptionPanel().addMouseListener(reportsOptionsListener);
        getView().getComplainReferenceOptionPanel().addMouseListener(referenceOptionsListener);
        getView().getSpecialityReferenceOptionPanel().addMouseListener(referenceOptionsListener);
         getView().getJPanel7().addMouseListener(userOptionsListener);
         getView().getJPanel9().addMouseListener(userOptionsListener);
        getView().getJPanel35().addMouseListener(userOptionsListener);

        
        getView().getHomeBtnPanel1().setName("homeBtn");
        getView().getHomeBtnPanel2().setName("homeBtn");
        getView().getHomeBtnPanel3().setName("homeBtn");
        getView().getHomeBtnPanel4().setName("homeBtn");
        
        getView().getAppointmentBtnPanel2().setName("appointmentBtnPanel");//recep
        getView().getAppointmentBtnPanel1().setName("appointmentBtnPanel");//admin
        getView().getAppointmentBtnPanel4().setName("appointmentBtnPanel");
        getView().getAppointmentBtnPanel3().setName("appointmentBtnPanel");
        
        getView().getMailBtnPanel2().setName("mailBtn");
        getView().getMailBtnPanel1().setName("mailBtn");
       
        
        getView().getComplaintBtnPanel1().setName("complaintBtn");
        getView().getComplaintBtnPanel2().setName("complaintBtn");
        getView().getComplaintBtnPanel3().setName("complaintBtn");
        
        getView().getVisitorBtnPanel2().setName("visitorBtn");
        getView().getVisitorBtnPanel1().setName("visitorBtn");
        
        getView().getReceptionistSettingBtnPanel().setName("settingBtn");
        getView().getMoSettingBtnPanel().setName("settingBtn");
        getView().getPatientSettingBtnPanel().setName("settingBtn");
        getView().getUserBtnPanel().setName("userBtn");
        getView().getUserBtnPanel2().setName("userBtn");
        getView().getReportBtnPanel().setName("reportBtn");
        getView().getRefferenceBtnPanel().setName("refferenceBtn");
        getView().getLogOutBtnPanel2().setName("logOut");
        getView().getLogOutBtnPanel1().setName("logOut");
        getView().getLogOutBtnPanel3().setName("logOut");
        getView().getLogOutBtnPanel4().setName("logOut");
        
        getView().getappointmentReportOptionPanel().setName("appointmentReport");
        getView(). getUserLogReportOptionPanel().setName("userLogReport");
        getView().getPatientCredentialReportOptionPanel().setName("patientCredentialReport");
        
        getView().getComplainReferenceOptionPanel().setName("ComplainReferenceOption");
        getView().getSpecialityReferenceOptionPanel().setName("SpecialityReferenceOption");
        
        getView().getJPanel9().setName("moOption");
         getView().getJPanel7().setName("receptionistOption");
        getView().getJPanel35().setName("patientOption");
        
        
                  
        
    }
MouseListener sideBarPanelListener = new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        resetAllColor();
                        //
                     
                        System.out.println(((JPanel)e.getSource()).getName());
                     if( ((JPanel)e.getSource()).getName().equalsIgnoreCase("complaintBtn")){
                        setColor(getView().getComplaintBtnPanel1());
                        setColor(getView().getComplaintBtnPanel2());
                        setColor(getView().getComplaintBtnPanel3());
                        setTables();
                        getView().getHomePanel().setVisible(false);
                        getView().getAppointmentPanel().setVisible(false);
                        getView().getRefferencePanel().setVisible(false);                        
                        getView().getMailPanel().setVisible(false);
                        getView().getReportsPanel().setVisible(false);
                        getView().getVisitorsPanel().setVisible(false);
                        getView().getSettingsPanel().setVisible(false);
                        getView().getUsersPanel().setVisible(false);
                        getView().getComplaintPanel().setVisible(true);
                        getView().getComplaintsMainOptionPanel().setVisible(true);
                        getView().getAppoinmentsMainOptionsPanel().setVisible(false);
                        getView().getVisitorsMainOptionPanel().setVisible(false);
                        getView().getMailsMainOptionsPanel().setVisible(false);
                        getView().getUsersMainOptionsPanel().setVisible(false);
                        getView().getRefferenceOptionsMainPanel().setVisible(false);
                        setComplainOptions();

                         
                     }
                     else if(((JPanel)e.getSource()).getName().equalsIgnoreCase("appointmentBtnPanel")){
                        setColor(getView().getAppointmentBtnPanel1());
                        setColor(getView().getAppointmentBtnPanel2());
                        setColor(getView().getAppointmentBtnPanel3());
                        setColor(getView().getAppointmentBtnPanel4());
                        setTables();
                        getView().getHomePanel().setVisible(false); 
                        getView().getComplaintPanel().setVisible(false);
                        getView().getRefferencePanel().setVisible(false);                        
                        getView().getMailPanel().setVisible(false);
                        getView().getReportsPanel().setVisible(false);
                        getView().getVisitorsPanel().setVisible(false);
                        getView().getSettingsPanel().setVisible(false);
                        getView().getUsersPanel().setVisible(false);
                        getView().getAppointmentPanel().setVisible(true);
    
                         getView().getComplaintsMainOptionPanel().setVisible(false);
                        getView().getAppoinmentsMainOptionsPanel().setVisible(true);
                        getView().getVisitorsMainOptionPanel().setVisible(false);
                        getView().getMailsMainOptionsPanel().setVisible(false);
                        getView().getUsersMainOptionsPanel().setVisible(false);
                        getView().getRefferenceOptionsMainPanel().setVisible(false);
                               

                        setAppointmentOptions();

                         
                     }
                     else if(((JPanel)e.getSource()).getName().equalsIgnoreCase("mailBtn")){
                        setColor(getView().getMailBtnPanel1());
                        setColor(getView().getMailBtnPanel2());
                        setTables();
                        getView().getHomePanel().setVisible(false);
                        getView().getAppointmentPanel().setVisible(false);
                        getView().getComplaintPanel().setVisible(false);
                        getView().getRefferencePanel().setVisible(false);                        
                        getView().getReportsPanel().setVisible(false);
                        getView().getVisitorsPanel().setVisible(false);
                        getView().getSettingsPanel().setVisible(false);
                        getView().getUsersPanel().setVisible(false);
                        getView().getMailPanel().setVisible(true);
                        getView().getComplaintsMainOptionPanel().setVisible(false);
                        getView().getVisitorsMainOptionPanel().setVisible(false);
                        getView().getAppoinmentsMainOptionsPanel().setVisible(false);
                        getView().getMailsMainOptionsPanel().setVisible(true);
                        getView().getUsersMainOptionsPanel().setVisible(false);
                        getView().getRefferenceOptionsMainPanel().setVisible(false);
                        setMailOptions();

                         
                         
                     }
                     else if(((JPanel)e.getSource()).getName().equalsIgnoreCase("userBtn")){
                        setColor(getView().getUserBtnPanel());
                        setColor(getView().getUserBtnPanel2());
                        setTables();
                        getView().getHomePanel().setVisible(false);
                        getView().getAppointmentPanel().setVisible(false);
                        getView().getComplaintPanel().setVisible(false);
                        getView().getRefferencePanel().setVisible(false);                        
                        getView().getMailPanel().setVisible(false);
                        getView().getReportsPanel().setVisible(false);
                        getView().getVisitorsPanel().setVisible(false);
                        getView().getSettingsPanel().setVisible(false);
                        getView().getUsersPanel().setVisible(true);
                        getView().getComplaintsMainOptionPanel().setVisible(false);
                        getView().getVisitorsMainOptionPanel().setVisible(false);
                        getView().getAppoinmentsMainOptionsPanel().setVisible(false);
                        getView().getMailsMainOptionsPanel().setVisible(false);
                        getView().getUsersMainOptionsPanel().setVisible(true);
                        getView().getRefferenceOptionsMainPanel().setVisible(false);
                        setUserOptions();
                         
                         
                     }
                     else if(((JPanel)e.getSource()).getName().equals("settingBtn")){
                        setColor(getView().getReceptionistSettingBtnPanel());
                        setColor(getView().getMoSettingBtnPanel());
                       // loadUserDetails();
                        setColor(getView().getPatientSettingBtnPanel());
                        getView().getHomePanel().setVisible(false);
                        getView().getUsersPanel().setVisible(false);
                        getView().getAppointmentPanel().setVisible(false);
                        getView().getComplaintPanel().setVisible(false);
                        getView().getRefferencePanel().setVisible(false);                        
                        getView().getMailPanel().setVisible(false);
                        getView().getReportsPanel().setVisible(false);
                        getView().getVisitorsPanel().setVisible(false);
                        getView().getSettingsPanel().setVisible(true);
                        getView().getComplaintsMainOptionPanel().setVisible(false);
                        getView().getVisitorsMainOptionPanel().setVisible(false);
                        getView().getAppoinmentsMainOptionsPanel().setVisible(false);
                        getView().getMailsMainOptionsPanel().setVisible(false);
                        getView().getUsersMainOptionsPanel().setVisible(false);
                        getView().getRefferenceOptionsMainPanel().setVisible(false);
                          
                     }
                     else if(((JPanel)e.getSource()).getName().equalsIgnoreCase("visitorBtn")){
                        setTables();
                        setColor(getView().getVisitorBtnPanel1());
                        setColor(getView().getVisitorBtnPanel2());        
                        getView().getHomePanel().setVisible(false);
                        getView().getUsersPanel().setVisible(false);
                        getView().getAppointmentPanel().setVisible(false);
                        getView().getComplaintPanel().setVisible(false);
                        getView().getRefferencePanel().setVisible(false);
                        getView().getSettingsPanel().setVisible(false);
                        getView().getMailPanel().setVisible(false);
                        getView().getReportsPanel().setVisible(false);
                        getView().getVisitorsPanel().setVisible(true);
                        getView().getComplaintsMainOptionPanel().setVisible(false);
                        getView().getVisitorsMainOptionPanel().setVisible(true);
                        getView().getAppoinmentsMainOptionsPanel().setVisible(false);
                        getView().getMailsMainOptionsPanel().setVisible(false);
                        getView().getUsersMainOptionsPanel().setVisible(false);
                        getView().getRefferenceOptionsMainPanel().setVisible(false);
                        setVisitorOptions();
                     }
                      else if(((JPanel)e.getSource()).getName().equalsIgnoreCase("refferenceBtn")){
                        setColor(getView().getRefferenceBtnPanel());    
                        setTables();
                        setComplainRefference();
                        getView().getHomePanel().setVisible(false);
                        getView().getVisitorsPanel().setVisible(false);
                        getView().getUsersPanel().setVisible(false);
                        getView().getAppointmentPanel().setVisible(false);
                        getView().getComplaintPanel().setVisible(false);
                        getView().getSettingsPanel().setVisible(false);
                        getView().getMailPanel().setVisible(false);
                        getView().getReportsPanel().setVisible(false);
                        getView().getRefferencePanel().setVisible(true);
                        getView().getComplaintsMainOptionPanel().setVisible(false);
                        getView().getVisitorsMainOptionPanel().setVisible(false);
                        getView().getMailPanel().setVisible(false);
                        getView().getAppoinmentsMainOptionsPanel().setVisible(false);
                        getView().getUsersMainOptionsPanel().setVisible(false);
                        getView().getRefferenceOptionsMainPanel().setVisible(true);
                        setRefferenceOption();
                     }
                      else if(((JPanel)e.getSource()).getName().equalsIgnoreCase("reportBtn")){
                       setAppoinmentReports();
                        setTables();
                        setColor(getView().getReportBtnPanel());
                        getView().getHomePanel().setVisible(false);
                        getView().getVisitorsPanel().setVisible(false);
                        getView().getUsersPanel().setVisible(false);
                        getView().getAppointmentPanel().setVisible(false);
                        getView().getComplaintPanel().setVisible(false);
                        getView().getRefferencePanel().setVisible(false);
                        getView().getSettingsPanel().setVisible(false);
                        getView().getMailPanel().setVisible(false);
                        getView().getReportsPanel().setVisible(true); 
                        getView().getMailPanel().setVisible(false);
                        getView().getComplaintsMainOptionPanel().setVisible(false);
                        getView().getVisitorsMainOptionPanel().setVisible(false);
                        getView().getAppoinmentsMainOptionsPanel().setVisible(false);
                        getView().getUsersMainOptionsPanel().setVisible(false);
                        getView().getRefferenceOptionsMainPanel().setVisible(false);
                        setMoComboBox();
                        setReportOptions();
                     }
                     else if(((JPanel)e.getSource()).getName().equalsIgnoreCase("homeBtn")){
                        setColor(getView().getHomeBtnPanel1());
                        setColor(getView().getHomeBtnPanel2());
                        setColor(getView().getHomeBtnPanel3());
                        setColor(getView().getHomeBtnPanel4());
                        setTables();       
                          
                        getView().getVisitorsPanel().setVisible(false);
                        getView().getUsersPanel().setVisible(false);
                        getView().getAppointmentPanel().setVisible(false);
                        getView().getComplaintPanel().setVisible(false);
                        getView().getRefferencePanel().setVisible(false);
                        getView().getSettingsPanel().setVisible(false);
                        getView().getMailPanel().setVisible(false);
                        getView().getReportsPanel().setVisible(false);
                        getView().getHomePanel().setVisible(true);
                        getView().getComplaintsMainOptionPanel().setVisible(false);
                        getView().getVisitorsMainOptionPanel().setVisible(false);
                        getView().getAppoinmentsMainOptionsPanel().setVisible(false);
                        getView().getMailsMainOptionsPanel().setVisible(false);
                        getView().getUsersMainOptionsPanel().setVisible(false);
                        getView().getRefferenceOptionsMainPanel().setVisible(false);
                         
                     }
                     
                     else if(((JPanel)e.getSource()).getName().equalsIgnoreCase("logOut")){
                         userLogOut();
                     }
                     
                     
                    }
                };
 MouseListener reportsOptionsListener =new MouseAdapter(){
     public void mouseClicked(MouseEvent e) { 
     if( ((JPanel)e.getSource()).getName().equalsIgnoreCase("appointmentReport")){
         setAppoinmentReports();
       }
     else if(((JPanel)e.getSource()).getName().equalsIgnoreCase("userLogReport")){
         setUserLogReports();
     }
     else if(((JPanel)e.getSource()).getName().equalsIgnoreCase("patientCredentialReport")){
         setPatientCredintialReports();
     }
 }
     
 };
 MouseListener referenceOptionsListener =new MouseAdapter(){
     public void mouseClicked(MouseEvent e) { 
     if( ((JPanel)e.getSource()).getName().equalsIgnoreCase("ComplainReferenceOption")){
         setComplainRefference();
       }
     else if(((JPanel)e.getSource()).getName().equalsIgnoreCase("SpecialityReferenceOption")){
         setSpecialityRefference();
     }
    
 }
     
 };
  MouseListener userOptionsListener =new MouseAdapter(){
     public void mouseClicked(MouseEvent e) { 
     if( ((JPanel)e.getSource()).getName().equalsIgnoreCase("moOption")){
         setOptionMo();
       }
     else if(((JPanel)e.getSource()).getName().equalsIgnoreCase("receptionistOption")){
         setOptionReceptionist();
     }
     else if(((JPanel)e.getSource()).getName().equalsIgnoreCase("patientOption")){
         setOptionPatient();
     }
      
    
 }
     
 };
 
 
 
 
    public  void setTables(){//binds data to the tables according to the type of user logged in
        if(getView().getUserRole().equals("Admin")){
            getAllAppointment();
            getAllComplaints();
            getDispatchedMails();
            getVisitorRecords();
            getAllUsers();
           getComplainRefference();
            getSpecialityRefference();
        }
        else if(getView().getUserRole().equals("Receptionist")){
        getAllAppointment();
        getAllComplaints();
        getDispatchedMails();
        getVisitorRecords();
        getAllPatients();
        
    }
        else if(getView().getUserRole().equals("Patient")){
            getPatientAppointmentTable(CurrentUser.getUser().getIdCardNo());
            getAllComplaints();
            
    }
        else if(getView().getUserRole().equals("MedicalOfficer")){
        getMOAppointmentTable(CurrentUser.getUser().getIdCardNo());
    }
        
    }
    
    public void setAppointmentOptions(){
          if(getView().getUserRole().equals("Admin")){
              getView().getAdminAppointmentOptions().setVisible(true);
              getView().getPatientAppointmentOptions().setVisible(false);
              getView().getReceptionistAppointmentOptions().setVisible(false);
              getView().getMoAppointmentOptions().setVisible(false);
            
        }
        else if(getView().getUserRole().equals("Receptionist")){
            getView().getReceptionistAppointmentOptions().setVisible(true);
            getView().getAdminAppointmentOptions().setVisible(false);
            getView().getPatientAppointmentOptions().setVisible(false);
            getView().getMoAppointmentOptions().setVisible(false);
            

        }
        else if(getView().getUserRole().equals("Patient")){
            getView().getAdminAppointmentOptions().setVisible(false);
            getView().getPatientAppointmentOptions().setVisible(true);
            getView().getReceptionistAppointmentOptions().setVisible(false);
            getView().getMoAppointmentOptions().setVisible(false);

        }
        else if(getView().getUserRole().equals("MedicalOfficer")){
            getView().getMoAppointmentOptions().setVisible(true);
            getView().getAdminAppointmentOptions().setVisible(false);
            getView().getPatientAppointmentOptions().setVisible(false);
            getView().getReceptionistAppointmentOptions().setVisible(false);  

        }
        
    }
    private void setMailOptions(){
          if(getView().getUserRole().equals("Admin")){
              getView().getAdminMailOptions().setVisible(true);
              getView().getReceptionMailOptions().setVisible(false);
          
            
        }
        else if(getView().getUserRole().equals("Receptionist")){
            getView().getReceptionMailOptions().setVisible(true);
            getView().getAdminMailOptions().setVisible(false);
            
            

        }
        else if(getView().getUserRole().equals("Patient")){
            getView().getAdminMailOptions().setVisible(false);

        }
        else if(getView().getUserRole().equals("MedicalOfficer")){
            getView().getAdminMailOptions().setVisible(false);
            
           

        }
        
    }
    private void setComplainOptions(){
          if(getView().getUserRole().equals("Admin")){
            getView().getPatientComplaintOptions().setVisible(false);
            getView().getAdminComplaintOptions().setVisible(true);
            getView().getReceptionistComplaintOptions().setVisible(false);
            
        }
        else if(getView().getUserRole().equals("Receptionist")){
        getView().getPatientComplaintOptions().setVisible(false);
        getView().getAdminComplaintOptions().setVisible(false);
        getView().getReceptionistComplaintOptions().setVisible(true);
            

        }
        else if(getView().getUserRole().equals("Patient")){
            getView().getPatientComplaintOptions().setVisible(true);
            getView().getAdminComplaintOptions().setVisible(false);
            getView().getReceptionistComplaintOptions().setVisible(false);

        }
        else if(getView().getUserRole().equals("MedicalOfficer")){
           
            
           

        }
        
    }
    private void setUserOptions(){
           if(getView().getUserRole().equals("Admin")){
            getView().getAdminUserOptions().setVisible(true);
            getView().getReceptionistUserOptions().setVisible(false);
            getView().getJPanel6().setVisible(true);
            setOptionMo();
            
        }
        else if(getView().getUserRole().equals("Receptionist")){
            getView().getReceptionistUserOptions().setVisible(true);
            getView().getAdminUserOptions().setVisible(false);
             getView().getJPanel6().setVisible(false);
            setOptionPatient();
            
            

        }
        
    }
    private void setRefferenceOption(){
         if(getView().getUserRole().equals("Admin")){
             getView().getAdminRefferenceOptions().setVisible(true);
            
        }
        
    }
    private void setReportOptions(){
         if(getView().getUserRole().equals("Admin")){
            getView().getAppoinmentReportPanel().setVisible(true);
            getView().getUserLogReportPanel().setVisible(false);
            getView().getPatientCreditialReportPanel().setVisible(false);
        }
    
        
    }
    private void setVisitorOptions(){
        if(getView().getUserRole().equals("Admin")){
            getView().getAdminVisitorOptions().setVisible(true);
            getView().getReceptionistVisitorOptions().setVisible(false);
            
        }
        else if(getView().getUserRole().equals("Receptionist")){
            getView().getAdminVisitorOptions().setVisible(false);
            getView().getReceptionistVisitorOptions().setVisible(true);
            

        }
        
        
    }
    

    public void setColor(JPanel panel){
         panel.setBackground(new Color(85,65,118));
    }
     
    public  void resetAllMainPanels(){//hiding all the main panels in the dashboard
        getView().getUsersPanel().setVisible(false);
        getView().getComplaintPanel().setVisible(false);
        getView().getMailPanel().setVisible(false);
        getView().getAppointmentPanel().setVisible(false);
        getView().getReportsPanel().setVisible(false);
        getView().getSettingsPanel().setVisible(false);
        getView().getRefferencePanel().setVisible(false);
        getView().getVisitorsPanel().setVisible(false);
     }
    public  void resetAllColor(){
        getView().getAppointmentBtnPanel4().setBackground(new Color(64,43,100));
        getView().getHomeBtnPanel1().setBackground(new Color(64,43,100));
        getView().getHomeBtnPanel2().setBackground(new Color(64,43,100));
        getView().getHomeBtnPanel3().setBackground(new Color(64,43,100));
        getView().getHomeBtnPanel4().setBackground(new Color(64,43,100));            
        getView().getMoSettingBtnPanel().setBackground(new Color(64,43,100));
        getView().getAppointmentBtnPanel3().setBackground(new Color(64,43,100));
        getView().getComplaintBtnPanel2().setBackground(new Color(64,43,100));
        getView().getPatientSettingBtnPanel().setBackground(new Color(64,43,100));
        getView().getAppointmentBtnPanel2().setBackground(new Color(64,43,100));
        getView().getMailBtnPanel2().setBackground(new Color(64,43,100));
        getView().getComplaintBtnPanel3().setBackground(new Color(64,43,100));
        getView().getVisitorBtnPanel2().setBackground(new Color(64,43,100));
        getView().getReceptionistSettingBtnPanel().setBackground(new Color(64,43,100));
        getView().getUserBtnPanel2().setBackground(new Color(64,43,100));
        getView().getUserBtnPanel().setBackground(new Color(64,43,100));
        getView().getReportBtnPanel().setBackground(new Color(64,43,100));
        getView().getAppointmentBtnPanel1().setBackground(new Color(64,43,100));
        getView().getMailBtnPanel1().setBackground(new Color(64,43,100));
        getView().getComplaintBtnPanel1().setBackground(new Color(64,43,100));
        getView().getVisitorBtnPanel1().setBackground(new Color(64,43,100));
        getView().getRefferenceBtnPanel().setBackground(new Color(64,43,100));
    }
     void resetColor(JPanel panel){
        panel.setBackground(new Color(64,43,100));
       
        
    } 
    public void setOptionMo(){
        resetHoverColor(getView().getJPanel7(),getView().getJLabel66());
        setHoverColor(getView().getJPanel9(),getView().getJLabel67());
        resetHoverColor(getView().getJPanel35(),getView().getJLabel68());
        getView().getMoScrollPanel().setVisible(true);
        getView().getReceptionistScrollPanel().setVisible(false);
        getView().getPatientScrollPanel().setVisible(false);
        
    }
    public void setOptionReceptionist(){
        setHoverColor(getView().getJPanel7(),getView().getJLabel66());
        resetHoverColor(getView().getJPanel9(),getView().getJLabel67());
        resetHoverColor(getView().getJPanel35(),getView().getJLabel68());
        getView().getReceptionistScrollPanel().setVisible(true);
        getView().getMoScrollPanel().setVisible(false);
        getView().getPatientScrollPanel().setVisible(false);
       
        
    }
    public void setOptionPatient(){
          resetHoverColor(getView().getJPanel7(),getView().getJLabel66());
        resetHoverColor(getView().getJPanel9(),getView().getJLabel67());
         setHoverColor(getView().getJPanel35(),getView().getJLabel68());
         getView().getMoScrollPanel().setVisible(false);
         getView().getReceptionistScrollPanel().setVisible(false);
         getView().getPatientScrollPanel().setVisible(true);
        
    }
  
    public void setAppoinmentReports(){
        resetHoverColor(getView().getJPanel38(),getView().getJLabel79());
        setHoverColor(getView().getJPanel18(),getView().getJLabel78());
        resetHoverColor(getView().getJPanel16(),getView().getJLabel77());
        getView().getAppoinmentReportPanel().setVisible(true);
        getView().getUserLogReportPanel().setVisible(false);
        getView().getPatientCreditialReportPanel().setVisible(false);
         getView().getAppointmentReportDateChooser().setDate(new Date());
         setAppointmentReportTable();
    }
    public void setUserLogReports(){
        resetHoverColor(getView().getJPanel38(),getView().getJLabel79());
        resetHoverColor(getView().getJPanel18(),getView().getJLabel78());
        setHoverColor(getView().getJPanel16(),getView().getJLabel77());
        getView().getAppoinmentReportPanel().setVisible(false);
        getView().getUserLogReportPanel().setVisible(true);
        getView().getPatientCreditialReportPanel().setVisible(false);
        getView().getUserLoginReportDateChooser3().setDate(new Date());
        setUserLoginReportTable();
        
    }
    public void setPatientCredintialReports(){
        setHoverColor(getView().getJPanel38(),getView().getJLabel79());
        resetHoverColor(getView().getJPanel18(),getView().getJLabel78());
        resetHoverColor(getView().getJPanel16(),getView().getJLabel77());
        getView().getAppoinmentReportPanel().setVisible(false);
        getView().getUserLogReportPanel().setVisible(false);
        getView().getPatientCreditialReportPanel().setVisible(true);
        setPatientCredintialReportTable();
    }
     
    private void setComplainRefference(){
        setHoverColor(getView().getComplainReferencePanel(),getView().getjLabel28());
        resetHoverColor(getView().getSpecialityReferencePanel(),getView().getjLabel31());
        getView().getComplaintReferencejScrollPanel().setVisible(true);
        getView().getSpecialityReferenceJScrollPanel().setVisible(false);
        getComplainRefference();
    }
    private void setSpecialityRefference(){
        setHoverColor(getView().getSpecialityReferencePanel(),getView().getjLabel31());
        resetHoverColor(getView().getComplainReferencePanel(),getView().getjLabel28());
         getView().getComplaintReferencejScrollPanel().setVisible(false);
        getView().getSpecialityReferenceJScrollPanel().setVisible(true);
        getSpecialityRefference();         
    }
    public void getComplainRefference(){
            ComplainRefference refference = new ComplainRefference();
           ArrayList<String> complainRefferenceList = refference.getComplainTypes();
            DefaultListModel<String> model = new DefaultListModel<String>();
             getView().getComplaintReferenceList().setModel(model);
          for(String s:complainRefferenceList){
                 model.addElement(s);
                }
    }
    public void getSpecialityRefference(){
       SpecialityRefference refference=new SpecialityRefference();
       ArrayList<String> specialityRefferenceList = refference.getSpecialityTypes();
        DefaultListModel<String> model2 = new DefaultListModel<String>();
        getView().getSpecialityRefferenceList().setModel(model2);
        for(String s:specialityRefferenceList){
                 model2.addElement(s);
                }          
         }
    public void setMoComboBox(){      
    Object[] items=  FileService.getAllMo(FileService.getRecords(FileService.getMoFile())).toArray();     
    DefaultComboBoxModel model = new DefaultComboBoxModel(items);
    getView().getAppointmentReportMoComboBox().setModel( model );
    }
    public void setAppointmentReportTable(){
        String date=PipeService.getDateSimpleFormat(getView().getAppointmentReportDateChooser().getDate());
            MedicalOfficer officer=(MedicalOfficer) getView().getAppointmentReportMoComboBox().getSelectedItem();
             ArrayList<String> list= FileService.getRecords(FileService.getAppointmentsFile());
            TableModel tm = getView().getAppointmentReportTable().getModel();
            DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
      
             for(int i=0;i<list.size();i++)  
           {  
            
            Appointment appoinment=Appointment.readAppoinment(list.get(i));
            try{
            if(appoinment.getAppointmentDate().equals(date) && appoinment.getMedicalOfficer().getIdCardNo().equals(officer.getIdCardNo())){
             Object[] row = {appoinment.getAppointmentNumber(), appoinment.getStatus(), appoinment.getPatient().getName(), appoinment.getPatient().getIdCardNo(), appoinment.getAppointmentDate(), appoinment.getAppointmentTime(), appoinment.getMedicalOfficer().getName(), appoinment.getSpeciality(),appoinment.getSymtomps()};
                    model.addRow(row);
            }
           }
            catch(NullPointerException e){
                   JOptionPane.showMessageDialog(null, "enter all fields");
            }
            
           }
        
    }
    public void setUserLoginReportTable(){
         String date=PipeService.getDateSimpleFormat(getView().getUserLoginReportDateChooser3().getDate());
         String role =getView().getUserLoginReportComboBox().getSelectedItem().toString();
         ArrayList<String> list= FileService.getRecords(FileService.getUserLoginFile());
        TableModel tm = getView().getUserLogReportTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
      
             for(int i=0;i<list.size();i++)  
           {  
            
            UserLogin login=UserLogin.readLogin(list.get(i));
            try{
            if(login.getDate().equals(date) && login.getRole().equals(role)){
             Object[] row = {login.getUserName(),login.getRole(),login.getDate(),login.getTime()};
                    model.addRow(row);
            }
           }
            catch(NullPointerException e){
                   JOptionPane.showMessageDialog(null, "enter all fields");
            }
            
           }
        
    }
    public void setPatientCredintialReportTable(){
         ArrayList<String> list= FileService.getRecords(FileService.getPatientsFile());
        TableModel tm = getView().getPatientCredintialTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
                
             for(int i=0;i<list.size();i++)  
           {  
            
            Patient patient=Patient.readPatientUser(list.get(i));
             Object[] row = {patient.getUserName(),patient.getName(),patient.getPassword()};
             model.addRow(row);
            
           }  
        
    } 
//getters
    public void  getPatientAppointmentTable(String id){
        System.out.println("patient id"+id);
        ArrayList<String> list= FileService.getRecords(FileService.getAppointmentsFile());
        TableModel tm = getView().getAppointmentTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
          
             for(int i=0;i<list.size();i++)  
           {  
                
                Appointment appoinment=Appointment.readAppoinment(list.get(i));
            
            if(appoinment.getPatient().getIdCardNo().equals(id)){
             Object[] row = {appoinment.getAppointmentNumber(), appoinment.getAppointmentDate(), appoinment.getAppointmentTime(), appoinment.getStatus(), appoinment.getPatient().getName(), appoinment.getPatient().getIdCardNo(), appoinment.getMedicalOfficer().getName(), appoinment.getSpeciality(),appoinment.getSymtomps(),appoinment.getMedicalOfficer().getIdCardNo()};
                    model.addRow(row);
            }
           }  
    }
    public void getMOAppointmentTable(String id){
       
          ArrayList<String> list= FileService.getRecords(FileService.getAppointmentsFile());
        TableModel tm = getView().getAppointmentTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
             for(int i=0;i<list.size();i++)  
           {  
             Appointment appoinment=Appointment.readAppoinment(list.get(i));
            
            if(appoinment.getMedicalOfficer().getIdCardNo().equals(id) && appoinment.getStatus().equalsIgnoreCase("Approved") ){
             Object[] row = {appoinment.getAppointmentNumber(), appoinment.getAppointmentDate(), appoinment.getAppointmentTime(), appoinment.getStatus(), appoinment.getPatient().getName(), appoinment.getPatient().getIdCardNo(), appoinment.getMedicalOfficer().getName(), appoinment.getSpeciality(),appoinment.getSymtomps(),appoinment.getMedicalOfficer().getIdCardNo()};
                    model.addRow(row);
            }
            
           }  
        
    }
    public void  getAllAppointment(){
        ArrayList<String> list= FileService.getRecords(FileService.getAppointmentsFile());
        TableModel tm = getView().getAppointmentTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
             for(int i=0;i<list.size();i++)  
           {  
            
            String [] data=list.get(i).split(",");
             Object[] row = {data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7],data[8],data[9]};
                    model.addRow(row);
            
           }  
        
    }
    public void getAllComplaints(){
         ArrayList<String> list= FileService.getRecords(FileService.getComplaintsFile());
        TableModel tm = getView().getComplaintsTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
       System.out.println("all complaints");  
             for(int i=0;i<list.size();i++)  
           {  
             String [] data=list.get(i).split(",");
            
             Object[] row = { data[0],data[1], data[2], data[3], data[4], data[5], data[6], data[7]};
                    model.addRow(row);
            
           }  
        
    }
    public void getPatientComplains(){
          ArrayList<String> list= FileService.getRecords(FileService.getComplaintsFile());
        TableModel tm = getView().getComplaintsTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
            System.out.println("patient complaints");  
             for(int i=0;i<list.size();i++)  
           {  
            
            String [] data=list.get(i).split(",");
             Object[] row = { data[1], data[2], data[3], data[4], data[5], data[6], data[7],data[8]};
                    model.addRow(row);
            
           }  
        
    }
    public void getDispatchedMails(){
         ArrayList<String> list= FileService.getRecords(FileService.getMailsFile());
        TableModel tm = getView().getMailsTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
            System.out.println("dispatched mails");  
             for(int i=0;i<list.size();i++)  
           {  
            
            String [] data=list.get(i).split(",");
             Object[] row = { data[0], data[1], data[2], data[3], data[4], data[5]};
                    model.addRow(row);
            
           }  
        
    }
    public void getVisitorRecords(){
        ArrayList<String> list= FileService.getRecords(FileService.getVisitorsFile());
        TableModel tm = getView().getVisitorsTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
             for(int i=0;i<list.size();i++)  
           {  
            
            String [] data=list.get(i).split(",");
             Object[] row = { data[0], data[1], data[2], data[3], data[4], data[5],data[6], data[7], data[8]};
                    model.addRow(row);
            
           }  
    }
    public void getAllUsers(){
       
             getAllMedicalOfficers();
           getAllReceptionist();
           getAllPatients();
        
    }
    public void getAllMedicalOfficers(){//this functions binds the medical officer table with all medical officers in the system by reading from medical officer txt file
        ArrayList<String> list= FileService.getRecords(FileService.getMoFile());
        TableModel tm = getView().getMedicalOfficerTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
             for(int i=0;i<list.size();i++)  
           {  
            
            MedicalOfficer officer=MedicalOfficer.readMoUser(list.get(i));
           
             Object[] row = {officer.getUserName(),officer.getName(),officer.getGender(),officer.getphoneNumber(),officer.getIdCardNo(),officer.getDateOfBirth(),officer.getAddress(),officer.getMaritalStatus(),officer.getPassword(),officer.getStrStaffId(),officer.getStrEmailAddress(),officer.getStrDateOfJoining(),officer.getCvFile(),officer.getStrSpecialityArea(),officer.getPhoto()};
                    model.addRow(row);
            
           }  
     
    }
    public void getAllReceptionist(){//this functions binds the receptionist table with all medical officers in the system by reading from receptionist txt file
        ArrayList<String> list= FileService.getRecords(FileService.getReceptionistFile());
        TableModel tm = getView().getReceptionistTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
             for(int i=0;i<list.size();i++)  
           {   
        Receptionist officer=Receptionist.readReceptionistUser(list.get(i));
             Object[] row = { officer.getUserName(),officer.getName(),officer.getGender(),officer.getphoneNumber(),officer.getIdCardNo(),officer.getDateOfBirth(),officer.getAddress(),officer.getMaritalStatus(),officer.getPassword(),officer.getStrStaffId(),officer.getStrEmailAddress(),officer.getStrDateOfJoining(),officer.getCvFile(),officer.getPhoto()};
                    model.addRow(row);
            
           }    
    }
    public void getAllPatients(){
         ArrayList<String> list= FileService.getRecords(FileService.getPatientsFile());
        TableModel tm = getView().getPatientsTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
             for(int i=0;i<list.size();i++)  
           {  
            
            Patient patient=Patient.readPatientUser(list.get(i));
             Object[] row = {patient.getUserName(),patient.getName(),patient.getGender(),patient.getphoneNumber(),patient.getIdCardNo(),patient.getDateOfBirth(),patient.getAddress(),patient.getMaritalStatus(),patient.getPassword(),patient.getStrBloodGrp(),patient.getStrAllergies()};
             model.addRow(row);
            
           }  
        
    }
    
   public void setHoverColor(JPanel panel,JLabel label){
                panel.setBackground(new Color(85,65,118));
                label.setForeground(Color.white);

    }
    
    public void resetHoverColor(JPanel panel,JLabel label){
                panel.setBackground(new Color(255,255,255));
                label.setForeground(new Color(102,0,102));

    }
     

/*other functions*/
//appointment
public void addNewAppointment(){
         AppointmentView appointmentView = new AppointmentView(getView(), new Appointment(),this,1);
         appointmentView.setVisible(true);
         
    }
public void generateApprovedAppointmentPdf(){
    FileService.generateApprovedAppoinmentReport();
}
public void editAppointment(){
        Object record= ((DefaultTableModel) getView().getAppointmentTable().getModel()).getDataVector().elementAt(getView().getAppointmentTable().getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                   AppointmentView appointmentView = new AppointmentView(getView(), Appointment.readAppoinment(line),this,2);
                   appointmentView.setVisible(true);
                   // EditAppointment edit=new EditAppointment(appointment,this);
                   
    } 
public void deleteAppointment(){
         
         
          Object record= ((DefaultTableModel) getView().getAppointmentTable().getModel()).getDataVector().elementAt(getView().getAppointmentTable().getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    AppointmentView appointmentView = new AppointmentView(getView(), Appointment.readAppoinment(line),this,2);
                    appointmentView.setVisible(true);
                    appointmentView.getController().deleteAppoinment();
                    /*if(AlertService.optionalPlane("Would you like to Delete the Appoinment Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
                    FileService.deleteRecord(path, line);
                     this.setTables();
                    }*/
    } 
public void approveAppointment(String status){
         Object record= ((DefaultTableModel) getView().getAppointmentTable().getModel()).getDataVector().elementAt(getView().getAppointmentTable().getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());             
                    AppointmentView appointmentView = new AppointmentView(getView(), Appointment.readAppoinment(line),this,2);
                   appointmentView.setVisible(true);
                    if(AlertService.optionalPlane("Would you like to Approve the Appoinment Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
                    FileService.deleteRecord(FileService.getAppointmentsFilePath(), line);
                    appointmentView.setStatus(status);
                    if(status.equalsIgnoreCase("Approve")){
                        String number=String.valueOf((FileService.getRecordCount(FileService.getAppointmentsFile())+1));
                        appointmentView.setAppoinmentNumber(number);
                    }
                    
                     appointmentView.getController().addAppoinment();
                    }              
     }
//complaint

private void addNewComplaint(){
        AddComplaint complaintView = new AddComplaint(getView().getUserRole(),this,new Complaint(),1);
        complaintView.setVisible(true);
    }
private void deleteComplaint(){
        Object record= ((DefaultTableModel) getView().getComplaintsTable().getModel()).getDataVector().elementAt(getView().getComplaintsTable().getSelectedRow());
        String line= PipeService.formatTableString(record.toString());
        AddComplaint complaintView = new AddComplaint(getView().getUserRole(),this, Complaint.readComplaint(line),2);
        complaintView.setVisible(true);
        complaintView.getController().deleteComplaint();                 
     } 
public void editComplaint(){
        Object record= ((DefaultTableModel) getView().getComplaintsTable().getModel()).getDataVector().elementAt(getView().getComplaintsTable().getSelectedRow());
        String line= PipeService.formatTableString(record.toString());
        AddComplaint complaintView = new AddComplaint(getView().getUserRole(),this, Complaint.readComplaint(line),2);
        complaintView.setVisible(true);
     }
public void editActionTaken( ){
        Object record= ((DefaultTableModel) getView().getComplaintsTable().getModel()).getDataVector().elementAt(getView().getComplaintsTable().getSelectedRow());
        String line= PipeService.formatTableString(record.toString());
        ComplaintController controller=new ComplaintController(Complaint.readComplaint(line),null,this);
        controller.changeActionTakenComplaint();
         
     }
     
//mails
private void addDispatchedPostal(){
        AddMail mail = new AddMail(getView(),null,this,1);
        mail.setVisible(true);
        
    }
private void deleteMail(){
          Object record= ((DefaultTableModel) getView().getMailsTable().getModel()).getDataVector().elementAt(getView().getMailsTable().getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                   AddMail mail = new AddMail(getView(),DispatchedPostal.readMail(line),this,2);
                    mail.setVisible(true);
                    mail.getController().deleteMail();
     }
private void editMail(){
          Object record= ((DefaultTableModel) getView().getMailsTable().getModel()).getDataVector().elementAt(getView().getMailsTable().getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    AddMail mail = new AddMail(getView(),DispatchedPostal.readMail(line),this,2);
                    mail.setVisible(true);
         
     }
     
//visitor function
private void addNewVisitorRecord(){
        AddVisitors record = new AddVisitors(getView(),null,this,1);
        record.setVisible(true);
    } 
private void deleteVisitorRecord(){
        Object record= ((DefaultTableModel) getView().getVisitorsTable().getModel()).getDataVector().elementAt(getView().getVisitorsTable().getSelectedRow());
        String line= PipeService.formatTableString(record.toString());
        AddVisitors deleteView = new AddVisitors(getView(),Visitor.readVisitor(line),this,2);
        deleteView.setVisible(true);
        deleteView.getController().deleteVisitor();
        
    }
private void editVisitorRecord(){
        Object record= ((DefaultTableModel) getView().getVisitorsTable().getModel()).getDataVector().elementAt(getView().getVisitorsTable().getSelectedRow());
        String line= PipeService.formatTableString(record.toString());
        AddVisitors edit =new AddVisitors(getView(),Visitor.readVisitor(line),this,2);
        edit.setVisible(true);
    }

//reference
private void addNewReference(){
     
        AddReference refference= new AddReference(1,this);
        refference.setVisible(true);
    
}
private void deleteReference(){
    if(getView().getComplaintReferencejScrollPanel().isShowing()){
        String selected = getView().getComplaintReferenceList().getSelectedValue();
        ReferenceController reference = new ReferenceController(null,selected,this);
        reference.deleteComplaintReference();
        
    }
    else if(getView().getSpecialityReferenceJScrollPanel().isShowing()){
                String selected = getView().getSpecialityRefferenceList().getSelectedValue();
                ReferenceController reference = new ReferenceController(null,selected,this);
                reference.deleteSpecialityReference();

    }
    
    
}
private void editReference(){
    if(getView().getComplaintReferencejScrollPanel().isShowing()){
        String selected = getView().getComplaintReferenceList().getSelectedValue();
        ReferenceController reference = new ReferenceController(null,selected,this);
        reference.editComplaintReference(selected);
        
    }
    else if(getView().getSpecialityReferenceJScrollPanel().isShowing()){
                String selected = getView().getSpecialityRefferenceList().getSelectedValue();
                ReferenceController reference = new ReferenceController(null,selected,this);
                reference.editSpecialityReference(selected);

    }
    
    
    
}

//reports functions

private void generateAppointmentsPdf(){
    FileService.generatePdf(getView().getAppointmentReportTable().getModel(),FileService.getAppoinmentReportFilePath());
}
private void generatePatientCredintialReportPdf(){
    FileService.generatePdf(getView().getPatientCredintialTable().getModel(),FileService.getPatientCredintailReportFilePath());
}
private void generateUserLoginReportPdf(){
    FileService.generatePdf(getView().getUserLogReportTable().getModel(),FileService.getUserLoginReportFilePath());
}
private void generateAppointmentsReportCsv(){
 try {
            FileService.generateCsvFile(getView().getAppointmentReportTable().getModel(),"files/reports/appointmentReport.csv");
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
}
private void generatePatientCredintialReportCsv(){
try {
            FileService.generateCsvFile(getView().getUserLogReportTable().getModel(),"files/reports/userLogReport.csv");
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
}
private void generateUserLoginReportCsv(){
 try {
            FileService.generateCsvFile(getView().getPatientCredintialTable().getModel(),"files/reports/patientCredintial.csv");
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
}
//settings panel functions
/* public void loadUserDetails(){
       User user=CurrentUser.getUser();
       System.out.println("user "+user.toString2());
       getView().getUserNameField().setText(user.getUserName());
       getView().getPasswordField().setText(user.getPassword());
        getView().getPhoneNumberField().setText(user.getphoneNumber());
        getView().getNameField().setText(user.getName());
        getView().getNicField().setText(user.getIdCardNo());
        getView().getGenderComboBox().setSelectedItem(user.getGender());
        getView().getMartialStatusComboBoxField().setSelectedItem(user.getMaritalStatus());
        getView().getAddressField().setText(user.getAddress());
        Date dob=PipeService.getStringToDateFormat(user.getDateOfBirth());
        getView().getDobDateChooser().setDate(dob);
        
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
         
         
        CurrentUser.getUser().setIdCardNo( getView().getNicField().getText());
        CurrentUser.getUser().setGender( getView().getGenderComboBox().getSelectedItem().toString());
        CurrentUser.getUser().setName( getView().getNameField().getText());
        CurrentUser.getUser().setUserName( getView().getUserNameField().getText());
        CurrentUser.getUser().setMaritalStatus( getView().getMartialStatusComboBoxField().getSelectedItem().toString());
        CurrentUser.getUser().setAddress( getView().getAddressField().getText());
        CurrentUser.getUser().setStrPassword( getView().getPasswordField().getText());
        CurrentUser.getUser().setphoneNumber( getView().getPhoneNumberField().getText());
        CurrentUser.getUser().setDateOfBirth(PipeService.getDateSimpleFormat( getView().getDobDateChooser().getDate()));
         
         FileService.addLine(path,  CurrentUser.getUser().toString2());
     }*/

 //user functions
 private void addUser(){
      if(getView().getMoScrollPanel().isShowing()){
          AddMedicalOfficer newOfficer=new  AddMedicalOfficer(null,this,1);  
          newOfficer.setVisible(true);
        }
        else if(getView().getPatientScrollPanel().isShowing()){
                     AddPatient newPatient=new  AddPatient(null,this,1); 
                     newPatient.setVisible(true);
        }
        else if(getView().getReceptionistScrollPanel().isShowing()){
                   AddReceptionist newReceptionist=new  AddReceptionist(null,this,1);
                   newReceptionist.setVisible(true);
        }
     
 }
 private void editUser(){
      if(getView().getMoScrollPanel().isShowing()){
          Object record= ((DefaultTableModel) getView().getMedicalOfficerTable().getModel()).getDataVector().elementAt(getView().getMedicalOfficerTable().getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    AddMedicalOfficer editOfficer=new  AddMedicalOfficer(MedicalOfficer.readMoUser(line),this,2);  
                    editOfficer.setVisible(true);
        }
        else if(getView().getPatientScrollPanel().isShowing()){
                    Object record= ((DefaultTableModel) getView().getPatientsTable().getModel()).getDataVector().elementAt(getView().getPatientsTable().getSelectedRow());
                    String line= PipeService.formatTableString(record.toString());
                    AddPatient editPatient=new  AddPatient(Patient.readPatientUser(line),this,2); 
                    editPatient.setVisible(true);
        }
        else if(getView().getReceptionistScrollPanel().isShowing()){
            Object record= ((DefaultTableModel) getView().getReceptionistTable().getModel()).getDataVector().elementAt(getView().getReceptionistTable().getSelectedRow());
                    String line= PipeService.formatTableString(record.toString());
                    AddReceptionist editReceptionist=new  AddReceptionist(Receptionist.readReceptionistUser(line),this,1);
                    editReceptionist.setVisible(true);
                   
        }
     
     
 }
 private void deleteUser(){
     if(getView().getMoScrollPanel().isShowing()){
                    Object record= ((DefaultTableModel) getView().getMedicalOfficerTable().getModel()).getDataVector().elementAt(getView().getMedicalOfficerTable().getSelectedRow());
                    String line= PipeService.formatTableString(record.toString());
                    AddMedicalOfficer editOfficer=new  AddMedicalOfficer(MedicalOfficer.readMoUser(line),this,2);  
                    editOfficer.getController().deleteMedicalOfficer();
        }
        else if(getView().getPatientScrollPanel().isShowing()){
                    Object record= ((DefaultTableModel) getView().getPatientsTable().getModel()).getDataVector().elementAt(getView().getPatientsTable().getSelectedRow());
                    String line= PipeService.formatTableString(record.toString());
                    AddPatient editPatient=new  AddPatient(Patient.readPatientUser(line),this,2); 
                    editPatient.getController().deletePatient();
        }
        else if(getView().getReceptionistScrollPanel().isShowing()){
                    Object record= ((DefaultTableModel) getView().getReceptionistTable().getModel()).getDataVector().elementAt(getView().getReceptionistTable().getSelectedRow());
                    String line= PipeService.formatTableString(record.toString());
                    AddReceptionist editReceptionist=new  AddReceptionist(Receptionist.readReceptionistUser(line),this,1);
                    editReceptionist.getController().deleteReceptionist();
                   
        }
     
 } 
 private void resetPassword(){
     if(getView().getMoScrollPanel().isShowing()){
                    Object record= ((DefaultTableModel) getView().getMedicalOfficerTable().getModel()).getDataVector().elementAt(getView().getMedicalOfficerTable().getSelectedRow());
                    String line= PipeService.formatTableString(record.toString());
                    AddMedicalOfficer editOfficer=new  AddMedicalOfficer(MedicalOfficer.readMoUser(line),this,2);  
                    editOfficer.getController().resetMedicalOfficerPassword();
        }
        else if(getView().getPatientScrollPanel().isShowing()){
                    Object record= ((DefaultTableModel) getView().getPatientsTable().getModel()).getDataVector().elementAt(getView().getPatientsTable().getSelectedRow());
                    String line= PipeService.formatTableString(record.toString());
                    AddPatient editPatient=new  AddPatient(Patient.readPatientUser(line),this,2); 
                    editPatient.getController().resetMedicalOfficerPassword();
        }
        else if(getView().getReceptionistScrollPanel().isShowing()){
                    Object record= ((DefaultTableModel) getView().getReceptionistTable().getModel()).getDataVector().elementAt(getView().getReceptionistTable().getSelectedRow());
                    String line= PipeService.formatTableString(record.toString());
                    AddReceptionist editReceptionist=new  AddReceptionist(Receptionist.readReceptionistUser(line),this,1);
                    editReceptionist.getController().resetReceptionistPassword();
                   
        }
     
 } 
 
 
 

  private void userLogOut(){
        getView().dispose();
        Home home=new Home();
        home.setVisible(true);
    }
    
}


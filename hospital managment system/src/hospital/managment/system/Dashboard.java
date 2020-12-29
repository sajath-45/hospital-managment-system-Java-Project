/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import com.toedter.calendar.JDateChooser;
import hospital.managment.system.models.ComplainRefference;
import hospital.managment.system.models.CurrentUser;
import hospital.managment.system.models.FileService;
import hospital.managment.system.models.SpecialityRefference;
import hospital.managment.system.models.MedicalOfficer;
import hospital.managment.system.models.Patient;
import hospital.managment.system.models.UserLogin;
import hospital.managment.system.models.Appointment;
import hospital.managment.system.models.PipeService;
import hospital.managment.system.models.Receptionist;
import hospital.managment.system.models.User;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author sajath
 */
public class Dashboard extends javax.swing.JFrame  {
    private String userRole;
    private DashboardController controller;
    /**
     * Creates new form dashboard
     * @param role
     */
    public Dashboard(String role) {
        initComponents();
        this.setVisible(true);
        
        setRole(role);
        SettingsController settingsController = new SettingsController(CurrentUser.getUser(),this);
        settingsController.initController();
        setController(new DashboardController(null,this));
        getController().initController(role);
        
    }
    private Dashboard() {
    }
    public void  setController(DashboardController controller){
        this.controller=controller;
    }
    public void setRole(String role){
        this.userRole=role;
    }
    public String getUserRole(){
        return this.userRole;
    }
    
    //getters
    public DashboardController getController(){
        return this.controller;
    }
    public JButton getAddAppointmentBtn(){//for patient
        return this.addAppointmentBtn;
    }
    public JButton getAddAppointmentBtn2(){//for patient
        return this.addAppointmentBtn2;
    }
    public JButton getApproveAppoinmentBtn(){//for patient
        return this.approveAppoinmentBtn;
    }
    public JButton getGeneratePdfBtn(){//for patient
        return this.generatePdfBtn;
    }
    public JButton getEditAppointmentBtn(){//for patient
        return this.editAppointmentBtn;
    }
    public JButton getDeleteAppointmentBtn(){//for patient
        return this.deleteAppointmentBtn;
    }
    public JButton getAddUsersBtn(){//for patient
        return this.addUsersBtn;
    }
     public JButton getAddUsersBtn2(){//for patient
        return this.addUsersBtn2;
    }
    public JButton getViewUsersBtn(){//for patient
        return this.resetPasswordBtn;
    }
     public JButton getViewUsersBtn2(){//for patient
        return this.resetPasswordBtn2;
    }
     public JButton getEditUsersBtn(){//for patient
        return this.editUsersBtn;
    }
      public JButton getEditUsersBtn2(){//for patient
        return this.editUsersBtn2;
    }
     public JButton getDeleteUsersBtn(){//for patient
        return this.deleteUsersBtn;
    }
     public JButton getDeleteUsersBtn2(){//for patient
        return this.deleteUsersBtn2;
    }
    public JButton getResetPasswordBtn(){
        return resetPasswordBtn;
    }
    public JButton getResetPasswordBtn2(){
        return resetPasswordBtn2;
    }
     
     
    public JButton getAddMailBtn(){
        return this.addMailBtn;
    }
    public JButton getEditMailBtn(){
        return this.editMailBtn;
    }
    public JButton getDeleteMailBtn2(){
        return this.deleteMailBtn2;
    }
    public JButton getDeleteMailBtn(){
        return this.deleteMailBtn;
    }
    
    public JButton getApproveComplaintBtn(){//for patient
        return this.approveComplaintBtn;
    }
    public JButton getCompleteAppointmentBtn(){//for patient
        return this.completedAppointmentBtn;
    }
    public JButton getAddComplaintBtn2(){//for patient
        return this.addComplaintBtn2;
    }
     public JButton getAddComplaintBtn(){//for patient
        return this.addComplaintBtn;
    }
    public JButton getEditComplaintBtn(){
        return this.editComplaintBtn;
    }
    public JButton getDeleteComplaintBtn(){
        return this.deleteComplaintBtn;
    }
    
    public JButton getAddVisitorBtn(){
        return this.addVisitorBtn;
    }
    public JButton getEditVisitorBtn(){
        return this.editVisitorBtn;
    }
    public JButton getDeleteVisitorBtn(){
        return this.deleteVisitorBtn;
    }
    public JButton getDeleteVisitorBtn2(){
        return this.deleteVisitorBtn2;
    }
    
    public JButton getAddReferenceBtn(){
        return this.addReferenceBtn;
    }
    public JButton getEditReferenceBtn(){
        return this.editReferenceBtn;
    }
    public JButton getdeleteReferenceBtn(){
        return this.deleteReferenceBtn;
    }
    public JTable getAppointmentTable(){
        return appointmentTable;
    }
    public JTable getComplaintsTable(){
        return complaintTable;
    }
    public JTable getMailsTable(){
        return dispatchedMailTable;
    }
    public JTable getVisitorsTable(){
        return visitorTable;
    }
     public JTable getAppointmentReportTable(){
        return appointmentReportTable;
    }
    public JTable getUserLogReportTable(){
        return userLogReportTable;
    }
    public JTable getPatientCredintialTable(){
        return patientCredintialTable;
    }
    public JTable getMedicalOfficerTable(){
        return moTable;
    }
     public JTable getPatientsTable(){
        return patientsTable;
    }
      public JTable getReceptionistTable(){
        return receptionistTable;
    }
    public JPanel getComplainReferencePanel(){
        return this.complainReferenceOptionPanel;
    }
    public JPanel getSpecialityReferencePanel(){
        return this.specialityReferenceOptionPanel;
    }
    //side panels
    public JPanel getReceptionSidePanel(){
        return this.receptionSidePanel;
    }
    public JPanel getAdminSidePanel(){
        return this.adminSidePanel;
    }
    public JPanel getPatientSidePanel(){
        return this.patientSidePanel;
    }
    public JPanel getMoSidePanel(){
        return this.moSidePanel;
    }
    //main panels
    public JPanel getHomePanel(){
        return this.homePanel;
    }
    public JPanel getAppointmentPanel(){
        return this.appointmentPanel;
    }
    public JPanel getRefferencePanel(){
        return this.refferencePanel;
    }
    public JPanel getComplaintPanel(){
        return this.complaintPanel;
    }
    public JPanel getMailPanel(){
        return this.mailPanel;
    }
    public JPanel getUsersPanel(){
        return this.usersPanel;
    }
    public JPanel getVisitorsPanel(){
        return this.visitorsPanel;
    }
    public JPanel getReportsPanel(){
        return this.reportsPanel;
    }
    public JPanel getSettingsPanel(){
        return this.settingsPanel;
    }
    //options panel
    public JPanel getUsersMainOptionsPanel(){
        return this.usersMainOption;
    }
    public JPanel getMailsMainOptionsPanel(){
        return this.mailMainOption;
    }
    public JPanel getAppoinmentsMainOptionsPanel(){
        return this.appointmentMainOption;
    }
    public JPanel getVisitorsMainOptionPanel(){
        return this.visitorsMainOption;
    }
    public JPanel getComplaintsMainOptionPanel(){
        return this.complaintsMainOption;
    }
    public JPanel getRefferenceOptionsMainPanel(){
        return this.refferenceMainOption;
    }
    //getters for side panel buttons
    public JPanel getHomeBtnPanel1(){
        return this.homeBtnPanel1;
    }
    public JPanel getHomeBtnPanel2(){
        return this.homeBtnPanel2;
    }
    public JPanel getHomeBtnPanel3(){
        return this.homeBtnPanel3;
    }
    public JPanel getHomeBtnPanel4(){
        return this.homeBtnPanel4;
    }
     public JPanel getAppointmentBtnPanel1(){
        return this.appointmentBtnPanel1;
    }
    public JPanel getAppointmentBtnPanel2(){
        return this.appointmentBtnPanel2;
    }
    public JPanel getAppointmentBtnPanel3(){
        return this.appointmentBtnPanel3;
    }
    public JPanel getAppointmentBtnPanel4(){
        return this.appointmentBtnPanel4;
    }
    
    public JPanel getMailBtnPanel1(){
        return this.mailBtnPanel1;
    }
    public JPanel getMailBtnPanel2(){
        return this.mailBtnPanel2;
    }
    public JPanel getComplaintBtnPanel1(){
        return this.complaintBtnPanel1;
    }
    public JPanel getComplaintBtnPanel2(){
        return this.complaintBtnPanel2;
    }
    public JPanel getComplaintBtnPanel3(){
        return this.complaintBtnPanel3;
    }
    public JPanel getVisitorBtnPanel1(){
        return this.visitorBtnPanel1;
    }
    public JPanel getVisitorBtnPanel2(){
        return this.visitorBtnPanel2;
    }
    public JPanel getUserBtnPanel(){
        return this.userBtnPanel;
    }
    public JPanel getUserBtnPanel2(){
        return this.userBtnPanel2;
    }
    
    
    public JPanel getLogOutBtnPanel1(){
        return this.logOutBtnPanel1;
    }
    public JPanel getLogOutBtnPanel2(){
        return this.logOutBtnPanel2;
    }
    public JPanel getLogOutBtnPanel3(){
        return this.logOutBtnPanel3;
    }
    public JPanel getLogOutBtnPanel4(){
        return this.logOutBtnPanel4;
    }
    
    
    public JPanel getMoSettingBtnPanel(){
        return this.moSettingBtnPanel;
    }
    public JPanel getPatientSettingBtnPanel(){
        return this.patientSettingBtnPanel;
    }
    public JPanel getReceptionistSettingBtnPanel(){
        return this.receptionistSettingBtnPanel;
    }
    public JPanel getRefferenceBtnPanel(){
        return this.refferenceBtnPanel;
    }
    public JPanel getReportBtnPanel(){
        return this.reportBtnPanel;
    }
     public JPanel getMoAppointmentOptions(){
        return moAppointmentOptions;
    }
    public JPanel getAdminAppointmentOptions(){
        return adminAppointmentOptions;
    }
    public JPanel getPatientAppointmentOptions(){
        return patientAppointmentOptions;
    }
    public JPanel getReceptionistAppointmentOptions(){
        return receptionAppointmentOptions;
    }
    public JPanel getAdminMailOptions(){
        return adminMailOptions;
    }
    public JPanel getReceptionMailOptions(){
        return receptionMailOptions;
    }
    public JPanel getPatientComplaintOptions(){
        return patientComplaintOptions;
    }
    public JPanel getAdminComplaintOptions(){
        return adminComplaintOptions;
    }
    public JPanel getReceptionComplaintOptions(){
        return receptionistComplaintOptions;
    }
    public JPanel getAdminUserOptions(){
        return adminUserOptions;
    }
     public JPanel getAdminRefferenceOptions(){
        return adminRefferenceOptions;
    }
      public JPanel getPatientComplainOptions(){
        return this.patientComplaintOptions;
    }
    public JPanel getAdminComplainOptions(){
        return this.adminComplaintOptions;
    }
    public JPanel getReceptionistComplaintOptions(){
        return this.receptionistComplaintOptions;
    }
    
   
    
    public JPanel getReceptionistUserOptions(){
        return this.receptionistUserOptions;
    }
    public JPanel getAdminVisitorOptions(){
        return this.adminVisitorOptions;
    }
    public JPanel getReceptionistVisitorOptions(){
        return this.receptionistVisitorOptions;
    }
    public JPanel getAppoinmentReportPanel(){
        return this.appoinmentReportPanel;
    }
    public JPanel getUserLogReportPanel(){
        return this.userLogReportPanel;
    }
    public JPanel getPatientCreditialReportPanel(){
        return this.patientCreditialReportPanel;
    }
    
    
    public JPanel getJPanel7(){
        return this.jPanel7;
    }
    public JLabel getJLabel66(){
        return this.jLabel66;
    }
    public JPanel getJPanel9(){
        return this.jPanel9;
    }
    public JLabel getJLabel67(){
        return this.jLabel67;
    }
    public JLabel getJLabel68(){
        return this.jLabel68;
    }
    public JPanel getJPanel35(){
        return this.jPanel35;
    }
    
    
    public JLabel getJLabel79(){
        return this.jLabel79;
    }
    public JPanel getJPanel38(){
        return this.patientCredentialReportOptionPanel;
    }
    public JLabel getJLabel78(){
        return this.jLabel78;
    }
    public JPanel getJPanel18(){
        return this.appointmentReportOptionPanel;
    }
    public JLabel getJLabel77(){
        return this.jLabel77;
    }
    public JPanel getJPanel16(){
        return this.userLogReportOptionPanel;
    }
    public JLabel getjLabel28(){
        return this.jLabel28;
    }
     public JLabel getjLabel31(){
        return this.jLabel31;
    }
    
    
    //scroll panels
    public JScrollPane getMoScrollPanel(){
        return this.moScrollPanel;
    }
     public JScrollPane getReceptionistScrollPanel(){
        return this.receptionistScrollPanel;
    }
     public JScrollPane getPatientScrollPanel(){
        return this.patientScrollPanel;
    }
     public JScrollPane getComplaintReferencejScrollPanel(){
        return this.complaintReferencejScrollPanel;
    }
     public JScrollPane getSpecialityReferenceJScrollPanel(){
        return this.specialityReferenceJScrollPanel;
    }
    //reffernce list
     
      public JList<String> getComplaintReferenceList(){
         return this.complainRefferenceList;
     }
       public JList<String> getSpecialityRefferenceList(){
         return this.specialityRefferenceList;
     }
     
     
     
     
    //other panels
     public JPanel getJPanel6(){
         return this.jPanel6;
     }
     //
    
     
    public JDateChooser   getUserLoginReportDateChooser3(){
        return this.userLoginReportDateChooser3;}
    public JComboBox<String>   getUserLoginReportComboBox(){
        return this.userLoginReportComboBox;}
    public JDateChooser   getAppointmentReportDateChooser(){
            return this.appointmentReportDateChooser;}
    public JComboBox<String>   getAppointmentReportMoComboBox(){
            return this.appointmentReportMoComboBox;}
    
    //report panel generate pdf and csv buttons
    public JButton getGenerateAppointmentReportPdfBtn(){
        return this.appoinmentReportPdfBtn;
    }
    public JButton getAppointmentReportPrepareBtn(){
        return this.appointmentReportPrepareBtn;
    }
    
    public JButton getUserLogPrepareBtn(){
        return this.userLogPrepareBtn;
    }
    public JButton getGenerateAppointmentReportCsvBtn(){
        return this.appointmentReportCsvBtn;
    }
    public JButton getGenerateUserLogReportPdfBtn(){
        return this.userLogReportPdfBtn;
    }
    public JButton getGenerateUserLogReportCsvBtn(){
        return this.userLogReportCsvBtn;
    }
    public JButton getGeneratePatientCredintialPdfBtn(){
        return this.patientCredintialPdfBtn;
    }
    public JButton getGeneratePatientCredintialCsvBtn(){
        return this.patientCredintialCsvBtn;
    }
    public JPanel getappointmentReportOptionPanel(){
        return this.appointmentReportOptionPanel;
    }
    public JPanel getUserLogReportOptionPanel(){
        return this.userLogReportOptionPanel;
    }
    public JPanel getPatientCredentialReportOptionPanel(){
        return this.patientCredentialReportOptionPanel;
    }
    //reference panel options
    public JPanel getComplainReferenceOptionPanel(){
        return this.complainReferenceOptionPanel;}
    public JPanel getSpecialityReferenceOptionPanel(){
        return this.specialityReferenceOptionPanel;}
    //settings panel
    public JTextField getUserNameField(){
         return this.userNameField;
     }
    public JTextField getNicField(){
         return this.nicField;
     }
    public JTextField getPasswordField(){
         return this.Passwordfield;
     }
    public JTextArea getAddressField(){
         return this.addressField;
     }
     public JTextField getPhoneNumberField(){
         return this.PhoneNofield;
     }
    public JComboBox<String> getGenderComboBox(){
         return this.genderComboBox1;
     }
    public JComboBox<String> getMartialStatusComboBoxField(){
         return this.martialStatusComboBox2;
     }
    public JDateChooser getDobDateChooser(){
         return this.jDateChooser1;
     }
    public JTextField getNameField(){
        return this.nameField;
    }
    public JButton getSaveUserBtn(){
        return saveUserBtn;
    }
    public JButton getPhotoAddBtn(){
        return photoAddBtn;
    }
    public JLabel getUserPhotoLabel(){
        return this.userPhotoLabel;
    }
    public JPanel getPhotoUploadedPanel(){
      return  this.photoUploadedPanel1;
    }
    
    
   
     
     
     
     //others methods
   /* public void setSidePanel(String role){
        if(getUserRole().equals("Admin")){
            getReceptionSidePanel().setVisible(false);
            getAdminSidePanel().setVisible(true);
            getPatientSidePanel().setVisible(false);
            getMoSidePanel().setVisible(false);
            
        }
        else if(getUserRole().equals("Receptionist")){
            getReceptionSidePanel().setVisible(true);
            getAdminSidePanel().setVisible(false);
              getPatientSidePanel().setVisible(false);
            getMoSidePanel().setVisible(false);
            

        }
        else if(getUserRole().equals("Patient")){
             getPatientSidePanel().setVisible(true);
            getMoSidePanel().setVisible(false);
            getReceptionSidePanel().setVisible(false);
            getAdminSidePanel().setVisible(false);

        }
        else if(getUserRole().equals("MedicalOfficer")){
            getPatientSidePanel().setVisible(false);
            getMoSidePanel().setVisible(true);
            getReceptionSidePanel().setVisible(false);
            getAdminSidePanel().setVisible(false);
            
           

        }
        
    }
    public void  setHome(){
         resetAllMainPanels();
        getHomePanel().setVisible(true);
        getComplaintsMainOptionPanel().setVisible(false);
        getAppoinmentsMainOptionsPanel().setVisible(false);
        getVisitorsMainOptionPanel().setVisible(false);
        getMailsMainOptionsPanel().setVisible(false);
        getUsersMainOptionsPanel().setVisible(false);
        getRefferenceOptionsMainPanel().setVisible(false);
       
    }
    public void setSideBarPanels(){
        getHomeBtnPanel1().addMouseListener(listener);
        getHomeBtnPanel2().addMouseListener(listener);
        getHomeBtnPanel3().addMouseListener(listener);
        getHomeBtnPanel4().addMouseListener(listener);
        getAppointmentBtnPanel4().addMouseListener(listener);
        getMoSettingBtnPanel().addMouseListener(listener);
        getAppointmentBtnPanel3().addMouseListener(listener);
        getComplaintBtnPanel2().addMouseListener(listener);
        getPatientSettingBtnPanel().addMouseListener(listener);
        getAppointmentBtnPanel2().addMouseListener(listener);
        getMailBtnPanel2().addMouseListener(listener);
        getComplaintBtnPanel1().addMouseListener(listener);
        getVisitorBtnPanel2().addMouseListener(listener);
        getReceptionistSettingBtnPanel().addMouseListener(listener);
        getUserBtnPanel2().addMouseListener(listener);
        getUserBtnPanel().addMouseListener(listener);
        getReportBtnPanel().addMouseListener(listener);
        getAppointmentBtnPanel1().addMouseListener(listener);
        getMailBtnPanel1().addMouseListener(listener);
        getComplaintBtnPanel3().addMouseListener(listener);
        getVisitorBtnPanel1().addMouseListener(listener);
        getAdminSettingBtnPanel().addMouseListener(listener);
        getRefferenceBtnPanel().addMouseListener(listener);
        
        getHomeBtnPanel1().setName("homeBtn");
        getHomeBtnPanel2().setName("homeBtn");
        getHomeBtnPanel3().setName("homeBtn");
        getHomeBtnPanel4().setName("homeBtn");
        
        getAppointmentBtnPanel2().setName("appointmentBtnPanel");//recep
        getAppointmentBtnPanel1().setName("appointmentBtnPanel");//admin
        getAppointmentBtnPanel4().setName("appointmentBtnPanel");
        getAppointmentBtnPanel3().setName("appointmentBtnPanel");
        
        getMailBtnPanel2().setName("mailBtn");
        getMailBtnPanel1().setName("mailBtn");
       
        
        getComplaintBtnPanel1().setName("complaintBtn");
        getComplaintBtnPanel2().setName("complaintBtn");
        getComplaintBtnPanel3().setName("complaintBtn");
        
         getVisitorBtnPanel2().setName("visitorBtn");
         getVisitorBtnPanel1().setName("visitorBtn");
        
        getAdminSettingBtnPanel().setName("settingBtn");
        getReceptionistSettingBtnPanel().setName("settingBtn");
        getMoSettingBtnPanel().setName("settingBtn");
        getPatientSettingBtnPanel().setName("settingBtn");
        
         getUserBtnPanel().setName("userBtn");
        getUserBtnPanel2().setName("userBtn");
        
        getReportBtnPanel().setName("reportBtn");
        
        getRefferenceBtnPanel().setName("refferenceBtn");
        
                  
        
    }
    MouseListener listener = new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        resetAllColor();
                        //
                     
                        System.out.println(((JPanel)e.getSource()).getName());
                     if( ((JPanel)e.getSource()).getName().equals("complaintBtn")){
                        setColor(getComplaintBtnPanel1());
                        setColor(getComplaintBtnPanel2());
                        setColor(getComplaintBtnPanel3());
                        setTables();
                        getHomePanel().setVisible(false);
                        getAppointmentPanel().setVisible(false);
                        getRefferencePanel().setVisible(false);                        
                        getMailPanel().setVisible(false);
                        getReportsPanel().setVisible(false);
                        getVisitorsPanel().setVisible(false);
                        getSettingsPanel().setVisible(false);
                        getUsersPanel().setVisible(false);
                        getComplaintPanel().setVisible(true);
                        getComplaintsMainOptionPanel().setVisible(true);
                        getAppoinmentsMainOptionsPanel().setVisible(false);
                        getVisitorsMainOptionPanel().setVisible(false);
                        getMailsMainOptionsPanel().setVisible(false);
                        getUsersMainOptionsPanel().setVisible(false);
                        getRefferenceOptionsMainPanel().setVisible(false);
                        setComplainOptions();

                         
                     }
                     else if(((JPanel)e.getSource()).getName().equals("appointmentBtnPanel")){
                        setColor(getAppointmentBtnPanel1());
                        setColor(getAppointmentBtnPanel2());
                        setColor(getAppointmentBtnPanel3());
                        setColor(getAppointmentBtnPanel4());
                        setTables();
                        getHomePanel().setVisible(false); 
                        getComplaintPanel().setVisible(false);
                        getRefferencePanel().setVisible(false);                        
                        getMailPanel().setVisible(false);
                        getReportsPanel().setVisible(false);
                        getVisitorsPanel().setVisible(false);
                        getSettingsPanel().setVisible(false);
                        getUsersPanel().setVisible(false);
                        getAppointmentPanel().setVisible(true);
    
                         getComplaintsMainOptionPanel().setVisible(false);
                        getAppoinmentsMainOptionsPanel().setVisible(true);
                        getVisitorsMainOptionPanel().setVisible(false);
                        getMailsMainOptionsPanel().setVisible(false);
                        getUsersMainOptionsPanel().setVisible(false);
                        getRefferenceOptionsMainPanel().setVisible(false);
                               

                        setAppointmentOptions();

                         
                     }
                     else if(((JPanel)e.getSource()).getName().equals("mailBtn")){
                        setColor(getMailBtnPanel1());
                        setColor(getMailBtnPanel2());
                        setTables();
                        getHomePanel().setVisible(false);
                        getAppointmentPanel().setVisible(false);
                        getComplaintPanel().setVisible(false);
                        getRefferencePanel().setVisible(false);                        
                        getReportsPanel().setVisible(false);
                        getVisitorsPanel().setVisible(false);
                        getSettingsPanel().setVisible(false);
                        getUsersPanel().setVisible(false);
                        getMailPanel().setVisible(true);
                        getComplaintsMainOptionPanel().setVisible(false);
                        getVisitorsMainOptionPanel().setVisible(false);
                        getAppoinmentsMainOptionsPanel().setVisible(false);
                        getMailsMainOptionsPanel().setVisible(true);
                        getUsersMainOptionsPanel().setVisible(false);
                        getRefferenceOptionsMainPanel().setVisible(false);
                        setMailOptions();

                         
                         
                     }
                     else if(((JPanel)e.getSource()).getName().equals("userBtn")){
                        setColor(getUserBtnPanel());
                        setColor(getUserBtnPanel2());
                        setTables();
                        getHomePanel().setVisible(false);
                        getAppointmentPanel().setVisible(false);
                        getComplaintPanel().setVisible(false);
                        getRefferencePanel().setVisible(false);                        
                        getMailPanel().setVisible(false);
                        getReportsPanel().setVisible(false);
                        getVisitorsPanel().setVisible(false);
                        getSettingsPanel().setVisible(false);
                        getUsersPanel().setVisible(true);
                        getComplaintsMainOptionPanel().setVisible(false);
                        getVisitorsMainOptionPanel().setVisible(false);
                        getAppoinmentsMainOptionsPanel().setVisible(false);
                        getMailsMainOptionsPanel().setVisible(false);
                        getUsersMainOptionsPanel().setVisible(true);
                        getRefferenceOptionsMainPanel().setVisible(false);
                        setUserOptions();
                         
                         
                     }
                     else if(((JPanel)e.getSource()).getName().equals("settingBtn")){
                        setColor(getAdminSettingBtnPanel());
                        setColor(getReceptionistSettingBtnPanel());
                        setColor(getMoSettingBtnPanel());
                        setTables();
                        setColor(getPatientSettingBtnPanel());
                        getHomePanel().setVisible(false);
                        getUsersPanel().setVisible(false);
                        getAppointmentPanel().setVisible(false);
                        getComplaintPanel().setVisible(false);
                        getRefferencePanel().setVisible(false);                        
                        getMailPanel().setVisible(false);
                        getReportsPanel().setVisible(false);
                        getVisitorsPanel().setVisible(false);
                        getSettingsPanel().setVisible(true);
                        loadUserDetails();
                        getComplaintsMainOptionPanel().setVisible(false);
                        getVisitorsMainOptionPanel().setVisible(false);
                        getAppoinmentsMainOptionsPanel().setVisible(false);
                        getMailsMainOptionsPanel().setVisible(false);
                        getUsersMainOptionsPanel().setVisible(false);
                        getRefferenceOptionsMainPanel().setVisible(false);
                          
                     }
                     else if(((JPanel)e.getSource()).getName().equals("visitorBtn")){
                        setTables();
                        setColor(getVisitorBtnPanel1());
                        setColor(getVisitorBtnPanel2());        
                        getHomePanel().setVisible(false);
                        getUsersPanel().setVisible(false);
                        getAppointmentPanel().setVisible(false);
                        getComplaintPanel().setVisible(false);
                        getRefferencePanel().setVisible(false);
                        getSettingsPanel().setVisible(false);
                        getMailPanel().setVisible(false);
                        getReportsPanel().setVisible(false);
                        getVisitorsPanel().setVisible(true);
                        getComplaintsMainOptionPanel().setVisible(false);
                        getVisitorsMainOptionPanel().setVisible(true);
                        getAppoinmentsMainOptionsPanel().setVisible(false);
                        getMailsMainOptionsPanel().setVisible(false);
                        getUsersMainOptionsPanel().setVisible(false);
                        getRefferenceOptionsMainPanel().setVisible(false);
                        setVisitorOptions();
                     }
                      else if(((JPanel)e.getSource()).getName().equals("refferenceBtn")){
                        setColor(getRefferenceBtnPanel());    
                        setTables();
                        setComplainRefference();
                        getHomePanel().setVisible(false);
                        getVisitorsPanel().setVisible(false);
                        getUsersPanel().setVisible(false);
                        getAppointmentPanel().setVisible(false);
                        getComplaintPanel().setVisible(false);
                        getSettingsPanel().setVisible(false);
                        getMailPanel().setVisible(false);
                        getReportsPanel().setVisible(false);
                        getRefferencePanel().setVisible(true);
                        getComplaintsMainOptionPanel().setVisible(false);
                        getVisitorsMainOptionPanel().setVisible(false);
                        getMailPanel().setVisible(false);
                        getAppoinmentsMainOptionsPanel().setVisible(false);
                        getUsersMainOptionsPanel().setVisible(false);
                        getRefferenceOptionsMainPanel().setVisible(true);
                        setRefferenceOption();
                     }
                      else if(((JPanel)e.getSource()).getName().equals("reportBtn")){
                        setColor(getReportBtnPanel());
                        setTables();
                        getHomePanel().setVisible(false);
                        getVisitorsPanel().setVisible(false);
                        getUsersPanel().setVisible(false);
                        getAppointmentPanel().setVisible(false);
                        getComplaintPanel().setVisible(false);
                        getRefferencePanel().setVisible(false);
                        getSettingsPanel().setVisible(false);
                        getMailPanel().setVisible(false);
                        getReportsPanel().setVisible(true); 
                        getMailPanel().setVisible(false);
                        getComplaintsMainOptionPanel().setVisible(false);
                        getVisitorsMainOptionPanel().setVisible(false);
                        getAppoinmentsMainOptionsPanel().setVisible(false);
                        getUsersMainOptionsPanel().setVisible(false);
                        getRefferenceOptionsMainPanel().setVisible(false);
                        setMoComboBox();
                        setReportOptions();
                     }
                     else if(((JPanel)e.getSource()).getName().equals("homeBtn")){
                        setColor(getHomeBtnPanel1());
                        setColor(getHomeBtnPanel2());
                        setColor(getHomeBtnPanel3());
                        setColor(getHomeBtnPanel4());
                        setTables();
                        
                          
                        getVisitorsPanel().setVisible(false);
                        getUsersPanel().setVisible(false);
                        getAppointmentPanel().setVisible(false);
                        getComplaintPanel().setVisible(false);
                        getRefferencePanel().setVisible(false);
                        getSettingsPanel().setVisible(false);
                        getMailPanel().setVisible(false);
                        getReportsPanel().setVisible(false);
                        getHomePanel().setVisible(true);
                        getComplaintsMainOptionPanel().setVisible(false);
                        getVisitorsMainOptionPanel().setVisible(false);
                        getAppoinmentsMainOptionsPanel().setVisible(false);
                        getMailsMainOptionsPanel().setVisible(false);
                        getUsersMainOptionsPanel().setVisible(false);
                        getRefferenceOptionsMainPanel().setVisible(false);
                         
                     } 
                     
                    }
                };
    
    */
   
    /* public void loadUserDetails(){
       
       User user=CurrentUser.getUser();
       System.out.println("user "+user.toString2());
       getUserNameField().setText(user.getUserName());
       getPasswordField().setText(user.getPassword());
        getPhoneNumberField().setText(user.getphoneNumber());
        getNameField().setText(user.getName());
        getNicField().setText(user.getIdCardNo());
        getGenderComboBox().setSelectedItem(user.getGender());
        getMartialStatusComboBoxField().setSelectedItem(user.getMaritalStatus());
        getAddressField().setText(user.getAddress());
        Date dob=PipeService.getStringToDateFormat(user.getDateOfBirth());
         getDobDateChooser().setDate(dob);
        
         
         

     }*/
   /*  public  void saveUser(){
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
         
         
        CurrentUser.getUser().setIdCardNo(getNicField().getText());
        CurrentUser.getUser().setGender(getGenderComboBox().getSelectedItem().toString());
        CurrentUser.getUser().setName(getNameField().getText());
        CurrentUser.getUser().setUserName(getUserNameField().getText());
        CurrentUser.getUser().setMaritalStatus(getMartialStatusComboBoxField().getSelectedItem().toString());
        CurrentUser.getUser().setAddress(getAddressField().getText());
        CurrentUser.getUser().setStrPassword(getPasswordField().getText());
        CurrentUser.getUser().setphoneNumber(getPhoneNumberField().getText());
        CurrentUser.getUser().setDateOfBirth(PipeService.getDateSimpleFormat(getDobDateChooser().getDate()));
         
         FileService.addLine(path,  CurrentUser.getUser().toString2());
     }*/
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        bgPanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        adminSidePanel = new javax.swing.JPanel();
        profileImg = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        appointmentBtnPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mailBtnPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        complaintBtnPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        reportBtnPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        visitorBtnPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        homeBtnPanel1 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        userBtnPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        refferenceBtnPanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        logOutBtnPanel1 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        userNameLabel = new javax.swing.JLabel();
        patientSidePanel = new javax.swing.JPanel();
        profileImg1 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        appointmentBtnPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        complaintBtnPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        homeBtnPanel3 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        logOutBtnPanel2 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        userNameLabel1 = new javax.swing.JLabel();
        patientSettingBtnPanel = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        moSidePanel = new javax.swing.JPanel();
        profileImg2 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        homeBtnPanel2 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        logOutBtnPanel3 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        appointmentBtnPanel4 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        userNameLabel2 = new javax.swing.JLabel();
        moSettingBtnPanel = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        receptionSidePanel = new javax.swing.JPanel();
        profileImg3 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        appointmentBtnPanel2 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        mailBtnPanel2 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        complaintBtnPanel3 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        visitorBtnPanel2 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        userBtnPanel2 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        homeBtnPanel4 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        logOutBtnPanel4 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        userNameLabel3 = new javax.swing.JLabel();
        receptionistSettingBtnPanel = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        appointmentPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        appointmentTable = new javax.swing.JTable();
        visitorsPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        visitorTable = new javax.swing.JTable();
        mailPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dispatchedMailTable = new javax.swing.JTable();
        complaintPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        complaintTable = new javax.swing.JTable();
        reportsPanel = new javax.swing.JPanel();
        appoinmentReportPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        appointmentReportTable = new javax.swing.JTable();
        appoinmentReportPdfBtn = new javax.swing.JButton();
        appointmentReportCsvBtn = new javax.swing.JButton();
        appointmentReportDateChooser = new com.toedter.calendar.JDateChooser();
        appointmentReportMoComboBox = new javax.swing.JComboBox<>();
        appointmentReportPrepareBtn = new javax.swing.JButton();
        userLogReportPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        userLogReportTable = new javax.swing.JTable();
        userLoginReportDateChooser3 = new com.toedter.calendar.JDateChooser();
        userLoginReportComboBox = new javax.swing.JComboBox<>();
        userLogReportPdfBtn = new javax.swing.JButton();
        userLogReportCsvBtn = new javax.swing.JButton();
        userLogPrepareBtn = new javax.swing.JButton();
        patientCreditialReportPanel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        patientCredintialTable = new javax.swing.JTable();
        patientCredintialPdfBtn = new javax.swing.JButton();
        patientCredintialCsvBtn = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        userLogReportOptionPanel = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        appointmentReportOptionPanel = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        patientCredentialReportOptionPanel = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        refferencePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        specialityReferenceOptionPanel = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        complainReferenceOptionPanel = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        specialityListPanel = new javax.swing.JPanel();
        complaintReferencejScrollPanel = new javax.swing.JScrollPane();
        complainRefferenceList = new javax.swing.JList<>();
        specialityReferenceJScrollPanel = new javax.swing.JScrollPane();
        specialityRefferenceList = new javax.swing.JList<>();
        settingsPanel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        genderComboBox1 = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel60 = new javax.swing.JLabel();
        PhoneNofield = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        nicField = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        martialStatusComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        addressField = new javax.swing.JTextArea();
        saveUserBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        Passwordfield = new javax.swing.JTextField();
        photoUploadedPanel1 = new javax.swing.JPanel();
        userPhotoLabel = new javax.swing.JLabel();
        photoAddBtn = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        usersPanel = new javax.swing.JPanel();
        moScrollPanel = new javax.swing.JScrollPane();
        moTable = new javax.swing.JTable();
        patientScrollPanel = new javax.swing.JScrollPane();
        patientsTable = new javax.swing.JTable();
        receptionistScrollPanel = new javax.swing.JScrollPane();
        receptionistTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        appointmentMainOption = new javax.swing.JPanel();
        adminAppointmentOptions = new javax.swing.JPanel();
        deleteAppointmentBtn = new javax.swing.JButton();
        receptionAppointmentOptions = new javax.swing.JPanel();
        approveAppoinmentBtn = new javax.swing.JButton();
        addAppointmentBtn = new javax.swing.JButton();
        generatePdfBtn = new javax.swing.JButton();
        editAppointmentBtn = new javax.swing.JButton();
        patientAppointmentOptions = new javax.swing.JPanel();
        addAppointmentBtn2 = new javax.swing.JButton();
        moAppointmentOptions = new javax.swing.JPanel();
        completedAppointmentBtn = new javax.swing.JButton();
        usersMainOption = new javax.swing.JPanel();
        adminUserOptions = new javax.swing.JPanel();
        deleteUsersBtn = new javax.swing.JButton();
        editUsersBtn = new javax.swing.JButton();
        resetPasswordBtn = new javax.swing.JButton();
        addUsersBtn = new javax.swing.JButton();
        receptionistUserOptions = new javax.swing.JPanel();
        deleteUsersBtn2 = new javax.swing.JButton();
        editUsersBtn2 = new javax.swing.JButton();
        addUsersBtn2 = new javax.swing.JButton();
        resetPasswordBtn2 = new javax.swing.JButton();
        mailMainOption = new javax.swing.JPanel();
        adminMailOptions = new javax.swing.JPanel();
        deleteMailBtn = new javax.swing.JButton();
        receptionMailOptions = new javax.swing.JPanel();
        deleteMailBtn2 = new javax.swing.JButton();
        editMailBtn = new javax.swing.JButton();
        addMailBtn = new javax.swing.JButton();
        complaintsMainOption = new javax.swing.JPanel();
        adminComplaintOptions = new javax.swing.JPanel();
        deleteComplaintBtn = new javax.swing.JButton();
        editComplaintBtn = new javax.swing.JButton();
        approveComplaintBtn = new javax.swing.JButton();
        patientComplaintOptions = new javax.swing.JPanel();
        addComplaintBtn2 = new javax.swing.JButton();
        receptionistComplaintOptions = new javax.swing.JPanel();
        addComplaintBtn = new javax.swing.JButton();
        visitorsMainOption = new javax.swing.JPanel();
        receptionistVisitorOptions = new javax.swing.JPanel();
        deleteVisitorBtn = new javax.swing.JButton();
        editVisitorBtn = new javax.swing.JButton();
        addVisitorBtn = new javax.swing.JButton();
        adminVisitorOptions = new javax.swing.JPanel();
        deleteVisitorBtn2 = new javax.swing.JButton();
        refferenceMainOption = new javax.swing.JPanel();
        adminRefferenceOptions = new javax.swing.JPanel();
        deleteReferenceBtn = new javax.swing.JButton();
        editReferenceBtn = new javax.swing.JButton();
        addReferenceBtn = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homePanel.setBackground(new java.awt.Color(153, 153, 153));
        homePanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel24.setText("HOME PANEL");

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(562, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(532, Short.MAX_VALUE))
        );

        bgPanel.add(homePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, -1));

        adminSidePanel.setBackground(new java.awt.Color(54, 33, 89));

        profileImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/old/DOCTORDETAILS (2).png"))); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setForeground(new java.awt.Color(54, 33, 89));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appointmentBtnPanel1.setBackground(new java.awt.Color(64, 43, 100));
        appointmentBtnPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Appointments");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/calendar 32.png"))); // NOI18N

        javax.swing.GroupLayout appointmentBtnPanel1Layout = new javax.swing.GroupLayout(appointmentBtnPanel1);
        appointmentBtnPanel1.setLayout(appointmentBtnPanel1Layout);
        appointmentBtnPanel1Layout.setHorizontalGroup(
            appointmentBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentBtnPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        appointmentBtnPanel1Layout.setVerticalGroup(
            appointmentBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appointmentBtnPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.add(appointmentBtnPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 250, 50));

        mailBtnPanel1.setBackground(new java.awt.Color(64, 43, 100));
        mailBtnPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mail");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/mail_configuration_24px.png"))); // NOI18N

        javax.swing.GroupLayout mailBtnPanel1Layout = new javax.swing.GroupLayout(mailBtnPanel1);
        mailBtnPanel1.setLayout(mailBtnPanel1Layout);
        mailBtnPanel1Layout.setHorizontalGroup(
            mailBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mailBtnPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        mailBtnPanel1Layout.setVerticalGroup(
            mailBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mailBtnPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mailBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(mailBtnPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 250, 50));

        complaintBtnPanel1.setBackground(new java.awt.Color(64, 43, 100));
        complaintBtnPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Complaints");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/complaint_32px.png"))); // NOI18N

        javax.swing.GroupLayout complaintBtnPanel1Layout = new javax.swing.GroupLayout(complaintBtnPanel1);
        complaintBtnPanel1.setLayout(complaintBtnPanel1Layout);
        complaintBtnPanel1Layout.setHorizontalGroup(
            complaintBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaintBtnPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        complaintBtnPanel1Layout.setVerticalGroup(
            complaintBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaintBtnPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(complaintBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(complaintBtnPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 250, 50));

        reportBtnPanel.setBackground(new java.awt.Color(64, 43, 100));
        reportBtnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Reports");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/resume_30px.png"))); // NOI18N

        javax.swing.GroupLayout reportBtnPanelLayout = new javax.swing.GroupLayout(reportBtnPanel);
        reportBtnPanel.setLayout(reportBtnPanelLayout);
        reportBtnPanelLayout.setHorizontalGroup(
            reportBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportBtnPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        reportBtnPanelLayout.setVerticalGroup(
            reportBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reportBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(reportBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 250, 50));

        visitorBtnPanel1.setBackground(new java.awt.Color(64, 43, 100));
        visitorBtnPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Visitors");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/myspace_app_24px.png"))); // NOI18N

        javax.swing.GroupLayout visitorBtnPanel1Layout = new javax.swing.GroupLayout(visitorBtnPanel1);
        visitorBtnPanel1.setLayout(visitorBtnPanel1Layout);
        visitorBtnPanel1Layout.setHorizontalGroup(
            visitorBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visitorBtnPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        visitorBtnPanel1Layout.setVerticalGroup(
            visitorBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visitorBtnPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(visitorBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(visitorBtnPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 250, 50));

        homeBtnPanel1.setBackground(new java.awt.Color(85, 65, 118));
        homeBtnPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Home");

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/home_32px.png"))); // NOI18N

        javax.swing.GroupLayout homeBtnPanel1Layout = new javax.swing.GroupLayout(homeBtnPanel1);
        homeBtnPanel1.setLayout(homeBtnPanel1Layout);
        homeBtnPanel1Layout.setHorizontalGroup(
            homeBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBtnPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        homeBtnPanel1Layout.setVerticalGroup(
            homeBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBtnPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homeBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(homeBtnPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 50));

        userBtnPanel.setBackground(new java.awt.Color(64, 43, 100));
        userBtnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Users");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new/user2.png"))); // NOI18N

        javax.swing.GroupLayout userBtnPanelLayout = new javax.swing.GroupLayout(userBtnPanel);
        userBtnPanel.setLayout(userBtnPanelLayout);
        userBtnPanelLayout.setHorizontalGroup(
            userBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userBtnPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        userBtnPanelLayout.setVerticalGroup(
            userBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68))
        );

        jPanel8.add(userBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 50));

        refferenceBtnPanel.setBackground(new java.awt.Color(64, 43, 100));
        refferenceBtnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Refference");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/documents_30px.png"))); // NOI18N

        javax.swing.GroupLayout refferenceBtnPanelLayout = new javax.swing.GroupLayout(refferenceBtnPanel);
        refferenceBtnPanel.setLayout(refferenceBtnPanelLayout);
        refferenceBtnPanelLayout.setHorizontalGroup(
            refferenceBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refferenceBtnPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        refferenceBtnPanelLayout.setVerticalGroup(
            refferenceBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refferenceBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(refferenceBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(refferenceBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 250, 50));

        logOutBtnPanel1.setBackground(new java.awt.Color(64, 43, 100));
        logOutBtnPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        logOutBtnPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logOutBtnPanel1MousePressed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Log-Out");

        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout logOutBtnPanel1Layout = new javax.swing.GroupLayout(logOutBtnPanel1);
        logOutBtnPanel1.setLayout(logOutBtnPanel1Layout);
        logOutBtnPanel1Layout.setHorizontalGroup(
            logOutBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logOutBtnPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        logOutBtnPanel1Layout.setVerticalGroup(
            logOutBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logOutBtnPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logOutBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(logOutBtnPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 250, 50));

        javax.swing.GroupLayout adminSidePanelLayout = new javax.swing.GroupLayout(adminSidePanel);
        adminSidePanel.setLayout(adminSidePanelLayout);
        adminSidePanelLayout.setHorizontalGroup(
            adminSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminSidePanelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(adminSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(adminSidePanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(profileImg)))
                .addGap(28, 28, 28))
            .addGroup(adminSidePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(userNameLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        adminSidePanelLayout.setVerticalGroup(
            adminSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminSidePanelLayout.createSequentialGroup()
                .addComponent(profileImg, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(userNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(333, Short.MAX_VALUE))
        );

        bgPanel.add(adminSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 1000));

        patientSidePanel.setBackground(new java.awt.Color(54, 33, 89));

        profileImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/old/DOCTORDETAILS (2).png"))); // NOI18N

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setForeground(new java.awt.Color(54, 33, 89));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appointmentBtnPanel3.setBackground(new java.awt.Color(64, 43, 100));
        appointmentBtnPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Appointments");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/calendar 32.png"))); // NOI18N

        javax.swing.GroupLayout appointmentBtnPanel3Layout = new javax.swing.GroupLayout(appointmentBtnPanel3);
        appointmentBtnPanel3.setLayout(appointmentBtnPanel3Layout);
        appointmentBtnPanel3Layout.setHorizontalGroup(
            appointmentBtnPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentBtnPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        appointmentBtnPanel3Layout.setVerticalGroup(
            appointmentBtnPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appointmentBtnPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel15.add(appointmentBtnPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 50));

        complaintBtnPanel2.setBackground(new java.awt.Color(64, 43, 100));
        complaintBtnPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Complaints");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/complaint_32px.png"))); // NOI18N

        javax.swing.GroupLayout complaintBtnPanel2Layout = new javax.swing.GroupLayout(complaintBtnPanel2);
        complaintBtnPanel2.setLayout(complaintBtnPanel2Layout);
        complaintBtnPanel2Layout.setHorizontalGroup(
            complaintBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaintBtnPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        complaintBtnPanel2Layout.setVerticalGroup(
            complaintBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaintBtnPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(complaintBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel15.add(complaintBtnPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 250, 50));

        homeBtnPanel3.setBackground(new java.awt.Color(85, 65, 118));
        homeBtnPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Home");

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new/user2.png"))); // NOI18N

        javax.swing.GroupLayout homeBtnPanel3Layout = new javax.swing.GroupLayout(homeBtnPanel3);
        homeBtnPanel3.setLayout(homeBtnPanel3Layout);
        homeBtnPanel3Layout.setHorizontalGroup(
            homeBtnPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBtnPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        homeBtnPanel3Layout.setVerticalGroup(
            homeBtnPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBtnPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homeBtnPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel15.add(homeBtnPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 50));

        logOutBtnPanel2.setBackground(new java.awt.Color(64, 43, 100));
        logOutBtnPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel69.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Log-Out");

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout logOutBtnPanel2Layout = new javax.swing.GroupLayout(logOutBtnPanel2);
        logOutBtnPanel2.setLayout(logOutBtnPanel2Layout);
        logOutBtnPanel2Layout.setHorizontalGroup(
            logOutBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logOutBtnPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        logOutBtnPanel2Layout.setVerticalGroup(
            logOutBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logOutBtnPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logOutBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel15.add(logOutBtnPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 250, 50));

        patientSettingBtnPanel.setBackground(new java.awt.Color(64, 43, 100));
        patientSettingBtnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout patientSettingBtnPanelLayout = new javax.swing.GroupLayout(patientSettingBtnPanel);
        patientSettingBtnPanel.setLayout(patientSettingBtnPanelLayout);
        patientSettingBtnPanelLayout.setHorizontalGroup(
            patientSettingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientSettingBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        patientSettingBtnPanelLayout.setVerticalGroup(
            patientSettingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout patientSidePanelLayout = new javax.swing.GroupLayout(patientSidePanel);
        patientSidePanel.setLayout(patientSidePanelLayout);
        patientSidePanelLayout.setHorizontalGroup(
            patientSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patientSidePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(patientSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(patientSidePanelLayout.createSequentialGroup()
                        .addComponent(profileImg1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patientSettingBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(patientSidePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(userNameLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        patientSidePanelLayout.setVerticalGroup(
            patientSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientSidePanelLayout.createSequentialGroup()
                .addGroup(patientSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(patientSidePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(patientSettingBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(userNameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(453, Short.MAX_VALUE))
        );

        bgPanel.add(patientSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 250, -1));

        moSidePanel.setBackground(new java.awt.Color(54, 33, 89));

        profileImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/old/DOCTORDETAILS (2).png"))); // NOI18N

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setForeground(new java.awt.Color(54, 33, 89));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeBtnPanel2.setBackground(new java.awt.Color(85, 65, 118));
        homeBtnPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Home");

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new/user2.png"))); // NOI18N

        javax.swing.GroupLayout homeBtnPanel2Layout = new javax.swing.GroupLayout(homeBtnPanel2);
        homeBtnPanel2.setLayout(homeBtnPanel2Layout);
        homeBtnPanel2Layout.setHorizontalGroup(
            homeBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBtnPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        homeBtnPanel2Layout.setVerticalGroup(
            homeBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBtnPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homeBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel22.add(homeBtnPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 50));

        logOutBtnPanel3.setBackground(new java.awt.Color(64, 43, 100));
        logOutBtnPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        logOutBtnPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logOutBtnPanel3MousePressed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Log-Out");

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/LogOut32px.png"))); // NOI18N

        javax.swing.GroupLayout logOutBtnPanel3Layout = new javax.swing.GroupLayout(logOutBtnPanel3);
        logOutBtnPanel3.setLayout(logOutBtnPanel3Layout);
        logOutBtnPanel3Layout.setHorizontalGroup(
            logOutBtnPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logOutBtnPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel71)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        logOutBtnPanel3Layout.setVerticalGroup(
            logOutBtnPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logOutBtnPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel72)
                .addContainerGap())
            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel22.add(logOutBtnPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 250, 50));

        appointmentBtnPanel4.setBackground(new java.awt.Color(64, 43, 100));
        appointmentBtnPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Appoinments");

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/calendar 32.png"))); // NOI18N

        javax.swing.GroupLayout appointmentBtnPanel4Layout = new javax.swing.GroupLayout(appointmentBtnPanel4);
        appointmentBtnPanel4.setLayout(appointmentBtnPanel4Layout);
        appointmentBtnPanel4Layout.setHorizontalGroup(
            appointmentBtnPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentBtnPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        appointmentBtnPanel4Layout.setVerticalGroup(
            appointmentBtnPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appointmentBtnPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addContainerGap())
            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel22.add(appointmentBtnPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 50));

        moSettingBtnPanel.setBackground(new java.awt.Color(54, 33, 89));
        moSettingBtnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout moSettingBtnPanelLayout = new javax.swing.GroupLayout(moSettingBtnPanel);
        moSettingBtnPanel.setLayout(moSettingBtnPanelLayout);
        moSettingBtnPanelLayout.setHorizontalGroup(
            moSettingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moSettingBtnPanelLayout.createSequentialGroup()
                .addComponent(jLabel40)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        moSettingBtnPanelLayout.setVerticalGroup(
            moSettingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moSettingBtnPanelLayout.createSequentialGroup()
                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout moSidePanelLayout = new javax.swing.GroupLayout(moSidePanel);
        moSidePanel.setLayout(moSidePanelLayout);
        moSidePanelLayout.setHorizontalGroup(
            moSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moSidePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(moSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(moSidePanelLayout.createSequentialGroup()
                        .addComponent(profileImg2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(moSettingBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
            .addGroup(moSidePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(userNameLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        moSidePanelLayout.setVerticalGroup(
            moSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moSidePanelLayout.createSequentialGroup()
                .addGroup(moSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(moSidePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(moSettingBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(userNameLabel2)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(522, Short.MAX_VALUE))
        );

        bgPanel.add(moSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, -1));

        receptionSidePanel.setBackground(new java.awt.Color(54, 33, 89));

        profileImg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/old/DOCTORDETAILS (2).png"))); // NOI18N

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setForeground(new java.awt.Color(54, 33, 89));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appointmentBtnPanel2.setBackground(new java.awt.Color(64, 43, 100));
        appointmentBtnPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Appointments");

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/calendar 32.png"))); // NOI18N

        javax.swing.GroupLayout appointmentBtnPanel2Layout = new javax.swing.GroupLayout(appointmentBtnPanel2);
        appointmentBtnPanel2.setLayout(appointmentBtnPanel2Layout);
        appointmentBtnPanel2Layout.setHorizontalGroup(
            appointmentBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentBtnPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        appointmentBtnPanel2Layout.setVerticalGroup(
            appointmentBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appointmentBtnPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addContainerGap())
            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel30.add(appointmentBtnPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 250, 50));

        mailBtnPanel2.setBackground(new java.awt.Color(64, 43, 100));
        mailBtnPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Mail");

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/mail_configuration_24px.png"))); // NOI18N

        javax.swing.GroupLayout mailBtnPanel2Layout = new javax.swing.GroupLayout(mailBtnPanel2);
        mailBtnPanel2.setLayout(mailBtnPanel2Layout);
        mailBtnPanel2Layout.setHorizontalGroup(
            mailBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mailBtnPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        mailBtnPanel2Layout.setVerticalGroup(
            mailBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mailBtnPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mailBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel30.add(mailBtnPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 250, 50));

        complaintBtnPanel3.setBackground(new java.awt.Color(64, 43, 100));
        complaintBtnPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel47.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Complaints");

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/complaint_32px.png"))); // NOI18N

        javax.swing.GroupLayout complaintBtnPanel3Layout = new javax.swing.GroupLayout(complaintBtnPanel3);
        complaintBtnPanel3.setLayout(complaintBtnPanel3Layout);
        complaintBtnPanel3Layout.setHorizontalGroup(
            complaintBtnPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaintBtnPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        complaintBtnPanel3Layout.setVerticalGroup(
            complaintBtnPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaintBtnPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(complaintBtnPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel30.add(complaintBtnPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 250, 50));

        visitorBtnPanel2.setBackground(new java.awt.Color(64, 43, 100));
        visitorBtnPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel51.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Visitors");

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/myspace_app_24px.png"))); // NOI18N

        javax.swing.GroupLayout visitorBtnPanel2Layout = new javax.swing.GroupLayout(visitorBtnPanel2);
        visitorBtnPanel2.setLayout(visitorBtnPanel2Layout);
        visitorBtnPanel2Layout.setHorizontalGroup(
            visitorBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visitorBtnPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        visitorBtnPanel2Layout.setVerticalGroup(
            visitorBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visitorBtnPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(visitorBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel30.add(visitorBtnPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 250, 50));

        userBtnPanel2.setBackground(new java.awt.Color(64, 43, 100));
        userBtnPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel55.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Users");

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new/user2.png"))); // NOI18N

        javax.swing.GroupLayout userBtnPanel2Layout = new javax.swing.GroupLayout(userBtnPanel2);
        userBtnPanel2.setLayout(userBtnPanel2Layout);
        userBtnPanel2Layout.setHorizontalGroup(
            userBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userBtnPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        userBtnPanel2Layout.setVerticalGroup(
            userBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userBtnPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userBtnPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel30.add(userBtnPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 50));

        homeBtnPanel4.setBackground(new java.awt.Color(85, 65, 118));
        homeBtnPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel57.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Home");

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/home_32px1.png"))); // NOI18N

        javax.swing.GroupLayout homeBtnPanel4Layout = new javax.swing.GroupLayout(homeBtnPanel4);
        homeBtnPanel4.setLayout(homeBtnPanel4Layout);
        homeBtnPanel4Layout.setHorizontalGroup(
            homeBtnPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBtnPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        homeBtnPanel4Layout.setVerticalGroup(
            homeBtnPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBtnPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homeBtnPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel30.add(homeBtnPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 50));

        logOutBtnPanel4.setBackground(new java.awt.Color(64, 43, 100));
        logOutBtnPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        logOutBtnPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logOutBtnPanel4MousePressed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Log-Out");

        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout logOutBtnPanel4Layout = new javax.swing.GroupLayout(logOutBtnPanel4);
        logOutBtnPanel4.setLayout(logOutBtnPanel4Layout);
        logOutBtnPanel4Layout.setHorizontalGroup(
            logOutBtnPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logOutBtnPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        logOutBtnPanel4Layout.setVerticalGroup(
            logOutBtnPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logOutBtnPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logOutBtnPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel30.add(logOutBtnPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 250, 50));

        receptionistSettingBtnPanel.setBackground(new java.awt.Color(64, 43, 100));
        receptionistSettingBtnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout receptionistSettingBtnPanelLayout = new javax.swing.GroupLayout(receptionistSettingBtnPanel);
        receptionistSettingBtnPanel.setLayout(receptionistSettingBtnPanelLayout);
        receptionistSettingBtnPanelLayout.setHorizontalGroup(
            receptionistSettingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionistSettingBtnPanelLayout.createSequentialGroup()
                .addComponent(jLabel54)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        receptionistSettingBtnPanelLayout.setVerticalGroup(
            receptionistSettingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout receptionSidePanelLayout = new javax.swing.GroupLayout(receptionSidePanel);
        receptionSidePanel.setLayout(receptionSidePanelLayout);
        receptionSidePanelLayout.setHorizontalGroup(
            receptionSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receptionSidePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(receptionSidePanelLayout.createSequentialGroup()
                .addGroup(receptionSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receptionSidePanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(userNameLabel3))
                    .addGroup(receptionSidePanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(profileImg3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(receptionistSettingBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        receptionSidePanelLayout.setVerticalGroup(
            receptionSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionSidePanelLayout.createSequentialGroup()
                .addGroup(receptionSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receptionSidePanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(receptionistSettingBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receptionSidePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(profileImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(userNameLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(383, Short.MAX_VALUE))
        );

        bgPanel.add(receptionSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 250, -1));

        appointmentPanel.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane1.setBorder(null);

        appointmentTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        appointmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Appointment No", "Date", "Time", "Status", "Patient Name", "Patient Id", "Medical Officer", "Speciality", "Sysmtomps", "Medical Officer Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        appointmentTable.setGridColor(new java.awt.Color(255, 255, 255));
        appointmentTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
        appointmentTable.setRowHeight(20);
        appointmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                appointmentTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(appointmentTable);
        if (appointmentTable.getColumnModel().getColumnCount() > 0) {
            appointmentTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            appointmentTable.getColumnModel().getColumn(1).setPreferredWidth(70);
            appointmentTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            appointmentTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            appointmentTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            appointmentTable.getColumnModel().getColumn(8).setPreferredWidth(120);
            appointmentTable.getColumnModel().getColumn(9).setPreferredWidth(120);
        }

        javax.swing.GroupLayout appointmentPanelLayout = new javax.swing.GroupLayout(appointmentPanel);
        appointmentPanel.setLayout(appointmentPanelLayout);
        appointmentPanelLayout.setHorizontalGroup(
            appointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                .addContainerGap())
        );
        appointmentPanelLayout.setVerticalGroup(
            appointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(481, Short.MAX_VALUE))
        );

        bgPanel.add(appointmentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 1090, 860));

        visitorsPanel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel17.setText("visitor table");

        jScrollPane5.setBorder(null);

        visitorTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        visitorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Date", "Id Card No", "Name", "Purpose", "Mobile", "In-Time", "Out-Time", "Note", "Attachment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        visitorTable.setGridColor(new java.awt.Color(255, 255, 255));
        visitorTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
        visitorTable.setRowHeight(20);
        visitorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                visitorTableMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(visitorTable);
        if (visitorTable.getColumnModel().getColumnCount() > 0) {
            visitorTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            visitorTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            visitorTable.getColumnModel().getColumn(3).setPreferredWidth(130);
            visitorTable.getColumnModel().getColumn(4).setPreferredWidth(130);
            visitorTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        javax.swing.GroupLayout visitorsPanelLayout = new javax.swing.GroupLayout(visitorsPanel);
        visitorsPanel.setLayout(visitorsPanelLayout);
        visitorsPanelLayout.setHorizontalGroup(
            visitorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visitorsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(visitorsPanelLayout.createSequentialGroup()
                .addGap(412, 412, 412)
                .addComponent(jLabel17)
                .addContainerGap(593, Short.MAX_VALUE))
        );
        visitorsPanelLayout.setVerticalGroup(
            visitorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visitorsPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(478, Short.MAX_VALUE))
        );

        bgPanel.add(visitorsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 1090, 860));

        mailPanel.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane2.setBorder(null);

        dispatchedMailTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        dispatchedMailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Refference No", "Date", "To Name", "Address", "Note", "Attachment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        dispatchedMailTable.setGridColor(new java.awt.Color(255, 255, 255));
        dispatchedMailTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
        dispatchedMailTable.setRowHeight(20);
        dispatchedMailTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dispatchedMailTableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(dispatchedMailTable);
        if (dispatchedMailTable.getColumnModel().getColumnCount() > 0) {
            dispatchedMailTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            dispatchedMailTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            dispatchedMailTable.getColumnModel().getColumn(3).setPreferredWidth(130);
            dispatchedMailTable.getColumnModel().getColumn(4).setPreferredWidth(130);
        }

        javax.swing.GroupLayout mailPanelLayout = new javax.swing.GroupLayout(mailPanel);
        mailPanel.setLayout(mailPanelLayout);
        mailPanelLayout.setHorizontalGroup(
            mailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                .addContainerGap())
        );
        mailPanelLayout.setVerticalGroup(
            mailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mailPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(470, Short.MAX_VALUE))
        );

        bgPanel.add(mailPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 1090, 860));

        complaintPanel.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane3.setBorder(null);

        complaintTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        complaintTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "type", "Date", "Patient Name", "Mobile", "Description", "Action", "Note", "Attachment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        complaintTable.setGridColor(new java.awt.Color(255, 255, 255));
        complaintTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
        complaintTable.setRowHeight(20);
        complaintTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                complaintTableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(complaintTable);
        if (complaintTable.getColumnModel().getColumnCount() > 0) {
            complaintTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            complaintTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            complaintTable.getColumnModel().getColumn(4).setPreferredWidth(130);
            complaintTable.getColumnModel().getColumn(5).setPreferredWidth(130);
            complaintTable.getColumnModel().getColumn(6).setPreferredWidth(130);
            complaintTable.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        javax.swing.GroupLayout complaintPanelLayout = new javax.swing.GroupLayout(complaintPanel);
        complaintPanel.setLayout(complaintPanelLayout);
        complaintPanelLayout.setHorizontalGroup(
            complaintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaintPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                .addContainerGap())
        );
        complaintPanelLayout.setVerticalGroup(
            complaintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaintPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(478, Short.MAX_VALUE))
        );

        bgPanel.add(complaintPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 1090, 860));

        reportsPanel.setBackground(new java.awt.Color(204, 204, 204));
        reportsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBorder(null);

        appointmentReportTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        appointmentReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Appointment No", "Status", "Patient Name", "Id Card No", "Date", "Time", "Medical Officer", "Speciality", "Sysmtomps"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        appointmentReportTable.setGridColor(new java.awt.Color(255, 255, 255));
        appointmentReportTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
        appointmentReportTable.setRowHeight(20);
        appointmentReportTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                appointmentReportTableMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(appointmentReportTable);
        if (appointmentReportTable.getColumnModel().getColumnCount() > 0) {
            appointmentReportTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            appointmentReportTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            appointmentReportTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            appointmentReportTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            appointmentReportTable.getColumnModel().getColumn(3).setHeaderValue("Id Card No");
            appointmentReportTable.getColumnModel().getColumn(4).setPreferredWidth(130);
            appointmentReportTable.getColumnModel().getColumn(4).setHeaderValue("Date");
            appointmentReportTable.getColumnModel().getColumn(5).setResizable(false);
            appointmentReportTable.getColumnModel().getColumn(5).setHeaderValue("Time");
            appointmentReportTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            appointmentReportTable.getColumnModel().getColumn(6).setHeaderValue("Medical Officer");
            appointmentReportTable.getColumnModel().getColumn(7).setHeaderValue("Speciality");
            appointmentReportTable.getColumnModel().getColumn(8).setHeaderValue("Sysmtomps");
        }

        appoinmentReportPdfBtn.setText("Generate Report in PDF");
        appoinmentReportPdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appoinmentReportPdfBtnActionPerformed(evt);
            }
        });

        appointmentReportCsvBtn.setText("Generate Report in CSV");
        appointmentReportCsvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentReportCsvBtnActionPerformed(evt);
            }
        });

        appointmentReportDateChooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                appointmentReportDateChooserMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentReportDateChooserMouseClicked(evt);
            }
        });
        appointmentReportDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                appointmentReportDateChooserPropertyChange(evt);
            }
        });

        appointmentReportMoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                appointmentReportMoComboBoxItemStateChanged(evt);
            }
        });

        appointmentReportPrepareBtn.setText("Prepare");

        javax.swing.GroupLayout appoinmentReportPanelLayout = new javax.swing.GroupLayout(appoinmentReportPanel);
        appoinmentReportPanel.setLayout(appoinmentReportPanelLayout);
        appoinmentReportPanelLayout.setHorizontalGroup(
            appoinmentReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appoinmentReportPanelLayout.createSequentialGroup()
                .addGroup(appoinmentReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(appoinmentReportPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(appoinmentReportPanelLayout.createSequentialGroup()
                        .addGroup(appoinmentReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(appoinmentReportPanelLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(appoinmentReportPdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(188, 188, 188)
                                .addComponent(appointmentReportCsvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(appoinmentReportPanelLayout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(appointmentReportDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(appointmentReportMoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)
                                .addComponent(appointmentReportPrepareBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 164, Short.MAX_VALUE)))
                .addContainerGap())
        );
        appoinmentReportPanelLayout.setVerticalGroup(
            appoinmentReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appoinmentReportPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(appoinmentReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(appointmentReportDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(appointmentReportMoComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(appointmentReportPrepareBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(appoinmentReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appoinmentReportPdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appointmentReportCsvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        reportsPanel.add(appoinmentReportPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1090, 710));

        jScrollPane8.setBorder(null);

        userLogReportTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        userLogReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "User Name", "Role", "Date", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userLogReportTable.setGridColor(new java.awt.Color(255, 255, 255));
        userLogReportTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
        userLogReportTable.setRowHeight(20);
        userLogReportTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userLogReportTableMousePressed(evt);
            }
        });
        jScrollPane8.setViewportView(userLogReportTable);
        if (userLogReportTable.getColumnModel().getColumnCount() > 0) {
            userLogReportTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            userLogReportTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            userLogReportTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            userLogReportTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        userLoginReportDateChooser3.setPreferredSize(new java.awt.Dimension(100, 20));

        userLoginReportComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Receptionist", "MedicalOfficer", "Patient", " ", " " }));
        userLoginReportComboBox.setPreferredSize(new java.awt.Dimension(100, 20));
        userLoginReportComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                userLoginReportComboBoxItemStateChanged(evt);
            }
        });

        userLogReportPdfBtn.setText("Generate Report in PDF");
        userLogReportPdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userLogReportPdfBtnActionPerformed(evt);
            }
        });

        userLogReportCsvBtn.setText("Generate Report in CSV");
        userLogReportCsvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userLogReportCsvBtnActionPerformed(evt);
            }
        });

        userLogPrepareBtn.setText("Prepare");

        javax.swing.GroupLayout userLogReportPanelLayout = new javax.swing.GroupLayout(userLogReportPanel);
        userLogReportPanel.setLayout(userLogReportPanelLayout);
        userLogReportPanelLayout.setHorizontalGroup(
            userLogReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLogReportPanelLayout.createSequentialGroup()
                .addGroup(userLogReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userLogReportPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE))
                    .addGroup(userLogReportPanelLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(userLoginReportDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(userLoginReportComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(userLogPrepareBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(userLogReportPanelLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(userLogReportPdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(userLogReportCsvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userLogReportPanelLayout.setVerticalGroup(
            userLogReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLogReportPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(userLogReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userLoginReportComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(userLoginReportDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userLogPrepareBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(userLogReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLogReportPdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLogReportCsvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        reportsPanel.add(userLogReportPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1090, 710));

        jScrollPane9.setBorder(null);

        patientCredintialTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        patientCredintialTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "User Name", "Name", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientCredintialTable.setGridColor(new java.awt.Color(255, 255, 255));
        patientCredintialTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
        patientCredintialTable.setRowHeight(20);
        patientCredintialTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                patientCredintialTableMousePressed(evt);
            }
        });
        jScrollPane9.setViewportView(patientCredintialTable);
        if (patientCredintialTable.getColumnModel().getColumnCount() > 0) {
            patientCredintialTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            patientCredintialTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            patientCredintialTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        patientCredintialPdfBtn.setText("Generate Report in PDF");
        patientCredintialPdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientCredintialPdfBtnActionPerformed(evt);
            }
        });

        patientCredintialCsvBtn.setText("Generate Report in CSV");
        patientCredintialCsvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientCredintialCsvBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patientCreditialReportPanelLayout = new javax.swing.GroupLayout(patientCreditialReportPanel);
        patientCreditialReportPanel.setLayout(patientCreditialReportPanelLayout);
        patientCreditialReportPanelLayout.setHorizontalGroup(
            patientCreditialReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientCreditialReportPanelLayout.createSequentialGroup()
                .addGroup(patientCreditialReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patientCreditialReportPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE))
                    .addGroup(patientCreditialReportPanelLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(patientCredintialPdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(patientCredintialCsvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        patientCreditialReportPanelLayout.setVerticalGroup(
            patientCreditialReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientCreditialReportPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(patientCreditialReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientCredintialPdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientCredintialCsvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(298, Short.MAX_VALUE))
        );

        reportsPanel.add(patientCreditialReportPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 73, 1090, 780));

        jPanel10.setBackground(new java.awt.Color(39, 55, 130));
        jPanel10.setForeground(new java.awt.Color(39, 55, 130));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userLogReportOptionPanel.setBackground(new java.awt.Color(255, 255, 255));
        userLogReportOptionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        userLogReportOptionPanel.setForeground(new java.awt.Color(102, 0, 102));
        userLogReportOptionPanel.setPreferredSize(new java.awt.Dimension(363, 40));
        userLogReportOptionPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userLogReportOptionPanelMousePressed(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(102, 0, 102));
        jLabel77.setText("User Login Report");
        jLabel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel77MouseExited(evt);
            }
        });

        javax.swing.GroupLayout userLogReportOptionPanelLayout = new javax.swing.GroupLayout(userLogReportOptionPanel);
        userLogReportOptionPanel.setLayout(userLogReportOptionPanelLayout);
        userLogReportOptionPanelLayout.setHorizontalGroup(
            userLogReportOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userLogReportOptionPanelLayout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );
        userLogReportOptionPanelLayout.setVerticalGroup(
            userLogReportOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        jPanel10.add(userLogReportOptionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 0, 370, 70));

        appointmentReportOptionPanel.setBackground(new java.awt.Color(255, 255, 255));
        appointmentReportOptionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        appointmentReportOptionPanel.setForeground(new java.awt.Color(102, 0, 102));

        jLabel78.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(102, 0, 102));
        jLabel78.setText("Appointment Reports");

        javax.swing.GroupLayout appointmentReportOptionPanelLayout = new javax.swing.GroupLayout(appointmentReportOptionPanel);
        appointmentReportOptionPanel.setLayout(appointmentReportOptionPanelLayout);
        appointmentReportOptionPanelLayout.setHorizontalGroup(
            appointmentReportOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentReportOptionPanelLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel78)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        appointmentReportOptionPanelLayout.setVerticalGroup(
            appointmentReportOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        jPanel10.add(appointmentReportOptionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 363, 70));

        patientCredentialReportOptionPanel.setBackground(new java.awt.Color(255, 255, 255));
        patientCredentialReportOptionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        patientCredentialReportOptionPanel.setForeground(new java.awt.Color(102, 0, 102));

        jLabel79.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(102, 0, 102));
        jLabel79.setText("Patients Creditials");

        javax.swing.GroupLayout patientCredentialReportOptionPanelLayout = new javax.swing.GroupLayout(patientCredentialReportOptionPanel);
        patientCredentialReportOptionPanel.setLayout(patientCredentialReportOptionPanelLayout);
        patientCredentialReportOptionPanelLayout.setHorizontalGroup(
            patientCredentialReportOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patientCredentialReportOptionPanelLayout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        patientCredentialReportOptionPanelLayout.setVerticalGroup(
            patientCredentialReportOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        jPanel10.add(patientCredentialReportOptionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 360, 70));

        reportsPanel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 70));

        bgPanel.add(reportsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 1000));

        refferencePanel.setBackground(new java.awt.Color(204, 204, 204));
        refferencePanel.setPreferredSize(new java.awt.Dimension(1090, 860));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        specialityReferenceOptionPanel.setBackground(new java.awt.Color(255, 255, 255));
        specialityReferenceOptionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(64, 43, 100));
        jLabel31.setText("Speciality Refference");

        javax.swing.GroupLayout specialityReferenceOptionPanelLayout = new javax.swing.GroupLayout(specialityReferenceOptionPanel);
        specialityReferenceOptionPanel.setLayout(specialityReferenceOptionPanelLayout);
        specialityReferenceOptionPanelLayout.setHorizontalGroup(
            specialityReferenceOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, specialityReferenceOptionPanelLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        specialityReferenceOptionPanelLayout.setVerticalGroup(
            specialityReferenceOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(specialityReferenceOptionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 530, 60));

        complainReferenceOptionPanel.setBackground(new java.awt.Color(255, 255, 255));
        complainReferenceOptionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(64, 43, 100));
        jLabel28.setText("Complain Refference");

        javax.swing.GroupLayout complainReferenceOptionPanelLayout = new javax.swing.GroupLayout(complainReferenceOptionPanel);
        complainReferenceOptionPanel.setLayout(complainReferenceOptionPanelLayout);
        complainReferenceOptionPanelLayout.setHorizontalGroup(
            complainReferenceOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, complainReferenceOptionPanelLayout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(172, 172, 172))
        );
        complainReferenceOptionPanelLayout.setVerticalGroup(
            complainReferenceOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        jPanel3.add(complainReferenceOptionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 60));

        specialityListPanel.setBackground(new java.awt.Color(204, 204, 204));
        specialityListPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        complainRefferenceList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        complaintReferencejScrollPanel.setViewportView(complainRefferenceList);

        specialityListPanel.add(complaintReferencejScrollPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 52, 502, 388));

        specialityRefferenceList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        specialityReferenceJScrollPanel.setViewportView(specialityRefferenceList);

        specialityListPanel.add(specialityReferenceJScrollPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 52, 502, 388));

        javax.swing.GroupLayout refferencePanelLayout = new javax.swing.GroupLayout(refferencePanel);
        refferencePanel.setLayout(refferencePanelLayout);
        refferencePanelLayout.setHorizontalGroup(
            refferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(refferencePanelLayout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(specialityListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        refferencePanelLayout.setVerticalGroup(
            refferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refferencePanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specialityListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(353, Short.MAX_VALUE))
        );

        bgPanel.add(refferencePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 1090, 860));

        settingsPanel.setBackground(new java.awt.Color(204, 204, 204));
        settingsPanel.setPreferredSize(new java.awt.Dimension(1090, 860));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("setting ");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel42.setText("Name");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setText("Gender");

        genderComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Neutral" }));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel59.setText("Date of birth");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel60.setText("Phone no");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel61.setText("NIC no");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel62.setText("Address");

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel63.setText("Marital status");

        martialStatusComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Married", "Single" }));
        martialStatusComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                martialStatusComboBox2ActionPerformed(evt);
            }
        });

        addressField.setColumns(20);
        addressField.setRows(5);
        jScrollPane6.setViewportView(addressField);

        saveUserBtn.setText("Save");
        saveUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUserBtnActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setText("Username");

        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel41.setText("Password");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(Passwordfield))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(Passwordfield))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        photoUploadedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userPhotoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userPhotoLabelMousePressed(evt);
            }
        });
        photoUploadedPanel1.add(userPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 150));

        photoAddBtn.setText("add");
        photoAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoAddBtnActionPerformed(evt);
            }
        });
        photoUploadedPanel1.add(photoAddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel65.setText("Photo");

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addComponent(nicField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(settingsPanelLayout.createSequentialGroup()
                                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(122, 122, 122)
                                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(PhoneNofield, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(settingsPanelLayout.createSequentialGroup()
                                        .addGap(187, 187, 187)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24)
                                .addComponent(photoUploadedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(genderComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(martialStatusComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                                .addComponent(saveUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(142, 142, 142))
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(photoUploadedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PhoneNofield, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(martialStatusComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nicField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196)
                        .addComponent(saveUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(198, Short.MAX_VALUE))
        );

        bgPanel.add(settingsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 1000));

        usersPanel.setBackground(new java.awt.Color(204, 204, 204));
        usersPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        moScrollPanel.setBorder(null);

        moTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        moTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "User Name", "Name", "Gender", "Mobile", "Id Card No", "D.O.B", "Address", "Martial Status", "Password", "Staff Id", "Staff Email", "Date Joined", "attachemnt", "Speciality", "Profile Image"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        moTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        moTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        moTable.setGridColor(new java.awt.Color(255, 255, 255));
        moTable.setRowHeight(20);
        moTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                moTableMousePressed(evt);
            }
        });
        moScrollPanel.setViewportView(moTable);
        if (moTable.getColumnModel().getColumnCount() > 0) {
            moTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            moTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            moTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            moTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            moTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            moTable.getColumnModel().getColumn(6).setPreferredWidth(130);
            moTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            moTable.getColumnModel().getColumn(8).setPreferredWidth(100);
            moTable.getColumnModel().getColumn(9).setPreferredWidth(100);
            moTable.getColumnModel().getColumn(10).setPreferredWidth(120);
            moTable.getColumnModel().getColumn(11).setPreferredWidth(100);
            moTable.getColumnModel().getColumn(12).setPreferredWidth(130);
            moTable.getColumnModel().getColumn(13).setPreferredWidth(100);
            moTable.getColumnModel().getColumn(14).setPreferredWidth(130);
        }

        usersPanel.add(moScrollPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1066, 349));

        patientScrollPanel.setBorder(null);

        patientsTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        patientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Name", "Gender", "Mobile", "Id Card No", "D.O.B", "Address", "Martail Status", "Password", "Blood Group", "Symtomps", "Photo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        patientsTable.setGridColor(new java.awt.Color(255, 255, 255));
        patientsTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
        patientsTable.setRowHeight(20);
        patientsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                patientsTableMousePressed(evt);
            }
        });
        patientScrollPanel.setViewportView(patientsTable);
        if (patientsTable.getColumnModel().getColumnCount() > 0) {
            patientsTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            patientsTable.getColumnModel().getColumn(2).setResizable(false);
            patientsTable.getColumnModel().getColumn(3).setResizable(false);
            patientsTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            patientsTable.getColumnModel().getColumn(4).setResizable(false);
            patientsTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            patientsTable.getColumnModel().getColumn(6).setPreferredWidth(120);
            patientsTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            patientsTable.getColumnModel().getColumn(8).setPreferredWidth(100);
            patientsTable.getColumnModel().getColumn(10).setResizable(false);
            patientsTable.getColumnModel().getColumn(10).setPreferredWidth(120);
        }

        usersPanel.add(patientScrollPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1066, 349));

        receptionistScrollPanel.setBorder(null);

        receptionistTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        receptionistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "User Name", "Name", "Gender", "Mobile", "id No", "D.O.B", "Address", "Martial Status", "Password", "Staff Id", "Staff Email", "Date Joined", "Attachment", "Staff Photo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        receptionistTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        receptionistTable.setGridColor(new java.awt.Color(255, 255, 255));
        receptionistTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
        receptionistTable.setRowHeight(20);
        receptionistTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                receptionistTableMousePressed(evt);
            }
        });
        receptionistScrollPanel.setViewportView(receptionistTable);
        if (receptionistTable.getColumnModel().getColumnCount() > 0) {
            receptionistTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            receptionistTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            receptionistTable.getColumnModel().getColumn(2).setPreferredWidth(130);
            receptionistTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            receptionistTable.getColumnModel().getColumn(6).setPreferredWidth(130);
            receptionistTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            receptionistTable.getColumnModel().getColumn(8).setPreferredWidth(100);
            receptionistTable.getColumnModel().getColumn(9).setPreferredWidth(100);
            receptionistTable.getColumnModel().getColumn(10).setPreferredWidth(100);
            receptionistTable.getColumnModel().getColumn(12).setPreferredWidth(120);
            receptionistTable.getColumnModel().getColumn(13).setPreferredWidth(120);
        }

        usersPanel.add(receptionistScrollPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1066, 349));

        jPanel6.setBackground(new java.awt.Color(39, 55, 130));
        jPanel6.setForeground(new java.awt.Color(39, 55, 130));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setForeground(new java.awt.Color(102, 0, 102));
        jPanel7.setPreferredSize(new java.awt.Dimension(363, 40));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel7MousePressed(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(102, 0, 102));
        jLabel66.setText("Receptionists");
        jLabel66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel66MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 0, 370, 40));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setForeground(new java.awt.Color(102, 0, 102));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel9MousePressed(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(102, 0, 102));
        jLabel67.setText("Medical Officers");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel67)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 363, 40));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel35.setForeground(new java.awt.Color(102, 0, 102));
        jPanel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel35MousePressed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(102, 0, 102));
        jLabel68.setText("Patients");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 360, 40));

        usersPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 40));

        bgPanel.add(usersPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 1090, 860));

        appointmentMainOption.setPreferredSize(new java.awt.Dimension(1090, 108));

        adminAppointmentOptions.setForeground(new java.awt.Color(85, 65, 118));

        deleteAppointmentBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteAppointmentBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteAppointmentBtn.setForeground(new java.awt.Color(85, 65, 118));
        deleteAppointmentBtn.setText("Delete");
        deleteAppointmentBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        deleteAppointmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAppointmentBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminAppointmentOptionsLayout = new javax.swing.GroupLayout(adminAppointmentOptions);
        adminAppointmentOptions.setLayout(adminAppointmentOptionsLayout);
        adminAppointmentOptionsLayout.setHorizontalGroup(
            adminAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminAppointmentOptionsLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(deleteAppointmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(832, Short.MAX_VALUE))
        );
        adminAppointmentOptionsLayout.setVerticalGroup(
            adminAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminAppointmentOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteAppointmentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        receptionAppointmentOptions.setForeground(new java.awt.Color(85, 65, 118));

        approveAppoinmentBtn.setBackground(new java.awt.Color(255, 255, 255));
        approveAppoinmentBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        approveAppoinmentBtn.setForeground(new java.awt.Color(85, 65, 118));
        approveAppoinmentBtn.setText("Approve");
        approveAppoinmentBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        approveAppoinmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveAppoinmentBtnActionPerformed(evt);
            }
        });

        addAppointmentBtn.setBackground(new java.awt.Color(255, 255, 255));
        addAppointmentBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addAppointmentBtn.setForeground(new java.awt.Color(85, 65, 118));
        addAppointmentBtn.setText("Add");
        addAppointmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAppointmentBtnActionPerformed(evt);
            }
        });

        generatePdfBtn.setBackground(new java.awt.Color(255, 255, 255));
        generatePdfBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        generatePdfBtn.setForeground(new java.awt.Color(85, 65, 118));
        generatePdfBtn.setText("Generate PDF");
        generatePdfBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        generatePdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatePdfBtnActionPerformed(evt);
            }
        });

        editAppointmentBtn.setBackground(new java.awt.Color(255, 255, 255));
        editAppointmentBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editAppointmentBtn.setForeground(new java.awt.Color(85, 65, 118));
        editAppointmentBtn.setText("Edit");
        editAppointmentBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        editAppointmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAppointmentBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receptionAppointmentOptionsLayout = new javax.swing.GroupLayout(receptionAppointmentOptions);
        receptionAppointmentOptions.setLayout(receptionAppointmentOptionsLayout);
        receptionAppointmentOptionsLayout.setHorizontalGroup(
            receptionAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionAppointmentOptionsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(addAppointmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(generatePdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(editAppointmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(approveAppoinmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 299, Short.MAX_VALUE))
        );
        receptionAppointmentOptionsLayout.setVerticalGroup(
            receptionAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionAppointmentOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receptionAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editAppointmentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addAppointmentBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(generatePdfBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(approveAppoinmentBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        patientAppointmentOptions.setForeground(new java.awt.Color(85, 65, 118));
        patientAppointmentOptions.setPreferredSize(new java.awt.Dimension(1090, 110));

        addAppointmentBtn2.setBackground(new java.awt.Color(255, 255, 255));
        addAppointmentBtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addAppointmentBtn2.setForeground(new java.awt.Color(85, 65, 118));
        addAppointmentBtn2.setText("Add");
        addAppointmentBtn2.setPreferredSize(new java.awt.Dimension(67, 31));
        addAppointmentBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAppointmentBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patientAppointmentOptionsLayout = new javax.swing.GroupLayout(patientAppointmentOptions);
        patientAppointmentOptions.setLayout(patientAppointmentOptionsLayout);
        patientAppointmentOptionsLayout.setHorizontalGroup(
            patientAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientAppointmentOptionsLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(addAppointmentBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addGap(843, 843, 843))
        );
        patientAppointmentOptionsLayout.setVerticalGroup(
            patientAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientAppointmentOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addAppointmentBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        moAppointmentOptions.setForeground(new java.awt.Color(85, 65, 118));

        completedAppointmentBtn.setBackground(new java.awt.Color(255, 255, 255));
        completedAppointmentBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        completedAppointmentBtn.setForeground(new java.awt.Color(85, 65, 118));
        completedAppointmentBtn.setText("Complete");
        completedAppointmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completedAppointmentBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout moAppointmentOptionsLayout = new javax.swing.GroupLayout(moAppointmentOptions);
        moAppointmentOptions.setLayout(moAppointmentOptionsLayout);
        moAppointmentOptionsLayout.setHorizontalGroup(
            moAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moAppointmentOptionsLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(completedAppointmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(869, Short.MAX_VALUE))
        );
        moAppointmentOptionsLayout.setVerticalGroup(
            moAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moAppointmentOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(completedAppointmentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout appointmentMainOptionLayout = new javax.swing.GroupLayout(appointmentMainOption);
        appointmentMainOption.setLayout(appointmentMainOptionLayout);
        appointmentMainOptionLayout.setHorizontalGroup(
            appointmentMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(appointmentMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(appointmentMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(appointmentMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(moAppointmentOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(receptionAppointmentOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adminAppointmentOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(patientAppointmentOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        appointmentMainOptionLayout.setVerticalGroup(
            appointmentMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
            .addGroup(appointmentMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(appointmentMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(appointmentMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(moAppointmentOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(receptionAppointmentOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adminAppointmentOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(patientAppointmentOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bgPanel.add(appointmentMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        usersMainOption.setPreferredSize(new java.awt.Dimension(1090, 108));

        adminUserOptions.setForeground(new java.awt.Color(85, 65, 118));

        deleteUsersBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteUsersBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteUsersBtn.setForeground(new java.awt.Color(85, 65, 118));
        deleteUsersBtn.setText("Delete");
        deleteUsersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUsersBtnActionPerformed(evt);
            }
        });

        editUsersBtn.setBackground(new java.awt.Color(255, 255, 255));
        editUsersBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editUsersBtn.setForeground(new java.awt.Color(85, 65, 118));
        editUsersBtn.setText("Edit");
        editUsersBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        editUsersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUsersBtnActionPerformed(evt);
            }
        });

        resetPasswordBtn.setBackground(new java.awt.Color(255, 255, 255));
        resetPasswordBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        resetPasswordBtn.setForeground(new java.awt.Color(85, 65, 118));
        resetPasswordBtn.setText("Reset Password");
        resetPasswordBtn.setPreferredSize(new java.awt.Dimension(67, 31));

        addUsersBtn.setBackground(new java.awt.Color(255, 255, 255));
        addUsersBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addUsersBtn.setForeground(new java.awt.Color(85, 65, 118));
        addUsersBtn.setText("Add");
        addUsersBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        addUsersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUsersBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminUserOptionsLayout = new javax.swing.GroupLayout(adminUserOptions);
        adminUserOptions.setLayout(adminUserOptionsLayout);
        adminUserOptionsLayout.setHorizontalGroup(
            adminUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminUserOptionsLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(addUsersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(resetPasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(editUsersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(deleteUsersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 289, Short.MAX_VALUE))
        );
        adminUserOptionsLayout.setVerticalGroup(
            adminUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminUserOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addUsersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(resetPasswordBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editUsersBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteUsersBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        receptionistUserOptions.setForeground(new java.awt.Color(85, 65, 118));

        deleteUsersBtn2.setBackground(new java.awt.Color(255, 255, 255));
        deleteUsersBtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteUsersBtn2.setForeground(new java.awt.Color(85, 65, 118));
        deleteUsersBtn2.setText("Delete");
        deleteUsersBtn2.setPreferredSize(new java.awt.Dimension(67, 31));
        deleteUsersBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUsersBtn2ActionPerformed(evt);
            }
        });

        editUsersBtn2.setBackground(new java.awt.Color(255, 255, 255));
        editUsersBtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editUsersBtn2.setForeground(new java.awt.Color(85, 65, 118));
        editUsersBtn2.setText("Edit");
        editUsersBtn2.setPreferredSize(new java.awt.Dimension(67, 31));
        editUsersBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUsersBtn2ActionPerformed(evt);
            }
        });

        addUsersBtn2.setBackground(new java.awt.Color(255, 255, 255));
        addUsersBtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addUsersBtn2.setForeground(new java.awt.Color(85, 65, 118));
        addUsersBtn2.setText("add");
        addUsersBtn2.setPreferredSize(new java.awt.Dimension(67, 31));
        addUsersBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUsersBtn2ActionPerformed(evt);
            }
        });

        resetPasswordBtn2.setBackground(new java.awt.Color(255, 255, 255));
        resetPasswordBtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        resetPasswordBtn2.setForeground(new java.awt.Color(85, 65, 118));
        resetPasswordBtn2.setText("Reset Password");
        resetPasswordBtn2.setPreferredSize(new java.awt.Dimension(67, 31));
        resetPasswordBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPasswordBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receptionistUserOptionsLayout = new javax.swing.GroupLayout(receptionistUserOptions);
        receptionistUserOptions.setLayout(receptionistUserOptionsLayout);
        receptionistUserOptionsLayout.setHorizontalGroup(
            receptionistUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionistUserOptionsLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(addUsersBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(editUsersBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(deleteUsersBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(resetPasswordBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 292, Short.MAX_VALUE))
        );
        receptionistUserOptionsLayout.setVerticalGroup(
            receptionistUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receptionistUserOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receptionistUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addUsersBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(editUsersBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteUsersBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetPasswordBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout usersMainOptionLayout = new javax.swing.GroupLayout(usersMainOption);
        usersMainOption.setLayout(usersMainOptionLayout);
        usersMainOptionLayout.setHorizontalGroup(
            usersMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
            .addGroup(usersMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(usersMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(usersMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(adminUserOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(receptionistUserOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        usersMainOptionLayout.setVerticalGroup(
            usersMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
            .addGroup(usersMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(usersMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(usersMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(adminUserOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(receptionistUserOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bgPanel.add(usersMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        mailMainOption.setPreferredSize(new java.awt.Dimension(1090, 108));

        adminMailOptions.setForeground(new java.awt.Color(85, 65, 118));

        deleteMailBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteMailBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteMailBtn.setForeground(new java.awt.Color(85, 65, 118));
        deleteMailBtn.setText("Delete");
        deleteMailBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        deleteMailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMailBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminMailOptionsLayout = new javax.swing.GroupLayout(adminMailOptions);
        adminMailOptions.setLayout(adminMailOptionsLayout);
        adminMailOptionsLayout.setHorizontalGroup(
            adminMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminMailOptionsLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(deleteMailBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(0, 851, Short.MAX_VALUE))
        );
        adminMailOptionsLayout.setVerticalGroup(
            adminMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminMailOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteMailBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        receptionMailOptions.setForeground(new java.awt.Color(85, 65, 118));

        deleteMailBtn2.setBackground(new java.awt.Color(255, 255, 255));
        deleteMailBtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteMailBtn2.setForeground(new java.awt.Color(85, 65, 118));
        deleteMailBtn2.setText("Delete");
        deleteMailBtn2.setPreferredSize(new java.awt.Dimension(67, 31));
        deleteMailBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMailBtn2ActionPerformed(evt);
            }
        });

        editMailBtn.setBackground(new java.awt.Color(255, 255, 255));
        editMailBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editMailBtn.setForeground(new java.awt.Color(85, 65, 118));
        editMailBtn.setText("Edit");
        editMailBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        editMailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMailBtnActionPerformed(evt);
            }
        });

        addMailBtn.setBackground(new java.awt.Color(255, 255, 255));
        addMailBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addMailBtn.setForeground(new java.awt.Color(85, 65, 118));
        addMailBtn.setText("Add");
        addMailBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        addMailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMailBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receptionMailOptionsLayout = new javax.swing.GroupLayout(receptionMailOptions);
        receptionMailOptions.setLayout(receptionMailOptionsLayout);
        receptionMailOptionsLayout.setHorizontalGroup(
            receptionMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionMailOptionsLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(addMailBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(71, 71, 71)
                .addComponent(editMailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(deleteMailBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 524, Short.MAX_VALUE))
        );
        receptionMailOptionsLayout.setVerticalGroup(
            receptionMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receptionMailOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receptionMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteMailBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(editMailBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(addMailBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout mailMainOptionLayout = new javax.swing.GroupLayout(mailMainOption);
        mailMainOption.setLayout(mailMainOptionLayout);
        mailMainOptionLayout.setHorizontalGroup(
            mailMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1127, Short.MAX_VALUE)
            .addGroup(mailMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mailMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(mailMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(receptionMailOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adminMailOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        mailMainOptionLayout.setVerticalGroup(
            mailMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
            .addGroup(mailMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mailMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(mailMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(receptionMailOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adminMailOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bgPanel.add(mailMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        complaintsMainOption.setPreferredSize(new java.awt.Dimension(1090, 108));

        adminComplaintOptions.setForeground(new java.awt.Color(85, 65, 118));

        deleteComplaintBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteComplaintBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteComplaintBtn.setForeground(new java.awt.Color(85, 65, 118));
        deleteComplaintBtn.setText("Delete");
        deleteComplaintBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        deleteComplaintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteComplaintBtnActionPerformed(evt);
            }
        });

        editComplaintBtn.setBackground(new java.awt.Color(255, 255, 255));
        editComplaintBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editComplaintBtn.setForeground(new java.awt.Color(85, 65, 118));
        editComplaintBtn.setText("Edit Complaint");
        editComplaintBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        editComplaintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editComplaintBtnActionPerformed(evt);
            }
        });

        approveComplaintBtn.setBackground(new java.awt.Color(255, 255, 255));
        approveComplaintBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        approveComplaintBtn.setForeground(new java.awt.Color(85, 65, 118));
        approveComplaintBtn.setText("set Action Taken");
        approveComplaintBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        approveComplaintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveComplaintBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminComplaintOptionsLayout = new javax.swing.GroupLayout(adminComplaintOptions);
        adminComplaintOptions.setLayout(adminComplaintOptionsLayout);
        adminComplaintOptionsLayout.setHorizontalGroup(
            adminComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminComplaintOptionsLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(approveComplaintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(editComplaintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(deleteComplaintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 319, Short.MAX_VALUE))
        );
        adminComplaintOptionsLayout.setVerticalGroup(
            adminComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminComplaintOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteComplaintBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(editComplaintBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(approveComplaintBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addContainerGap())
        );

        patientComplaintOptions.setForeground(new java.awt.Color(85, 65, 118));

        addComplaintBtn2.setBackground(new java.awt.Color(255, 255, 255));
        addComplaintBtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addComplaintBtn2.setForeground(new java.awt.Color(85, 65, 118));
        addComplaintBtn2.setText("Add Complain");
        addComplaintBtn2.setPreferredSize(new java.awt.Dimension(67, 31));
        addComplaintBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addComplaintBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patientComplaintOptionsLayout = new javax.swing.GroupLayout(patientComplaintOptions);
        patientComplaintOptions.setLayout(patientComplaintOptionsLayout);
        patientComplaintOptionsLayout.setHorizontalGroup(
            patientComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientComplaintOptionsLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(addComplaintBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(685, Short.MAX_VALUE))
        );
        patientComplaintOptionsLayout.setVerticalGroup(
            patientComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientComplaintOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addComplaintBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        receptionistComplaintOptions.setForeground(new java.awt.Color(85, 65, 118));

        addComplaintBtn.setBackground(new java.awt.Color(255, 255, 255));
        addComplaintBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addComplaintBtn.setForeground(new java.awt.Color(85, 65, 118));
        addComplaintBtn.setText("Add Complaint");
        addComplaintBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        addComplaintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addComplaintBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receptionistComplaintOptionsLayout = new javax.swing.GroupLayout(receptionistComplaintOptions);
        receptionistComplaintOptions.setLayout(receptionistComplaintOptionsLayout);
        receptionistComplaintOptionsLayout.setHorizontalGroup(
            receptionistComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionistComplaintOptionsLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(addComplaintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(758, Short.MAX_VALUE))
        );
        receptionistComplaintOptionsLayout.setVerticalGroup(
            receptionistComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receptionistComplaintOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addComplaintBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout complaintsMainOptionLayout = new javax.swing.GroupLayout(complaintsMainOption);
        complaintsMainOption.setLayout(complaintsMainOptionLayout);
        complaintsMainOptionLayout.setHorizontalGroup(
            complaintsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(complaintsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(complaintsMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(complaintsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(adminComplaintOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(patientComplaintOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(receptionistComplaintOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        complaintsMainOptionLayout.setVerticalGroup(
            complaintsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
            .addGroup(complaintsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(complaintsMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(complaintsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(adminComplaintOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(patientComplaintOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(receptionistComplaintOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bgPanel.add(complaintsMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        visitorsMainOption.setPreferredSize(new java.awt.Dimension(1090, 108));

        receptionistVisitorOptions.setForeground(new java.awt.Color(85, 65, 118));

        deleteVisitorBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteVisitorBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteVisitorBtn.setForeground(new java.awt.Color(85, 65, 118));
        deleteVisitorBtn.setText("Delete");
        deleteVisitorBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        deleteVisitorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVisitorBtnActionPerformed(evt);
            }
        });

        editVisitorBtn.setBackground(new java.awt.Color(255, 255, 255));
        editVisitorBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editVisitorBtn.setForeground(new java.awt.Color(85, 65, 118));
        editVisitorBtn.setText("Edit");
        editVisitorBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        editVisitorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editVisitorBtnActionPerformed(evt);
            }
        });

        addVisitorBtn.setBackground(new java.awt.Color(255, 255, 255));
        addVisitorBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addVisitorBtn.setForeground(new java.awt.Color(85, 65, 118));
        addVisitorBtn.setText("Add");
        addVisitorBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        addVisitorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVisitorBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receptionistVisitorOptionsLayout = new javax.swing.GroupLayout(receptionistVisitorOptions);
        receptionistVisitorOptions.setLayout(receptionistVisitorOptionsLayout);
        receptionistVisitorOptionsLayout.setHorizontalGroup(
            receptionistVisitorOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionistVisitorOptionsLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(addVisitorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(editVisitorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(deleteVisitorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 441, Short.MAX_VALUE))
        );
        receptionistVisitorOptionsLayout.setVerticalGroup(
            receptionistVisitorOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receptionistVisitorOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receptionistVisitorOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addVisitorBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(editVisitorBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteVisitorBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        adminVisitorOptions.setForeground(new java.awt.Color(85, 65, 118));

        deleteVisitorBtn2.setBackground(new java.awt.Color(255, 255, 255));
        deleteVisitorBtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteVisitorBtn2.setForeground(new java.awt.Color(85, 65, 118));
        deleteVisitorBtn2.setText("Delete");
        deleteVisitorBtn2.setPreferredSize(new java.awt.Dimension(67, 31));
        deleteVisitorBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVisitorBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminVisitorOptionsLayout = new javax.swing.GroupLayout(adminVisitorOptions);
        adminVisitorOptions.setLayout(adminVisitorOptionsLayout);
        adminVisitorOptionsLayout.setHorizontalGroup(
            adminVisitorOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminVisitorOptionsLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(deleteVisitorBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(840, Short.MAX_VALUE))
        );
        adminVisitorOptionsLayout.setVerticalGroup(
            adminVisitorOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminVisitorOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteVisitorBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout visitorsMainOptionLayout = new javax.swing.GroupLayout(visitorsMainOption);
        visitorsMainOption.setLayout(visitorsMainOptionLayout);
        visitorsMainOptionLayout.setHorizontalGroup(
            visitorsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visitorsMainOptionLayout.createSequentialGroup()
                .addComponent(adminVisitorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(visitorsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(visitorsMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(receptionistVisitorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        visitorsMainOptionLayout.setVerticalGroup(
            visitorsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visitorsMainOptionLayout.createSequentialGroup()
                .addComponent(adminVisitorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(visitorsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(visitorsMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(receptionistVisitorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bgPanel.add(visitorsMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        refferenceMainOption.setForeground(new java.awt.Color(85, 65, 118));
        refferenceMainOption.setPreferredSize(new java.awt.Dimension(1090, 108));

        adminRefferenceOptions.setForeground(new java.awt.Color(85, 65, 118));

        deleteReferenceBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteReferenceBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteReferenceBtn.setForeground(new java.awt.Color(85, 65, 118));
        deleteReferenceBtn.setText("Delete");
        deleteReferenceBtn.setPreferredSize(new java.awt.Dimension(67, 31));

        editReferenceBtn.setBackground(new java.awt.Color(255, 255, 255));
        editReferenceBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editReferenceBtn.setForeground(new java.awt.Color(85, 65, 118));
        editReferenceBtn.setText("Edit");
        editReferenceBtn.setPreferredSize(new java.awt.Dimension(67, 31));

        addReferenceBtn.setBackground(new java.awt.Color(255, 255, 255));
        addReferenceBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addReferenceBtn.setForeground(new java.awt.Color(85, 65, 118));
        addReferenceBtn.setText("Add");
        addReferenceBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        addReferenceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReferenceBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminRefferenceOptionsLayout = new javax.swing.GroupLayout(adminRefferenceOptions);
        adminRefferenceOptions.setLayout(adminRefferenceOptionsLayout);
        adminRefferenceOptionsLayout.setHorizontalGroup(
            adminRefferenceOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminRefferenceOptionsLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(addReferenceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(editReferenceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(deleteReferenceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 480, Short.MAX_VALUE))
        );
        adminRefferenceOptionsLayout.setVerticalGroup(
            adminRefferenceOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminRefferenceOptionsLayout.createSequentialGroup()
                .addGroup(adminRefferenceOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addReferenceBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(editReferenceBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteReferenceBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout refferenceMainOptionLayout = new javax.swing.GroupLayout(refferenceMainOption);
        refferenceMainOption.setLayout(refferenceMainOptionLayout);
        refferenceMainOptionLayout.setHorizontalGroup(
            refferenceMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, refferenceMainOptionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(adminRefferenceOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        refferenceMainOptionLayout.setVerticalGroup(
            refferenceMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, refferenceMainOptionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adminRefferenceOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bgPanel.add(refferenceMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void appointmentTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentTableMousePressed

        if (getAppointmentTable().getSelectedRow() > -1) {
            // print first column value from selected row
           
            getEditUsersBtn().setEnabled(true);
        }
    }//GEN-LAST:event_appointmentTableMousePressed

  
    private void approveComplaintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveComplaintBtnActionPerformed
        // TODO add your handling code here:
      // UpdateComplaintActionTaken action = new UpdateComplaintActionTaken(this);
        
    }//GEN-LAST:event_approveComplaintBtnActionPerformed

    private void dispatchedMailTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dispatchedMailTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dispatchedMailTableMousePressed

    private void complaintTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_complaintTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_complaintTableMousePressed

    private void appointmentReportTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentReportTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentReportTableMousePressed

    private void visitorTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visitorTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_visitorTableMousePressed

    private void moTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_moTableMousePressed

    private void addAppointmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAppointmentBtnActionPerformed
        // TODO add your handling code here:
        //addNewAppointment();
        
    }//GEN-LAST:event_addAppointmentBtnActionPerformed

    private void generatePdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatePdfBtnActionPerformed
        // TODO add your handling code here:
       // FileService.generateApprovedAppoinmentReport();
    }//GEN-LAST:event_generatePdfBtnActionPerformed

    private void addAppointmentBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAppointmentBtn2ActionPerformed
        // TODO add your handling code here:
        //addNewAppointment();
    }//GEN-LAST:event_addAppointmentBtn2ActionPerformed

    private void completedAppointmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completedAppointmentBtnActionPerformed
        // TODO add your handling code here:
        // approveAppoinment("Completed");
    }//GEN-LAST:event_completedAppointmentBtnActionPerformed

    private void addMailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMailBtnActionPerformed
        //addDispatchedPostal();
    }//GEN-LAST:event_addMailBtnActionPerformed

    private void addComplaintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addComplaintBtnActionPerformed
        // TODO add your handling code here:
        //addNewComplaint();
    }//GEN-LAST:event_addComplaintBtnActionPerformed

    private void addComplaintBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addComplaintBtn2ActionPerformed
        // TODO add your handling code here:
        //addNewComplaint();
    }//GEN-LAST:event_addComplaintBtn2ActionPerformed

    private void addUsersBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUsersBtn2ActionPerformed
        // TODO add your handling code here:
        // addNewUser();
    }//GEN-LAST:event_addUsersBtn2ActionPerformed

    private void addVisitorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVisitorBtnActionPerformed
        // TODO add your handling code here:
       // addNewVisitorRecord();
    }//GEN-LAST:event_addVisitorBtnActionPerformed

    private void addUsersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUsersBtnActionPerformed
        // TODO add your handling code here:
        //addNewUser();
    }//GEN-LAST:event_addUsersBtnActionPerformed

    private void userNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFieldActionPerformed

    private void martialStatusComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_martialStatusComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_martialStatusComboBox2ActionPerformed

    private void saveUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveUserBtnActionPerformed
      // saveUser();
    }//GEN-LAST:event_saveUserBtnActionPerformed

    private void photoAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoAddBtnActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_photoAddBtnActionPerformed

    private void userPhotoLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userPhotoLabelMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_userPhotoLabelMousePressed

    private void patientsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientsTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientsTableMousePressed

    private void jLabel66MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel66MouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel66MouseExited

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        // TODO add your handling code here:
      //  setOptionReceptionist();
       

    }//GEN-LAST:event_jPanel7MousePressed

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MousePressed
        // TODO add your handling code here:
        //setOptionMo();
        
        
    }//GEN-LAST:event_jPanel9MousePressed

    private void jPanel35MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel35MousePressed
        // TODO add your handling code here:
       // setOptionPatient();
        

    }//GEN-LAST:event_jPanel35MousePressed

    private void receptionistTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionistTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_receptionistTableMousePressed

    private void logOutBtnPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnPanel3MousePressed
       // userLogOut();
    }//GEN-LAST:event_logOutBtnPanel3MousePressed

    private void logOutBtnPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnPanel4MousePressed
       // userLogOut();
    }//GEN-LAST:event_logOutBtnPanel4MousePressed

    private void logOutBtnPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnPanel1MousePressed
        // TODO add your handling code here:
       // userLogOut();
    }//GEN-LAST:event_logOutBtnPanel1MousePressed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void deleteUsersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUsersBtnActionPerformed
       // alterUser(1);
        
    }//GEN-LAST:event_deleteUsersBtnActionPerformed

    private void addReferenceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReferenceBtnActionPerformed
        // TODO add your handling code here:
       // addRefference();
    }//GEN-LAST:event_addReferenceBtnActionPerformed

    private void editUsersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUsersBtnActionPerformed
        // TODO add your handling code here:
       //  alterUser(2);
    }//GEN-LAST:event_editUsersBtnActionPerformed

    private void editUsersBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUsersBtn2ActionPerformed
        // TODO add your handling code here:
       // alterUser(2);//2 for edit
    }//GEN-LAST:event_editUsersBtn2ActionPerformed

    private void deleteUsersBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUsersBtn2ActionPerformed
        // TODO add your handling code here:
       // alterUser(1);//1 for edit
    }//GEN-LAST:event_deleteUsersBtn2ActionPerformed

    private void editAppointmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAppointmentBtnActionPerformed
        // TODO add your handling code here:
        //editAppointment();
        
    }//GEN-LAST:event_editAppointmentBtnActionPerformed

    private void approveAppoinmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveAppoinmentBtnActionPerformed
        // TODO add your handling code here:
        //approveAppoinment("Approved");
    }//GEN-LAST:event_approveAppoinmentBtnActionPerformed

    private void deleteMailBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMailBtn2ActionPerformed
        // TODO add your handling code here:
        //deleteMail();
        
    }//GEN-LAST:event_deleteMailBtn2ActionPerformed

    private void editComplaintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editComplaintBtnActionPerformed
        // TODO add your handling code here:
        //editComplaint();
    }//GEN-LAST:event_editComplaintBtnActionPerformed

    private void deleteComplaintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteComplaintBtnActionPerformed
        // TODO add your handling code here:
       // deleteComplaint();
    }//GEN-LAST:event_deleteComplaintBtnActionPerformed

    private void deleteVisitorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVisitorBtnActionPerformed
        //deleteVisitorRecord();
    }//GEN-LAST:event_deleteVisitorBtnActionPerformed

    private void editVisitorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editVisitorBtnActionPerformed
        //editVisitorRecord();
    }//GEN-LAST:event_editVisitorBtnActionPerformed

    private void deleteVisitorBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVisitorBtn2ActionPerformed
          //deleteVisitorRecord();
    }//GEN-LAST:event_deleteVisitorBtn2ActionPerformed

    private void userLogReportTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLogReportTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_userLogReportTableMousePressed

    private void patientCredintialTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientCredintialTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientCredintialTableMousePressed

    private void appointmentReportCsvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentReportCsvBtnActionPerformed
      /*  try {
            FileService.generateCsvFile(getAppointmentReportTable().getModel(),"files/report/appointmentReport.csv");
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_appointmentReportCsvBtnActionPerformed

    private void jLabel77MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel77MouseExited

    private void userLogReportOptionPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLogReportOptionPanelMousePressed
         //setUserLogReports();
    }//GEN-LAST:event_userLogReportOptionPanelMousePressed

    private void userLogReportPdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userLogReportPdfBtnActionPerformed
               //  FileService.generatePdf(getUserLogReportTable().getModel(),FileService.getUserLoginReportFilePath());

        
    }//GEN-LAST:event_userLogReportPdfBtnActionPerformed

    private void appointmentReportMoComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_appointmentReportMoComboBoxItemStateChanged
        // TODO add your handling code here:
        
       // setAppointmentReportTable();
        
    }//GEN-LAST:event_appointmentReportMoComboBoxItemStateChanged

    private void appointmentReportDateChooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentReportDateChooserMouseClicked
    
         
    }//GEN-LAST:event_appointmentReportDateChooserMouseClicked

    private void appointmentReportDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_appointmentReportDateChooserPropertyChange
   
    }//GEN-LAST:event_appointmentReportDateChooserPropertyChange

    private void appointmentReportDateChooserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentReportDateChooserMousePressed
        // setAppointmentReportTable();
    }//GEN-LAST:event_appointmentReportDateChooserMousePressed

    private void userLoginReportComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_userLoginReportComboBoxItemStateChanged
           // setUserLoginReportTable();
    }//GEN-LAST:event_userLoginReportComboBoxItemStateChanged

    private void deleteMailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMailBtnActionPerformed
        //deleteMail();
    }//GEN-LAST:event_deleteMailBtnActionPerformed

    private void editMailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMailBtnActionPerformed
       //editMail();
    }//GEN-LAST:event_editMailBtnActionPerformed

    private void deleteAppointmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAppointmentBtnActionPerformed
        //deleteAppointment();
    }//GEN-LAST:event_deleteAppointmentBtnActionPerformed

    private void patientCredintialPdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientCredintialPdfBtnActionPerformed
       // FileService.generatePdf(getPatientCredintialTable().getModel(),FileService.getPatientCredintailReportFilePath());
    }//GEN-LAST:event_patientCredintialPdfBtnActionPerformed

    private void appoinmentReportPdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appoinmentReportPdfBtnActionPerformed
      //   FileService.generatePdf(getAppointmentReportTable().getModel(),FileService.getAppoinmentReportFilePath());
    }//GEN-LAST:event_appoinmentReportPdfBtnActionPerformed

    private void userLogReportCsvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userLogReportCsvBtnActionPerformed
    /*    try {
            FileService.generateCsvFile(getUserLogReportTable().getModel(),"files/report/userLogReport.csv");
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }//GEN-LAST:event_userLogReportCsvBtnActionPerformed

    private void patientCredintialCsvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientCredintialCsvBtnActionPerformed
       /* try {
            FileService.generateCsvFile(getPatientCredintialTable().getModel(),"files/reports/patientCredintial.csv");
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }//GEN-LAST:event_patientCredintialCsvBtnActionPerformed

    private void resetPasswordBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPasswordBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetPasswordBtn2ActionPerformed
 
   /*  private void addRefference(){
        AddReference refference= new AddReference(this);
    }*/
    
    /*private void addNewUser(){
        AddUser user= new AddUser(1,getUserRole(),this,null,null,null);
    }*/
  
    
    private void alterUser( int type){        
        if(getMoScrollPanel().isShowing()){
                   Object record= ((DefaultTableModel) getMedicalOfficerTable().getModel()).getDataVector().elementAt(getMedicalOfficerTable().getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getMoFilePath();
                    MedicalOfficer officer=MedicalOfficer.readMoUser(line);
                    if(type==1){
                         FileService.deleteRecord(path, line);
                    }
                    else if(type==2){
                        AddUser edit=new AddUser(2,getUserRole(),this,null,officer,null);
                    }
                  
                  
        }
        else if(getPatientScrollPanel().isShowing()){
                     Object record= ((DefaultTableModel) getPatientsTable().getModel()).getDataVector().elementAt(getPatientsTable().getSelectedRow());
                     String line= PipeService.formatTableString(record.toString());
                     String path=FileService.getPatientsFilePath();
                     Patient patient=Patient.readPatientUser(line);
                    if(type==1){
                         FileService.deleteRecord(path, line);
                    }
                    else if(type==2){
                        AddUser edit=new AddUser(2,getUserRole(),this,patient,null,null);
                    }

        }
        else if(getReceptionistScrollPanel().isShowing()){
                     Object record= ((DefaultTableModel) getReceptionistTable().getModel()).getDataVector().elementAt(receptionistTable.getSelectedRow());
                      String line= PipeService.formatTableString(record.toString());
                      String path=FileService.getReceptionistFilePath();
                      Receptionist officer=Receptionist.readReceptionistUser(line);
                    if(type==1){
                         FileService.deleteRecord(path, line);
                    }
                    else if(type==2){
                        AddUser edit=new AddUser(2,getUserRole(),this,null,null,officer);
                    }
        }
   
      // setTables();
    }
    private void userLogOut(){
        this.dispose();
        Home home=new Home();
        home.setVisible(true);
    }
          
    /*
    public void setTables(){
        if(getUserRole().equals("Admin")){
            getAllAppointment();
            getAllComplaints();
            getDispatchedMails();
            getVisitorRecords();
            getAllUsers();
           // getComplainRefference();
           // getSpecialityRefference();
        }
        else if(getUserRole().equals("Receptionist")){
        getAllAppointment();
        getAllComplaints();
        getDispatchedMails();
        getVisitorRecords();
        getAllPatients();
        
    }
        else if(getUserRole().equals("Patient")){
            getPatientAppointmentTable("199829003939");
            getAllComplaints();
            
    }
        else if(getUserRole().equals("MedicalOfficer")){
        getMOAppointmentTable("dr001");
    }
        
    }
    
    private void setAppointmentOptions(){
          if(getUserRole().equals("Admin")){
              getAdminAppointmentOptions().setVisible(true);
              getPatientAppointmentOptions().setVisible(false);
              getReceptionistAppointmentOptions().setVisible(false);
              getMoAppointmentOptions().setVisible(false);
            
        }
        else if(getUserRole().equals("Receptionist")){
            getReceptionistAppointmentOptions().setVisible(true);
            getAdminAppointmentOptions().setVisible(false);
            getPatientAppointmentOptions().setVisible(false);
            getMoAppointmentOptions().setVisible(false);
            

        }
        else if(getUserRole().equals("Patient")){
            getAdminAppointmentOptions().setVisible(false);
            getPatientAppointmentOptions().setVisible(true);
            getReceptionistAppointmentOptions().setVisible(false);
            getMoAppointmentOptions().setVisible(false);

        }
        else if(getUserRole().equals("MedicalOfficer")){
            getMoAppointmentOptions().setVisible(true);
            getAdminAppointmentOptions().setVisible(false);
            getPatientAppointmentOptions().setVisible(false);
            getReceptionistAppointmentOptions().setVisible(false);  

        }
        
    }
    private void setMailOptions(){
          if(getUserRole().equals("Admin")){
              getAdminMailOptions().setVisible(true);
              getReceptionMailOptions().setVisible(false);
          
            
        }
        else if(getUserRole().equals("Receptionist")){
              getReceptionMailOptions().setVisible(true);
            getAdminMailOptions().setVisible(false);
            
            

        }
        else if(getUserRole().equals("Patient")){
            getAdminMailOptions().setVisible(false);

        }
        else if(getUserRole().equals("MedicalOfficer")){
            getAdminMailOptions().setVisible(false);
            
           

        }
        
    }
    private void setComplainOptions(){
          if(getUserRole().equals("Admin")){
            getPatientComplaintOptions().setVisible(false);
            getAdminComplaintOptions().setVisible(true);
            getReceptionistComplaintOptions().setVisible(false);
            
        }
        else if(getUserRole().equals("Receptionist")){
        getPatientComplaintOptions().setVisible(false);
        getAdminComplaintOptions().setVisible(false);
        getReceptionistComplaintOptions().setVisible(true);
            

        }
        else if(getUserRole().equals("Patient")){
            getPatientComplaintOptions().setVisible(true);
            getAdminComplaintOptions().setVisible(false);
            getReceptionistComplaintOptions().setVisible(false);

        }
        else if(getUserRole().equals("MedicalOfficer")){
           
            
           

        }
        
    }
    private void setUserOptions(){
           if(getUserRole().equals("Admin")){
            getAdminUserOptions().setVisible(true);
            getReceptionistUserOptions().setVisible(false);
            getJPanel6().setVisible(true);
            setOptionMo();
            
        }
        else if(getUserRole().equals("Receptionist")){
            getReceptionistUserOptions().setVisible(true);
            getAdminUserOptions().setVisible(false);
             getJPanel6().setVisible(false);
             setOptionPatient();
            
            

        }
        
    }
    private void setRefferenceOption(){
         if(getUserRole().equals("Admin")){
             getAdminRefferenceOptions().setVisible(true);
            
        }
        
    }
    private void setReportOptions(){
         if(getUserRole().equals("Admin")){
            getAppoinmentReportPanel().setVisible(true);
           getUserLogReportPanel().setVisible(false);
            getPatientCreditialReportPanel().setVisible(false);
        }
    
        
    }

    private void setVisitorOptions(){
        if(getUserRole().equals("Admin")){
            getAdminVisitorOptions().setVisible(true);
            getReceptionistVisitorOptions().setVisible(false);
            
        }
        else if(getUserRole().equals("Receptionist")){
          getAdminVisitorOptions().setVisible(false);
            getReceptionistVisitorOptions().setVisible(true);
            

        }
        
        
    }
    */
    
    
   /* public void setOptionMo(){
        resetHoverColor(jPanel7,jLabel66);
        setHoverColor(jPanel9,jLabel67);
        resetHoverColor(jPanel35,jLabel68);
        getMoScrollPanel().setVisible(true);
        getReceptionistScrollPanel().setVisible(false);
        getPatientScrollPanel().setVisible(false);
        
    }
    public void setOptionReceptionist(){
        setHoverColor(jPanel7,jLabel66);
        resetHoverColor(jPanel9,jLabel67);
        resetHoverColor(jPanel35,jLabel68);
        getReceptionistScrollPanel().setVisible(true);
        getMoScrollPanel().setVisible(false);
        getPatientScrollPanel().setVisible(false);
       
        
    }
    public void setOptionPatient(){
          resetHoverColor(jPanel7,jLabel66);
        resetHoverColor(jPanel9,jLabel67);
         setHoverColor(jPanel35,jLabel68);
         getMoScrollPanel().setVisible(false);
         getReceptionistScrollPanel().setVisible(false);
         getPatientScrollPanel().setVisible(true);
        
    }
    public void setAppoinmentReports(){
        resetHoverColor(jPanel38,jLabel79);
        setHoverColor(jPanel18,jLabel78);
        resetHoverColor(jPanel16,jLabel77);
        getAppoinmentReportPanel().setVisible(true);
        getUserLogReportPanel().setVisible(false);
        getPatientCreditialReportPanel().setVisible(false);
         setAppointmentReportTable();
    }
    public void setUserLogReports(){
        resetHoverColor(jPanel38,jLabel79);
        resetHoverColor(jPanel18,jLabel78);
        setHoverColor(jPanel16,jLabel77);
        getAppoinmentReportPanel().setVisible(false);
        getUserLogReportPanel().setVisible(true);
        getPatientCreditialReportPanel().setVisible(false);
        setUserLoginReportTable();
        
    }
    public void setPatientCredintialReports(){
        setHoverColor(jPanel38,jLabel79);
        resetHoverColor(jPanel18,jLabel78);
        resetHoverColor(jPanel16,jLabel77);
        getAppoinmentReportPanel().setVisible(false);
        getUserLogReportPanel().setVisible(false);
        getPatientCreditialReportPanel().setVisible(true);
         setPatientCredintialReportTable();
    }
    */
    
    
    
    
    
    
    
  /*  public void setHoverColor(JPanel panel,JLabel label){
                panel.setBackground(new Color(85,65,118));
                label.setForeground(Color.white);

    }
    
    public void resetHoverColor(JPanel panel,JLabel label){
                panel.setBackground(new Color(255,255,255));
                label.setForeground(new Color(102,0,102));

    }*/
    
    
    private void getPatientAppointmentTable(String id){
        ArrayList<String> list= FileService.getPatientAppointments(id);
        TableModel tm = getAppointmentTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
        System.out.println("patient appointments");  
             for(int i=0;i<list.size();i++)  
           {  
            
            String [] data=list.get(i).split(",");
            
             Object[] row = {data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7],data[8]};
                    model.addRow(row);
            
           }  
    }
    private void getMOAppointmentTable(String id){
          ArrayList<String> list= FileService.getMOAppointments(id);
        TableModel tm = getAppointmentTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
             for(int i=0;i<list.size();i++)  
           {  
            
            
            String [] data=list.get(i).split(",");
             Object[] row = {data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7],data[8]};
                    model.addRow(row);
            
           }  
        
    }
    private void getAllAppointment(){
        ArrayList<String> list= FileService.getRecords(FileService.getAppointmentsFile());
        TableModel tm = getAppointmentTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
       System.out.println("all appointments"); 
             for(int i=0;i<list.size();i++)  
           {  
            
            String [] data=list.get(i).split(",");
             Object[] row = {data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7],data[8],data[9]};
                    model.addRow(row);
            
           }  
        
    }
    private void getAllComplaints(){
         ArrayList<String> list= FileService.getRecords(FileService.getComplaintsFile());
        TableModel tm = getComplaintsTable().getModel();
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
    private void getPatientComplains(){
          ArrayList<String> list= FileService.getRecords(FileService.getComplaintsFile());
        TableModel tm = getComplaintsTable().getModel();
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
    private void getDispatchedMails(){
         ArrayList<String> list= FileService.getRecords(FileService.getMailsFile());
        TableModel tm = getMailsTable().getModel();
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
    private void getVisitorRecords(){
        ArrayList<String> list= FileService.getRecords(FileService.getVisitorsFile());
        TableModel tm = getVisitorsTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
             for(int i=0;i<list.size();i++)  
           {  
            
            String [] data=list.get(i).split(",");
             Object[] row = { data[0], data[1], data[2], data[3], data[4], data[5],data[6], data[7], data[8]};
                    model.addRow(row);
            
           }  
    }
    private void getAllUsers(){
       
             getAllMedicalOfficers();
           getAllReceptionist();
           getAllPatients();
        
    }
    public void getAllMedicalOfficers(){
        ArrayList<String> list= FileService.getRecords(FileService.getMoFile());
        TableModel tm = getMedicalOfficerTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
             for(int i=0;i<list.size();i++)  
           {  
            
            MedicalOfficer officer=MedicalOfficer.readMoUser(list.get(i));
           
             Object[] row = {officer.getUserName(),officer.getName(),officer.getGender(),officer.getphoneNumber(),officer.getIdCardNo(),officer.getDateOfBirth(),officer.getAddress(),officer.getMaritalStatus(),officer.getPassword(),officer.getStrStaffId(),officer.getStrEmailAddress(),officer.getStrDateOfJoining(),officer.getCvFile(),officer.getStrSpecialityArea(),officer.getPhoto()};
                    model.addRow(row);
            
           }  
     
    }
    public void getAllReceptionist(){
        ArrayList<String> list= FileService.getRecords(FileService.getReceptionistFile());
        TableModel tm = getReceptionistTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
             for(int i=0;i<list.size();i++)  
           {   
        Receptionist officer=Receptionist.readReceptionistUser(list.get(i));
             Object[] row = { officer.getUserName(),officer.getName(),officer.getGender(),officer.getphoneNumber(),officer.getIdCardNo(),officer.getDateOfBirth(),officer.getAddress(),officer.getMaritalStatus(),officer.getPassword(),officer.getStrStaffId(),officer.getStrEmailAddress(),officer.getStrDateOfJoining(),officer.getCvFile(),officer.getPhoto()};
                    model.addRow(row);
            
           }    
    }
    private void getAllPatients(){
         ArrayList<String> list= FileService.getRecords(FileService.getPatientsFile());
        TableModel tm = getPatientsTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
             for(int i=0;i<list.size();i++)  
           {  
            
            Patient patient=Patient.readPatientUser(list.get(i));
             Object[] row = {patient.getUserName(),patient.getName(),patient.getGender(),patient.getphoneNumber(),patient.getIdCardNo(),patient.getDateOfBirth(),patient.getAddress(),patient.getMaritalStatus(),patient.getPassword(),patient.getStrBloodGrp(),patient.getStrAllergies()};
             model.addRow(row);
            
           }  
        
    }
    private void setComplainRefference(){
       // setColor(getComplainReferencePanel());
       // resetColor(getSpecialityReferencePanel());
        getComplainRefference();
        
    }
    private void setSpecialityRefference(){
       // setColor(getSpecialityReferencePanel());
       // resetColor(getComplainReferencePanel());
        getSpecialityRefference();         
    }
    private void getComplainRefference(){
            ComplainRefference refference = new ComplainRefference();
           ArrayList<String> complainRefferenceList = refference.getComplainTypes();
            DefaultListModel<String> model = new DefaultListModel<String>();
             getComplaintReferenceList().setModel(model);
          for(String s:complainRefferenceList){
                 model.addElement(s);
                }
    }
    private void getSpecialityRefference(){
       SpecialityRefference refference=new SpecialityRefference();
       ArrayList<String> specialityRefferenceList = refference.getSpecialityTypes();
        DefaultListModel<String> model2 = new DefaultListModel<String>();
        getSpecialityRefferenceList().setModel(model2);
        for(String s:specialityRefferenceList){
                 model2.addElement(s);
                }          
         }
     
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
    
    
  /*  public void setColor(JPanel panel){
         panel.setBackground(new Color(85,65,118));
    }
     
    public  void resetAllMainPanels(){
        getUsersPanel().setVisible(false);
        getComplaintPanel().setVisible(false);
        getMailPanel().setVisible(false);
        getAppointmentPanel().setVisible(false);
        getReportsPanel().setVisible(false);
        getSettingsPanel().setVisible(false);
        getRefferencePanel().setVisible(false);
        getVisitorsPanel().setVisible(false);
     }
    public void resetAllColor(){
        getAppointmentBtnPanel4().setBackground(new Color(64,43,100));
        getHomeBtnPanel1().setBackground(new Color(64,43,100));
        getHomeBtnPanel2().setBackground(new Color(64,43,100));
        getHomeBtnPanel3().setBackground(new Color(64,43,100));
        getHomeBtnPanel4().setBackground(new Color(64,43,100));            
        getMoSettingBtnPanel().setBackground(new Color(64,43,100));
        getAppointmentBtnPanel3().setBackground(new Color(64,43,100));
        getComplaintBtnPanel2().setBackground(new Color(64,43,100));
        getPatientSettingBtnPanel().setBackground(new Color(64,43,100));
        getAppointmentBtnPanel2().setBackground(new Color(64,43,100));
        getMailBtnPanel2().setBackground(new Color(64,43,100));
        getComplaintBtnPanel3().setBackground(new Color(64,43,100));
        getVisitorBtnPanel2().setBackground(new Color(64,43,100));
        getReceptionistSettingBtnPanel().setBackground(new Color(64,43,100));
        getUserBtnPanel2().setBackground(new Color(64,43,100));
        getUserBtnPanel().setBackground(new Color(64,43,100));
        getReportBtnPanel().setBackground(new Color(64,43,100));
        getAppointmentBtnPanel1().setBackground(new Color(64,43,100));
        getMailBtnPanel1().setBackground(new Color(64,43,100));
        getComplaintBtnPanel1().setBackground(new Color(64,43,100));
        getVisitorBtnPanel1().setBackground(new Color(64,43,100));
        getAdminSettingBtnPanel().setBackground(new Color(64,43,100));
        getRefferenceBtnPanel().setBackground(new Color(64,43,100));
    }
     void resetColor(JPanel panel){
        panel.setBackground(new Color(64,43,100));
       
        
    }*/
     
     
     
     //appoinment functions here
  /*  public void addNewAppointment(){
         AddAppointment appointmentView = new AddAppointment(this, new Appointment(),1);
         appointmentView.setVisible(true);
         
    }
    public void editAppointment(){
        Object record= ((DefaultTableModel) appointmentTable.getModel()).getDataVector().elementAt(appointmentTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getAppointmentsFilePath();
                   Appointment appointment=Appointment.readAppoinment(line);
                   AddAppointment appointmentView = new AddAppointment(this, appointment,2);
                   appointmentView.setVisible(true);
                   // EditAppointment edit=new EditAppointment(appointment,this);
                   
    } */
    /* public void deleteAppointment(){
         
         
          Object record= ((DefaultTableModel) appointmentTable.getModel()).getDataVector().elementAt(appointmentTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                   // String path=FileService.getAppointmentsFilePath();
                    AddAppointment appointmentView = new AddAppointment(this, Appointment.readAppoinment(line),2);
                    appointmentView.setVisible(true);
                    appointmentView.getController().deleteAppoinment();
                   if(AlertService.optionalPlane("Would you like to Delete the Appoinment Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
                    FileService.deleteRecord(path, line);
                     this.setTables();
                    }
    } */
     /*public void approveAppoinment(String status){
         Object record= ((DefaultTableModel) appointmentTable.getModel()).getDataVector().elementAt(appointmentTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    //String path=FileService.getAppointmentsFilePath();
                   // FileService.deleteRecord(path, line);
                    Appointment appointment=Appointment.readAppoinment(line);
                    
                    //FileService.addLine(path, appointment.toString());
                    // this.setTables();
                    AddAppointment appointmentView = new AddAppointment(this, Appointment.readAppoinment(line),2);
                   appointmentView.setStatus("Approved");
                    
     }*/
  
   
     //complaint functions here
   /*   private void addNewComplaint(){
        AddComplaint complaint = new AddComplaint(this.getUserRole(),this);
    }
     private void deleteComplaint(){
          Object record= ((DefaultTableModel) complaintTable.getModel()).getDataVector().elementAt(complaintTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getComplaintsFilePath();
                    if(AlertService.optionalPlane("Would you like to Delete the Complaint Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
                    FileService.deleteRecord(path, line);
                    this.setTables();}
         
     }
     private void editComplaint(){
          Object record= ((DefaultTableModel) complaintTable.getModel()).getDataVector().elementAt(complaintTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getComplaintsFilePath();
                    Complaint complain= Complaint.readComplaint(line);
                    EditComplaint edit=new EditComplaint(complain,this);
     }
     public void editApproveAction(String action){
           Object record= ((DefaultTableModel) complaintTable.getModel()).getDataVector().elementAt(complaintTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getComplaintsFilePath();
                    FileService.deleteRecord(path,line);
                    Complaint complain= Complaint.readComplaint(line);
                    complain.setStrActionTaken(action);
                    FileService.addLine(path, complain.toString());
                    this.setTables();
         
     }*/
     
     //mails functions here
     /* private void addDispatchedPostal(){
        AddMail mail = new AddMail(this);
    }
     private void deleteMail(){
          Object record= ((DefaultTableModel) dispatchedMailTable.getModel()).getDataVector().elementAt(dispatchedMailTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getMailsFilePath();
            if(AlertService.optionalPlane("Would you like to Delete the Mail Record?", "Warning!")==JOptionPane.YES_NO_OPTION){

                    FileService.deleteRecord(path, line);
                    this.setTables();
                    }
         
     }
     private void editMail(){
          Object record= ((DefaultTableModel) dispatchedMailTable.getModel()).getDataVector().elementAt(dispatchedMailTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getMailsFilePath();
                    DispatchedPostal mail= DispatchedPostal.readMail(line);
                    EditMail edit=new EditMail(mail,this);
         
     }*/
     
   //visitor records functions here
   /* private void addNewVisitorRecord(){
        AddVisitors record = new AddVisitors(this);
    } 
    private void deleteVisitorRecord(){
        Object record= ((DefaultTableModel) visitorTable.getModel()).getDataVector().elementAt(visitorTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getVisitorsFilePath();
                    if(AlertService.optionalPlane("Would you like to Delete the Visitor Record?", "Warning!")==JOptionPane.YES_NO_OPTION){
                    FileService.deleteRecord(path, line);
                    this.setTables();}
        
    }
    private void editVisitorRecord(){
        Object record= ((DefaultTableModel) visitorTable.getModel()).getDataVector().elementAt(visitorTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getVisitorsFilePath();
                    Visitor visitor =Visitor.readVisitor(line) ;
                    EditVisitor edit =new EditVisitor(visitor,this);
    }*/
   
    
  //report functons here
    
/*private void setMoComboBox(){      
    Object[] items=  FileService.getAllMo(FileService.getRecords(FileService.getMoFile())).toArray();     
    DefaultComboBoxModel model = new DefaultComboBoxModel(items);
    getAppointmentReportMoComboBox().setModel( model );
    }
private void setAppointmentReportTable(){
        String date=PipeService.getDateSimpleFormat(getAppointmentReportDateChooser().getDate());
        MedicalOfficer officer=(MedicalOfficer) getAppointmentReportMoComboBox().getSelectedItem();
         ArrayList<String> list= FileService.getRecords(FileService.getAppointmentsFile());
        TableModel tm = getAppointmentReportTable().getModel();
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
private void setUserLoginReportTable(){
         String date=PipeService.getDateSimpleFormat(getUserLoginReportDateChooser3().getDate());
         String role =getUserLoginReportComboBox().getSelectedItem().toString();
         ArrayList<String> list= FileService.getRecords(FileService.getUserLoginFile());
        TableModel tm = getUserLogReportTable().getModel();
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
private void setPatientCredintialReportTable(){
         ArrayList<String> list= FileService.getRecords(FileService.getPatientsFile());
        TableModel tm = getPatientCredintialTable().getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
                
             for(int i=0;i<list.size();i++)  
           {  
            
            Patient patient=Patient.readPatientUser(list.get(i));
             Object[] row = {patient.getUserName(),patient.getName(),patient.getPassword()};
             model.addRow(row);
            
           }  
        
    } */
     
   
     
     


       
     
     
     
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Passwordfield;
    private javax.swing.JTextField PhoneNofield;
    private javax.swing.JButton addAppointmentBtn;
    private javax.swing.JButton addAppointmentBtn2;
    private javax.swing.JButton addComplaintBtn;
    private javax.swing.JButton addComplaintBtn2;
    private javax.swing.JButton addMailBtn;
    private javax.swing.JButton addReferenceBtn;
    private javax.swing.JButton addUsersBtn;
    private javax.swing.JButton addUsersBtn2;
    private javax.swing.JButton addVisitorBtn;
    private javax.swing.JTextArea addressField;
    private javax.swing.JPanel adminAppointmentOptions;
    private javax.swing.JPanel adminComplaintOptions;
    private javax.swing.JPanel adminMailOptions;
    private javax.swing.JPanel adminRefferenceOptions;
    private javax.swing.JPanel adminSidePanel;
    private javax.swing.JPanel adminUserOptions;
    private javax.swing.JPanel adminVisitorOptions;
    private javax.swing.JPanel appoinmentReportPanel;
    private javax.swing.JButton appoinmentReportPdfBtn;
    private javax.swing.JPanel appointmentBtnPanel1;
    private javax.swing.JPanel appointmentBtnPanel2;
    private javax.swing.JPanel appointmentBtnPanel3;
    private javax.swing.JPanel appointmentBtnPanel4;
    private javax.swing.JPanel appointmentMainOption;
    private javax.swing.JPanel appointmentPanel;
    private javax.swing.JButton appointmentReportCsvBtn;
    private com.toedter.calendar.JDateChooser appointmentReportDateChooser;
    private javax.swing.JComboBox<String> appointmentReportMoComboBox;
    private javax.swing.JPanel appointmentReportOptionPanel;
    private javax.swing.JButton appointmentReportPrepareBtn;
    private javax.swing.JTable appointmentReportTable;
    private javax.swing.JTable appointmentTable;
    private javax.swing.JButton approveAppoinmentBtn;
    private javax.swing.JButton approveComplaintBtn;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JPanel complainReferenceOptionPanel;
    private javax.swing.JList<String> complainRefferenceList;
    private javax.swing.JPanel complaintBtnPanel1;
    private javax.swing.JPanel complaintBtnPanel2;
    private javax.swing.JPanel complaintBtnPanel3;
    private javax.swing.JPanel complaintPanel;
    private javax.swing.JScrollPane complaintReferencejScrollPanel;
    private javax.swing.JTable complaintTable;
    private javax.swing.JPanel complaintsMainOption;
    private javax.swing.JButton completedAppointmentBtn;
    private javax.swing.JButton deleteAppointmentBtn;
    private javax.swing.JButton deleteComplaintBtn;
    private javax.swing.JButton deleteMailBtn;
    private javax.swing.JButton deleteMailBtn2;
    private javax.swing.JButton deleteReferenceBtn;
    private javax.swing.JButton deleteUsersBtn;
    private javax.swing.JButton deleteUsersBtn2;
    private javax.swing.JButton deleteVisitorBtn;
    private javax.swing.JButton deleteVisitorBtn2;
    private javax.swing.JTable dispatchedMailTable;
    private javax.swing.JButton editAppointmentBtn;
    private javax.swing.JButton editComplaintBtn;
    private javax.swing.JButton editMailBtn;
    private javax.swing.JButton editReferenceBtn;
    private javax.swing.JButton editUsersBtn;
    private javax.swing.JButton editUsersBtn2;
    private javax.swing.JButton editVisitorBtn;
    private javax.swing.JComboBox<String> genderComboBox1;
    private javax.swing.JButton generatePdfBtn;
    private javax.swing.JPanel homeBtnPanel1;
    private javax.swing.JPanel homeBtnPanel2;
    private javax.swing.JPanel homeBtnPanel3;
    private javax.swing.JPanel homeBtnPanel4;
    private javax.swing.JPanel homePanel;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel logOutBtnPanel1;
    private javax.swing.JPanel logOutBtnPanel2;
    private javax.swing.JPanel logOutBtnPanel3;
    private javax.swing.JPanel logOutBtnPanel4;
    private javax.swing.JPanel mailBtnPanel1;
    private javax.swing.JPanel mailBtnPanel2;
    private javax.swing.JPanel mailMainOption;
    private javax.swing.JPanel mailPanel;
    private javax.swing.JComboBox<String> martialStatusComboBox2;
    private javax.swing.JPanel moAppointmentOptions;
    private javax.swing.JScrollPane moScrollPanel;
    private javax.swing.JPanel moSettingBtnPanel;
    private javax.swing.JPanel moSidePanel;
    public javax.swing.JTable moTable;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nicField;
    private javax.swing.JPanel patientAppointmentOptions;
    private javax.swing.JPanel patientComplaintOptions;
    private javax.swing.JPanel patientCredentialReportOptionPanel;
    private javax.swing.JButton patientCredintialCsvBtn;
    private javax.swing.JButton patientCredintialPdfBtn;
    private javax.swing.JTable patientCredintialTable;
    private javax.swing.JPanel patientCreditialReportPanel;
    private javax.swing.JScrollPane patientScrollPanel;
    private javax.swing.JPanel patientSettingBtnPanel;
    private javax.swing.JPanel patientSidePanel;
    private javax.swing.JTable patientsTable;
    private javax.swing.JButton photoAddBtn;
    private javax.swing.JPanel photoUploadedPanel1;
    private javax.swing.JLabel profileImg;
    private javax.swing.JLabel profileImg1;
    private javax.swing.JLabel profileImg2;
    private javax.swing.JLabel profileImg3;
    private javax.swing.JPanel receptionAppointmentOptions;
    private javax.swing.JPanel receptionMailOptions;
    private javax.swing.JPanel receptionSidePanel;
    private javax.swing.JPanel receptionistComplaintOptions;
    private javax.swing.JScrollPane receptionistScrollPanel;
    private javax.swing.JPanel receptionistSettingBtnPanel;
    private javax.swing.JTable receptionistTable;
    private javax.swing.JPanel receptionistUserOptions;
    private javax.swing.JPanel receptionistVisitorOptions;
    private javax.swing.JPanel refferenceBtnPanel;
    private javax.swing.JPanel refferenceMainOption;
    private javax.swing.JPanel refferencePanel;
    private javax.swing.JPanel reportBtnPanel;
    private javax.swing.JPanel reportsPanel;
    private javax.swing.JButton resetPasswordBtn;
    private javax.swing.JButton resetPasswordBtn2;
    private javax.swing.JButton saveUserBtn;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JPanel specialityListPanel;
    private javax.swing.JScrollPane specialityReferenceJScrollPanel;
    private javax.swing.JPanel specialityReferenceOptionPanel;
    private javax.swing.JList<String> specialityRefferenceList;
    private javax.swing.JPanel userBtnPanel;
    private javax.swing.JPanel userBtnPanel2;
    private javax.swing.JButton userLogPrepareBtn;
    private javax.swing.JButton userLogReportCsvBtn;
    private javax.swing.JPanel userLogReportOptionPanel;
    private javax.swing.JPanel userLogReportPanel;
    private javax.swing.JButton userLogReportPdfBtn;
    private javax.swing.JTable userLogReportTable;
    private javax.swing.JComboBox<String> userLoginReportComboBox;
    private com.toedter.calendar.JDateChooser userLoginReportDateChooser3;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel userNameLabel1;
    private javax.swing.JLabel userNameLabel2;
    private javax.swing.JLabel userNameLabel3;
    private javax.swing.JLabel userPhotoLabel;
    private javax.swing.JPanel usersMainOption;
    private javax.swing.JPanel usersPanel;
    private javax.swing.JPanel visitorBtnPanel1;
    private javax.swing.JPanel visitorBtnPanel2;
    private javax.swing.JTable visitorTable;
    private javax.swing.JPanel visitorsMainOption;
    private javax.swing.JPanel visitorsPanel;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


/**
 *
 * @author sajath
 */
public class Dashboard extends javax.swing.JFrame implements ActionListener {
    private String userRole;

    /**
     * Creates new form dashboard
     * @param role
     */
    public Dashboard(String role) {
        initComponents();
        this.setVisible(true);
        setHome();
        setRole(role);
        setSidePanel(role);
        setTables();
        setSideBarPanels();
        
      

        
    }
    private Dashboard() {
    }
    public void setRole(String role){
        this.userRole=role;
    }
    public String getUserRole(){
        return this.userRole;
    }
    
     
     
     
     //others methods
    public void setSidePanel(String role){
        if(getUserRole().equals("Admin")){
            receptionSidePanel.setVisible(false);
            adminSidePanel.setVisible(true);
            patientSidePanel.setVisible(false);
            moSidePanel.setVisible(false);
            
        }
        else if(getUserRole().equals("Receptionist")){
            receptionSidePanel.setVisible(true);
            adminSidePanel.setVisible(false);
              patientSidePanel.setVisible(false);
            moSidePanel.setVisible(false);
            

        }
        else if(getUserRole().equals("Patient")){
             patientSidePanel.setVisible(true);
            moSidePanel.setVisible(false);
            receptionSidePanel.setVisible(false);
            adminSidePanel.setVisible(false);

        }
        else if(getUserRole().equals("MedicalOfficer")){
            patientSidePanel.setVisible(false);
            moSidePanel.setVisible(true);
            receptionSidePanel.setVisible(false);
            adminSidePanel.setVisible(false);
            
           

        }
        
    }
    
    public void  setHome(){
         resetAllMainPanels();
          homePanel.setVisible(true);
           complaintsMainOption.setVisible(false);
            appointmentMainOption.setVisible(false);
            visitorsMainOption.setVisible(false);
            mailMainOption.setVisible(false);
            usersMainOption.setVisible(false);
            refferenceMainOption.setVisible(false);
            jDateChooser2.setDate(new Date());
    }
    
    
    public void setSideBarPanels(){
        homeBtnPanel1.addMouseListener(listener);
          homeBtnPanel2.addMouseListener(listener);
            homeBtnPanel3.addMouseListener(listener);
              homeBtnPanel4.addMouseListener(listener);
         jPanel23.addMouseListener(listener);
        moSettingPanel.addMouseListener(listener);
        jPanel5.addMouseListener(listener);
        jPanel17.addMouseListener(listener);
        patientSettingPanel.addMouseListener(listener);
        jPanel31.addMouseListener(listener);
        jPanel32.addMouseListener(listener);
        jPanel33.addMouseListener(listener);
        visitorBtnPanel2.addMouseListener(listener);
        receptionistSettingPanel.addMouseListener(listener);
        userBtnPanel2.addMouseListener(listener);
        userBtnPanel.addMouseListener(listener);
        reportBtnPanel.addMouseListener(listener);
        appointmentBtnPanel.addMouseListener(listener);
        mailBtnPanel.addMouseListener(listener);
        complaintBtnPanel.addMouseListener(listener);
        visitorBtnPanel.addMouseListener(listener);
        settingBtnPanel.addMouseListener(listener);
        refferenceBtnPanel.addMouseListener(listener);
        
        homeBtnPanel1.setName("homeBtn");
        homeBtnPanel2.setName("homeBtn");
        homeBtnPanel3.setName("homeBtn");
        homeBtnPanel4.setName("homeBtn");
        
        jPanel31.setName("appointmentBtnPanel");//recep
        appointmentBtnPanel.setName("appointmentBtnPanel");//admin
        jPanel5.setName("appointmentBtnPanel");
        jPanel23.setName("appointmentBtnPanel");
        
        mailBtnPanel.setName("mailBtn");
        jPanel32.setName("mailBtn");
       
        
        complaintBtnPanel.setName("complaintBtn");
        jPanel17.setName("complaintBtn");
        jPanel33.setName("complaintBtn");
        
        visitorBtnPanel2.setName("visitorBtn");
        visitorBtnPanel.setName("visitorBtn");
        
        settingBtnPanel.setName("settingBtn");
        receptionistSettingPanel.setName("settingBtn");
        moSettingPanel.setName("settingBtn");
        patientSettingPanel.setName("settingBtn");
        
         userBtnPanel.setName("userBtn");
        userBtnPanel2.setName("userBtn");
        
        reportBtnPanel.setName("reportBtn");
        
        refferenceBtnPanel.setName("refferenceBtn");
        
                  
        
    }
    
    MouseListener listener = new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        resetAllColor();
                        //
                     
                        System.out.println(((JPanel)e.getSource()).getName());
                     if( ((JPanel)e.getSource()).getName().equals("complaintBtn")){
                         setColor(complaintBtnPanel);
                         setColor(jPanel17);
                         setColor(jPanel33);
                          setTables();
                         homePanel.setVisible(false);
                         appointmentPanel.setVisible(false);
                          refferencePanel.setVisible(false);                        
                          mailPanel.setVisible(false);
                         reportsPanel.setVisible(false);
                          visitorsPanel.setVisible(false);
                          settingsPanel.setVisible(false);
                          usersPanel.setVisible(false);
                        complaintPanel.setVisible(true);
                        
                        complaintsMainOption.setVisible(true);
                        appointmentMainOption.setVisible(false);
                        visitorsMainOption.setVisible(false);
                        mailMainOption.setVisible(false);
                        usersMainOption.setVisible(false);
                        refferenceMainOption.setVisible(false);
                         setComplainOptions();

                         
                     }
                     else if(((JPanel)e.getSource()).getName().equals("appointmentBtnPanel")){
                          setColor(jPanel5);
                         setColor(appointmentBtnPanel);
                         setColor(jPanel31);
                          setColor(jPanel23);
                           setTables();
                           homePanel.setVisible(false); 
                         complaintPanel.setVisible(false);
                          refferencePanel.setVisible(false);                        
                          mailPanel.setVisible(false);
                         reportsPanel.setVisible(false);
                          visitorsPanel.setVisible(false);
                          settingsPanel.setVisible(false);
                          usersPanel.setVisible(false);
                        appointmentPanel.setVisible(true);
                        
                        
                         complaintsMainOption.setVisible(false);
                        appointmentMainOption.setVisible(true);
                        visitorsMainOption.setVisible(false);
                        mailMainOption.setVisible(false);
                        usersMainOption.setVisible(false);
                        refferenceMainOption.setVisible(false);
                               

                        setAppointmentOptions();

                         
                     }
                     else if(((JPanel)e.getSource()).getName().equals("mailBtn")){
                          setColor(mailBtnPanel);
                         setColor(jPanel32);
                          setTables();
                          homePanel.setVisible(false);
                         appointmentPanel.setVisible(false);
                         complaintPanel.setVisible(false);
                          refferencePanel.setVisible(false);                        
                         reportsPanel.setVisible(false);
                          visitorsPanel.setVisible(false);
                          settingsPanel.setVisible(false);
                          usersPanel.setVisible(false);
                        mailPanel.setVisible(true);
                        
                         complaintsMainOption.setVisible(false);
                        appointmentMainOption.setVisible(false);
                        visitorsMainOption.setVisible(false);
                        mailMainOption.setVisible(true);
                        usersMainOption.setVisible(false);
                        refferenceMainOption.setVisible(false);
                        setMailOptions();

                         
                         
                     }
                     else if(((JPanel)e.getSource()).getName().equals("userBtn")){
                          setColor(userBtnPanel);
                         setColor(userBtnPanel2);
                          setTables();
                          homePanel.setVisible(false);
                            appointmentPanel.setVisible(false);
                         complaintPanel.setVisible(false);
                          refferencePanel.setVisible(false);                        
                          mailPanel.setVisible(false);
                         reportsPanel.setVisible(false);
                          visitorsPanel.setVisible(false);
                          settingsPanel.setVisible(false);
                          usersPanel.setVisible(true);
                          
                           complaintsMainOption.setVisible(false);
                        appointmentMainOption.setVisible(false);
                        visitorsMainOption.setVisible(false);
                        mailMainOption.setVisible(false);
                        usersMainOption.setVisible(true);
                        refferenceMainOption.setVisible(false);
                        setUserOptions();
                         
                         
                     }
                     else if(((JPanel)e.getSource()).getName().equals("settingBtn")){
                           setColor(settingBtnPanel);
                         setColor(receptionistSettingPanel);
                         setColor(moSettingPanel);
                         setTables();
                       
                          setColor(patientSettingPanel);
                          homePanel.setVisible(false);
                          usersPanel.setVisible(false);
                          appointmentPanel.setVisible(false);
                         complaintPanel.setVisible(false);
                          refferencePanel.setVisible(false);                        
                          mailPanel.setVisible(false);
                         reportsPanel.setVisible(false);
                          visitorsPanel.setVisible(false);
                          settingsPanel.setVisible(true);
                          
                           complaintsMainOption.setVisible(false);
                        appointmentMainOption.setVisible(false);
                        visitorsMainOption.setVisible(false);
                        mailMainOption.setVisible(false);
                        usersMainOption.setVisible(false);
                        refferenceMainOption.setVisible(false);
                          setSettingsOptions();
                     }
                     else if(((JPanel)e.getSource()).getName().equals("visitorBtn")){
                          setTables();
                         setColor(visitorBtnPanel);
                         setColor(visitorBtnPanel2);        
                        
                         homePanel.setVisible(false);
                             usersPanel.setVisible(false);
                            appointmentPanel.setVisible(false);
                         complaintPanel.setVisible(false);
                          refferencePanel.setVisible(false);
                          settingsPanel.setVisible(false);
                          mailPanel.setVisible(false);
                         reportsPanel.setVisible(false);
                          visitorsPanel.setVisible(true);
                          
                          complaintsMainOption.setVisible(false);
                        appointmentMainOption.setVisible(false);
                        visitorsMainOption.setVisible(true);
                        mailMainOption.setVisible(false);
                        usersMainOption.setVisible(false);
                        refferenceMainOption.setVisible(false);
                         setVisitorOptions();
                     }
                      else if(((JPanel)e.getSource()).getName().equals("refferenceBtn")){
                         setColor(refferenceBtnPanel);
                        
                          setTables();
                         setComplainRefference();
                         
                         homePanel.setVisible(false);
                           visitorsPanel.setVisible(false);
                             usersPanel.setVisible(false);
                            appointmentPanel.setVisible(false);
                         complaintPanel.setVisible(false);
                          settingsPanel.setVisible(false);
                          mailPanel.setVisible(false);
                         reportsPanel.setVisible(false);
                           refferencePanel.setVisible(true);
                           
                            complaintsMainOption.setVisible(false);
                        appointmentMainOption.setVisible(false);
                        visitorsMainOption.setVisible(false);
                        mailMainOption.setVisible(false);
                        usersMainOption.setVisible(false);
                        refferenceMainOption.setVisible(true);
                        setRefferenceOption();
                     }
                      else if(((JPanel)e.getSource()).getName().equals("reportBtn")){
                         setColor(reportBtnPanel);
                          setTables();
                        
                          homePanel.setVisible(false);
                           visitorsPanel.setVisible(false);
                             usersPanel.setVisible(false);
                            appointmentPanel.setVisible(false);
                         complaintPanel.setVisible(false);
                          refferencePanel.setVisible(false);
                          settingsPanel.setVisible(false);
                          mailPanel.setVisible(false);
                         reportsPanel.setVisible(true);
                         
                          complaintsMainOption.setVisible(false);
                        appointmentMainOption.setVisible(false);
                        visitorsMainOption.setVisible(false);
                        mailMainOption.setVisible(false);
                        usersMainOption.setVisible(false);
                        refferenceMainOption.setVisible(false);
                        setMoComboBox();
                          setReportOptions();
                     }
                     else if(((JPanel)e.getSource()).getName().equals("homeBtn")){
                         setColor(homeBtnPanel1);
                          setColor(homeBtnPanel2);
                           setColor(homeBtnPanel3);
                            setColor(homeBtnPanel4);
                          setTables();
                        
                          
                           visitorsPanel.setVisible(false);
                             usersPanel.setVisible(false);
                            appointmentPanel.setVisible(false);
                         complaintPanel.setVisible(false);
                          refferencePanel.setVisible(false);
                          settingsPanel.setVisible(false);
                          mailPanel.setVisible(false);
                         reportsPanel.setVisible(false);
                         homePanel.setVisible(true);
                         
                          complaintsMainOption.setVisible(false);
                        appointmentMainOption.setVisible(false);
                        visitorsMainOption.setVisible(false);
                        mailMainOption.setVisible(false);
                        usersMainOption.setVisible(false);
                        refferenceMainOption.setVisible(false);
                         
                     }
                     
                     
                     
                    }
                };
    
    
     public void actionPerformed(ActionEvent e) {
           System.out.println("event "+e);
        if(e.getSource() == jPanel23){
            System.out.println("japnel 23");
        }
    } 
      public void actionPerformedBtn(ActionEvent e) {
        
    } 

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
        appointmentBtnPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mailBtnPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        complaintBtnPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        reportBtnPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        visitorBtnPanel = new javax.swing.JPanel();
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
        settingBtnPanel1 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        userNameLabel = new javax.swing.JLabel();
        settingBtnPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        patientSidePanel = new javax.swing.JPanel();
        profileImg1 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        patientSettingPanel = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        homeBtnPanel3 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        patientSettingPanel1 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        userNameLabel1 = new javax.swing.JLabel();
        moSidePanel = new javax.swing.JPanel();
        profileImg2 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        moSettingPanel = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        homeBtnPanel2 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        userNameLabel2 = new javax.swing.JLabel();
        receptionSidePanel = new javax.swing.JPanel();
        profileImg3 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
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
        receptionistSettingPanel1 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        userNameLabel3 = new javax.swing.JLabel();
        receptionistSettingPanel = new javax.swing.JPanel();
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        moComboBox = new javax.swing.JComboBox<>();
        userLogReportPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        appointmentTable4 = new javax.swing.JTable();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        patientCreditialReportPanel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        appointmentTable5 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        refferencePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        specialityListPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        refferenceList = new javax.swing.JList<>();
        settingsPanel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        usernamefield = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        namefield = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        Passwordfield = new javax.swing.JPasswordField();
        jLabel50 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel60 = new javax.swing.JLabel();
        PhoneNofield = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        NICNofield = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        AddressField = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        dateJoinedField = new com.toedter.calendar.JDateChooser();
        jLabel49 = new javax.swing.JLabel();
        staffIdField = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        staffEmailField = new javax.swing.JTextField();
        photoUploadedPanel1 = new javax.swing.JPanel();
        receptionistPhotoLabel = new javax.swing.JLabel();
        photoAddBtn2 = new javax.swing.JButton();
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
        jButton5 = new javax.swing.JButton();
        receptionAppointmentOptions = new javax.swing.JPanel();
        approveAppoinmentBtn9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        generatePdfBtn = new javax.swing.JButton();
        editBtn5 = new javax.swing.JButton();
        patientAppointmentOptions = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        moAppointmentOptions = new javax.swing.JPanel();
        moAppoinmentCompleteBtn = new javax.swing.JButton();
        usersMainOption = new javax.swing.JPanel();
        adminUserOptions = new javax.swing.JPanel();
        adminDeleteUser = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        viewBtn11 = new javax.swing.JButton();
        addBtn11 = new javax.swing.JButton();
        receptionUserOptions = new javax.swing.JPanel();
        deleteBtn15 = new javax.swing.JButton();
        editBtn7 = new javax.swing.JButton();
        addBtn10 = new javax.swing.JButton();
        mailMainOption = new javax.swing.JPanel();
        adminMailOptions = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        receptionMailOptions = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        editBtn6 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        complaintsMainOption = new javax.swing.JPanel();
        adminComplaintOptions = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        editBtn3 = new javax.swing.JButton();
        approveBtn3 = new javax.swing.JButton();
        patientComplaintOptions = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        receptionComplaintOptions = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        visitorsMainOption = new javax.swing.JPanel();
        receptionVisitorOptions = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        editBtn8 = new javax.swing.JButton();
        addBtn13 = new javax.swing.JButton();
        adminVisitorOptions = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        refferenceMainOption = new javax.swing.JPanel();
        adminRefferenceOptions = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        editBtn2 = new javax.swing.JButton();
        addBtn12 = new javax.swing.JButton();

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

        appointmentBtnPanel.setBackground(new java.awt.Color(64, 43, 100));
        appointmentBtnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        appointmentBtnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                appointmentBtnPanelMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Appointments");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/calendar 32.png"))); // NOI18N

        javax.swing.GroupLayout appointmentBtnPanelLayout = new javax.swing.GroupLayout(appointmentBtnPanel);
        appointmentBtnPanel.setLayout(appointmentBtnPanelLayout);
        appointmentBtnPanelLayout.setHorizontalGroup(
            appointmentBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentBtnPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        appointmentBtnPanelLayout.setVerticalGroup(
            appointmentBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appointmentBtnPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.add(appointmentBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 250, 50));

        mailBtnPanel.setBackground(new java.awt.Color(64, 43, 100));
        mailBtnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mailBtnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mailBtnPanelMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mail");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/mail_configuration_24px.png"))); // NOI18N

        javax.swing.GroupLayout mailBtnPanelLayout = new javax.swing.GroupLayout(mailBtnPanel);
        mailBtnPanel.setLayout(mailBtnPanelLayout);
        mailBtnPanelLayout.setHorizontalGroup(
            mailBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mailBtnPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        mailBtnPanelLayout.setVerticalGroup(
            mailBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mailBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mailBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(mailBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 250, 50));

        complaintBtnPanel.setBackground(new java.awt.Color(64, 43, 100));
        complaintBtnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        complaintBtnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                complaintBtnPanelMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Complaints");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/documents_30px.png"))); // NOI18N

        javax.swing.GroupLayout complaintBtnPanelLayout = new javax.swing.GroupLayout(complaintBtnPanel);
        complaintBtnPanel.setLayout(complaintBtnPanelLayout);
        complaintBtnPanelLayout.setHorizontalGroup(
            complaintBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaintBtnPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        complaintBtnPanelLayout.setVerticalGroup(
            complaintBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaintBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(complaintBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(complaintBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 250, 50));

        reportBtnPanel.setBackground(new java.awt.Color(64, 43, 100));
        reportBtnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        reportBtnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reportBtnPanelMousePressed(evt);
            }
        });

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

        visitorBtnPanel.setBackground(new java.awt.Color(64, 43, 100));
        visitorBtnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        visitorBtnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                visitorBtnPanelMousePressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Visitors");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/myspace_app_24px.png"))); // NOI18N

        javax.swing.GroupLayout visitorBtnPanelLayout = new javax.swing.GroupLayout(visitorBtnPanel);
        visitorBtnPanel.setLayout(visitorBtnPanelLayout);
        visitorBtnPanelLayout.setHorizontalGroup(
            visitorBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visitorBtnPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        visitorBtnPanelLayout.setVerticalGroup(
            visitorBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visitorBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(visitorBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(visitorBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 250, 50));

        homeBtnPanel1.setBackground(new java.awt.Color(85, 65, 118));
        homeBtnPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        homeBtnPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeBtnPanel1MousePressed(evt);
            }
        });

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
        userBtnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userBtnPanelMousePressed(evt);
            }
        });

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
        refferenceBtnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                refferenceBtnPanelMousePressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Refference");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout refferenceBtnPanelLayout = new javax.swing.GroupLayout(refferenceBtnPanel);
        refferenceBtnPanel.setLayout(refferenceBtnPanelLayout);
        refferenceBtnPanelLayout.setHorizontalGroup(
            refferenceBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refferenceBtnPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
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

        settingBtnPanel1.setBackground(new java.awt.Color(64, 43, 100));
        settingBtnPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        settingBtnPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingBtnPanel1MousePressed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Log-Out");

        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout settingBtnPanel1Layout = new javax.swing.GroupLayout(settingBtnPanel1);
        settingBtnPanel1.setLayout(settingBtnPanel1Layout);
        settingBtnPanel1Layout.setHorizontalGroup(
            settingBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingBtnPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        settingBtnPanel1Layout.setVerticalGroup(
            settingBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingBtnPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(settingBtnPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 250, 50));

        settingBtnPanel.setBackground(new java.awt.Color(54, 33, 89));
        settingBtnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        settingBtnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingBtnPanelMousePressed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout settingBtnPanelLayout = new javax.swing.GroupLayout(settingBtnPanel);
        settingBtnPanel.setLayout(settingBtnPanelLayout);
        settingBtnPanelLayout.setHorizontalGroup(
            settingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        settingBtnPanelLayout.setVerticalGroup(
            settingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout adminSidePanelLayout = new javax.swing.GroupLayout(adminSidePanel);
        adminSidePanel.setLayout(adminSidePanelLayout);
        adminSidePanelLayout.setHorizontalGroup(
            adminSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminSidePanelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(adminSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(adminSidePanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(adminSidePanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(profileImg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(settingBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(adminSidePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(userNameLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        adminSidePanelLayout.setVerticalGroup(
            adminSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminSidePanelLayout.createSequentialGroup()
                .addGroup(adminSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileImg, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(adminSidePanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(settingBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        jPanel5.setBackground(new java.awt.Color(64, 43, 100));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Appointments");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/calendar 32.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 50));

        jPanel17.setBackground(new java.awt.Color(64, 43, 100));
        jPanel17.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel17MousePressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Complaints");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/documents_30px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel15.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 250, 50));

        patientSettingPanel.setBackground(new java.awt.Color(64, 43, 100));
        patientSettingPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        patientSettingPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                patientSettingPanelMousePressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Settings");

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout patientSettingPanelLayout = new javax.swing.GroupLayout(patientSettingPanel);
        patientSettingPanel.setLayout(patientSettingPanelLayout);
        patientSettingPanelLayout.setHorizontalGroup(
            patientSettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientSettingPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        patientSettingPanelLayout.setVerticalGroup(
            patientSettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientSettingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(patientSettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel15.add(patientSettingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 250, 50));

        homeBtnPanel3.setBackground(new java.awt.Color(85, 65, 118));
        homeBtnPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        homeBtnPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeBtnPanel3MousePressed(evt);
            }
        });

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

        patientSettingPanel1.setBackground(new java.awt.Color(64, 43, 100));
        patientSettingPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        patientSettingPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                patientSettingPanel1MousePressed(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Settings");

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout patientSettingPanel1Layout = new javax.swing.GroupLayout(patientSettingPanel1);
        patientSettingPanel1.setLayout(patientSettingPanel1Layout);
        patientSettingPanel1Layout.setHorizontalGroup(
            patientSettingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientSettingPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        patientSettingPanel1Layout.setVerticalGroup(
            patientSettingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientSettingPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(patientSettingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel15.add(patientSettingPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 250, 50));

        javax.swing.GroupLayout patientSidePanelLayout = new javax.swing.GroupLayout(patientSidePanel);
        patientSidePanel.setLayout(patientSidePanelLayout);
        patientSidePanelLayout.setHorizontalGroup(
            patientSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patientSidePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(patientSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(profileImg1)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(patientSidePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(userNameLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        patientSidePanelLayout.setVerticalGroup(
            patientSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientSidePanelLayout.createSequentialGroup()
                .addComponent(profileImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(userNameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(403, Short.MAX_VALUE))
        );

        bgPanel.add(patientSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 250, -1));

        moSidePanel.setBackground(new java.awt.Color(54, 33, 89));

        profileImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/old/DOCTORDETAILS (2).png"))); // NOI18N

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setForeground(new java.awt.Color(54, 33, 89));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(64, 43, 100));
        jPanel23.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel23MousePressed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Log-out");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/calendar 32.png"))); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel29)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addContainerGap())
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 250, 50));

        moSettingPanel.setBackground(new java.awt.Color(64, 43, 100));
        moSettingPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        moSettingPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                moSettingPanelMousePressed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Settings");

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout moSettingPanelLayout = new javax.swing.GroupLayout(moSettingPanel);
        moSettingPanel.setLayout(moSettingPanelLayout);
        moSettingPanelLayout.setHorizontalGroup(
            moSettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moSettingPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        moSettingPanelLayout.setVerticalGroup(
            moSettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moSettingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(moSettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel22.add(moSettingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 250, 50));

        homeBtnPanel2.setBackground(new java.awt.Color(85, 65, 118));
        homeBtnPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        homeBtnPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeBtnPanel2MousePressed(evt);
            }
        });

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

        jPanel37.setBackground(new java.awt.Color(64, 43, 100));
        jPanel37.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel37MousePressed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Appointments");

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/calendar 32.png"))); // NOI18N

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel71)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel72)
                .addContainerGap())
            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel22.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 50));

        javax.swing.GroupLayout moSidePanelLayout = new javax.swing.GroupLayout(moSidePanel);
        moSidePanel.setLayout(moSidePanelLayout);
        moSidePanelLayout.setHorizontalGroup(
            moSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moSidePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(moSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profileImg2))
                .addGap(27, 27, 27))
            .addGroup(moSidePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(userNameLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        moSidePanelLayout.setVerticalGroup(
            moSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moSidePanelLayout.createSequentialGroup()
                .addComponent(profileImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(userNameLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(448, Short.MAX_VALUE))
        );

        bgPanel.add(moSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, -1));

        receptionSidePanel.setBackground(new java.awt.Color(54, 33, 89));

        profileImg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/old/DOCTORDETAILS (2).png"))); // NOI18N

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setForeground(new java.awt.Color(54, 33, 89));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel31.setBackground(new java.awt.Color(64, 43, 100));
        jPanel31.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel31MousePressed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Appointments");

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/calendar 32.png"))); // NOI18N

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addContainerGap())
            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel30.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 250, 50));

        jPanel32.setBackground(new java.awt.Color(64, 43, 100));
        jPanel32.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel32MousePressed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Mail");

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/mail_configuration_24px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel30.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 250, 50));

        jPanel33.setBackground(new java.awt.Color(64, 43, 100));
        jPanel33.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel33MousePressed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Complaints");

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/documents_30px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel30.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 250, 50));

        visitorBtnPanel2.setBackground(new java.awt.Color(64, 43, 100));
        visitorBtnPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        visitorBtnPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                visitorBtnPanel2MousePressed(evt);
            }
        });

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
        userBtnPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userBtnPanel2MousePressed(evt);
            }
        });

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
        homeBtnPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeBtnPanel4MousePressed(evt);
            }
        });

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

        receptionistSettingPanel1.setBackground(new java.awt.Color(64, 43, 100));
        receptionistSettingPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        receptionistSettingPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                receptionistSettingPanel1MousePressed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Log-Out");

        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout receptionistSettingPanel1Layout = new javax.swing.GroupLayout(receptionistSettingPanel1);
        receptionistSettingPanel1.setLayout(receptionistSettingPanel1Layout);
        receptionistSettingPanel1Layout.setHorizontalGroup(
            receptionistSettingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionistSettingPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        receptionistSettingPanel1Layout.setVerticalGroup(
            receptionistSettingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionistSettingPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receptionistSettingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel30.add(receptionistSettingPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 250, 50));

        receptionistSettingPanel.setBackground(new java.awt.Color(64, 43, 100));
        receptionistSettingPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        receptionistSettingPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                receptionistSettingPanelMousePressed(evt);
            }
        });

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout receptionistSettingPanelLayout = new javax.swing.GroupLayout(receptionistSettingPanel);
        receptionistSettingPanel.setLayout(receptionistSettingPanelLayout);
        receptionistSettingPanelLayout.setHorizontalGroup(
            receptionistSettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionistSettingPanelLayout.createSequentialGroup()
                .addComponent(jLabel54)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        receptionistSettingPanelLayout.setVerticalGroup(
            receptionistSettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(receptionistSettingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        receptionSidePanelLayout.setVerticalGroup(
            receptionSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionSidePanelLayout.createSequentialGroup()
                .addGroup(receptionSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receptionSidePanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(receptionistSettingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                "Appointment No", "Date", "Time", "Status", "Patient Name", "Id Card No", "Medical Officer", "Speciality", "Sysmtomps", "Staff Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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

        jButton2.setText("Generate Report in PDF");

        jButton3.setText("Generate Report in CSV");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jDateChooser2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jDateChooser2MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser2MouseClicked(evt);
            }
        });
        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });

        moComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                moComboBoxItemStateChanged(evt);
            }
        });

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
                                .addGap(188, 188, 188)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(127, 127, 127)
                                .addComponent(moComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(appoinmentReportPanelLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(188, 188, 188)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        appoinmentReportPanelLayout.setVerticalGroup(
            appoinmentReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appoinmentReportPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(appoinmentReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(moComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(appoinmentReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        reportsPanel.add(appoinmentReportPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1090, 710));

        jScrollPane8.setBorder(null);

        appointmentTable4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        appointmentTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "User Name", "Date", "Time", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        appointmentTable4.setGridColor(new java.awt.Color(255, 255, 255));
        appointmentTable4.setIntercellSpacing(new java.awt.Dimension(5, 5));
        appointmentTable4.setRowHeight(20);
        appointmentTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                appointmentTable4MousePressed(evt);
            }
        });
        jScrollPane8.setViewportView(appointmentTable4);
        if (appointmentTable4.getColumnModel().getColumnCount() > 0) {
            appointmentTable4.getColumnModel().getColumn(0).setPreferredWidth(100);
            appointmentTable4.getColumnModel().getColumn(1).setPreferredWidth(100);
            appointmentTable4.getColumnModel().getColumn(2).setPreferredWidth(100);
            appointmentTable4.getColumnModel().getColumn(3).setPreferredWidth(100);
            appointmentTable4.getColumnModel().getColumn(3).setHeaderValue("Id Card No");
        }

        jDateChooser3.setPreferredSize(new java.awt.Dimension(100, 20));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.setPreferredSize(new java.awt.Dimension(100, 20));

        jButton4.setText("Generate Report in PDF");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton9.setText("Generate Report in CSV");

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
                        .addGap(169, 169, 169)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(userLogReportPanelLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userLogReportPanelLayout.setVerticalGroup(
            userLogReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLogReportPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(userLogReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(userLogReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        reportsPanel.add(userLogReportPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1090, 710));

        jScrollPane9.setBorder(null);

        appointmentTable5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        appointmentTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        appointmentTable5.setGridColor(new java.awt.Color(255, 255, 255));
        appointmentTable5.setIntercellSpacing(new java.awt.Dimension(5, 5));
        appointmentTable5.setRowHeight(20);
        appointmentTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                appointmentTable5MousePressed(evt);
            }
        });
        jScrollPane9.setViewportView(appointmentTable5);
        if (appointmentTable5.getColumnModel().getColumnCount() > 0) {
            appointmentTable5.getColumnModel().getColumn(0).setPreferredWidth(100);
            appointmentTable5.getColumnModel().getColumn(1).setPreferredWidth(100);
            appointmentTable5.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jButton10.setText("Generate Report in PDF");

        jButton19.setText("Generate Report in CSV");

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
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(298, Short.MAX_VALUE))
        );

        reportsPanel.add(patientCreditialReportPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 73, 1090, 780));

        jPanel10.setBackground(new java.awt.Color(39, 55, 130));
        jPanel10.setForeground(new java.awt.Color(39, 55, 130));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel16.setForeground(new java.awt.Color(102, 0, 102));
        jPanel16.setPreferredSize(new java.awt.Dimension(363, 40));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel16MousePressed(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel16MouseEntered(evt);
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

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 0, 370, 70));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel18.setForeground(new java.awt.Color(102, 0, 102));
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel18MousePressed(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(102, 0, 102));
        jLabel78.setText("Appointment Reports");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel78)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 363, 70));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel38.setForeground(new java.awt.Color(102, 0, 102));
        jPanel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel38MousePressed(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(102, 0, 102));
        jLabel79.setText("Patients Creditials");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 360, 70));

        reportsPanel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 70));

        bgPanel.add(reportsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 1000));

        refferencePanel.setBackground(new java.awt.Color(204, 204, 204));
        refferencePanel.setPreferredSize(new java.awt.Dimension(1090, 860));

        jPanel2.setBackground(new java.awt.Color(64, 43, 100));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Speciality Refference");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(64, 43, 100));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Complain Refference");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        specialityListPanel.setBackground(new java.awt.Color(204, 204, 204));

        refferenceList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(refferenceList);

        javax.swing.GroupLayout specialityListPanelLayout = new javax.swing.GroupLayout(specialityListPanel);
        specialityListPanel.setLayout(specialityListPanelLayout);
        specialityListPanelLayout.setHorizontalGroup(
            specialityListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialityListPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        specialityListPanelLayout.setVerticalGroup(
            specialityListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialityListPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

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
                .addGap(31, 31, 31)
                .addComponent(specialityListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );

        bgPanel.add(refferencePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 1090, 860));

        settingsPanel.setBackground(new java.awt.Color(204, 204, 204));
        settingsPanel.setPreferredSize(new java.awt.Dimension(1090, 860));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("setting ");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setText("Username");

        usernamefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernamefieldActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("Password");

        namefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namefieldActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setText("Name");

        Passwordfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordfieldActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setText("Gender");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Neutral" }));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setText("Date of birth");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel60.setText("Phone no");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel61.setText("NIC no");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel62.setText("Address");

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel63.setText("Marital status");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Married", "Single" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        AddressField.setColumns(20);
        AddressField.setRows(5);
        jScrollPane6.setViewportView(AddressField);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel64.setText("Date of joining");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setText("Staff ID");

        staffIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffIdFieldActionPerformed(evt);
            }
        });

        jLabel37.setText("Staff Email");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(staffIdField)
                    .addComponent(dateJoinedField, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(staffEmailField))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateJoinedField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staffIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        photoUploadedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        receptionistPhotoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                receptionistPhotoLabelMousePressed(evt);
            }
        });
        photoUploadedPanel1.add(receptionistPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 150));

        photoAddBtn2.setText("add");
        photoAddBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoAddBtn2ActionPerformed(evt);
            }
        });
        photoUploadedPanel1.add(photoAddBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel65.setText("Staff Photo");

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(settingsPanelLayout.createSequentialGroup()
                                    .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(usernamefield)
                                            .addComponent(namefield)
                                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                            .addComponent(PhoneNofield))
                                        .addComponent(Passwordfield, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(3, 3, 3))
                                .addComponent(NICNofield, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(142, 142, 142))))
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(223, 223, 223))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
                                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)))
                        .addComponent(photoUploadedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(photoUploadedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Passwordfield, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernamefield, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))
                        .addGap(30, 30, 30)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namefield, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PhoneNofield, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NICNofield, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(331, Short.MAX_VALUE))
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
                "User Name", "Name", "Gender", "Mobile", "Id Card No", "D.O.B", "Address", "Martail Status", "Password", "Blood Group", "Symtomps"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(85, 65, 118));
        jButton5.setText("Delete");
        jButton5.setPreferredSize(new java.awt.Dimension(67, 31));

        javax.swing.GroupLayout adminAppointmentOptionsLayout = new javax.swing.GroupLayout(adminAppointmentOptions);
        adminAppointmentOptions.setLayout(adminAppointmentOptionsLayout);
        adminAppointmentOptionsLayout.setHorizontalGroup(
            adminAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminAppointmentOptionsLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(832, Short.MAX_VALUE))
        );
        adminAppointmentOptionsLayout.setVerticalGroup(
            adminAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminAppointmentOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        receptionAppointmentOptions.setForeground(new java.awt.Color(85, 65, 118));

        approveAppoinmentBtn9.setBackground(new java.awt.Color(255, 255, 255));
        approveAppoinmentBtn9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        approveAppoinmentBtn9.setForeground(new java.awt.Color(85, 65, 118));
        approveAppoinmentBtn9.setText("Approve");
        approveAppoinmentBtn9.setPreferredSize(new java.awt.Dimension(67, 31));
        approveAppoinmentBtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveAppoinmentBtn9ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(85, 65, 118));
        jButton11.setText("Add");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
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

        editBtn5.setBackground(new java.awt.Color(255, 255, 255));
        editBtn5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editBtn5.setForeground(new java.awt.Color(85, 65, 118));
        editBtn5.setText("Edit");
        editBtn5.setPreferredSize(new java.awt.Dimension(67, 31));
        editBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtn5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receptionAppointmentOptionsLayout = new javax.swing.GroupLayout(receptionAppointmentOptions);
        receptionAppointmentOptions.setLayout(receptionAppointmentOptionsLayout);
        receptionAppointmentOptionsLayout.setHorizontalGroup(
            receptionAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionAppointmentOptionsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(generatePdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(editBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(approveAppoinmentBtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 299, Short.MAX_VALUE))
        );
        receptionAppointmentOptionsLayout.setVerticalGroup(
            receptionAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionAppointmentOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receptionAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editBtn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(generatePdfBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(approveAppoinmentBtn9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        patientAppointmentOptions.setForeground(new java.awt.Color(85, 65, 118));
        patientAppointmentOptions.setPreferredSize(new java.awt.Dimension(1090, 110));

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(85, 65, 118));
        jButton12.setText("Add");
        jButton12.setPreferredSize(new java.awt.Dimension(67, 31));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patientAppointmentOptionsLayout = new javax.swing.GroupLayout(patientAppointmentOptions);
        patientAppointmentOptions.setLayout(patientAppointmentOptionsLayout);
        patientAppointmentOptionsLayout.setHorizontalGroup(
            patientAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientAppointmentOptionsLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addGap(843, 843, 843))
        );
        patientAppointmentOptionsLayout.setVerticalGroup(
            patientAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientAppointmentOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        moAppointmentOptions.setForeground(new java.awt.Color(85, 65, 118));

        moAppoinmentCompleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        moAppoinmentCompleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        moAppoinmentCompleteBtn.setForeground(new java.awt.Color(85, 65, 118));
        moAppoinmentCompleteBtn.setText("Complete");
        moAppoinmentCompleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moAppoinmentCompleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout moAppointmentOptionsLayout = new javax.swing.GroupLayout(moAppointmentOptions);
        moAppointmentOptions.setLayout(moAppointmentOptionsLayout);
        moAppointmentOptionsLayout.setHorizontalGroup(
            moAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moAppointmentOptionsLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(moAppoinmentCompleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(869, Short.MAX_VALUE))
        );
        moAppointmentOptionsLayout.setVerticalGroup(
            moAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moAppointmentOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(moAppoinmentCompleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
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

        adminDeleteUser.setBackground(new java.awt.Color(255, 255, 255));
        adminDeleteUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        adminDeleteUser.setForeground(new java.awt.Color(85, 65, 118));
        adminDeleteUser.setText("Delete");
        adminDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminDeleteUserActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(255, 255, 255));
        editBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editBtn.setForeground(new java.awt.Color(85, 65, 118));
        editBtn.setText("Edit");
        editBtn.setPreferredSize(new java.awt.Dimension(67, 31));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        viewBtn11.setBackground(new java.awt.Color(255, 255, 255));
        viewBtn11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewBtn11.setForeground(new java.awt.Color(85, 65, 118));
        viewBtn11.setText("view");
        viewBtn11.setPreferredSize(new java.awt.Dimension(67, 31));

        addBtn11.setBackground(new java.awt.Color(255, 255, 255));
        addBtn11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addBtn11.setForeground(new java.awt.Color(85, 65, 118));
        addBtn11.setText("Add");
        addBtn11.setPreferredSize(new java.awt.Dimension(67, 31));
        addBtn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminUserOptionsLayout = new javax.swing.GroupLayout(adminUserOptions);
        adminUserOptions.setLayout(adminUserOptionsLayout);
        adminUserOptionsLayout.setHorizontalGroup(
            adminUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminUserOptionsLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(addBtn11, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(viewBtn11, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(adminDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 301, Short.MAX_VALUE))
        );
        adminUserOptionsLayout.setVerticalGroup(
            adminUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminUserOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBtn11, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(viewBtn11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminDeleteUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        receptionUserOptions.setForeground(new java.awt.Color(85, 65, 118));

        deleteBtn15.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteBtn15.setForeground(new java.awt.Color(85, 65, 118));
        deleteBtn15.setText("Delete");
        deleteBtn15.setPreferredSize(new java.awt.Dimension(67, 31));
        deleteBtn15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn15ActionPerformed(evt);
            }
        });

        editBtn7.setBackground(new java.awt.Color(255, 255, 255));
        editBtn7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editBtn7.setForeground(new java.awt.Color(85, 65, 118));
        editBtn7.setText("Edit");
        editBtn7.setPreferredSize(new java.awt.Dimension(67, 31));
        editBtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtn7ActionPerformed(evt);
            }
        });

        addBtn10.setBackground(new java.awt.Color(255, 255, 255));
        addBtn10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addBtn10.setForeground(new java.awt.Color(85, 65, 118));
        addBtn10.setText("add");
        addBtn10.setPreferredSize(new java.awt.Dimension(67, 31));
        addBtn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receptionUserOptionsLayout = new javax.swing.GroupLayout(receptionUserOptions);
        receptionUserOptions.setLayout(receptionUserOptionsLayout);
        receptionUserOptionsLayout.setHorizontalGroup(
            receptionUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionUserOptionsLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(addBtn10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(editBtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(deleteBtn15, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 493, Short.MAX_VALUE))
        );
        receptionUserOptionsLayout.setVerticalGroup(
            receptionUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receptionUserOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receptionUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addBtn10, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(editBtn7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(receptionUserOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        usersMainOptionLayout.setVerticalGroup(
            usersMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
            .addGroup(usersMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(usersMainOptionLayout.createSequentialGroup()
                    .addGap(0, 1, Short.MAX_VALUE)
                    .addGroup(usersMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(adminUserOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(receptionUserOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 1, Short.MAX_VALUE)))
        );

        bgPanel.add(usersMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        mailMainOption.setPreferredSize(new java.awt.Dimension(1090, 108));

        adminMailOptions.setForeground(new java.awt.Color(85, 65, 118));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(85, 65, 118));
        jButton6.setText("Delete");
        jButton6.setPreferredSize(new java.awt.Dimension(67, 31));

        javax.swing.GroupLayout adminMailOptionsLayout = new javax.swing.GroupLayout(adminMailOptions);
        adminMailOptions.setLayout(adminMailOptionsLayout);
        adminMailOptionsLayout.setHorizontalGroup(
            adminMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminMailOptionsLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(0, 851, Short.MAX_VALUE))
        );
        adminMailOptionsLayout.setVerticalGroup(
            adminMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminMailOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        receptionMailOptions.setForeground(new java.awt.Color(85, 65, 118));

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(85, 65, 118));
        jButton14.setText("Delete");
        jButton14.setPreferredSize(new java.awt.Dimension(67, 31));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        editBtn6.setBackground(new java.awt.Color(255, 255, 255));
        editBtn6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editBtn6.setForeground(new java.awt.Color(85, 65, 118));
        editBtn6.setText("Edit");
        editBtn6.setPreferredSize(new java.awt.Dimension(67, 31));

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(85, 65, 118));
        jButton13.setText("Add");
        jButton13.setPreferredSize(new java.awt.Dimension(67, 31));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receptionMailOptionsLayout = new javax.swing.GroupLayout(receptionMailOptions);
        receptionMailOptions.setLayout(receptionMailOptionsLayout);
        receptionMailOptionsLayout.setHorizontalGroup(
            receptionMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionMailOptionsLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(71, 71, 71)
                .addComponent(editBtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 524, Short.MAX_VALUE))
        );
        receptionMailOptionsLayout.setVerticalGroup(
            receptionMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receptionMailOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receptionMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(editBtn6, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
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

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(85, 65, 118));
        jButton8.setText("Delete");
        jButton8.setPreferredSize(new java.awt.Dimension(67, 31));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        editBtn3.setBackground(new java.awt.Color(255, 255, 255));
        editBtn3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editBtn3.setForeground(new java.awt.Color(85, 65, 118));
        editBtn3.setText("Edit Complaint");
        editBtn3.setPreferredSize(new java.awt.Dimension(67, 31));
        editBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtn3ActionPerformed(evt);
            }
        });

        approveBtn3.setBackground(new java.awt.Color(255, 255, 255));
        approveBtn3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        approveBtn3.setForeground(new java.awt.Color(85, 65, 118));
        approveBtn3.setText("set Action Taken");
        approveBtn3.setPreferredSize(new java.awt.Dimension(67, 31));
        approveBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminComplaintOptionsLayout = new javax.swing.GroupLayout(adminComplaintOptions);
        adminComplaintOptions.setLayout(adminComplaintOptionsLayout);
        adminComplaintOptionsLayout.setHorizontalGroup(
            adminComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminComplaintOptionsLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(approveBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, Short.MAX_VALUE)
                .addGap(85, 85, 85)
                .addComponent(editBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 319, Short.MAX_VALUE))
        );
        adminComplaintOptionsLayout.setVerticalGroup(
            adminComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminComplaintOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(editBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(approveBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addContainerGap())
        );

        patientComplaintOptions.setForeground(new java.awt.Color(85, 65, 118));

        jButton18.setBackground(new java.awt.Color(255, 255, 255));
        jButton18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton18.setForeground(new java.awt.Color(85, 65, 118));
        jButton18.setText("Add Complain");
        jButton18.setPreferredSize(new java.awt.Dimension(67, 31));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patientComplaintOptionsLayout = new javax.swing.GroupLayout(patientComplaintOptions);
        patientComplaintOptions.setLayout(patientComplaintOptionsLayout);
        patientComplaintOptionsLayout.setHorizontalGroup(
            patientComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientComplaintOptionsLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(707, 707, 707))
        );
        patientComplaintOptionsLayout.setVerticalGroup(
            patientComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientComplaintOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        receptionComplaintOptions.setForeground(new java.awt.Color(85, 65, 118));

        jButton16.setBackground(new java.awt.Color(255, 255, 255));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton16.setForeground(new java.awt.Color(85, 65, 118));
        jButton16.setText("Add Complaint");
        jButton16.setPreferredSize(new java.awt.Dimension(67, 31));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receptionComplaintOptionsLayout = new javax.swing.GroupLayout(receptionComplaintOptions);
        receptionComplaintOptions.setLayout(receptionComplaintOptionsLayout);
        receptionComplaintOptionsLayout.setHorizontalGroup(
            receptionComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionComplaintOptionsLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(773, Short.MAX_VALUE))
        );
        receptionComplaintOptionsLayout.setVerticalGroup(
            receptionComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receptionComplaintOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
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
                        .addComponent(receptionComplaintOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(receptionComplaintOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bgPanel.add(complaintsMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        visitorsMainOption.setPreferredSize(new java.awt.Dimension(1090, 108));

        receptionVisitorOptions.setForeground(new java.awt.Color(85, 65, 118));

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(85, 65, 118));
        jButton15.setText("Delete");
        jButton15.setPreferredSize(new java.awt.Dimension(67, 31));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        editBtn8.setBackground(new java.awt.Color(255, 255, 255));
        editBtn8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editBtn8.setForeground(new java.awt.Color(85, 65, 118));
        editBtn8.setText("Edit");
        editBtn8.setPreferredSize(new java.awt.Dimension(67, 31));
        editBtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtn8ActionPerformed(evt);
            }
        });

        addBtn13.setBackground(new java.awt.Color(255, 255, 255));
        addBtn13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addBtn13.setForeground(new java.awt.Color(85, 65, 118));
        addBtn13.setText("Add");
        addBtn13.setPreferredSize(new java.awt.Dimension(67, 31));
        addBtn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receptionVisitorOptionsLayout = new javax.swing.GroupLayout(receptionVisitorOptions);
        receptionVisitorOptions.setLayout(receptionVisitorOptionsLayout);
        receptionVisitorOptionsLayout.setHorizontalGroup(
            receptionVisitorOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionVisitorOptionsLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(addBtn13, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(editBtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 441, Short.MAX_VALUE))
        );
        receptionVisitorOptionsLayout.setVerticalGroup(
            receptionVisitorOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receptionVisitorOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receptionVisitorOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addBtn13, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(editBtn8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        adminVisitorOptions.setForeground(new java.awt.Color(85, 65, 118));

        jButton17.setBackground(new java.awt.Color(255, 255, 255));
        jButton17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton17.setForeground(new java.awt.Color(85, 65, 118));
        jButton17.setText("Delete");
        jButton17.setPreferredSize(new java.awt.Dimension(67, 31));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminVisitorOptionsLayout = new javax.swing.GroupLayout(adminVisitorOptions);
        adminVisitorOptions.setLayout(adminVisitorOptionsLayout);
        adminVisitorOptionsLayout.setHorizontalGroup(
            adminVisitorOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminVisitorOptionsLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(840, Short.MAX_VALUE))
        );
        adminVisitorOptionsLayout.setVerticalGroup(
            adminVisitorOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminVisitorOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
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
                    .addComponent(receptionVisitorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(receptionVisitorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bgPanel.add(visitorsMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        refferenceMainOption.setForeground(new java.awt.Color(85, 65, 118));
        refferenceMainOption.setPreferredSize(new java.awt.Dimension(1090, 108));

        adminRefferenceOptions.setForeground(new java.awt.Color(85, 65, 118));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(85, 65, 118));
        jButton7.setText("Delete");
        jButton7.setPreferredSize(new java.awt.Dimension(67, 31));

        editBtn2.setBackground(new java.awt.Color(255, 255, 255));
        editBtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editBtn2.setForeground(new java.awt.Color(85, 65, 118));
        editBtn2.setText("Edit");
        editBtn2.setPreferredSize(new java.awt.Dimension(67, 31));

        addBtn12.setBackground(new java.awt.Color(255, 255, 255));
        addBtn12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addBtn12.setForeground(new java.awt.Color(85, 65, 118));
        addBtn12.setText("Add");
        addBtn12.setPreferredSize(new java.awt.Dimension(67, 31));
        addBtn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminRefferenceOptionsLayout = new javax.swing.GroupLayout(adminRefferenceOptions);
        adminRefferenceOptions.setLayout(adminRefferenceOptionsLayout);
        adminRefferenceOptionsLayout.setHorizontalGroup(
            adminRefferenceOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminRefferenceOptionsLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(addBtn12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(editBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 480, Short.MAX_VALUE))
        );
        adminRefferenceOptionsLayout.setVerticalGroup(
            adminRefferenceOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminRefferenceOptionsLayout.createSequentialGroup()
                .addGroup(adminRefferenceOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addBtn12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(editBtn2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void moSettingPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moSettingPanelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_moSettingPanelMousePressed

    private void jPanel23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel23MousePressed

    private void jPanel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MousePressed

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MousePressed

    private void appointmentTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentTableMousePressed

        if (appointmentTable.getSelectedRow() > -1) {
            // print first column value from selected row
           
            editBtn.setEnabled(true);
        }
    }//GEN-LAST:event_appointmentTableMousePressed

    private void userBtnPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtnPanelMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_userBtnPanelMousePressed

    private void settingBtnPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingBtnPanelMousePressed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_settingBtnPanelMousePressed

    private void visitorBtnPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visitorBtnPanelMousePressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_visitorBtnPanelMousePressed

    private void reportBtnPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportBtnPanelMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_reportBtnPanelMousePressed

    private void complaintBtnPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_complaintBtnPanelMousePressed
    
    }//GEN-LAST:event_complaintBtnPanelMousePressed

    private void mailBtnPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mailBtnPanelMousePressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_mailBtnPanelMousePressed

  
    private void appointmentBtnPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentBtnPanelMousePressed

       

    }//GEN-LAST:event_appointmentBtnPanelMousePressed

    private void jPanel31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel31MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel31MousePressed

    private void jPanel32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel32MousePressed

    private void jPanel33MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel33MousePressed

    private void visitorBtnPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visitorBtnPanel2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_visitorBtnPanel2MousePressed

    private void receptionistSettingPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionistSettingPanelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_receptionistSettingPanelMousePressed

    private void userBtnPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtnPanel2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_userBtnPanel2MousePressed

    private void patientSettingPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientSettingPanelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientSettingPanelMousePressed

    private void refferenceBtnPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refferenceBtnPanelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_refferenceBtnPanelMousePressed

    private void approveBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtn3ActionPerformed
        // TODO add your handling code here:
       UpdateComplaintActionTaken action = new UpdateComplaintActionTaken(this);
        
    }//GEN-LAST:event_approveBtn3ActionPerformed

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

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
       setComplainRefference();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
           setSpecialityRefference();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        addNewAppointment();
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void generatePdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatePdfBtnActionPerformed
        // TODO add your handling code here:
        generateAppoinmentReport();
    }//GEN-LAST:event_generatePdfBtnActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        addNewAppointment();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void moAppoinmentCompleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moAppoinmentCompleteBtnActionPerformed
        // TODO add your handling code here:
         approveAppoinment("Completed");
    }//GEN-LAST:event_moAppoinmentCompleteBtnActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        addDispatchedPostal();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        addNewComplaint();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        addNewComplaint();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void addBtn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn10ActionPerformed
        // TODO add your handling code here:
         addNewUser();
    }//GEN-LAST:event_addBtn10ActionPerformed

    private void homeBtnPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnPanel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeBtnPanel1MousePressed

    private void homeBtnPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnPanel2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeBtnPanel2MousePressed

    private void homeBtnPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnPanel3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeBtnPanel3MousePressed

    private void homeBtnPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnPanel4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeBtnPanel4MousePressed

    private void addBtn13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn13ActionPerformed
        // TODO add your handling code here:
        addNewVisitorRecord();
    }//GEN-LAST:event_addBtn13ActionPerformed

    private void addBtn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn11ActionPerformed
        // TODO add your handling code here:
        addNewUser();
    }//GEN-LAST:event_addBtn11ActionPerformed

    private void usernamefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernamefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernamefieldActionPerformed

    private void PasswordfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordfieldActionPerformed

    private void staffIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffIdFieldActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void photoAddBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoAddBtn2ActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_photoAddBtn2ActionPerformed

    private void receptionistPhotoLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionistPhotoLabelMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_receptionistPhotoLabelMousePressed

    private void patientsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientsTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientsTableMousePressed

    private void jLabel66MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel66MouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel66MouseExited

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        // TODO add your handling code here:
        setOptionReceptionist();
       

    }//GEN-LAST:event_jPanel7MousePressed

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MousePressed
        // TODO add your handling code here:
        setOptionMo();
        
        
    }//GEN-LAST:event_jPanel9MousePressed

    private void jPanel35MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel35MousePressed
        // TODO add your handling code here:
        setOptionPatient();
        

    }//GEN-LAST:event_jPanel35MousePressed

    private void receptionistTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionistTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_receptionistTableMousePressed

    private void patientSettingPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientSettingPanel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientSettingPanel1MousePressed

    private void jPanel37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MousePressed

    private void receptionistSettingPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionistSettingPanel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_receptionistSettingPanel1MousePressed

    private void settingBtnPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingBtnPanel1MousePressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_settingBtnPanel1MousePressed

    private void namefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namefieldActionPerformed

    private void adminDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminDeleteUserActionPerformed
        alterUser(1);
        
    }//GEN-LAST:event_adminDeleteUserActionPerformed

    private void addBtn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn12ActionPerformed
        // TODO add your handling code here:
        addRefference();
    }//GEN-LAST:event_addBtn12ActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
         alterUser(2);
    }//GEN-LAST:event_editBtnActionPerformed

    private void editBtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtn7ActionPerformed
        // TODO add your handling code here:
        alterUser(2);//2 for edit
    }//GEN-LAST:event_editBtn7ActionPerformed

    private void deleteBtn15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn15ActionPerformed
        // TODO add your handling code here:
        alterUser(1);//1 for edit
    }//GEN-LAST:event_deleteBtn15ActionPerformed

    private void editBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtn5ActionPerformed
        // TODO add your handling code here:
        editAppointment();
        
    }//GEN-LAST:event_editBtn5ActionPerformed

    private void approveAppoinmentBtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveAppoinmentBtn9ActionPerformed
        // TODO add your handling code here:
        approveAppoinment("Approved");
    }//GEN-LAST:event_approveAppoinmentBtn9ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        deleteMail();
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void editBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtn3ActionPerformed
        // TODO add your handling code here:
        editComplaint();
    }//GEN-LAST:event_editBtn3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        deleteComplaint();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        deleteVisitorRecord();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void editBtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtn8ActionPerformed
        editVisitorRecord();
    }//GEN-LAST:event_editBtn8ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
          deleteVisitorRecord();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void appointmentTable4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentTable4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentTable4MousePressed

    private void appointmentTable5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentTable5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentTable5MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel77MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel77MouseExited

    private void jPanel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MousePressed
         setUserLogReports();
    }//GEN-LAST:event_jPanel16MousePressed

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MousePressed
        setAppoinmentReports();
        
    }//GEN-LAST:event_jPanel18MousePressed

    private void jPanel38MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel38MousePressed
            setPatientCredintialReports();
    }//GEN-LAST:event_jPanel38MousePressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void moComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_moComboBoxItemStateChanged
        // TODO add your handling code here:
        
        setAppointmentReportTable();
        
    }//GEN-LAST:event_moComboBoxItemStateChanged

    private void jDateChooser2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser2MouseClicked
    
         
    }//GEN-LAST:event_jDateChooser2MouseClicked

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
   
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jDateChooser2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser2MousePressed
         setAppointmentReportTable();
    }//GEN-LAST:event_jDateChooser2MousePressed
 
   
    
    
    
    
    
    
   
    
    
   
    
    private void addNewUser(){
        AddUser user= new AddUser(1,getUserRole(),this,null,null,null);
    }
    private void addRefference(){
        AddReference refference= new AddReference(this);
    }
    
    private void alterUser( int type){
       
        
        
        
        if(moScrollPanel.isShowing()){
                   Object record= ((DefaultTableModel) moTable.getModel()).getDataVector().elementAt(moTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getMoFilePath();
                    MedicalOfficer officer=FileService.readMoUser(line);
                    if(type==1){
                         FileService.deleteRecord(path, line);
                    }
                    else if(type==2){
                        AddUser edit=new AddUser(2,getUserRole(),this,null,officer,null);
                    }
                  
                  
        }
        else if(patientScrollPanel.isShowing()){
                     Object record= ((DefaultTableModel) patientsTable.getModel()).getDataVector().elementAt(patientsTable.getSelectedRow());
                     String line= PipeService.formatTableString(record.toString());
                     String path=FileService.getPatientsFilePath();
                     Patient patient=FileService.readPatientUser(line);
                    if(type==1){
                         FileService.deleteRecord(path, line);
                    }
                    else if(type==2){
                        AddUser edit=new AddUser(2,getUserRole(),this,patient,null,null);
                    }

        }
        else if(receptionistScrollPanel.isShowing()){
                     Object record= ((DefaultTableModel) receptionistTable.getModel()).getDataVector().elementAt(receptionistTable.getSelectedRow());
                      String line= PipeService.formatTableString(record.toString());
                      String path=FileService.getReceptionistFilePath();
                      Receptionist officer=FileService.readReceptionistUser(line);
                    if(type==1){
                         FileService.deleteRecord(path, line);
                    }
                    else if(type==2){
                        AddUser edit=new AddUser(2,getUserRole(),this,null,null,officer);
                    }
        }
        
       
        
        
        
        
        
        
        
        
        
        
       setTables();
    }
    
    
    
    
    
   
   
    
    
    
    public void setTables(){
        if(getUserRole().equals("Admin")){
            getAllAppointment();
            getAllComplaints();
            getDispatchedMails();
            getVisitorRecords();
            getAllUsers();
            getComplainRefference();
            getSpecialityRefference();
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
              adminAppointmentOptions.setVisible(true);
              patientAppointmentOptions.setVisible(false);
              receptionAppointmentOptions.setVisible(false);
              moAppointmentOptions.setVisible(false);
            
        }
        else if(getUserRole().equals("Receptionist")){
             receptionAppointmentOptions.setVisible(true);
             adminAppointmentOptions.setVisible(false);
              patientAppointmentOptions.setVisible(false);
               moAppointmentOptions.setVisible(false);
            

        }
        else if(getUserRole().equals("Patient")){
             adminAppointmentOptions.setVisible(false);
              patientAppointmentOptions.setVisible(true);
               receptionAppointmentOptions.setVisible(false);
                moAppointmentOptions.setVisible(false);

        }
        else if(getUserRole().equals("MedicalOfficer")){
              moAppointmentOptions.setVisible(true);
            adminAppointmentOptions.setVisible(false);
              patientAppointmentOptions.setVisible(false);
               receptionAppointmentOptions.setVisible(false);
           
            
           

        }
        
    }
    private void setMailOptions(){
          if(getUserRole().equals("Admin")){
              adminMailOptions.setVisible(true);
              receptionMailOptions.setVisible(false);
          
            
        }
        else if(getUserRole().equals("Receptionist")){
              receptionMailOptions.setVisible(true);
            adminMailOptions.setVisible(false);
            
            

        }
        else if(getUserRole().equals("Patient")){
            adminMailOptions.setVisible(false);

        }
        else if(getUserRole().equals("MedicalOfficer")){
            adminMailOptions.setVisible(false);
            
           

        }
        
    }
    private void setComplainOptions(){
          if(getUserRole().equals("Admin")){
              patientComplaintOptions.setVisible(false);
            adminComplaintOptions.setVisible(true);
            receptionComplaintOptions.setVisible(false);
            
        }
        else if(getUserRole().equals("Receptionist")){
             patientComplaintOptions.setVisible(false);
          adminComplaintOptions.setVisible(false);
            receptionComplaintOptions.setVisible(true);
            

        }
        else if(getUserRole().equals("Patient")){
             patientComplaintOptions.setVisible(true);
            adminComplaintOptions.setVisible(false);
              receptionComplaintOptions.setVisible(false);

        }
        else if(getUserRole().equals("MedicalOfficer")){
           
            
           

        }
        
    }
    private void setUserOptions(){
           if(getUserRole().equals("Admin")){
                adminUserOptions.setVisible(true);
            receptionUserOptions.setVisible(false);
            jPanel6.setVisible(true);
            setOptionMo();
            
        }
        else if(getUserRole().equals("Receptionist")){
            receptionUserOptions.setVisible(true);
            adminUserOptions.setVisible(false);
             jPanel6.setVisible(false);
             setOptionPatient();
            
            

        }
        
    }
    private void setRefferenceOption(){
         if(getUserRole().equals("Admin")){
             adminRefferenceOptions.setVisible(true);
            
        }
        
    }
    private void setReportOptions(){
         if(getUserRole().equals("Admin")){
            appoinmentReportPanel.setVisible(true);
           userLogReportPanel.setVisible(false);
            patientCreditialReportPanel.setVisible(false);
        }
    
        
    }
    private void setVisitorOptions(){
        if(getUserRole().equals("Admin")){
            adminVisitorOptions.setVisible(true);
            receptionVisitorOptions.setVisible(false);
            
        }
        else if(getUserRole().equals("Receptionist")){
          adminVisitorOptions.setVisible(false);
            receptionVisitorOptions.setVisible(true);
            

        }
        
        
    }
    private void setSettingsOptions(){
        
    }
    
    public void setOptionMo(){
         resetHoverColor(jPanel7,jLabel66);
        setHoverColor(jPanel9,jLabel67);
         resetHoverColor(jPanel35,jLabel68);
           moScrollPanel.setVisible(true);
          receptionistScrollPanel.setVisible(false);
         patientScrollPanel.setVisible(false);
        
    }
    public void setOptionReceptionist(){
         setHoverColor(jPanel7,jLabel66);
        resetHoverColor(jPanel9,jLabel67);
         resetHoverColor(jPanel35,jLabel68);
          receptionistScrollPanel.setVisible(true);
         moScrollPanel.setVisible(false);
           patientScrollPanel.setVisible(false);
       
        
    }
    public void setOptionPatient(){
          resetHoverColor(jPanel7,jLabel66);
        resetHoverColor(jPanel9,jLabel67);
         setHoverColor(jPanel35,jLabel68);
         moScrollPanel.setVisible(false);
         receptionistScrollPanel.setVisible(false);
         patientScrollPanel.setVisible(true);
        
    }
    
    public void setAppoinmentReports(){
        resetHoverColor(jPanel38,jLabel79);
        setHoverColor(jPanel18,jLabel78);
        resetHoverColor(jPanel16,jLabel77);
        appoinmentReportPanel.setVisible(true);
        userLogReportPanel.setVisible(false);
        patientCreditialReportPanel.setVisible(false);
    }
    public void setUserLogReports(){
        resetHoverColor(jPanel38,jLabel79);
        resetHoverColor(jPanel18,jLabel78);
        setHoverColor(jPanel16,jLabel77);
        appoinmentReportPanel.setVisible(false);
        userLogReportPanel.setVisible(true);
        patientCreditialReportPanel.setVisible(false);
        
    }
    public void setPatientCredintialReports(){
        setHoverColor(jPanel38,jLabel79);
        resetHoverColor(jPanel18,jLabel78);
        resetHoverColor(jPanel16,jLabel77);
        appoinmentReportPanel.setVisible(false);
        userLogReportPanel.setVisible(false);
        patientCreditialReportPanel.setVisible(true);
    }
    
    
    
    
    
    
    
    
    public void setHoverColor(JPanel panel,JLabel label){
                panel.setBackground(new Color(85,65,118));
                label.setForeground(Color.white);

    }
    
    public void resetHoverColor(JPanel panel,JLabel label){
                panel.setBackground(new Color(255,255,255));
                label.setForeground(new Color(102,0,102));

    }
    
    
    private void getPatientAppointmentTable(String id){
        ArrayList<String> list= FileService.getPatientAppointments(id);
        TableModel tm = appointmentTable.getModel();
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
        TableModel tm = appointmentTable.getModel();
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
        TableModel tm = appointmentTable.getModel();
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
        TableModel tm = complaintTable.getModel();
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
        TableModel tm = complaintTable.getModel();
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
        TableModel tm = dispatchedMailTable.getModel();
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
    
    private void getReceivedMails(){
        
    }
    
    private void getVisitorRecords(){
        ArrayList<String> list= FileService.getRecords(FileService.getVisitorsFile());
        TableModel tm = visitorTable.getModel();
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
        TableModel tm = moTable.getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
             for(int i=0;i<list.size();i++)  
           {  
            
            MedicalOfficer officer=FileService.readMoUser(list.get(i));
           
             Object[] row = {officer.getUserName(),officer.getName(),officer.getGender(),officer.getphoneNumber(),officer.getIdCardNo(),officer.getDateOfBirth(),officer.getAddress(),officer.getMaritalStatus(),officer.getPassword(),officer.getStrStaffId(),officer.getStrEmailAddress(),officer.getStrDateOfJoining(),officer.getCvFile(),officer.getStrSpecialityArea(),officer.getPhoto()};
                    model.addRow(row);
            
           }  
     
    }
    
    public void getAllReceptionist(){
        ArrayList<String> list= FileService.getRecords(FileService.getReceptionistFile());
        TableModel tm = receptionistTable.getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
             for(int i=0;i<list.size();i++)  
           {   
        Receptionist officer=FileService.readReceptionistUser(list.get(i));
             Object[] row = { officer.getUserName(),officer.getName(),officer.getGender(),officer.getphoneNumber(),officer.getIdCardNo(),officer.getDateOfBirth(),officer.getAddress(),officer.getMaritalStatus(),officer.getPassword(),officer.getStrStaffId(),officer.getStrEmailAddress(),officer.getStrDateOfJoining(),officer.getCvFile(),officer.getPhoto()};
                    model.addRow(row);
            
           }    
    }
    
    private void getAllPatients(){
         ArrayList<String> list= FileService.getRecords(FileService.getPatientsFile());
        TableModel tm = patientsTable.getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
             for(int i=0;i<list.size();i++)  
           {  
            
            Patient patient=FileService.readPatientUser(list.get(i));
             Object[] row = {patient.getUserName(),patient.getName(),patient.getGender(),patient.getphoneNumber(),patient.getIdCardNo(),patient.getDateOfBirth(),patient.getAddress(),patient.getMaritalStatus(),patient.getPassword(),patient.getStrBloodGrp(),patient.getStrAllergies()};
             model.addRow(row);
            
           }  
        
    }
    private void setComplainRefference(){
        setColor(jPanel1);
        resetColor(jPanel2);
        getComplainRefference();
        
    }
     private void setSpecialityRefference(){
        setColor(jPanel2);
        resetColor(jPanel1);
        getSpecialityRefference();         
    }
     private void getComplainRefference(){
            ComplainRefference refference = new ComplainRefference();
           ArrayList<String> complainRefferenceList = refference.getComplainTypes();
            DefaultListModel<String> model = new DefaultListModel<String>();
             refferenceList.setModel(model);
          for(String s:complainRefferenceList){
                 model.addElement(s);
                }
    }
      private void getSpecialityRefference(){
       SpecialityRefference refference=new SpecialityRefference();
       ArrayList<String> specialityRefferenceList = refference.getSpecialityTypes();
        DefaultListModel<String> model2 = new DefaultListModel<String>();
        refferenceList.setModel(model2);
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
    
    
     void setColor(JPanel panel){
         panel.setBackground(new Color(85,65,118));
    }
     
     void resetAllMainPanels(){
         usersPanel.setVisible(false);
         complaintPanel.setVisible(false);
          mailPanel.setVisible(false);
           appointmentPanel.setVisible(false);
            reportsPanel.setVisible(false);
             settingsPanel.setVisible(false);
              refferencePanel.setVisible(false);
               visitorsPanel.setVisible(false);
     }
      void resetAllColor(){
         jPanel23.setBackground(new Color(64,43,100));
         homeBtnPanel1.setBackground(new Color(64,43,100));
          homeBtnPanel2.setBackground(new Color(64,43,100));
           homeBtnPanel3.setBackground(new Color(64,43,100));
            homeBtnPanel4.setBackground(new Color(64,43,100));
                         
        moSettingPanel.setBackground(new Color(64,43,100));
        jPanel5.setBackground(new Color(64,43,100));
        jPanel17.setBackground(new Color(64,43,100));
        patientSettingPanel.setBackground(new Color(64,43,100));
        jPanel31.setBackground(new Color(64,43,100));
        jPanel32.setBackground(new Color(64,43,100));
        jPanel33.setBackground(new Color(64,43,100));
        visitorBtnPanel2.setBackground(new Color(64,43,100));
        receptionistSettingPanel.setBackground(new Color(64,43,100));
        userBtnPanel2.setBackground(new Color(64,43,100));
        userBtnPanel.setBackground(new Color(64,43,100));
        reportBtnPanel.setBackground(new Color(64,43,100));
        appointmentBtnPanel.setBackground(new Color(64,43,100));
        mailBtnPanel.setBackground(new Color(64,43,100));
        complaintBtnPanel.setBackground(new Color(64,43,100));
        visitorBtnPanel.setBackground(new Color(64,43,100));
        settingBtnPanel.setBackground(new Color(64,43,100));
        refferenceBtnPanel.setBackground(new Color(64,43,100));
    }
     void resetColor(JPanel panel){
        panel.setBackground(new Color(64,43,100));
       
        
    }
     
     
     
     //appoinment functions here
    public void addNewAppointment(){
         AddAppointment appointment = new AddAppointment(this);
         
    }
    public void editAppointment(){
        Object record= ((DefaultTableModel) appointmentTable.getModel()).getDataVector().elementAt(appointmentTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getAppointmentsFilePath();
                   Appointment appointment=FileService.readAppoinment(line);
                    EditAppointment edit=new EditAppointment(appointment,this);
                   
    } 
     public void deleteAppointment(){
          Object record= ((DefaultTableModel) appointmentTable.getModel()).getDataVector().elementAt(appointmentTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getAppointmentsFilePath();
                    FileService.deleteRecord(path, line);
                     this.setTables();
    } 
     public void approveAppoinment(String status){
         Object record= ((DefaultTableModel) appointmentTable.getModel()).getDataVector().elementAt(appointmentTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getAppointmentsFilePath();
                    FileService.deleteRecord(path, line);
                    Appointment appointment=FileService.readAppoinment(line);
                    appointment.setStatus(status);
                    FileService.addLine(path, appointment.toString());
                     this.setTables();
     }
     public void generateAppoinmentReport(){
          Document document = new Document();
    try
    {
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("files/new.pdf"));
        document.open();
 
        PdfPTable table = new PdfPTable(10); // 3 columns.
        table.setWidthPercentage(100); //Width 100%
        table.setSpacingBefore(5f); //Space before table
        table.setSpacingAfter(5f); //Space after table
 
        //Set Column widths
        float[] columnWidths = {1f, 1f, 1f,1f, 1f, 1f,1f, 1f, 1f,1f};
        table.setWidths(columnWidths);
        table.addCell("number");
        table.addCell("Date");
        table.addCell("Time");
        table.addCell("Status");
        table.addCell("Patient Name");
        table.addCell("Patient Id Card");
        table.addCell("Medical Officer");
        table.addCell("Speciality");
        table.addCell("Systomp");
        table.addCell("Staff Id");
        ArrayList<String> appointmentList =FileService.getRecords(FileService.getAppointmentsFile());
        
        
         for(int i=0; i<appointmentList.size(); i++){
             Appointment appoinment=FileService.readAppoinment(appointmentList.get(i));
             if(appoinment.getStatus().equals("Approved")){
                 
            table.addCell(appoinment.getAppointmentNumber());
            table.addCell(appoinment.getAppointmentDate());
            table.addCell(appoinment.getAppointmentTime());
            table.addCell(appoinment.getStatus());
            table.addCell(appoinment.getPatient().getName());
            table.addCell(appoinment.getPatient().getIdCardNo());
            table.addCell(appoinment.getMedicalOfficer().moName());
            table.addCell(appoinment.getSpeciality());
            table.addCell(appoinment.getSymtomps());
            table.addCell(appoinment.getMedicalOfficer().getStrStaffId());
            
                 
                 
                 
             }
         
         }
        
        
        
        
        
        
        
        
 
        
 
        //To avoid having the cell border and the content overlap, if you are having thick cell borders
        //cell1.setUserBorderPadding(true);
        //cell2.setUserBorderPadding(true);
        //cell3.setUserBorderPadding(true);
 
 
        document.add(table);
 
        document.close();
        writer.close();
    } catch (Exception e)
    {
        e.printStackTrace();
    }
         
         
     }
   
     //complaint functions here
      private void addNewComplaint(){
        AddComplaint complaint = new AddComplaint(this.getUserRole(),this);
    }
     private void deleteComplaint(){
          Object record= ((DefaultTableModel) complaintTable.getModel()).getDataVector().elementAt(complaintTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getComplaintsFilePath();
                    FileService.deleteRecord(path, line);
                    this.setTables();
         
     }
     private void editComplaint(){
          Object record= ((DefaultTableModel) complaintTable.getModel()).getDataVector().elementAt(complaintTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getComplaintsFilePath();
                    Complaint complain= FileService.readComplaint(line);
                    EditComplaint edit=new EditComplaint(complain,this);
     }
     public void editApproveAction(String action){
           Object record= ((DefaultTableModel) complaintTable.getModel()).getDataVector().elementAt(complaintTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getComplaintsFilePath();
                    FileService.deleteRecord(path,line);
                    Complaint complain= FileService.readComplaint(line);
                    complain.setStrActionTaken(action);
                    FileService.addLine(path, complain.toString());
                    this.setTables();
         
     }
     
     //mails functions here
      private void addDispatchedPostal(){
        AddMail mail = new AddMail(this);
    }
     private void deleteMail(){
          Object record= ((DefaultTableModel) dispatchedMailTable.getModel()).getDataVector().elementAt(dispatchedMailTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getMailsFilePath();
                    FileService.deleteRecord(path, line);
                    this.setTables();
         
     }
     private void editMail(){
          Object record= ((DefaultTableModel) dispatchedMailTable.getModel()).getDataVector().elementAt(dispatchedMailTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getMailsFilePath();
                    DispatchedPostal mail= FileService.readMail(line);
                    EditMail edit=new EditMail(mail,this);
         
     }
     
   //visitor records functions here
    private void addNewVisitorRecord(){
        AddVisitors record = new AddVisitors(this);
    } 
    private void deleteVisitorRecord(){
        Object record= ((DefaultTableModel) visitorTable.getModel()).getDataVector().elementAt(visitorTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getVisitorsFilePath();
                    FileService.deleteRecord(path, line);
                    this.setTables();
        
    }
    private void editVisitorRecord(){
        Object record= ((DefaultTableModel) visitorTable.getModel()).getDataVector().elementAt(visitorTable.getSelectedRow());
                   String line= PipeService.formatTableString(record.toString());
                    String path=FileService.getVisitorsFilePath();
                    Visitor visitor =FileService.readVisitor(line) ;
                    EditVisitor edit =new EditVisitor(visitor,this);
    }
   //  
    
  //report functons here
    
    private void setMoComboBox(){      
    Object[] items=  FileService.getAllMo(FileService.getRecords(FileService.getMoFile())).toArray();     
    DefaultComboBoxModel model = new DefaultComboBoxModel(items);
    moComboBox.setModel( model );
    }
    
    
    private void setAppointmentReportTable(){
        String date=getDateSimpleFormat(jDateChooser2.getDate());
        MedicalOfficer officer=(MedicalOfficer) moComboBox.getSelectedItem();
         ArrayList<String> list= FileService.getRecords(FileService.getAppointmentsFile());
        TableModel tm = appointmentReportTable.getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
      
             for(int i=0;i<list.size();i++)  
           {  
            
            Appointment appoinment=FileService.readAppoinment(list.get(i));
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
        
    }
     private void setPatientCredintialReportTable(){
        
    } 
     
     private String getDateSimpleFormat(Date date){
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date); 
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AddressField;
    private javax.swing.JTextField NICNofield;
    private javax.swing.JPasswordField Passwordfield;
    private javax.swing.JTextField PhoneNofield;
    private javax.swing.JButton addBtn10;
    private javax.swing.JButton addBtn11;
    private javax.swing.JButton addBtn12;
    private javax.swing.JButton addBtn13;
    private javax.swing.JPanel adminAppointmentOptions;
    private javax.swing.JPanel adminComplaintOptions;
    private javax.swing.JButton adminDeleteUser;
    private javax.swing.JPanel adminMailOptions;
    private javax.swing.JPanel adminRefferenceOptions;
    private javax.swing.JPanel adminSidePanel;
    private javax.swing.JPanel adminUserOptions;
    private javax.swing.JPanel adminVisitorOptions;
    private javax.swing.JPanel appoinmentReportPanel;
    private javax.swing.JPanel appointmentBtnPanel;
    private javax.swing.JPanel appointmentMainOption;
    private javax.swing.JPanel appointmentPanel;
    private javax.swing.JTable appointmentReportTable;
    private javax.swing.JTable appointmentTable;
    private javax.swing.JTable appointmentTable4;
    private javax.swing.JTable appointmentTable5;
    private javax.swing.JButton approveAppoinmentBtn9;
    private javax.swing.JButton approveBtn3;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JPanel complaintBtnPanel;
    private javax.swing.JPanel complaintPanel;
    private javax.swing.JTable complaintTable;
    private javax.swing.JPanel complaintsMainOption;
    private com.toedter.calendar.JDateChooser dateJoinedField;
    private javax.swing.JButton deleteBtn15;
    private javax.swing.JTable dispatchedMailTable;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton editBtn2;
    private javax.swing.JButton editBtn3;
    private javax.swing.JButton editBtn5;
    private javax.swing.JButton editBtn6;
    private javax.swing.JButton editBtn7;
    private javax.swing.JButton editBtn8;
    private javax.swing.JButton generatePdfBtn;
    private javax.swing.JPanel homeBtnPanel1;
    private javax.swing.JPanel homeBtnPanel2;
    private javax.swing.JPanel homeBtnPanel3;
    private javax.swing.JPanel homeBtnPanel4;
    private javax.swing.JPanel homePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JLabel jLabel49;
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
    private javax.swing.JLabel jLabel64;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
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
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel mailBtnPanel;
    private javax.swing.JPanel mailMainOption;
    private javax.swing.JPanel mailPanel;
    private javax.swing.JButton moAppoinmentCompleteBtn;
    private javax.swing.JPanel moAppointmentOptions;
    private javax.swing.JComboBox<String> moComboBox;
    private javax.swing.JScrollPane moScrollPanel;
    private javax.swing.JPanel moSettingPanel;
    private javax.swing.JPanel moSidePanel;
    private javax.swing.JTable moTable;
    private javax.swing.JTextField namefield;
    private javax.swing.JPanel patientAppointmentOptions;
    private javax.swing.JPanel patientComplaintOptions;
    private javax.swing.JPanel patientCreditialReportPanel;
    private javax.swing.JScrollPane patientScrollPanel;
    private javax.swing.JPanel patientSettingPanel;
    private javax.swing.JPanel patientSettingPanel1;
    private javax.swing.JPanel patientSidePanel;
    private javax.swing.JTable patientsTable;
    private javax.swing.JButton photoAddBtn2;
    private javax.swing.JPanel photoUploadedPanel1;
    private javax.swing.JLabel profileImg;
    private javax.swing.JLabel profileImg1;
    private javax.swing.JLabel profileImg2;
    private javax.swing.JLabel profileImg3;
    private javax.swing.JPanel receptionAppointmentOptions;
    private javax.swing.JPanel receptionComplaintOptions;
    private javax.swing.JPanel receptionMailOptions;
    private javax.swing.JPanel receptionSidePanel;
    private javax.swing.JPanel receptionUserOptions;
    private javax.swing.JPanel receptionVisitorOptions;
    private javax.swing.JLabel receptionistPhotoLabel;
    private javax.swing.JScrollPane receptionistScrollPanel;
    private javax.swing.JPanel receptionistSettingPanel;
    private javax.swing.JPanel receptionistSettingPanel1;
    private javax.swing.JTable receptionistTable;
    private javax.swing.JPanel refferenceBtnPanel;
    private javax.swing.JList<String> refferenceList;
    private javax.swing.JPanel refferenceMainOption;
    private javax.swing.JPanel refferencePanel;
    private javax.swing.JPanel reportBtnPanel;
    private javax.swing.JPanel reportsPanel;
    private javax.swing.JPanel settingBtnPanel;
    private javax.swing.JPanel settingBtnPanel1;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JPanel specialityListPanel;
    private javax.swing.JTextField staffEmailField;
    private javax.swing.JTextField staffIdField;
    private javax.swing.JPanel userBtnPanel;
    private javax.swing.JPanel userBtnPanel2;
    private javax.swing.JPanel userLogReportPanel;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel userNameLabel1;
    private javax.swing.JLabel userNameLabel2;
    private javax.swing.JLabel userNameLabel3;
    private javax.swing.JTextField usernamefield;
    private javax.swing.JPanel usersMainOption;
    private javax.swing.JPanel usersPanel;
    private javax.swing.JButton viewBtn11;
    private javax.swing.JPanel visitorBtnPanel;
    private javax.swing.JPanel visitorBtnPanel2;
    private javax.swing.JTable visitorTable;
    private javax.swing.JPanel visitorsMainOption;
    private javax.swing.JPanel visitorsPanel;
    // End of variables declaration//GEN-END:variables
}

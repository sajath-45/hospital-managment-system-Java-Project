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
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
            reportsMainOption.setVisible(false);
            settingsMainOption.setVisible(false);
        
    }
    
    public void setBtns(){
        
        
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
                        resetOptionPanels();
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
                        reportsMainOption.setVisible(false);
                        settingsMainOption.setVisible(false);
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
                        reportsMainOption.setVisible(false);
                        settingsMainOption.setVisible(false);
                               

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
                        reportsMainOption.setVisible(false);
                        settingsMainOption.setVisible(false);
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
                        reportsMainOption.setVisible(false);
                        settingsMainOption.setVisible(false);
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
                        reportsMainOption.setVisible(false);
                        settingsMainOption.setVisible(true);
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
                        reportsMainOption.setVisible(false);
                        settingsMainOption.setVisible(false);
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
                        reportsMainOption.setVisible(false);
                        settingsMainOption.setVisible(false);
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
                        reportsMainOption.setVisible(true);
                        settingsMainOption.setVisible(false);
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
                        reportsMainOption.setVisible(false);
                        settingsMainOption.setVisible(false);
                         
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
        settingBtnPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        homeBtnPanel1 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        userBtnPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        refferenceBtnPanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        userNameLabel = new javax.swing.JLabel();
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
        receptionistSettingPanel = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        userBtnPanel2 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        homeBtnPanel4 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        userNameLabel3 = new javax.swing.JLabel();
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
        jScrollPane4 = new javax.swing.JScrollPane();
        appointmentTable3 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
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
        usersPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        appointmentMainOption = new javax.swing.JPanel();
        adminAppointmentOptions = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        approveBtn1 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        editBtn1 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        receptionAppointmentOptions = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        rAppointmentView = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        editBtn5 = new javax.swing.JButton();
        patientAppointmentOptions = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        rAppointmentView1 = new javax.swing.JButton();
        moAppointmentOptions = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        moAppoinmentComplete = new javax.swing.JButton();
        usersMainOption = new javax.swing.JPanel();
        adminUserOptions = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        editBtn = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel59 = new javax.swing.JPanel();
        addBtn11 = new javax.swing.JButton();
        jPanel60 = new javax.swing.JPanel();
        viewBtn11 = new javax.swing.JButton();
        receptionUserOptions = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        editBtn7 = new javax.swing.JButton();
        jPanel49 = new javax.swing.JPanel();
        editBtn15 = new javax.swing.JButton();
        jPanel58 = new javax.swing.JPanel();
        addBtn10 = new javax.swing.JButton();
        mailMainOption = new javax.swing.JPanel();
        adminMailOptions = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        viewBtn3 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        receptionMailOptions = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        viewBtn5 = new javax.swing.JButton();
        jPanel45 = new javax.swing.JPanel();
        editBtn6 = new javax.swing.JButton();
        jPanel47 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        complaintsMainOption = new javax.swing.JPanel();
        adminComplaintOptions = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        approveBtn3 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        editBtn3 = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        patientComplaintOptions = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jPanel57 = new javax.swing.JPanel();
        viewBtn19 = new javax.swing.JButton();
        receptionComplaintOptions = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jPanel52 = new javax.swing.JPanel();
        viewBtnBtn8 = new javax.swing.JButton();
        visitorsMainOption = new javax.swing.JPanel();
        receptionVisitorOptions = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        editBtn8 = new javax.swing.JButton();
        jPanel51 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jPanel63 = new javax.swing.JPanel();
        addBtn13 = new javax.swing.JButton();
        jPanel64 = new javax.swing.JPanel();
        viewBtn13 = new javax.swing.JButton();
        adminVisitorOptions = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jPanel66 = new javax.swing.JPanel();
        viewBtn14 = new javax.swing.JButton();
        refferenceMainOption = new javax.swing.JPanel();
        adminRefferenceOptions = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        editBtn2 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel61 = new javax.swing.JPanel();
        addBtn12 = new javax.swing.JButton();
        jPanel62 = new javax.swing.JPanel();
        viewBtn12 = new javax.swing.JButton();
        reportsMainOption = new javax.swing.JPanel();
        adminReportOptions = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        approveBtn4 = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        editBtn4 = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        settingsMainOption = new javax.swing.JPanel();

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

        settingBtnPanel.setBackground(new java.awt.Color(64, 43, 100));
        settingBtnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        settingBtnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingBtnPanelMousePressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Settings");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout settingBtnPanelLayout = new javax.swing.GroupLayout(settingBtnPanel);
        settingBtnPanel.setLayout(settingBtnPanelLayout);
        settingBtnPanelLayout.setHorizontalGroup(
            settingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingBtnPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        settingBtnPanelLayout.setVerticalGroup(
            settingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(settingBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 250, 50));

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

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new/user2.png"))); // NOI18N

        javax.swing.GroupLayout homeBtnPanel1Layout = new javax.swing.GroupLayout(homeBtnPanel1);
        homeBtnPanel1.setLayout(homeBtnPanel1Layout);
        homeBtnPanel1Layout.setHorizontalGroup(
            homeBtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBtnPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
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
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
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

        javax.swing.GroupLayout adminSidePanelLayout = new javax.swing.GroupLayout(adminSidePanel);
        adminSidePanel.setLayout(adminSidePanelLayout);
        adminSidePanelLayout.setHorizontalGroup(
            adminSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminSidePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(adminSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(adminSidePanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(profileImg)))
                .addGap(27, 27, 27))
            .addGroup(adminSidePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(userNameLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        adminSidePanelLayout.setVerticalGroup(
            adminSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminSidePanelLayout.createSequentialGroup()
                .addComponent(profileImg, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(userNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
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
                .addGap(72, 72, 72)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(423, Short.MAX_VALUE))
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
        jLabel29.setText("Appointments");

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
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addContainerGap())
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 50));

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
                .addContainerGap(498, Short.MAX_VALUE))
        );

        bgPanel.add(moSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 250, -1));

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
                .addGap(37, 37, 37)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
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
                .addGap(37, 37, 37)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
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
                .addGap(37, 37, 37)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
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

        receptionistSettingPanel.setBackground(new java.awt.Color(64, 43, 100));
        receptionistSettingPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        receptionistSettingPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                receptionistSettingPanelMousePressed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Settings");

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/settings_24px.png"))); // NOI18N

        javax.swing.GroupLayout receptionistSettingPanelLayout = new javax.swing.GroupLayout(receptionistSettingPanel);
        receptionistSettingPanel.setLayout(receptionistSettingPanelLayout);
        receptionistSettingPanelLayout.setHorizontalGroup(
            receptionistSettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionistSettingPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        receptionistSettingPanelLayout.setVerticalGroup(
            receptionistSettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionistSettingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receptionistSettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel30.add(receptionistSettingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 250, 50));

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

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new/user2.png"))); // NOI18N

        javax.swing.GroupLayout homeBtnPanel4Layout = new javax.swing.GroupLayout(homeBtnPanel4);
        homeBtnPanel4.setLayout(homeBtnPanel4Layout);
        homeBtnPanel4Layout.setHorizontalGroup(
            homeBtnPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBtnPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
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
                        .addGap(45, 45, 45)
                        .addComponent(profileImg3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        receptionSidePanelLayout.setVerticalGroup(
            receptionSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profileImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(userNameLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(377, Short.MAX_VALUE))
        );

        bgPanel.add(receptionSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 250, -1));

        appointmentPanel.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane1.setBorder(null);

        appointmentTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        appointmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Appointment No", "Date", "Time", "Status", "Patient Name", "Id Card No", "Medical Officer", "Speciality", "Sysmtomps"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false, false
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
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(visitorsPanelLayout.createSequentialGroup()
                .addGap(412, 412, 412)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                "type", "Date", "Patient Name", "Description", "Mobile", "Action", "Note", "Attachment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
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
            complaintTable.getColumnModel().getColumn(3).setPreferredWidth(130);
            complaintTable.getColumnModel().getColumn(5).setPreferredWidth(130);
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

        jScrollPane4.setBorder(null);

        appointmentTable3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        appointmentTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        appointmentTable3.setGridColor(new java.awt.Color(255, 255, 255));
        appointmentTable3.setIntercellSpacing(new java.awt.Dimension(5, 5));
        appointmentTable3.setRowHeight(20);
        appointmentTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                appointmentTable3MousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(appointmentTable3);
        if (appointmentTable3.getColumnModel().getColumnCount() > 0) {
            appointmentTable3.getColumnModel().getColumn(0).setPreferredWidth(100);
            appointmentTable3.getColumnModel().getColumn(2).setPreferredWidth(100);
            appointmentTable3.getColumnModel().getColumn(3).setPreferredWidth(130);
            appointmentTable3.getColumnModel().getColumn(4).setPreferredWidth(130);
            appointmentTable3.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        jLabel18.setText("report panel");

        javax.swing.GroupLayout reportsPanelLayout = new javax.swing.GroupLayout(reportsPanel);
        reportsPanel.setLayout(reportsPanelLayout);
        reportsPanelLayout.setHorizontalGroup(
            reportsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(reportsPanelLayout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        reportsPanelLayout.setVerticalGroup(
            reportsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportsPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(478, Short.MAX_VALUE))
        );

        bgPanel.add(reportsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 1090, 860));

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

        jLabel23.setText("setting ");

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(jLabel23)
                .addContainerGap(661, Short.MAX_VALUE))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(833, Short.MAX_VALUE))
        );

        bgPanel.add(settingsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 1090, 860));

        usersPanel.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane8.setBorder(null);

        usersTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id No", "name", "ype", "Id Card No", "Date", "Time", "Medical Officer", "Speciality", "Sysmtomps"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        usersTable.setGridColor(new java.awt.Color(255, 255, 255));
        usersTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
        usersTable.setRowHeight(20);
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usersTableMousePressed(evt);
            }
        });
        jScrollPane8.setViewportView(usersTable);
        if (usersTable.getColumnModel().getColumnCount() > 0) {
            usersTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            usersTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            usersTable.getColumnModel().getColumn(3).setPreferredWidth(130);
            usersTable.getColumnModel().getColumn(4).setPreferredWidth(130);
            usersTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        javax.swing.GroupLayout usersPanelLayout = new javax.swing.GroupLayout(usersPanel);
        usersPanel.setLayout(usersPanelLayout);
        usersPanelLayout.setHorizontalGroup(
            usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                .addContainerGap())
        );
        usersPanelLayout.setVerticalGroup(
            usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(478, Short.MAX_VALUE))
        );

        bgPanel.add(usersPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 1090, 860));

        appointmentMainOption.setPreferredSize(new java.awt.Dimension(1090, 108));

        jPanel10.setBackground(new java.awt.Color(153, 153, 255));

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel16.setBackground(new java.awt.Color(153, 153, 255));

        approveBtn1.setText("Approve");
        approveBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(approveBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(approveBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel18.setBackground(new java.awt.Color(153, 153, 255));

        editBtn1.setText("Edit");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(editBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel19.setBackground(new java.awt.Color(153, 153, 255));

        jButton5.setText("Delete");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout adminAppointmentOptionsLayout = new javax.swing.GroupLayout(adminAppointmentOptions);
        adminAppointmentOptions.setLayout(adminAppointmentOptionsLayout);
        adminAppointmentOptionsLayout.setHorizontalGroup(
            adminAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminAppointmentOptionsLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 347, Short.MAX_VALUE))
        );
        adminAppointmentOptionsLayout.setVerticalGroup(
            adminAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminAppointmentOptionsLayout.createSequentialGroup()
                .addGroup(adminAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(153, 153, 255));

        jButton11.setText("Add");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel28.setBackground(new java.awt.Color(153, 153, 255));

        rAppointmentView.setText("View");
        rAppointmentView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rAppointmentViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(rAppointmentView, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rAppointmentView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel36.setBackground(new java.awt.Color(153, 153, 255));

        editBtn5.setText("Edit");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(editBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editBtn5, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout receptionAppointmentOptionsLayout = new javax.swing.GroupLayout(receptionAppointmentOptions);
        receptionAppointmentOptions.setLayout(receptionAppointmentOptionsLayout);
        receptionAppointmentOptionsLayout.setHorizontalGroup(
            receptionAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionAppointmentOptionsLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 443, Short.MAX_VALUE))
        );
        receptionAppointmentOptionsLayout.setVerticalGroup(
            receptionAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionAppointmentOptionsLayout.createSequentialGroup()
                .addGroup(receptionAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        patientAppointmentOptions.setPreferredSize(new java.awt.Dimension(1090, 110));

        jPanel42.setBackground(new java.awt.Color(153, 153, 255));

        jButton12.setText("Add");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel43.setBackground(new java.awt.Color(153, 153, 255));

        rAppointmentView1.setText("View");
        rAppointmentView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rAppointmentView1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(rAppointmentView1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rAppointmentView1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout patientAppointmentOptionsLayout = new javax.swing.GroupLayout(patientAppointmentOptions);
        patientAppointmentOptions.setLayout(patientAppointmentOptionsLayout);
        patientAppointmentOptionsLayout.setHorizontalGroup(
            patientAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientAppointmentOptionsLayout.createSequentialGroup()
                .addGap(1098, 1098, 1098)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        patientAppointmentOptionsLayout.setVerticalGroup(
            patientAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel46.setBackground(new java.awt.Color(153, 153, 255));

        moAppoinmentComplete.setText("Complete");
        moAppoinmentComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moAppoinmentCompleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(moAppoinmentComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(moAppoinmentComplete, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout moAppointmentOptionsLayout = new javax.swing.GroupLayout(moAppointmentOptions);
        moAppointmentOptions.setLayout(moAppointmentOptionsLayout);
        moAppointmentOptionsLayout.setHorizontalGroup(
            moAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moAppointmentOptionsLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 703, Short.MAX_VALUE))
        );
        moAppointmentOptionsLayout.setVerticalGroup(
            moAppointmentOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moAppointmentOptionsLayout.createSequentialGroup()
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout appointmentMainOptionLayout = new javax.swing.GroupLayout(appointmentMainOption);
        appointmentMainOption.setLayout(appointmentMainOptionLayout);
        appointmentMainOptionLayout.setHorizontalGroup(
            appointmentMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2068, Short.MAX_VALUE)
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

        jPanel13.setBackground(new java.awt.Color(153, 153, 255));

        editBtn.setText("Edit");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(153, 153, 255));

        jButton4.setText("Delete");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel59.setBackground(new java.awt.Color(153, 153, 255));
        jPanel59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel59MousePressed(evt);
            }
        });

        addBtn11.setText("Add");
        addBtn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(addBtn11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBtn11, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel60.setBackground(new java.awt.Color(153, 153, 255));

        viewBtn11.setText("view");

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(viewBtn11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewBtn11, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout adminUserOptionsLayout = new javax.swing.GroupLayout(adminUserOptions);
        adminUserOptions.setLayout(adminUserOptionsLayout);
        adminUserOptionsLayout.setHorizontalGroup(
            adminUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminUserOptionsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 294, Short.MAX_VALUE))
        );
        adminUserOptionsLayout.setVerticalGroup(
            adminUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel48.setBackground(new java.awt.Color(153, 153, 255));

        editBtn7.setText("Edit");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(editBtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editBtn7, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel49.setBackground(new java.awt.Color(153, 153, 255));

        editBtn15.setText("Delete");

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(editBtn15, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editBtn15, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel58.setBackground(new java.awt.Color(153, 153, 255));

        addBtn10.setText("add");
        addBtn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(addBtn10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBtn10, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout receptionUserOptionsLayout = new javax.swing.GroupLayout(receptionUserOptions);
        receptionUserOptions.setLayout(receptionUserOptionsLayout);
        receptionUserOptionsLayout.setHorizontalGroup(
            receptionUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionUserOptionsLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 475, Short.MAX_VALUE))
        );
        receptionUserOptionsLayout.setVerticalGroup(
            receptionUserOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout usersMainOptionLayout = new javax.swing.GroupLayout(usersMainOption);
        usersMainOption.setLayout(usersMainOptionLayout);
        usersMainOptionLayout.setHorizontalGroup(
            usersMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
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
            .addGap(0, 110, Short.MAX_VALUE)
            .addGroup(usersMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(usersMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(usersMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(adminUserOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(receptionUserOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bgPanel.add(usersMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        mailMainOption.setPreferredSize(new java.awt.Dimension(1090, 108));

        jPanel11.setBackground(new java.awt.Color(153, 153, 255));

        viewBtn3.setText("Add");
        viewBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel25.setBackground(new java.awt.Color(153, 153, 255));

        jButton6.setText("Delete");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout adminMailOptionsLayout = new javax.swing.GroupLayout(adminMailOptions);
        adminMailOptions.setLayout(adminMailOptionsLayout);
        adminMailOptionsLayout.setHorizontalGroup(
            adminMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminMailOptionsLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 580, Short.MAX_VALUE))
        );
        adminMailOptionsLayout.setVerticalGroup(
            adminMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel12.setBackground(new java.awt.Color(153, 153, 255));

        jButton13.setText("Add");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel44.setBackground(new java.awt.Color(153, 153, 255));

        viewBtn5.setText("View");
        viewBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtn5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(viewBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewBtn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel45.setBackground(new java.awt.Color(153, 153, 255));

        editBtn6.setText("Edit");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(editBtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editBtn6, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel47.setBackground(new java.awt.Color(153, 153, 255));

        jButton14.setText("Delete");

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout receptionMailOptionsLayout = new javax.swing.GroupLayout(receptionMailOptions);
        receptionMailOptions.setLayout(receptionMailOptionsLayout);
        receptionMailOptionsLayout.setHorizontalGroup(
            receptionMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionMailOptionsLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 347, Short.MAX_VALUE))
        );
        receptionMailOptionsLayout.setVerticalGroup(
            receptionMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionMailOptionsLayout.createSequentialGroup()
                .addGroup(receptionMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receptionMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mailMainOptionLayout = new javax.swing.GroupLayout(mailMainOption);
        mailMainOption.setLayout(mailMainOptionLayout);
        mailMainOptionLayout.setHorizontalGroup(
            mailMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
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
            .addGap(0, 110, Short.MAX_VALUE)
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

        jPanel27.setBackground(new java.awt.Color(153, 153, 255));

        approveBtn3.setText("Approve");
        approveBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(approveBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(approveBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel29.setBackground(new java.awt.Color(153, 153, 255));

        editBtn3.setText("Edit");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(editBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel34.setBackground(new java.awt.Color(153, 153, 255));

        jButton8.setText("Delete");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout adminComplaintOptionsLayout = new javax.swing.GroupLayout(adminComplaintOptions);
        adminComplaintOptions.setLayout(adminComplaintOptionsLayout);
        adminComplaintOptionsLayout.setHorizontalGroup(
            adminComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminComplaintOptionsLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 347, Short.MAX_VALUE))
        );
        adminComplaintOptionsLayout.setVerticalGroup(
            adminComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminComplaintOptionsLayout.createSequentialGroup()
                .addGroup(adminComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel54.setBackground(new java.awt.Color(153, 153, 255));

        jButton18.setText("Add Complain");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel57.setBackground(new java.awt.Color(153, 153, 255));

        viewBtn19.setText("View");

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(viewBtn19, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewBtn19, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout patientComplaintOptionsLayout = new javax.swing.GroupLayout(patientComplaintOptions);
        patientComplaintOptions.setLayout(patientComplaintOptionsLayout);
        patientComplaintOptionsLayout.setHorizontalGroup(
            patientComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientComplaintOptionsLayout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 511, Short.MAX_VALUE))
        );
        patientComplaintOptionsLayout.setVerticalGroup(
            patientComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientComplaintOptionsLayout.createSequentialGroup()
                .addGroup(patientComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel50.setBackground(new java.awt.Color(153, 153, 255));

        jButton16.setText("Add");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel52.setBackground(new java.awt.Color(153, 153, 255));

        viewBtnBtn8.setText("View");

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(viewBtnBtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewBtnBtn8, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout receptionComplaintOptionsLayout = new javax.swing.GroupLayout(receptionComplaintOptions);
        receptionComplaintOptions.setLayout(receptionComplaintOptionsLayout);
        receptionComplaintOptionsLayout.setHorizontalGroup(
            receptionComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionComplaintOptionsLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 530, Short.MAX_VALUE))
        );
        receptionComplaintOptionsLayout.setVerticalGroup(
            receptionComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionComplaintOptionsLayout.createSequentialGroup()
                .addGroup(receptionComplaintOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
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
            .addGap(0, 110, Short.MAX_VALUE)
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

        jPanel26.setBackground(new java.awt.Color(153, 153, 255));

        editBtn8.setText("Edit");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(editBtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editBtn8, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel51.setBackground(new java.awt.Color(153, 153, 255));

        jButton15.setText("Delete");

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel63.setBackground(new java.awt.Color(153, 153, 255));

        addBtn13.setText("Add");
        addBtn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(addBtn13, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBtn13, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel64.setBackground(new java.awt.Color(153, 153, 255));

        viewBtn13.setText("view");

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(viewBtn13, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewBtn13, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout receptionVisitorOptionsLayout = new javax.swing.GroupLayout(receptionVisitorOptions);
        receptionVisitorOptions.setLayout(receptionVisitorOptionsLayout);
        receptionVisitorOptionsLayout.setHorizontalGroup(
            receptionVisitorOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionVisitorOptionsLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 350, Short.MAX_VALUE))
        );
        receptionVisitorOptionsLayout.setVerticalGroup(
            receptionVisitorOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel53.setBackground(new java.awt.Color(153, 153, 255));

        jButton17.setText("Delete");

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel66.setBackground(new java.awt.Color(153, 153, 255));

        viewBtn14.setText("view");

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(viewBtn14, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewBtn14, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout adminVisitorOptionsLayout = new javax.swing.GroupLayout(adminVisitorOptions);
        adminVisitorOptions.setLayout(adminVisitorOptionsLayout);
        adminVisitorOptionsLayout.setHorizontalGroup(
            adminVisitorOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminVisitorOptionsLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 484, Short.MAX_VALUE))
        );
        adminVisitorOptionsLayout.setVerticalGroup(
            adminVisitorOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout visitorsMainOptionLayout = new javax.swing.GroupLayout(visitorsMainOption);
        visitorsMainOption.setLayout(visitorsMainOptionLayout);
        visitorsMainOptionLayout.setHorizontalGroup(
            visitorsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(visitorsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(visitorsMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(receptionVisitorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(visitorsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(visitorsMainOptionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(adminVisitorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        visitorsMainOptionLayout.setVerticalGroup(
            visitorsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
            .addGroup(visitorsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(visitorsMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(receptionVisitorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
            .addGroup(visitorsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, visitorsMainOptionLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminVisitorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        bgPanel.add(visitorsMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        refferenceMainOption.setPreferredSize(new java.awt.Dimension(1090, 108));

        jPanel21.setBackground(new java.awt.Color(153, 153, 255));

        editBtn2.setText("Edit");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(editBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel24.setBackground(new java.awt.Color(153, 153, 255));

        jButton7.setText("Delete");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel61.setBackground(new java.awt.Color(153, 153, 255));

        addBtn12.setText("Add");

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(addBtn12, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBtn12, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel62.setBackground(new java.awt.Color(153, 153, 255));

        viewBtn12.setText("view");

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(viewBtn12, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewBtn12, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout adminRefferenceOptionsLayout = new javax.swing.GroupLayout(adminRefferenceOptions);
        adminRefferenceOptions.setLayout(adminRefferenceOptionsLayout);
        adminRefferenceOptionsLayout.setHorizontalGroup(
            adminRefferenceOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminRefferenceOptionsLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 350, Short.MAX_VALUE))
        );
        adminRefferenceOptionsLayout.setVerticalGroup(
            adminRefferenceOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout refferenceMainOptionLayout = new javax.swing.GroupLayout(refferenceMainOption);
        refferenceMainOption.setLayout(refferenceMainOptionLayout);
        refferenceMainOptionLayout.setHorizontalGroup(
            refferenceMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(refferenceMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(refferenceMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(adminRefferenceOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        refferenceMainOptionLayout.setVerticalGroup(
            refferenceMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
            .addGroup(refferenceMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(refferenceMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(adminRefferenceOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bgPanel.add(refferenceMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        reportsMainOption.setPreferredSize(new java.awt.Dimension(1090, 108));

        jPanel38.setBackground(new java.awt.Color(153, 153, 255));

        jButton9.setText("Add");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel39.setBackground(new java.awt.Color(153, 153, 255));

        approveBtn4.setText("Approve");
        approveBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtn4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(approveBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(approveBtn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel40.setBackground(new java.awt.Color(153, 153, 255));

        editBtn4.setText("Edit");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(editBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editBtn4, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel41.setBackground(new java.awt.Color(153, 153, 255));

        jButton10.setText("Delete");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout adminReportOptionsLayout = new javax.swing.GroupLayout(adminReportOptions);
        adminReportOptions.setLayout(adminReportOptionsLayout);
        adminReportOptionsLayout.setHorizontalGroup(
            adminReportOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminReportOptionsLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 347, Short.MAX_VALUE))
        );
        adminReportOptionsLayout.setVerticalGroup(
            adminReportOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminReportOptionsLayout.createSequentialGroup()
                .addGroup(adminReportOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminReportOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout reportsMainOptionLayout = new javax.swing.GroupLayout(reportsMainOption);
        reportsMainOption.setLayout(reportsMainOptionLayout);
        reportsMainOptionLayout.setHorizontalGroup(
            reportsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(reportsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(reportsMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(adminReportOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        reportsMainOptionLayout.setVerticalGroup(
            reportsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
            .addGroup(reportsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(reportsMainOptionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(adminReportOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bgPanel.add(reportsMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        settingsMainOption.setPreferredSize(new java.awt.Dimension(1090, 108));

        javax.swing.GroupLayout settingsMainOptionLayout = new javax.swing.GroupLayout(settingsMainOption);
        settingsMainOption.setLayout(settingsMainOptionLayout);
        settingsMainOptionLayout.setHorizontalGroup(
            settingsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        settingsMainOptionLayout.setVerticalGroup(
            settingsMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        bgPanel.add(settingsMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

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
            System.out.println("works");
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        addNewAppointment();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void approveBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_approveBtn1ActionPerformed

    private void viewBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtn3ActionPerformed
        // TODO add your handling code here:
        addDispatchedPostal();
    }//GEN-LAST:event_viewBtn3ActionPerformed

    private void approveBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_approveBtn3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void approveBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_approveBtn4ActionPerformed

    private void dispatchedMailTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dispatchedMailTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dispatchedMailTableMousePressed

    private void complaintTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_complaintTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_complaintTableMousePressed

    private void appointmentTable3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentTable3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentTable3MousePressed

    private void visitorTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visitorTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_visitorTableMousePressed

    private void usersTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_usersTableMousePressed

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

    private void rAppointmentViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rAppointmentViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rAppointmentViewActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void rAppointmentView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rAppointmentView1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rAppointmentView1ActionPerformed

    private void moAppoinmentCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moAppoinmentCompleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moAppoinmentCompleteActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
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

    private void viewBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtn5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewBtn5ActionPerformed

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

    private void jPanel59MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel59MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel59MousePressed

    private void addBtn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn11ActionPerformed
        // TODO add your handling code here:
        addNewUser();
    }//GEN-LAST:event_addBtn11ActionPerformed
 
    private void addNewAppointment(){
         AddAppointment appointment = new AddAppointment(this);
         
    }
    
    private void addNewComplaint(){
        AddComplaint complaint = new AddComplaint(this.getUserRole(),this);
    }
    private void addNewVisitorRecord(){
        AddVisitors record = new AddVisitors(this);
    }
    
    private void addDispatchedPostal(){
        AddMail mail = new AddMail(this);
    }
    
    private void addNewUser(){
        AddUser user= new AddUser(getUserRole(),this);
    }
    
    
    
    private void resetOptionPanels(){
        
        
        
        
    }
    private void setComplainRefference(){
        setColor(jPanel1);
             resetColor(jPanel2);
            ComplainRefference refference = new ComplainRefference();
           ArrayList<String> complainRefferenceList = refference.getComplainTypes();
            DefaultListModel<String> model = new DefaultListModel<String>();
             refferenceList.setModel(model);
          for(String s:complainRefferenceList){
                 model.addElement(s);
                }
        
    }
    
     private void setSpecialityRefference(){
         setColor(jPanel2);
            resetColor(jPanel1);
         SpecialityRefference refference=new SpecialityRefference();
        
       ArrayList<String> specialityRefferenceList = refference.getSpecialityTypes();
            DefaultListModel<String> model2 = new DefaultListModel<String>();
             refferenceList.setModel(model2);
          for(String s:specialityRefferenceList){
                 model2.addElement(s);
                }
           
            
        
        
    }
    
    
    
    
    public void setTables(){
        if(getUserRole().equals("Admin")){
            getAllAppointment();
            getAllComplaints();
            getDispatchedMails();
            getVisitorRecords();
            getReceivedMails();
        }
        else if(getUserRole().equals("Receptionist")){
        getAllAppointment();
        getAllComplaints();
        getDispatchedMails();
        getVisitorRecords();
        
        getReceivedMails();
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
            
        }
        else if(getUserRole().equals("Receptionist")){
            receptionUserOptions.setVisible(true);
            adminUserOptions.setVisible(false);
            
            

        }
        
    }
    private void setRefferenceOption(){
         if(getUserRole().equals("Admin")){
             adminRefferenceOptions.setVisible(true);
            
        }
        
    }
    private void setReportOptions(){
         if(getUserRole().equals("Admin")){
            adminReportOptions.setVisible(true);
           
            
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
    
    
    private void getPatientAppointmentTable(String id){
        ArrayList<String> list= FileService.getPatientAppointments(id);
        TableModel tm = appointmentTable.getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
        System.out.println("patient appointments");  
             for(int i=0;i<list.size();i++)  
           {  
            System.out.println(list.get(i));  
            
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
        System.out.println("Mo appoinments");  
             for(int i=0;i<list.size();i++)  
           {  
            System.out.println(list.get(i));  
            
            String [] data=list.get(i).split(",");
             Object[] row = {data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7],data[8]};
                    model.addRow(row);
            
           }  
        
    }
    private void getAllAppointment(){
        ArrayList<String> list= FileService.getAllAppointments();
        TableModel tm = appointmentTable.getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
       System.out.println("all appointments"); 
             for(int i=0;i<list.size();i++)  
           {  
            System.out.println(list.get(i));  
            
            String [] data=list.get(i).split(",");
             Object[] row = {data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7],data[8]};
                    model.addRow(row);
            
           }  
        
    }
    
    private void getAllComplaints(){
         ArrayList<String> list= FileService.getAllComplaints();
        TableModel tm = complaintTable.getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
       System.out.println("all complaints");  
             for(int i=0;i<list.size();i++)  
           {  
            System.out.println(list.get(i));  
            
            String [] data=list.get(i).split(",");
             Object[] row = { data[0],data[1], data[2], data[3], data[4], data[5], data[6], data[7]};
                    model.addRow(row);
            
           }  
        
    }
    
    private void getPatientComplains(){
          ArrayList<String> list= FileService.getPatientComplaints();
        TableModel tm = complaintTable.getModel();
                DefaultTableModel model = (DefaultTableModel) tm;
                model.setRowCount(0);
            System.out.println("patient complaints");  
             for(int i=0;i<list.size();i++)  
           {  
            System.out.println(list.get(i));  
            
            String [] data=list.get(i).split(",");
             Object[] row = { data[1], data[2], data[3], data[4], data[5], data[6], data[7],data[8]};
                    model.addRow(row);
            
           }  
        
    }
    
    private void getDispatchedMails(){
         ArrayList<String> list= FileService.getDispatchedMails();
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
        ArrayList<String> list= FileService.getVisitorRecords();
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn10;
    private javax.swing.JButton addBtn11;
    private javax.swing.JButton addBtn12;
    private javax.swing.JButton addBtn13;
    private javax.swing.JPanel adminAppointmentOptions;
    private javax.swing.JPanel adminComplaintOptions;
    private javax.swing.JPanel adminMailOptions;
    private javax.swing.JPanel adminRefferenceOptions;
    private javax.swing.JPanel adminReportOptions;
    private javax.swing.JPanel adminSidePanel;
    private javax.swing.JPanel adminUserOptions;
    private javax.swing.JPanel adminVisitorOptions;
    private javax.swing.JPanel appointmentBtnPanel;
    private javax.swing.JPanel appointmentMainOption;
    private javax.swing.JPanel appointmentPanel;
    private javax.swing.JTable appointmentTable;
    private javax.swing.JTable appointmentTable3;
    private javax.swing.JButton approveBtn1;
    private javax.swing.JButton approveBtn3;
    private javax.swing.JButton approveBtn4;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JPanel complaintBtnPanel;
    private javax.swing.JPanel complaintPanel;
    private javax.swing.JTable complaintTable;
    private javax.swing.JPanel complaintsMainOption;
    private javax.swing.JTable dispatchedMailTable;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton editBtn1;
    private javax.swing.JButton editBtn15;
    private javax.swing.JButton editBtn2;
    private javax.swing.JButton editBtn3;
    private javax.swing.JButton editBtn4;
    private javax.swing.JButton editBtn5;
    private javax.swing.JButton editBtn6;
    private javax.swing.JButton editBtn7;
    private javax.swing.JButton editBtn8;
    private javax.swing.JPanel homeBtnPanel1;
    private javax.swing.JPanel homeBtnPanel2;
    private javax.swing.JPanel homeBtnPanel3;
    private javax.swing.JPanel homeBtnPanel4;
    private javax.swing.JPanel homePanel;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel mailBtnPanel;
    private javax.swing.JPanel mailMainOption;
    private javax.swing.JPanel mailPanel;
    private javax.swing.JButton moAppoinmentComplete;
    private javax.swing.JPanel moAppointmentOptions;
    private javax.swing.JPanel moSettingPanel;
    private javax.swing.JPanel moSidePanel;
    private javax.swing.JPanel patientAppointmentOptions;
    private javax.swing.JPanel patientComplaintOptions;
    private javax.swing.JPanel patientSettingPanel;
    private javax.swing.JPanel patientSidePanel;
    private javax.swing.JLabel profileImg;
    private javax.swing.JLabel profileImg1;
    private javax.swing.JLabel profileImg2;
    private javax.swing.JLabel profileImg3;
    private javax.swing.JButton rAppointmentView;
    private javax.swing.JButton rAppointmentView1;
    private javax.swing.JPanel receptionAppointmentOptions;
    private javax.swing.JPanel receptionComplaintOptions;
    private javax.swing.JPanel receptionMailOptions;
    private javax.swing.JPanel receptionSidePanel;
    private javax.swing.JPanel receptionUserOptions;
    private javax.swing.JPanel receptionVisitorOptions;
    private javax.swing.JPanel receptionistSettingPanel;
    private javax.swing.JPanel refferenceBtnPanel;
    private javax.swing.JList<String> refferenceList;
    private javax.swing.JPanel refferenceMainOption;
    private javax.swing.JPanel refferencePanel;
    private javax.swing.JPanel reportBtnPanel;
    private javax.swing.JPanel reportsMainOption;
    private javax.swing.JPanel reportsPanel;
    private javax.swing.JPanel settingBtnPanel;
    private javax.swing.JPanel settingsMainOption;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JPanel specialityListPanel;
    private javax.swing.JPanel userBtnPanel;
    private javax.swing.JPanel userBtnPanel2;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel userNameLabel1;
    private javax.swing.JLabel userNameLabel2;
    private javax.swing.JLabel userNameLabel3;
    private javax.swing.JPanel usersMainOption;
    private javax.swing.JPanel usersPanel;
    private javax.swing.JTable usersTable;
    private javax.swing.JButton viewBtn11;
    private javax.swing.JButton viewBtn12;
    private javax.swing.JButton viewBtn13;
    private javax.swing.JButton viewBtn14;
    private javax.swing.JButton viewBtn19;
    private javax.swing.JButton viewBtn3;
    private javax.swing.JButton viewBtn5;
    private javax.swing.JButton viewBtnBtn8;
    private javax.swing.JPanel visitorBtnPanel;
    private javax.swing.JPanel visitorBtnPanel2;
    private javax.swing.JTable visitorTable;
    private javax.swing.JPanel visitorsMainOption;
    private javax.swing.JPanel visitorsPanel;
    // End of variables declaration//GEN-END:variables
}

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
     */
    public Dashboard(String role) {
        this.setVisible(true);
        initComponents();
        setRole(role);
        setSidePanel(role);
        setTables();
        setSideBarPanels();
        
    }

    private Dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    
    public void setSideBarPanels(){
         jPanel23.addMouseListener(listener);
        moSettingPanel.addMouseListener(listener);
        jPanel5.addMouseListener(listener);
        jPanel17.addMouseListener(listener);
        patientSettingPanel.addMouseListener(listener);
        jPanel31.addMouseListener(listener);
        jPanel32.addMouseListener(listener);
        jPanel33.addMouseListener(listener);
        jPanel35.addMouseListener(listener);
        receptionistSettingPanel.addMouseListener(listener);
        jPanel37.addMouseListener(listener);
        userBtnPanel.addMouseListener(listener);
        reportBtnPanel.addMouseListener(listener);
        appointmentBtnPanel.addMouseListener(listener);
        mailBtnPanel.addMouseListener(listener);
        complaintBtnPanel.addMouseListener(listener);
        visitorBtnPanel.addMouseListener(listener);
        settingBtnPanel.addMouseListener(listener);
        refferenceBtnPanel.addMouseListener(listener);
        
        
        jPanel31.setName("appointmentBtnPanel");//recep
        appointmentBtnPanel.setName("appointmentBtnPanel");//admin
        jPanel5.setName("appointmentBtnPanel");
        jPanel23.setName("appointmentBtnPanel");
        
        mailBtnPanel.setName("mailBtn");
        jPanel32.setName("mailBtn");
       
        
        complaintBtnPanel.setName("complaintBtn");
        jPanel17.setName("complaintBtn");
        jPanel33.setName("complaintBtn");
        
        jPanel35.setName("visitorBtn");
        visitorBtnPanel.setName("visitorBtn");
        
        settingBtnPanel.setName("settingBtn");
        receptionistSettingPanel.setName("settingBtn");
        moSettingPanel.setName("settingBtn");
        patientSettingPanel.setName("settingBtn");
        
         userBtnPanel.setName("userBtn");
        jPanel37.setName("userBtn");
        
        reportBtnPanel.setName("reportBtn");
        
        refferenceBtnPanel.setName("refferenceBtn");
        
                  
        
    }
       MouseListener listener = new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        resetAllColor();
                        resetAllMainPanels();
                        System.out.println(((JPanel)e.getSource()).getName());
                     if( ((JPanel)e.getSource()).getName().equals("complaintBtn")){
                         setColor(complaintBtnPanel);
                         setColor(jPanel17);
                         setColor(jPanel33);
                         complaintPanel.setVisible(true);
                         
                     }
                     else if(((JPanel)e.getSource()).getName().equals("appointmentBtnPanel")){
                          setColor(jPanel5);
                         setColor(appointmentBtnPanel);
                         setColor(jPanel31);
                          setColor(jPanel23);
                          appointmentPanel.setVisible(true);
                         
                     }
                     else if(((JPanel)e.getSource()).getName().equals("mailBtn")){
                          setColor(mailBtnPanel);
                         setColor(jPanel32);
                         mailPanel.setVisible(true);
                         
                         
                     }
                     else if(((JPanel)e.getSource()).getName().equals("userBtn")){
                          setColor(userBtnPanel);
                         setColor(jPanel37);
                         usersPanel.setVisible(true);
                         
                         
                     }
                     else if(((JPanel)e.getSource()).getName().equals("settingBtn")){
                           setColor(settingBtnPanel);
                         setColor(receptionistSettingPanel);
                         setColor(moSettingPanel);
                          setColor(patientSettingPanel);
                          complaintPanel.setVisible(false);
                          settingsPanel.setVisible(true);
                     }
                     else if(((JPanel)e.getSource()).getName().equals("visitorBtn")){
                         visitorsPanel.setVisible(true);
                         complaintPanel.setVisible(false);
                         setColor(visitorBtnPanel);
                         setColor(jPanel35);
                      
                         System.out.println("visitor panel");
                     }
                      else if(((JPanel)e.getSource()).getName().equals("refferenceBtn")){
                         setColor(refferenceBtnPanel);
                         refferencePanel.setVisible(true);
                     }
                      else if(((JPanel)e.getSource()).getName().equals("reportBtn")){
                         setColor(reportBtnPanel);
                         reportsPanel.setVisible(true);
                     }
                     
                    }
                };
    
    
     public void actionPerformed(ActionEvent e) {
           System.out.println("event "+e);
        if(e.getSource() == jPanel23){
            System.out.println("japnel 23");
        }
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
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
        jPanel35 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        receptionistSettingPanel = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        userNameLabel3 = new javax.swing.JLabel();
        adminAppointmentOptions1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        approveBtn1 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        editBtn1 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        adminUsertOptions = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        approveBtn = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        editBtn = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        adminMailOptions = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        approveBtn2 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        editBtn2 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        adminComplaintOptions = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        approveBtn3 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        editBtn3 = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        adminReportOption = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        approveBtn4 = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        editBtn4 = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
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
        jScrollPane6 = new javax.swing.JScrollPane();
        appointmentTable5 = new javax.swing.JTable();
        settingsPanel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        usersPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        appointmentTable7 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminSidePanel.setBackground(new java.awt.Color(54, 33, 89));

        profileImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/old/DOCTORDETAILS (2).png"))); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setForeground(new java.awt.Color(54, 33, 89));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appointmentBtnPanel.setBackground(new java.awt.Color(85, 65, 118));
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

        jPanel8.add(appointmentBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 50));

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

        jPanel8.add(mailBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 250, 50));

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

        jPanel8.add(complaintBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 250, 50));

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

        jPanel8.add(reportBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 250, 50));

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

        jPanel8.add(visitorBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 250, 50));

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

        jPanel8.add(settingBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 250, 50));

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
                .addContainerGap())
        );

        jPanel8.add(userBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 50));

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

        jPanel8.add(refferenceBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 250, 50));

        javax.swing.GroupLayout adminSidePanelLayout = new javax.swing.GroupLayout(adminSidePanel);
        adminSidePanel.setLayout(adminSidePanelLayout);
        adminSidePanelLayout.setHorizontalGroup(
            adminSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminSidePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(adminSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(profileImg)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        bgPanel.add(adminSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 250, -1));

        patientSidePanel.setBackground(new java.awt.Color(54, 33, 89));

        profileImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/old/DOCTORDETAILS (2).png"))); // NOI18N

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setForeground(new java.awt.Color(54, 33, 89));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(85, 65, 118));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 50));

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

        jPanel15.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 50));

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

        jPanel15.add(patientSettingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 250, 50));

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
                .addGap(87, 87, 87)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(458, Short.MAX_VALUE))
        );

        bgPanel.add(patientSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 250, -1));

        moSidePanel.setBackground(new java.awt.Color(54, 33, 89));

        profileImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/old/DOCTORDETAILS (2).png"))); // NOI18N

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setForeground(new java.awt.Color(54, 33, 89));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(85, 65, 118));
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

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 50));

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

        jPanel22.add(moSettingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 50));

        javax.swing.GroupLayout moSidePanelLayout = new javax.swing.GroupLayout(moSidePanel);
        moSidePanel.setLayout(moSidePanelLayout);
        moSidePanelLayout.setHorizontalGroup(
            moSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moSidePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(moSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(profileImg2)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(80, 80, 80)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(550, Short.MAX_VALUE))
        );

        bgPanel.add(moSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 250, -1));

        receptionSidePanel.setBackground(new java.awt.Color(54, 33, 89));

        profileImg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/old/DOCTORDETAILS (2).png"))); // NOI18N

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setForeground(new java.awt.Color(54, 33, 89));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel31.setBackground(new java.awt.Color(85, 65, 118));
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

        jPanel30.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 50));

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

        jPanel30.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 250, 50));

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

        jPanel30.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 250, 50));

        jPanel35.setBackground(new java.awt.Color(64, 43, 100));
        jPanel35.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel35MousePressed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Visitors");

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/myspace_app_24px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel30.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 250, 50));

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

        jPanel30.add(receptionistSettingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 250, 50));

        jPanel37.setBackground(new java.awt.Color(64, 43, 100));
        jPanel37.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel37MousePressed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Users");

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new/user2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel30.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 50));

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
                .addContainerGap(427, Short.MAX_VALUE))
        );

        bgPanel.add(receptionSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 250, -1));

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

        javax.swing.GroupLayout adminAppointmentOptions1Layout = new javax.swing.GroupLayout(adminAppointmentOptions1);
        adminAppointmentOptions1.setLayout(adminAppointmentOptions1Layout);
        adminAppointmentOptions1Layout.setHorizontalGroup(
            adminAppointmentOptions1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminAppointmentOptions1Layout.createSequentialGroup()
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
        adminAppointmentOptions1Layout.setVerticalGroup(
            adminAppointmentOptions1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminAppointmentOptions1Layout.createSequentialGroup()
                .addGroup(adminAppointmentOptions1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminAppointmentOptions1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        bgPanel.add(adminAppointmentOptions1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        jPanel9.setBackground(new java.awt.Color(153, 153, 255));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(153, 153, 255));

        approveBtn.setText("Approve");
        approveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(approveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(approveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout adminUsertOptionsLayout = new javax.swing.GroupLayout(adminUsertOptions);
        adminUsertOptions.setLayout(adminUsertOptionsLayout);
        adminUsertOptionsLayout.setHorizontalGroup(
            adminUsertOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminUsertOptionsLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 347, Short.MAX_VALUE))
        );
        adminUsertOptionsLayout.setVerticalGroup(
            adminUsertOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminUsertOptionsLayout.createSequentialGroup()
                .addGroup(adminUsertOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminUsertOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        bgPanel.add(adminUsertOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        jPanel11.setBackground(new java.awt.Color(153, 153, 255));

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel21.setBackground(new java.awt.Color(153, 153, 255));

        approveBtn2.setText("Approve");
        approveBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(approveBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(approveBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel24.setBackground(new java.awt.Color(153, 153, 255));

        editBtn2.setText("Edit");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(editBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
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
                .addGap(42, 42, 42)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 347, Short.MAX_VALUE))
        );
        adminMailOptionsLayout.setVerticalGroup(
            adminMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminMailOptionsLayout.createSequentialGroup()
                .addGroup(adminMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminMailOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        bgPanel.add(adminMailOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

        jPanel26.setBackground(new java.awt.Color(153, 153, 255));

        jButton7.setText("Add");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                .addGap(42, 42, 42)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                        .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        bgPanel.add(adminComplaintOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

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

        javax.swing.GroupLayout adminReportOptionLayout = new javax.swing.GroupLayout(adminReportOption);
        adminReportOption.setLayout(adminReportOptionLayout);
        adminReportOptionLayout.setHorizontalGroup(
            adminReportOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminReportOptionLayout.createSequentialGroup()
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
        adminReportOptionLayout.setVerticalGroup(
            adminReportOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminReportOptionLayout.createSequentialGroup()
                .addGroup(adminReportOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminReportOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        bgPanel.add(adminReportOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 110));

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
            appointmentTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            appointmentTable.getColumnModel().getColumn(3).setPreferredWidth(130);
            appointmentTable.getColumnModel().getColumn(4).setPreferredWidth(130);
            appointmentTable.getColumnModel().getColumn(6).setPreferredWidth(100);
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

        jScrollPane6.setBorder(null);

        appointmentTable5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        appointmentTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        appointmentTable5.setGridColor(new java.awt.Color(255, 255, 255));
        appointmentTable5.setIntercellSpacing(new java.awt.Dimension(5, 5));
        appointmentTable5.setRowHeight(20);
        appointmentTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                appointmentTable5MousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(appointmentTable5);
        if (appointmentTable5.getColumnModel().getColumnCount() > 0) {
            appointmentTable5.getColumnModel().getColumn(0).setPreferredWidth(100);
            appointmentTable5.getColumnModel().getColumn(2).setPreferredWidth(100);
            appointmentTable5.getColumnModel().getColumn(3).setPreferredWidth(130);
            appointmentTable5.getColumnModel().getColumn(4).setPreferredWidth(130);
            appointmentTable5.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        javax.swing.GroupLayout refferencePanelLayout = new javax.swing.GroupLayout(refferencePanel);
        refferencePanel.setLayout(refferencePanelLayout);
        refferencePanelLayout.setHorizontalGroup(
            refferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refferencePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                .addContainerGap())
        );
        refferencePanelLayout.setVerticalGroup(
            refferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refferencePanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(478, Short.MAX_VALUE))
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

        appointmentTable7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        appointmentTable7.setModel(new javax.swing.table.DefaultTableModel(
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
        appointmentTable7.setGridColor(new java.awt.Color(255, 255, 255));
        appointmentTable7.setIntercellSpacing(new java.awt.Dimension(5, 5));
        appointmentTable7.setRowHeight(20);
        appointmentTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                appointmentTable7MousePressed(evt);
            }
        });
        jScrollPane8.setViewportView(appointmentTable7);
        if (appointmentTable7.getColumnModel().getColumnCount() > 0) {
            appointmentTable7.getColumnModel().getColumn(0).setPreferredWidth(100);
            appointmentTable7.getColumnModel().getColumn(2).setPreferredWidth(100);
            appointmentTable7.getColumnModel().getColumn(3).setPreferredWidth(130);
            appointmentTable7.getColumnModel().getColumn(4).setPreferredWidth(130);
            appointmentTable7.getColumnModel().getColumn(6).setPreferredWidth(100);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 746, Short.MAX_VALUE)
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

    private void approveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_approveBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void appointmentTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentTableMousePressed

        if (appointmentTable.getSelectedRow() > -1) {
            // print first column value from selected row
            System.out.println("works");
            approveBtn.setEnabled(true);
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

    private void jPanel35MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel35MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel35MousePressed

    private void receptionistSettingPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionistSettingPanelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_receptionistSettingPanelMousePressed

    private void jPanel37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MousePressed

    private void patientSettingPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientSettingPanelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientSettingPanelMousePressed

    private void refferenceBtnPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refferenceBtnPanelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_refferenceBtnPanelMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void approveBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_approveBtn1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void approveBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_approveBtn2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

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

    private void appointmentTable5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentTable5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentTable5MousePressed

    private void appointmentTable7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentTable7MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentTable7MousePressed

    private void setTables(){
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
            getPatientComplains("199829003939");
            
    }
        else if(getUserRole().equals("MedicalOfficer")){
        getMOAppointmentTable("dr001");
    }
        
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
         approveBtn.setEnabled(false);
                     editBtn.setEnabled(false);
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
         approveBtn.setEnabled(false);
                     editBtn.setEnabled(false);
        
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
             Object[] row = { data[1], data[2], data[3], data[4], data[5], data[6], data[7],data[8]};
                    model.addRow(row);
            
           }  
        
    }
    
    private void getPatientComplains(String id){
          ArrayList<String> list= FileService.getPatientComplaints(id);
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
          mailPanel.setVisible(false);
           appointmentPanel.setVisible(false);
            reportsPanel.setVisible(false);
             settingsPanel.setVisible(false);
              refferencePanel.setVisible(false);
               visitorsPanel.setVisible(false);
     }
      void resetAllColor(){
         jPanel23.setBackground(new Color(64,43,100));
        moSettingPanel.setBackground(new Color(64,43,100));
        jPanel5.setBackground(new Color(64,43,100));
        jPanel17.setBackground(new Color(64,43,100));
        patientSettingPanel.setBackground(new Color(64,43,100));
        jPanel31.setBackground(new Color(64,43,100));
        jPanel32.setBackground(new Color(64,43,100));
        jPanel33.setBackground(new Color(64,43,100));
        jPanel35.setBackground(new Color(64,43,100));
        receptionistSettingPanel.setBackground(new Color(64,43,100));
        jPanel37.setBackground(new Color(64,43,100));
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
    private javax.swing.JPanel adminAppointmentOptions1;
    private javax.swing.JPanel adminComplaintOptions;
    private javax.swing.JPanel adminMailOptions;
    private javax.swing.JPanel adminReportOption;
    private javax.swing.JPanel adminSidePanel;
    private javax.swing.JPanel adminUsertOptions;
    private javax.swing.JPanel appointmentBtnPanel;
    private javax.swing.JPanel appointmentPanel;
    private javax.swing.JTable appointmentTable;
    private javax.swing.JTable appointmentTable3;
    private javax.swing.JTable appointmentTable5;
    private javax.swing.JTable appointmentTable7;
    private javax.swing.JButton approveBtn;
    private javax.swing.JButton approveBtn1;
    private javax.swing.JButton approveBtn2;
    private javax.swing.JButton approveBtn3;
    private javax.swing.JButton approveBtn4;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JPanel complaintBtnPanel;
    private javax.swing.JPanel complaintPanel;
    private javax.swing.JTable complaintTable;
    private javax.swing.JTable dispatchedMailTable;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton editBtn1;
    private javax.swing.JButton editBtn2;
    private javax.swing.JButton editBtn3;
    private javax.swing.JButton editBtn4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel mailBtnPanel;
    private javax.swing.JPanel mailPanel;
    private javax.swing.JPanel moSettingPanel;
    private javax.swing.JPanel moSidePanel;
    private javax.swing.JPanel patientSettingPanel;
    private javax.swing.JPanel patientSidePanel;
    private javax.swing.JLabel profileImg;
    private javax.swing.JLabel profileImg1;
    private javax.swing.JLabel profileImg2;
    private javax.swing.JLabel profileImg3;
    private javax.swing.JPanel receptionSidePanel;
    private javax.swing.JPanel receptionistSettingPanel;
    private javax.swing.JPanel refferenceBtnPanel;
    private javax.swing.JPanel refferencePanel;
    private javax.swing.JPanel reportBtnPanel;
    private javax.swing.JPanel reportsPanel;
    private javax.swing.JPanel settingBtnPanel;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JPanel userBtnPanel;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel userNameLabel1;
    private javax.swing.JLabel userNameLabel2;
    private javax.swing.JLabel userNameLabel3;
    private javax.swing.JPanel usersPanel;
    private javax.swing.JPanel visitorBtnPanel;
    private javax.swing.JTable visitorTable;
    private javax.swing.JPanel visitorsPanel;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.managment.system;

import hospital.managment.system.models.FileService;
import hospital.managment.system.models.SpecialityRefference;
import hospital.managment.system.models.MedicalOfficer;
import hospital.managment.system.models.Patient;
import hospital.managment.system.models.Receptionist;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sajath
 */
public class AddUser extends javax.swing.JFrame {
    private int selectionType;
    private String userRole;
    private JFileChooser openFileChooser;
    private File attachment;
     private File photoAttachment;
    private Dashboard dashboard;
    private boolean photoChoosen=false;
    private int actionType;
    private Patient patient;
    private MedicalOfficer officer;
    private Receptionist receptionist;
    
    
    
    /** Creates new form AddUser
     * @param actionType
     * @param role
     * @param dashboard
     * @param patient
     * @param officer
     * @param receptionist */
    public AddUser(int actionType,String role,Dashboard dashboard,Patient patient,MedicalOfficer officer,Receptionist receptionist) {
        initComponents();
        setActionType(actionType);
        this.setVisible(true);
        setUserRole(role);
        setDashboard(dashboard);
         setPatient(patient);
        setMedicalOfficer(officer);
        setReceptionist(receptionist);
        initActionType();
        
                
        
       
        
        
    }

    public AddUser() {
    }
    
    public void initActionType(){
        if(getActionType()==2){
            jPanel3.setVisible(false);
            editUserBtn.setVisible(true);
       
             addUserBtn2.setVisible(false);
             
            
            
            
            if(getPatient() != null){
                try {
                    setOptionPatient();
                    setCurrentPatient();
                } catch (ParseException ex) {
                    Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(getMedicalOfficer() != null){
                try {
                    setOptionMo();
                    setCurrentMo();
                } catch (ParseException ex) {
                    Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(getReceptionist() != null){
                try {
                    setOptionReceptionist();
                    setCurrentReceptionist();
                } catch (ParseException ex) {
                    Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            
            
        }
        else{
        editUserBtn.setVisible(false);
        createSpecialityComboBox();
        setFileChooser();
        checkPhoto();
        setRoleOption();
            
        }
    }
    
     
    public void  setMedicalOfficer(MedicalOfficer officer){
        this.officer=officer;
    }
    public void setPatient(Patient patient){
         this.patient=patient;
    }
    public void setReceptionist(Receptionist receptionist){
         this.receptionist=receptionist;
    }
    
    public MedicalOfficer  getMedicalOfficer(){
        return officer;
    }
    public Patient getPatient(){
         return patient;
    }
    public Receptionist getReceptionist(){
         return receptionist;
    }
    
    public void setActionType(int type){
        this.actionType=type;//edit or new 
    }
    
    public void setUserRole(String role){
        this.userRole=role;
    }
    public void setSelectionType(int type){
        this.selectionType=type;
    }
     public void setphotoChoosen(boolean value){
        this.photoChoosen=value;
    }
     public void setDashboard(Dashboard dash){
         this.dashboard=dash;
     }
     
     //getters
     public int getActionType(){
         return this.actionType;  
     }
    public String getUserRole(){
        return userRole;
    }
    public boolean getphotoChoosen(){
        return this.photoChoosen;
    }
    public Dashboard getDashboard(){
         return dashboard;
     }
   
    
    public int getSelectionType(){
        return this.selectionType;
        
    }
     private void setFileChooser(){
        openFileChooser =new JFileChooser();
        
    }
     
     
     private void  setCurrentPatient() throws ParseException{
          this.nameField.setText(getPatient().getName());
        this.genderField.setSelectedItem(getPatient().getGender());
        this.mobileField.setText(getPatient().getphoneNumber());
        this.idCardField.setText(getPatient().getIdCardNo());
        this.addressField.setText(getPatient().getAddress());
        this.userNameField.setText(getPatient().getUserName());
        this.martialStatusField.setSelectedItem(getPatient().getMaritalStatus());
        allergiesField.setText(getPatient().getStrAllergies());
        bloodComboBox.setSelectedItem(getPatient().getStrBloodGrp());
        java.util.Date dob=new SimpleDateFormat("dd/MM/yyyy").parse(getPatient().getDateOfBirth());
        dobField.setDate(dob);
         
     }
     private void  setCurrentMo() throws ParseException{
         this.nameField.setText(getMedicalOfficer().getName());
        this.genderField.setSelectedItem(getMedicalOfficer().getGender());
        this.mobileField.setText(getMedicalOfficer().getphoneNumber());
        this.idCardField.setText(getMedicalOfficer().getIdCardNo());
        this.addressField.setText(getMedicalOfficer().getAddress());
        this.userNameField.setText(getMedicalOfficer().getUserName());
        this.martialStatusField.setSelectedItem(getMedicalOfficer().getMaritalStatus());
        this.attachment=getMedicalOfficer().getCvFile();
        this. photoAttachment=getMedicalOfficer().getPhoto();
        this.staffIdField1.setText(getMedicalOfficer().getStrStaffId());
        this.staffMailField1.setText(getMedicalOfficer().getStrEmailAddress());
        java.util.Date dob=new SimpleDateFormat("dd/MM/yyyy").parse(getMedicalOfficer().getDateOfBirth());
        java.util.Date joinDate=new SimpleDateFormat("dd/MM/yyyy").parse(getMedicalOfficer().getStrDateOfJoining());
        dobField.setDate(dob);
        dateJoinField1.setDate(joinDate);
        
        setphotoChoosen(true);
        checkPhoto();
          createSpecialityComboBox();
          specialityComboBox.setSelectedItem(getMedicalOfficer().getStrSpecialityArea());
         
         
         
     }
     private void  setCurrentReceptionist() throws ParseException{
         this.nameField.setText(getReceptionist().getName());
        this.genderField.setSelectedItem(getReceptionist().getGender());
        this.mobileField.setText(getReceptionist().getphoneNumber());
        this.idCardField.setText(getReceptionist().getIdCardNo());
        this.addressField.setText(getReceptionist().getAddress());
        this.userNameField.setText(getReceptionist().getUserName());
        this.martialStatusField.setSelectedItem(getReceptionist().getMaritalStatus());
        this.attachment=getReceptionist().getCvFile();
        this. photoAttachment=getReceptionist().getPhoto();
        this.staffIdField.setText(getReceptionist().getStrStaffId());
        this.staffMailField.setText(getReceptionist().getStrEmailAddress());
        java.util.Date dob=new SimpleDateFormat("dd/MM/yyyy").parse(getReceptionist().getDateOfBirth());
        java.util.Date joinDate=new SimpleDateFormat("dd/MM/yyyy").parse(getReceptionist().getStrDateOfJoining());
        dobField.setDate(dob);
        dateJoinField.setDate(joinDate);
         setphotoChoosen(true);
        checkPhoto();
         
     }
     
     
     
     
     
     
     

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        genderField = new javax.swing.JComboBox<>();
        nameField = new javax.swing.JTextField();
        mobileField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressField = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        martialStatusField = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        idCardField = new javax.swing.JTextField();
        dobField = new com.toedter.calendar.JDateChooser();
        receptionPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        staffIdField = new javax.swing.JTextField();
        staffMailField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        chooseFileBtn = new javax.swing.JButton();
        fileNameLabel = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        dateJoinField = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        photoUploadedPanel1 = new javax.swing.JPanel();
        photoAddBtn2 = new javax.swing.JButton();
        receptionistPhotoLabel = new javax.swing.JLabel();
        patientPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        allergiesField = new javax.swing.JTextArea();
        bloodComboBox = new javax.swing.JComboBox<>();
        moPanel = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        staffIdField1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        staffMailField1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        chooseFileBtn1 = new javax.swing.JButton();
        fileNameLabel1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        dateJoinField1 = new com.toedter.calendar.JDateChooser();
        jLabel29 = new javax.swing.JLabel();
        specialityComboBox = new javax.swing.JComboBox<>();
        photoUploadedPanel = new javax.swing.JPanel();
        moPhotoLabel = new javax.swing.JLabel();
        photoAddBtn1 = new javax.swing.JButton();
        editUserBtn = new javax.swing.JButton();
        addUserBtn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(233, 228, 228));
        jPanel1.setPreferredSize(new java.awt.Dimension(910, 670));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(85, 65, 118));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add User");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(363, 363, 363)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(426, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 40));

        jPanel3.setBackground(new java.awt.Color(39, 55, 130));
        jPanel3.setForeground(new java.awt.Color(39, 55, 130));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setForeground(new java.awt.Color(102, 0, 102));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Receptionists");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 320, 40));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setForeground(new java.awt.Color(102, 0, 102));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Medical Officers");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel3)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setForeground(new java.awt.Color(102, 0, 102));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("Patients");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 300, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 910, 40));

        jPanel7.setBackground(new java.awt.Color(233, 228, 228));
        jPanel7.setPreferredSize(new java.awt.Dimension(470, 670));

        jLabel5.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(85, 65, 118));
        jLabel5.setText("Name");

        jLabel6.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(85, 65, 118));
        jLabel6.setText("Gender");

        jLabel7.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(85, 65, 118));
        jLabel7.setText("Phone Number");

        jLabel8.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(85, 65, 118));
        jLabel8.setText("Date-Of-Birth");

        genderField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        jLabel9.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(85, 65, 118));
        jLabel9.setText("Address");

        addressField.setColumns(20);
        addressField.setRows(5);
        jScrollPane1.setViewportView(addressField);

        jLabel10.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(85, 65, 118));
        jLabel10.setText("Martial Status");

        martialStatusField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Married", "Single" }));
        martialStatusField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                martialStatusFieldActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(85, 65, 118));
        jLabel11.setText("User Name");

        jLabel14.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(85, 65, 118));
        jLabel14.setText("Id Card No");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14))
                        .addGap(55, 55, 55)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(genderField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mobileField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameField)
                    .addComponent(martialStatusField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userNameField)
                    .addComponent(idCardField)
                    .addComponent(dobField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(genderField, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobileField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dobField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idCardField, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(martialStatusField, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 470, 590));

        receptionPanel.setBackground(new java.awt.Color(233, 228, 228));
        receptionPanel.setForeground(new java.awt.Color(85, 65, 118));

        jLabel12.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(85, 65, 118));
        jLabel12.setText("Staff Id");

        staffMailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffMailFieldActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(85, 65, 118));
        jLabel15.setText("Staff Photograph");

        jLabel17.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(85, 65, 118));
        jLabel17.setText("Attachment");

        chooseFileBtn.setText("Choose");
        chooseFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileBtnActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(85, 65, 118));
        jLabel19.setText("Date Of Joining");

        jLabel18.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(85, 65, 118));
        jLabel18.setText("Staff Email");

        photoUploadedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        photoAddBtn2.setText("add");
        photoAddBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoAddBtn2ActionPerformed(evt);
            }
        });
        photoUploadedPanel1.add(photoAddBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        receptionistPhotoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                receptionistPhotoLabelMousePressed(evt);
            }
        });
        photoUploadedPanel1.add(receptionistPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 150));

        javax.swing.GroupLayout receptionPanelLayout = new javax.swing.GroupLayout(receptionPanel);
        receptionPanel.setLayout(receptionPanelLayout);
        receptionPanelLayout.setHorizontalGroup(
            receptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(receptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                    .addComponent(jLabel15)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(28, 28, 28)
                .addGroup(receptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receptionPanelLayout.createSequentialGroup()
                        .addComponent(chooseFileBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(receptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(staffMailField)
                        .addComponent(staffIdField)
                        .addComponent(dateJoinField, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                    .addGroup(receptionPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(photoUploadedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        receptionPanelLayout.setVerticalGroup(
            receptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionPanelLayout.createSequentialGroup()
                .addGroup(receptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(receptionPanelLayout.createSequentialGroup()
                        .addGroup(receptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(receptionPanelLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(receptionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(photoUploadedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(receptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staffMailField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(receptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staffIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(receptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addComponent(dateJoinField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(receptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chooseFileBtn)))
                    .addComponent(fileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.add(receptionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 450, 440));

        patientPanel.setBackground(new java.awt.Color(233, 228, 228));

        jLabel20.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel20.setText("Allergies");

        jLabel21.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel21.setText("Blooad Group");

        allergiesField.setColumns(20);
        allergiesField.setRows(5);
        jScrollPane2.setViewportView(allergiesField);

        bloodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));

        javax.swing.GroupLayout patientPanelLayout = new javax.swing.GroupLayout(patientPanel);
        patientPanel.setLayout(patientPanelLayout);
        patientPanelLayout.setHorizontalGroup(
            patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGroup(patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patientPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bloodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(patientPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        patientPanelLayout.setVerticalGroup(
            patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientPanelLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bloodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.add(patientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 440, 440));

        moPanel.setBackground(new java.awt.Color(233, 228, 228));
        moPanel.setForeground(new java.awt.Color(85, 65, 118));

        jLabel22.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(85, 65, 118));
        jLabel22.setText("Staff Id");

        jLabel23.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(85, 65, 118));
        jLabel23.setText("Speciality");

        staffMailField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffMailField1ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(85, 65, 118));
        jLabel25.setText("Staff Photograph");

        jLabel27.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(85, 65, 118));
        jLabel27.setText("Attachment");

        chooseFileBtn1.setText("Choose");
        chooseFileBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileBtn1ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(85, 65, 118));
        jLabel28.setText("Date Of Joining");

        jLabel29.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(85, 65, 118));
        jLabel29.setText("Staff Email");

        specialityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        photoUploadedPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        photoUploadedPanel.add(moPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 150));

        photoAddBtn1.setText("add");
        photoAddBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoAddBtn1ActionPerformed(evt);
            }
        });
        photoUploadedPanel.add(photoAddBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        javax.swing.GroupLayout moPanelLayout = new javax.swing.GroupLayout(moPanel);
        moPanel.setLayout(moPanelLayout);
        moPanelLayout.setHorizontalGroup(
            moPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(moPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addGroup(moPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                .addGroup(moPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(moPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(moPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(staffMailField1)
                            .addComponent(staffIdField1)
                            .addComponent(dateJoinField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moPanelLayout.createSequentialGroup()
                                .addComponent(chooseFileBtn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fileNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(specialityComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(moPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(photoUploadedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        moPanelLayout.setVerticalGroup(
            moPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moPanelLayout.createSequentialGroup()
                .addGroup(moPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(moPanelLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(moPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(photoUploadedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(moPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(specialityComboBox))
                .addGap(27, 27, 27)
                .addGroup(moPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffMailField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(moPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staffIdField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(moPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(dateJoinField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(moPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(moPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chooseFileBtn1))
                    .addComponent(fileNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(moPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 440, 450));

        editUserBtn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        editUserBtn.setForeground(new java.awt.Color(85, 65, 118));
        editUserBtn.setText("Save");
        editUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserBtnActionPerformed(evt);
            }
        });
        jPanel1.add(editUserBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 560, -1, 52));

        addUserBtn2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        addUserBtn2.setForeground(new java.awt.Color(85, 65, 118));
        addUserBtn2.setText("Add User");
        addUserBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(addUserBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 560, -1, 52));

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void martialStatusFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_martialStatusFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_martialStatusFieldActionPerformed

    private void staffMailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffMailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffMailFieldActionPerformed

    private void addUserBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtn2ActionPerformed
        // TODO add your handling code here:
         addUser();
    }//GEN-LAST:event_addUserBtn2ActionPerformed

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jLabel2MouseExited

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        // TODO add your handling code here:
       setOptionMo();
    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
        // TODO add your handling code here:
                setOptionPatient();

        
    }//GEN-LAST:event_jPanel6MousePressed

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        // TODO add your handling code here:
        setOptionReceptionist();
       

    }//GEN-LAST:event_jPanel4MousePressed

    private void chooseFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileBtnActionPerformed
        // TODO add your handling code here:
                openFileChooser();

    }//GEN-LAST:event_chooseFileBtnActionPerformed

    private void staffMailField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffMailField1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_staffMailField1ActionPerformed

    private void chooseFileBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileBtn1ActionPerformed
        // TODO add your handling code here:
        openFileChooser();
    }//GEN-LAST:event_chooseFileBtn1ActionPerformed

    private void photoAddBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoAddBtn1ActionPerformed
        // TODO add your handling code here:
        addPhoto();
    }//GEN-LAST:event_photoAddBtn1ActionPerformed

    private void photoAddBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoAddBtn2ActionPerformed
        // TODO add your handling code here:
        addPhoto();
    }//GEN-LAST:event_photoAddBtn2ActionPerformed

    private void receptionistPhotoLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionistPhotoLabelMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_receptionistPhotoLabelMousePressed

    private void editUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserBtnActionPerformed
        // TODO add your handling code here:
        editUser();
    }//GEN-LAST:event_editUserBtnActionPerformed
     public void createSpecialityComboBox(){
        SpecialityRefference refference=new SpecialityRefference();
        DefaultComboBoxModel newModel = new DefaultComboBoxModel(refference.getSpecialityTypes().toArray());
         specialityComboBox.setModel( newModel );
    }
     
    public void openFileChooser(){
        
        int returnValue =openFileChooser.showOpenDialog(this);
            if(returnValue==JFileChooser.APPROVE_OPTION){
                attachment = openFileChooser.getSelectedFile();
                fileNameLabel.setText(attachment.getName());
            }
            else{
                 attachment = null;
                 fileNameLabel.setText("no file choosen");
                  fileNameLabel1.setText("no file choosen");
            }
        
    }
    public void addPhoto(){
         int returnValue =openFileChooser.showOpenDialog(this);
            if(returnValue==JFileChooser.APPROVE_OPTION){
                this. photoAttachment = openFileChooser.getSelectedFile();
               setphotoChoosen(true);
               
            }
            else{
                this. photoAttachment = null;
                 setphotoChoosen(false);
            }
             checkPhoto();
        
    }
    
    private void editUser(){
           
        if(selectionType==1){//mo
           FileService.deleteRecord(FileService.getMoFilePath(), getMedicalOfficer().toString2());
        }
        else if(selectionType==2){//reception
            FileService.deleteRecord(FileService.getReceptionistFilePath(), getReceptionist().toString());
           
        }
        else if(selectionType==3){//patient
           FileService.deleteRecord(FileService.getPatientsFilePath(), getPatient().toString2());
        }
        
        addUser();
        
    }
    
    
    
    
    public void addUser(){
        String name=nameField.getText();
        String gender=genderField.getSelectedItem().toString();
        String mobile=mobileField.getText();
        String id=idCardField.getText();
        String address=addressField.getText();
        String userName=userNameField.getText();
        String martialStatus=martialStatusField.getSelectedItem().toString();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dob=formatter.format(dobField.getDate()); 
            
            
         
          
        if(selectionType==1){//mo
            String speciality=specialityComboBox.getSelectedItem().toString();
             String staffId=staffIdField1.getText();
            String staffEmail=staffMailField1.getText();
            String dateJoined=formatter.format(dateJoinField1.getDate()); 
           File file=this.attachment;
           File imageFile=this. photoAttachment;
           
           MedicalOfficer medicalOfficer =new MedicalOfficer(userName,name,gender,mobile,id,dob,address,martialStatus,id,staffId,staffEmail,dateJoined,file,speciality,imageFile);
        FileService.addLine(FileService.getMoFilePath(), medicalOfficer.toString2());
       
        }
        else if(selectionType==2){//reception
             String staffId=staffIdField.getText();
            String staffEmail=staffMailField.getText();
            String dateJoined=formatter.format(dateJoinField.getDate()); 
           File file=this.attachment;
            File imageFile=this. photoAttachment;
      
            Receptionist receptionist = new Receptionist(userName,name,gender,mobile,id,dob,address,martialStatus,id,staffId,staffEmail,dateJoined,file,imageFile);
            FileService.addLine(FileService.getReceptionistFilePath(), receptionist.toString());
            System.out.println(receptionist.toString());
           
        }
        else if(selectionType==3){//patient
            String alleries=allergiesField.getText();
            String bloodGroup=bloodComboBox.getSelectedItem().toString();
            
            Patient patient =new Patient(userName,name,gender,mobile,id,dob,address,martialStatus,id,bloodGroup,alleries,null);
            FileService.addLine(FileService.getPatientsFilePath(), patient.toString2());
            System.out.println(patient.toString2());
            System.out.println("dob"+dob+"martial"+martialStatus);
        }
       // getDashboard().setTables();
        this.dispose();
        
        
    }
    public void checkPhoto(){
        if(getphotoChoosen()){
           //hotoUploadedPanel.setVisible(true);
           //hotoNotUploadedPanel.setVisible(false);
           photoAddBtn1.setVisible(false);
           
           if(this.selectionType==1){
            setStaffPhoto(moPhotoLabel,photoAttachment);
           }
           else if (this.selectionType==2){
               setStaffPhoto(receptionistPhotoLabel,photoAttachment);
           }
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
    
    
    public void setRoleOption(){
        if(getUserRole().equals("Admin")){
            setOptionMo();
        }
        else{
            jPanel3.setVisible(false);
            setSelectionType(3);
             receptionPanel.setVisible(false);
         moPanel.setVisible(false);
         patientPanel.setVisible(true);
            
        }
        
    }
    
    
    public void setOptionMo(){
         setHoverColor(jPanel5,jLabel3);
        resetHoverColor(jPanel4,jLabel2);
         resetHoverColor(jPanel6,jLabel4);
         setSelectionType(1);
           moPanel.setVisible(true);
          receptionPanel.setVisible(false);
         patientPanel.setVisible(false);
        
    }
    public void setOptionReceptionist(){
         resetHoverColor(jPanel5,jLabel3);
        setHoverColor(jPanel4,jLabel2);
         resetHoverColor(jPanel6,jLabel4);
         setSelectionType(2);
          receptionPanel.setVisible(true);
         patientPanel.setVisible(false);
           moPanel.setVisible(false);
       
        
    }
    public void setOptionPatient(){
         resetHoverColor(jPanel5,jLabel3);
        resetHoverColor(jPanel4,jLabel2);
         setHoverColor(jPanel6,jLabel4);
         setSelectionType(3);
         receptionPanel.setVisible(false);
         moPanel.setVisible(false);
         patientPanel.setVisible(true);
        
    }
    
    public void setHoverColor(JPanel panel,JLabel label){
                panel.setBackground(new Color(85,65,118));
                label.setForeground(Color.white);

    }
    
    public void resetHoverColor(JPanel panel,JLabel label){
                panel.setBackground(new Color(255,255,255));
                label.setForeground(new Color(102,0,102));

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
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserBtn2;
    private javax.swing.JTextArea addressField;
    private javax.swing.JTextArea allergiesField;
    private javax.swing.JComboBox<String> bloodComboBox;
    private javax.swing.JButton chooseFileBtn;
    private javax.swing.JButton chooseFileBtn1;
    private com.toedter.calendar.JDateChooser dateJoinField;
    private com.toedter.calendar.JDateChooser dateJoinField1;
    private com.toedter.calendar.JDateChooser dobField;
    private javax.swing.JButton editUserBtn;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JLabel fileNameLabel1;
    private javax.swing.JComboBox<String> genderField;
    private javax.swing.JTextField idCardField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> martialStatusField;
    private javax.swing.JPanel moPanel;
    private javax.swing.JLabel moPhotoLabel;
    private javax.swing.JTextField mobileField;
    private javax.swing.JTextField nameField;
    private javax.swing.JPanel patientPanel;
    private javax.swing.JButton photoAddBtn1;
    private javax.swing.JButton photoAddBtn2;
    private javax.swing.JPanel photoUploadedPanel;
    private javax.swing.JPanel photoUploadedPanel1;
    private javax.swing.JPanel receptionPanel;
    private javax.swing.JLabel receptionistPhotoLabel;
    private javax.swing.JComboBox<String> specialityComboBox;
    private javax.swing.JTextField staffIdField;
    private javax.swing.JTextField staffIdField1;
    private javax.swing.JTextField staffMailField;
    private javax.swing.JTextField staffMailField1;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables

}

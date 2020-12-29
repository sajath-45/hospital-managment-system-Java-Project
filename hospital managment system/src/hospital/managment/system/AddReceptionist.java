/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import com.toedter.calendar.JDateChooser;
import hospital.managment.system.models.PipeService;
import hospital.managment.system.models.Receptionist;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author sajath
 */
public class AddReceptionist extends javax.swing.JFrame {
    private ReceptionistController controller;
    private Receptionist receptionist;
    private JFileChooser openFileChooser;
    private File attachment;
    private Dashboard dashboard;
    private File photoAttachment;
    private boolean photoChoosen=false;
    
    /**
     * Creates new form AddReceptionist
     */
    public AddReceptionist(Receptionist user,DashboardController controller,int type) {
         initComponents();
        setFileChooser();
        setReceptionist(user);
        setController( new ReceptionistController(getReceptionist(),this,controller) );
        getAddUserBtn().addActionListener(getController());
        getController().initController();
        if(type==1){
             getAddUserBtn().setText("Add");
        }
        else if(type==2){
             getAddUserBtn().setText("Save");
            setEditData();
        }
    }

    private AddReceptionist() {
    }
    
    
    
    public void setController(ReceptionistController controller){
        this.controller=controller;
    }
    public void setReceptionist(Receptionist user){
        this.receptionist=user;    
    }
     public void setDashboard(Dashboard dash){
        this.dashboard=dash;
    }
     public void setAttachment(File file){
        this.attachment=file;
    }
     public void setPhotoAttachment(File file){
        this.photoAttachment=file;
    }
    private void setFileChooser(){
        openFileChooser =new JFileChooser();   
    }
     public void setAttachmentName(String name){
        this.attachmentName.setText(name);
    }
      public void setphotoChoosen(boolean value){
        this.photoChoosen=value;
    }
     public void setEditData(){
        getNameField().setText(getReceptionist().getName());
        getPhoneNumberField().setText(getReceptionist().getphoneNumber());
        getIdCardField().setText(getReceptionist().getIdCardNo());
        getGenderComboBox().setSelectedItem(getReceptionist().getGender());
        getAddressField().setText(getReceptionist().getAddress());
        getMartialStatusComboBox().setSelectedItem(getReceptionist().getMaritalStatus());
        getUserNameField().setText(getReceptionist().getUserName());
        getStaffMailField().setText(getReceptionist().getStrEmailAddress());
        getDobDateChooser().setDate(PipeService.getStringToDateFormat(getReceptionist().getDateOfBirth()));
        getStaffIdField().setText(getReceptionist().getStrStaffId());
        getDateJoinDateChooser().setDate(PipeService.getStringToDateFormat(getReceptionist().getStrDateOfJoining()));
        setAttachment(getReceptionist().getCvFile());
        setPhotoAttachment(getReceptionist().getPhoto());
        
        if(getAttachment()==null){
             setAttachmentName("no file choosen");
        }
        else{
             setAttachmentName(getAttachment().getName());
        }
        
        
        if(getPhotoAttachment()==null){
             setphotoChoosen(false);
        }
        else{
             setphotoChoosen(true);
        }
        this.getController().checkPhoto();
        
        
        
        
    }
     
    //getters
     public Dashboard getDashboard(){
        return dashboard;
    }
    public Receptionist getReceptionist(){
        return this.receptionist;
    }
    public ReceptionistController getController(){
         return controller;
     }
    public JTextField getNameField(){
        return this.nameField;
    }
    public JTextField getPhoneNumberField(){
        return this.mobileField;
    }
    public JTextField getIdCardField(){
        return this.idCardField;
    }
    public JComboBox<String> getGenderComboBox(){
        return this.genderComboBox;
    }
    public JTextArea getAddressField(){
        return this.addressField;
    }
    public JComboBox<String> getMartialStatusComboBox(){
        return this.martialStatusComboBox;
    }
    public JTextField getUserNameField(){
        return this.userNameField;
    }
    public JTextField getStaffMailField(){
        return this.staffMailField;
    }
    public JTextField getStaffIdField(){
        return this.staffIdField;
    }
    public JDateChooser getDateJoinDateChooser(){
        return this.dateJoinDateChooser;
    }
    public JDateChooser getDobDateChooser(){
        return this.dobDateChooser;
    }
    public JButton getChooseFileBtn(){
        return this.chooseFileBtn;
    }
    public JButton getPhotoAddBtn(){
        return this.photoAddBtn;
    }
    public JButton getAddUserBtn(){
        return this.addUserBtn;
    }
    public JLabel getAttachmentName(){
        return this.attachmentName;
    }
    public JLabel getphotoLabel(){
        return this.photoLabel;
    }
    public JPanel getPhotoUploadedPanel(){
        return this.photoUploadedPanel;
    }
    public File getAttachment(){
       return this.attachment;
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        nameField = new javax.swing.JTextField();
        mobileField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressField = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        martialStatusComboBox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        idCardField = new javax.swing.JTextField();
        dobDateChooser = new com.toedter.calendar.JDateChooser();
        receptionPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        staffIdField = new javax.swing.JTextField();
        staffMailField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        chooseFileBtn = new javax.swing.JButton();
        attachmentName = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        dateJoinDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        photoUploadedPanel = new javax.swing.JPanel();
        photoAddBtn = new javax.swing.JButton();
        photoLabel = new javax.swing.JLabel();
        addUserBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(233, 228, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(85, 65, 118));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Receptionist");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/icons8_delete1_32.png"))); // NOI18N
        jLabel13.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(385, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 40));

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

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        jLabel9.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(85, 65, 118));
        jLabel9.setText("Address");

        addressField.setColumns(20);
        addressField.setRows(5);
        jScrollPane1.setViewportView(addressField);

        jLabel10.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(85, 65, 118));
        jLabel10.setText("Martial Status");

        martialStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Married", "Single" }));

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
                    .addComponent(genderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mobileField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameField)
                    .addComponent(martialStatusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userNameField)
                    .addComponent(idCardField)
                    .addComponent(dobDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(genderComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobileField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dobDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idCardField, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(martialStatusComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 470, 630));

        receptionPanel.setBackground(new java.awt.Color(233, 228, 228));
        receptionPanel.setForeground(new java.awt.Color(85, 65, 118));

        jLabel12.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(85, 65, 118));
        jLabel12.setText("Staff Id");

        jLabel15.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(85, 65, 118));
        jLabel15.setText("Staff Photograph");

        jLabel17.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(85, 65, 118));
        jLabel17.setText("Attachment");

        chooseFileBtn.setText("Choose");

        jLabel19.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(85, 65, 118));
        jLabel19.setText("Date Of Joining");

        jLabel18.setFont(new java.awt.Font("Jamrul", 1, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(85, 65, 118));
        jLabel18.setText("Staff Email");

        photoUploadedPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        photoAddBtn.setText("add");
        photoUploadedPanel.add(photoAddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        photoUploadedPanel.add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 150));

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
                .addGroup(receptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(receptionPanelLayout.createSequentialGroup()
                        .addComponent(chooseFileBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(attachmentName, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(staffMailField)
                    .addComponent(staffIdField)
                    .addComponent(dateJoinDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(receptionPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(photoUploadedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                .addComponent(photoUploadedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
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
                            .addComponent(dateJoinDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(receptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chooseFileBtn)))
                    .addComponent(attachmentName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jPanel1.add(receptionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 450, 500));

        addUserBtn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        addUserBtn.setForeground(new java.awt.Color(85, 65, 118));
        addUserBtn.setText("Save");
        jPanel1.add(addUserBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 570, -1, 52));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AddReceptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddReceptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddReceptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddReceptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddReceptionist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserBtn;
    private javax.swing.JTextArea addressField;
    private javax.swing.JLabel attachmentName;
    private javax.swing.JButton chooseFileBtn;
    private com.toedter.calendar.JDateChooser dateJoinDateChooser;
    private com.toedter.calendar.JDateChooser dobDateChooser;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JTextField idCardField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> martialStatusComboBox;
    private javax.swing.JTextField mobileField;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton photoAddBtn;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JPanel photoUploadedPanel;
    private javax.swing.JPanel receptionPanel;
    private javax.swing.JTextField staffIdField;
    private javax.swing.JTextField staffMailField;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables
}

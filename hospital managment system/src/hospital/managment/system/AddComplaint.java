/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import hospital.managment.system.controllers.ComplaintController;
import hospital.managment.system.controllers.DashboardController;
import com.toedter.calendar.JDateChooser;
import hospital.managment.system.models.ComplainRefference;
import hospital.managment.system.models.Complaint;
import hospital.managment.system.models.CurrentUser;
import hospital.managment.system.models.FileService;
import hospital.managment.system.models.PipeService;
import java.awt.Color;
import java.io.File;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Sangeerthana
 */
public class AddComplaint extends javax.swing.JFrame {
    private ComplaintController controller;
    private JFileChooser openFileChooser;
    private Complaint complaint;
    private File attachment;
    private String userRole;
  

    /**
     * Creates new form addComplaint
     */
    private AddComplaint() {
    }
    public AddComplaint(String role,DashboardController controller,Complaint complain,int type) {
        initComponents();
       
        this.setVisible(true);
        setUserRole(role);
        setComplaint(complain);
        setController(new ComplaintController( getComplaint(),this,controller));
        getController().initController();
        getAddComplaintBtn().addActionListener(getController());
        
        if(type==1){
        getAddComplaintBtn().setText("Add");
        getComplainDateChooser().setDate(new Date());
        }
        else if(type==2){
            getAddComplaintBtn().setText("Save");
            setEditData();
        }
        
        
        
        
        //setComplainTypeComboBox();
       // setFileChooser();
        //setData();
        
        
    }
    
    
    public void setComplaint(Complaint com){
        this.complaint=com;
        
    }
    public void setController(ComplaintController controller){
        this.controller=controller;
    }
    public void setAttachment(File file){
         this.attachment=file;
    }
     private void setUserRole(String role){
        this.userRole=role;
    }
    public void setFileChooser(){
        this.openFileChooser =new JFileChooser();
        
    }
    public void setEditData(){
        setComplainByTextField(getComplaint().getStrComplaintBy());
        setComplainTypeComboBox(getComplaint().getStrType());
        setPhoneNumberTextField(getComplaint().getPhoneNumber());
        setDescriptionTextField(getComplaint().getStrDescription());
        setComplainDateChooser(getComplaint().getStrDate());
        setComplainActionTaken(getComplaint().getStrActionTaken());
        setComplainNoteField(getComplaint().getStrNote());
        setAttachment(getComplaint().getAttachment());
        getFileLabel().setText(getComplaint().getAttachment().getName());
        
    }
    public void setComplainByTextField(String name){
        getComplainByTextField().setText(name);
    }
    public void setComplainTypeComboBox(String type){
         this.getComplainTypeComboBox().setSelectedItem(type);
    }
    public void setPhoneNumberTextField(String number){
         this.getPhoneNumberTextField().setText(number);
    }
    public void setDescriptionTextField(String description){
         this.getDescriptionTextField().setText(description);
    }
    public void setComplainDateChooser(String date){
         this.getComplainDateChooser().setDate(PipeService.getStringToDateFormat(date));
    }
    public void setComplainActionTaken(String action){
         this.getComplainActionTaken().setText(action);
    }
    public void setComplainNoteField(String note){
         this.getComplainNoteField().setText(note);
    }
     
     //gettrrs
    
    public  ComplaintController getController(){
        return controller;
    }
    public Complaint getComplaint(){
         return this.complaint;
    }
    public File getAttachment(){
        return this.attachment;
    }
   
    public String getUserRole(){
        return this.userRole;
    }
    public JTextField getComplainByTextField(){
        return this.complainByText;
    }
    public JComboBox<String> getComplainTypeComboBox(){
        return this.complainTypeComboBox;
    }
    public JTextField getPhoneNumberTextField(){
        return this.phoneNumber;
    }
    public JTextField getDescriptionTextField(){
        return this.descriptionField;
    }
    public JDateChooser getComplainDateChooser(){
        return this.complainDate;
    }
    public JTextField getComplainActionTaken(){
        return this.actionTakenField;
    }
    public JTextField getComplainNoteField(){
        return this.noteField;
    }
    public JButton getAddComplaintBtn(){
        return this.addComplaintBtn;
    }
    public JButton getOpenFileChooserBtn(){
        return this.openFileChooserBtn;
    }
    public JLabel getFileLabel(){
        return this.fileNameLabel;
    }
    public JFileChooser getFileChooser(){
        return this.openFileChooser;
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
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        complainTypeComboBox = new javax.swing.JComboBox<>();
        complainByText = new javax.swing.JTextField();
        phoneNumber = new javax.swing.JTextField();
        descriptionField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        actionTakenField = new javax.swing.JTextField();
        noteField = new javax.swing.JTextField();
        addComplaintBtn = new javax.swing.JButton();
        complainDate = new com.toedter.calendar.JDateChooser();
        openFileChooserBtn = new javax.swing.JButton();
        fileNameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(910, 570));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(85, 65, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Complaint");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 0, 168, -1));

        jPanel7.setBackground(new java.awt.Color(85, 65, 118));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/icons8_delete1_32.png"))); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(40, 40));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, -1));
        jPanel7.getAccessibleContext().setAccessibleName("");

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(85, 65, 118));
        jLabel2.setText("Complaint type");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 150, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(85, 65, 118));
        jLabel3.setText("Complaint By");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 140, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(85, 65, 118));
        jLabel4.setText("Phone No");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 100, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(85, 65, 118));
        jLabel5.setText("Description");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 120, 30));

        jPanel1.add(complainTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 210, 30));
        jPanel1.add(complainByText, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 210, 30));

        phoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberActionPerformed(evt);
            }
        });
        jPanel1.add(phoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 210, 30));

        descriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionFieldActionPerformed(evt);
            }
        });
        jPanel1.add(descriptionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 210, 110));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(85, 65, 118));
        jLabel6.setText("Date");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 80, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(85, 65, 118));
        jLabel7.setText("Action taken");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 120, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(85, 65, 118));
        jLabel8.setText("Note");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 100, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(85, 65, 118));
        jLabel9.setText("Attachment");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 120, 30));
        jPanel1.add(actionTakenField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 200, 80));
        jPanel1.add(noteField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 200, 80));

        addComplaintBtn.setBackground(new java.awt.Color(255, 255, 255));
        addComplaintBtn.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        addComplaintBtn.setForeground(new java.awt.Color(85, 65, 118));
        addComplaintBtn.setText("Add");
        addComplaintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addComplaintBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addComplaintBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, -1, 40));
        jPanel1.add(complainDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 190, 30));

        openFileChooserBtn.setText("open File");
        openFileChooserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileChooserBtnActionPerformed(evt);
            }
        });
        jPanel1.add(openFileChooserBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 400, -1, -1));
        jPanel1.add(fileNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, 200, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
   /* private void setData(){
        if(this.getUserRole().equalsIgnoreCase("Patient")){
            getComplainByTextField().setText(CurrentUser.getUser().getName());
             getComplainActionTaken().setEditable(false);

        }
    }
      private void setComplainTypeComboBox(){
        ComplainRefference refference = new ComplainRefference();
        DefaultComboBoxModel newModel = new DefaultComboBoxModel(refference.getComplainTypes().toArray());
         getComplainTypeComboBox().setModel( newModel );
        
    }*/
    
    private void descriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionFieldActionPerformed

    private void phoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberActionPerformed

    private void addComplaintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addComplaintBtnActionPerformed
        // TODO add your handling code here:
       /* String complainType=getComplainTypeComboBox().getSelectedItem().toString();
        String complainBy=getComplainByTextField().getText();
        String mobile=getPhoneNumberTextField().getText();
        String description=getDescriptionTextField().getText();
         String date=PipeService.getDateSimpleFormat(getComplainDateChooser().getDate());  
         String actionTaken=getComplainActionTaken().getText();
         String note=getComplainNoteField().getText();
         File file=getAttachment();
         
         //validate needed
         Complaint complain =new Complaint(complainType,date,complainBy,mobile,description,actionTaken,note,file);
         FileService.addLine(FileService.getComplaintsFilePath(),complain.toString());
          this.dashboard.setTables();
           this.dispose();*/
          
    }//GEN-LAST:event_addComplaintBtnActionPerformed

    private void openFileChooserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileChooserBtnActionPerformed
        // TODO add your handling code here:
          /*  int returnValue =getFileChooser().showOpenDialog(this);
            if(returnValue==JFileChooser.APPROVE_OPTION){
                 setAttachment(getFileChooser().getSelectedFile());
                getFileLabel().setText(getAttachment().getName());
            }
            else{
                setAttachment(null);
                 
                 getFileLabel().setText("no file choosen");
            }*/
    }//GEN-LAST:event_openFileChooserBtnActionPerformed

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
    }//GEN-LAST:event_jPanel7MouseExited

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
         this.dispose();
    }//GEN-LAST:event_jLabel10MousePressed
    
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
            java.util.logging.Logger.getLogger(AddComplaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddComplaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddComplaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddComplaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddComplaint().setVisible(true);
            }
        });
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actionTakenField;
    private javax.swing.JButton addComplaintBtn;
    private javax.swing.JTextField complainByText;
    private com.toedter.calendar.JDateChooser complainDate;
    private javax.swing.JComboBox<String> complainTypeComboBox;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField noteField;
    private javax.swing.JButton openFileChooserBtn;
    private javax.swing.JTextField phoneNumber;
    // End of variables declaration//GEN-END:variables
}

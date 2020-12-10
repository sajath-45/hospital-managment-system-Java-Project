/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;

/**
 *
 * @author Sangeerthana
 */
public class addComplaint extends javax.swing.JFrame {
    private JFileChooser openFileChooser;
    private File attachment;
    /**
     * Creates new form addComplaint
     */
    public addComplaint() {
        initComponents();
         setComplainTypeComboBox();
         setFileChooser();
         
         Date date = new Date();
     complainDate.setDate(date);
        
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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
        jButton2 = new javax.swing.JButton();
        complainDate = new com.toedter.calendar.JDateChooser();
        openFIleBtn = new javax.swing.JButton();
        fileNameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(85, 65, 118));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/icons8-close-window-32.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Complaint");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(85, 65, 118));
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 500, -1, 40));
        jPanel1.add(complainDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 190, 30));

        openFIleBtn.setText("open File");
        openFIleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFIleBtnActionPerformed(evt);
            }
        });
        jPanel1.add(openFIleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 400, -1, -1));
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
    }// </editor-fold>//GEN-END:initComponents

    private void setFileChooser(){
        openFileChooser =new JFileChooser();
        
    }
    
    private void descriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionFieldActionPerformed

    private void phoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            String complainType=complainTypeComboBox.getSelectedItem().toString();
            String complainBy=complainByText.getText();
          String mobile=phoneNumber.getText();
          String description=descriptionField.getText();
           SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
         String date=formatter.format(complainDate.getDate());  
         String actionTaken=actionTakenField.getText();
         String note=noteField.getText();
         File file=this.attachment;
         
         //validate needed
         Complaint complain =new Complaint(complainType,date,complainBy,mobile,description,actionTaken,note,file);
         try {
                FileService.writeComplaint(complain);
            } catch (IOException ex) {
                Logger.getLogger(addAppointment.class.getName()).log(Level.SEVERE, null, ex);
            }
          
    }//GEN-LAST:event_jButton2ActionPerformed

    private void openFIleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFIleBtnActionPerformed
        // TODO add your handling code here:
            int returnValue =openFileChooser.showOpenDialog(this);
            if(returnValue==JFileChooser.APPROVE_OPTION){
                attachment = openFileChooser.getSelectedFile();
                fileNameLabel.setText(attachment.getName());
            }
            else{
                 fileNameLabel.setText("no file choosen");
            }
    }//GEN-LAST:event_openFIleBtnActionPerformed

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
            java.util.logging.Logger.getLogger(addComplaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addComplaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addComplaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addComplaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addComplaint().setVisible(true);
            }
        });
    }
    private void setComplainTypeComboBox(){
        ComplainRefference refference = new ComplainRefference();
       System.out.println("works");
        
        DefaultComboBoxModel newModel = new DefaultComboBoxModel(refference.getComplainTypes().toArray());
         complainTypeComboBox.setModel( newModel );
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actionTakenField;
    private javax.swing.JTextField complainByText;
    private com.toedter.calendar.JDateChooser complainDate;
    private javax.swing.JComboBox<String> complainTypeComboBox;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField noteField;
    private javax.swing.JButton openFIleBtn;
    private javax.swing.JTextField phoneNumber;
    // End of variables declaration//GEN-END:variables
}

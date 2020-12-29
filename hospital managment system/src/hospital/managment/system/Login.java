/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import hospital.managment.system.models.CurrentUser;
import hospital.managment.system.models.FileService;
import hospital.managment.system.models.UserLogin;
import hospital.managment.system.models.PipeService;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane; 
import java.util.Date;


/**
 *
 * @author sajath
 */
public class Login extends javax.swing.JFrame {
   private String date;
   private String time;
   private String role;
   private String userName;
   private  final int userNameIndex=0;
   private  final int passwordIndex=8;
   

    /**
     * Creates new form doctorSignIn
     * @param type
     */
    public Login(int type) {
        initComponents();
        createUi(type);
    }

    private Login() {
        
    }
    public void setUserName(String name){
        this.userName=name;
    }
     public void setDate(String date){
        this.date=date;
    }
      public void setTime(String time){
          this.time=time;
    }
       public void setRole(String role){
           this.role=role;
    }
       public String getUserName(){
           return userName;
       }
        public String getDate(){
            return date;
           
       }
         public String getTime(){
           return time;
       }
          public String getRole(){
               return role;
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
        jLabel2 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        imgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new Color(60, 60, 60, 80));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setVerifyInputWhenFocusTarget(false);

        jLabel2.setBackground(new Color(60, 60, 60, 80));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Medical Officer Login");
        jLabel2.setOpaque(true);

        userNameField.setColumns(1);
        userNameField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        userNameField.setMargin(new java.awt.Insets(0, 10, 0, 0));
        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });

        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        passwordField.setMargin(new java.awt.Insets(0, 10, 0, 0));
        passwordField.setMinimumSize(new java.awt.Dimension(4, 19));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new/profile-user (1).png"))); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new/lock (1).png"))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        loginBtn.setBackground(new java.awt.Color(0, 153, 51));
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Login");
        loginBtn.setBorder(null);
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginBtnMousePressed(evt);
            }
        });
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(170, 70, 510, 310);

        imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new/doctor.jpg"))); // NOI18N
        imgLabel.setPreferredSize(new java.awt.Dimension(1000, 500));
        jPanel1.add(imgLabel);
        imgLabel.setBounds(0, 0, 1000, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
    
         
        
        
    }//GEN-LAST:event_loginBtnActionPerformed

    private void loginBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMousePressed
        // TODO add your handling code here:
                if(this.validateFields()){
                    if(this.validateLogin()){
                         

                         
                         UserLogin newLogin=new UserLogin(userNameField.getText(),this.getRole(),PipeService.getDateSimpleFormat(new Date()),PipeService.getTimeSipleFormat(new Date()));
                        
                          try {
                                  FileService.writeLoginRecord(FileService.getUserLoginFilePath(),newLogin.toString());                               
                                  Dashboard dashboard=new Dashboard(newLogin.getRole()); 
                                  this.dispose();
                              } catch (IOException ex) {
                                 JOptionPane.showMessageDialog(null, "user login file not available");
                                 this.dispose();
                              }
                          
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Inavlid creditials");
                    }
                    
                    
                }
        
        
    }//GEN-LAST:event_loginBtnMousePressed
    private void  createUi(int type){
        jPanel2.setBackground(new Color(60, 60, 60, 80));
        if(type==1){
          
            String imageName = "src/resources/new/doctor.jpg";
            ImageIcon icon = new ImageIcon(imageName);
            icon.getImage().flush();
            imgLabel.setIcon(icon);
            jLabel2.setText("Medical Officer Login");
            this.setRole("MedicalOfficer");
           
            
        
        }
        else if(type==2){
             jLabel2.setText("Receptionist Login");
             String imageName = "src/resources/new/r1.png";
            ImageIcon icon = new ImageIcon(imageName);
            icon.getImage().flush();
            imgLabel.setIcon(icon); 
            this.setRole("Receptionist");
        }
        else if(type==3){
             jLabel2.setText("Admin Login");
             String imageName = "src/resources/new/admin.jpg";
            ImageIcon icon = new ImageIcon(imageName);
            icon.getImage().flush();
            imgLabel.setIcon(icon);
            this.setRole("Admin");
            
        }
        else if(type==4){
             jLabel2.setText("Patient Login");
               String imageName = "src/resources/new/pat.png";
            ImageIcon icon = new ImageIcon(imageName);
            icon.getImage().flush();
            imgLabel.setIcon(icon);
            this.setRole("Patient");
            
        }
        
    }
    
    
    public boolean validateLogin(){
        boolean isUserValid=false;
        File loginFile=null;
        if(getRole().equalsIgnoreCase("Admin")){
            loginFile=FileService.getAdminFile();
        }
        else if(getRole().equalsIgnoreCase("MedicalOfficer")){
             loginFile=FileService.getMoFile();
            
        }
        else if(getRole().equalsIgnoreCase("Patient")){
             loginFile=FileService.getPatientsFile();
            
        }
         else if(getRole().equalsIgnoreCase("Receptionist")){
             loginFile=FileService.getReceptionistFile();
            
        }
      

         try {
             BufferedReader reader = new BufferedReader(new FileReader(loginFile));
            String line;
            while ((line = reader.readLine()) != null) {
                 
                String[] data = line.split(","); //username, password, email, etc
                System.out.println("username"+data[0]);
                 System.out.println("pass"+data[8]);
               if(data[userNameIndex].equals(this.userNameField.getText()) && this.passwordField.getText().equals(data[passwordIndex])){
                    isUserValid=true;
               }
               if(isUserValid){
                   CurrentUser user=new CurrentUser(getRole(),line);
                   break;
               }
            }
            reader.close();
            
        } 
         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return isUserValid;
        
        
    }
    public  boolean validateFields(){
        if(passwordField.getText().length()!=0 && userNameField.getText().length()!=0){
             return true;
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Please enter all fileds");
            return false;
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables

    


}

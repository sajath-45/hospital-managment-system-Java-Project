/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import hospital.managment.system.models.FileService;
import hospital.managment.system.models.MedicalOfficer;
import hospital.managment.system.models.Patient;
import hospital.managment.system.models.Appointment;
import hospital.managment.system.models.PipeService;
import com.toedter.calendar.JDateChooser;
import hospital.managment.system.models.SpecialityRefference;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

/**
 *
 * @author Sangeerthana
 */
public class AppointmentView extends javax.swing.JFrame {
    private Dashboard dashboard;
    private AppointmentController controller;
    private Appointment appointment;
    private String status="Pending";
    private String appointmentNumber=String.valueOf((FileService.getRecordCount(FileService.getAppointmentsFile())+1));
    private AppointmentView() {
    }
    public AppointmentView(Dashboard dash,Appointment appointment,int type) {
        
        initComponents();
        setDashboard(dash);
        //createPatientComboBox();
      // createSpecialityComboBox();
        setAppointment(appointment);
        setController(new AppointmentController( getAppointment(),this));
        getController().initController();
        getAddAppoimentBtn().addActionListener(getController());
        
        if(type==1){
        getAddAppoimentBtn().setText("Add");
        }
        else if(type==2){
            getAddAppoimentBtn().setText("Save");
            setEditData();
        }
        
    }

    
    
    public void setEditData(){
        this.setAppoinmentNumber(getAppointment().getAppointmentNumber());
        this.setAppointmentDate(getAppointment().getAppointmentDate());
        this.setAppointmentTime(getAppointment().getAppointmentTime());
        this.setStatus(getAppointment().getStatus());
        this.setSymtomps(getAppointment().getSymtomps());
        this.setSpeciality(getAppointment().getSpeciality());
        this.setMedicalOfficer(getAppointment().getMedicalOfficer());
        this.setPatient(getAppointment().getPatient());
        
        
    }
    
    public void setDashboard(Dashboard dash){
        this.dashboard=dash;
    }
    public void setAppointment(Appointment appointment){
        this.appointment=appointment;
    }
    public void setController(AppointmentController controller){
        this.controller=controller;
    }
    public void setAppoinmentNumber(String number){
        this.appointmentNumber=number;
    }
    public void setAppointmentDate(String date){
        jDateChooser.setDate(PipeService.getStringToDateFormat(date));
    }
    public void setAppointmentTime(String time){
        String[] timeSplit=time.split(" ");
        timeHour.setValue(Integer.parseInt(timeSplit[0]));
        timeMinute.setValue(Integer.parseInt(timeSplit[1]));
        timeComboBox.setSelectedItem(timeSplit[2]);
        
    }
    public void setMedicalOfficer(MedicalOfficer mo){
        System.out.println("worls");
        for (int i=0; i<doctorComboBox.getModel().getSize(); i++)
        {
            if (doctorComboBox.getItemAt(i).toString().equals(mo.toString()))
            {
                doctorComboBox.setSelectedIndex(i);
                break;
            }
        }
        
        //this.doctorComboBox.setSelectedItem(mo);
    }
    public void setPatient(Patient patient){
        System.out.println("worls");
        for (int i=0; i<patientComboBox.getModel().getSize(); i++)
        {
            if (patientComboBox.getItemAt(i).toString().equals(patient.toString()))
            {
                patientComboBox.setSelectedIndex(i);
                break;
            }
        }
        
       // patientComboBox.setSelectedItem(patient);
    }
    public void setStatus(String status){
       
        this.status=status;
    }
    public void setSymtomps(String symtomp){
        sysmtompsField.setText(symtomp);
    }
    public void setSpeciality(String speciality){
        specialityComboBox.setSelectedItem(speciality);
    }
    

    public Dashboard getDashboard(){
        return dashboard;
    }
    
    public Appointment getAppointment(){
        return this.appointment;
    }
    public  AppointmentController getController(){
        return controller;
    }
     
    public String getAppointmentNumber(){
         return appointmentNumber;
     }
     public JComboBox<String>  getSpecialityComboBox(){
        return specialityComboBox;
    }
    public JComboBox<Patient> getPatientComboBox(){
        return patientComboBox;
    }
    public JComboBox<MedicalOfficer> getMedicalOfficerComboBox(){
        return doctorComboBox;
    }
    public JDateChooser getDateChooser(){
        return jDateChooser;
    }
    public JSpinner getTimeHourChooser(){
        return timeHour;
    }
    public JSpinner getTimeMinuteChooser(){
        return timeMinute;
    }
    public JComboBox<String> getTimeSegmentChooser(){
        return timeComboBox;
    }
    public JTextArea getSysmtompsTextField(){
        return sysmtompsField;
    }
    
    public String getAppoinmentStatus(){
        return status;
    }
    public JLabel getCloseLabel(){
        return this.closeBtn;
    }
    public JButton getAddAppoimentBtn(){
        return this.addAppoinmentBtn;
    }
    
    
    
    
    
    
    
    
    
   /* public Patient  getPatient(){
        return (Patient) getPatientComboBox().getSelectedItem();
    }
    public String  getAppointmentDate(){  
       Date date = getDateChooser().getDate(); 
       return PipeService.getDateSimpleFormat(date);
    }
    public String getAppoinmentTime(){
        int hour = (Integer) getTimeHourChooser().getValue();
        int min = (Integer) getTimeMinuteChooser().getValue();
        String seg = getTimeSegmentChooser().getSelectedItem().toString();
        String time=Integer.toString(hour)+ " "+Integer.toString(min)+" "+ seg;
        return time;
    }
    
    
    public String getAppointmentSpecialityField(){
       return  getSpecialityComboBox().getSelectedItem().toString();
    }
    public MedicalOfficer getMedicalOfficerField(){
       return  (MedicalOfficer) getMedicalOfficerComboBox().getSelectedItem();
    }
    public String getSymtomps(){
        return getSysmtompsTextField().getText();
    }
    */
   
    
   

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
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        closeBtn = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        doctorComboBox = new javax.swing.JComboBox<>();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        addAppoinmentBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        specialityComboBox = new javax.swing.JComboBox<>();
        patientComboBox = new javax.swing.JComboBox<>();
        timeHour = new javax.swing.JSpinner();
        timeMinute = new javax.swing.JSpinner();
        timeComboBox = new javax.swing.JComboBox<>();
        symtompslabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sysmtompsField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setForeground(new java.awt.Color(85, 65, 118));

        jPanel2.setBackground(new java.awt.Color(85, 65, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(204, 204, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Add Appointment");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 0, 206, 40));

        jPanel4.setBackground(new java.awt.Color(85, 65, 118));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/icons8_minus1_32.png"))); // NOI18N
        jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 41, 41));

        jPanel3.setBackground(new java.awt.Color(85, 65, 118));
        jPanel3.setPreferredSize(new java.awt.Dimension(41, 41));

        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/icons8_delete1_32.png"))); // NOI18N
        closeBtn.setPreferredSize(new java.awt.Dimension(41, 41));
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeBtnMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(85, 65, 118));
        jLabel4.setText("Patient ");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(85, 65, 118));
        jLabel6.setText("Date");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(85, 65, 118));
        jLabel10.setText("Doctor");

        doctorComboBox.setMaximumRowCount(50);

        addAppoinmentBtn.setText("Add");
        addAppoinmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAppoinmentBtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(85, 65, 118));
        jLabel8.setText("Time");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(85, 65, 118));
        jLabel1.setText("Speciality");

        specialityComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                specialityComboBoxItemStateChanged(evt);
            }
        });

        timeHour.setModel(new javax.swing.SpinnerNumberModel(1, 0, 23, 1));

        timeMinute.setModel(new javax.swing.SpinnerNumberModel(0, 0, 45, 15));

        timeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A.M", "P.M" }));

        symtompslabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        symtompslabel.setForeground(new java.awt.Color(85, 65, 118));
        symtompslabel.setText("Symptoms");

        sysmtompsField.setColumns(20);
        sysmtompsField.setRows(5);
        jScrollPane1.setViewportView(sysmtompsField);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(106, 106, 106))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(patientComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(timeHour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(timeMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(symtompslabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(specialityComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(doctorComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(addAppoinmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(specialityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(patientComboBox)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(doctorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(addAppoinmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(222, 222, 222))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(symtompslabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    private void addAppoinmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAppoinmentBtnActionPerformed

       /* String speciality=getAppointmentSpecialityField().getSelectedItem().toString();
        MedicalOfficer doctor = (MedicalOfficer) getMedicalOfficerField().getSelectedItem();
        Patient patient  =(Patient) getPatientField().getSelectedItem();
        Date date = getAppointmentDateField().getDate();
        String appointmentDate=PipeService.getDateSimpleFormat(date);  
        int hour = (Integer) getAppointmentTimeHour().getValue();
        int min = (Integer) getAppointmentTimeMin().getValue();
        String seg = getAppointmentTimeSegment().getSelectedItem().toString();
        String time=Integer.toString(hour)+ " "+Integer.toString(min)+" "+ seg;
        String symtomps=getSymtompField().getText();
        System.out.println(speciality+""+doctor+" "+patient+" "+appointmentDate+" "+time+" "+ symtomps);
        
        Appointment appointment =new Appointment(getAppointmentNumber(),patient,doctor,appointmentDate,time,getAppoinmentStatus(),symtomps,speciality);
        getController().setModel(appointment);*/
        
        //FileService.addLine(FileService.getAppointmentsFilePath(),appointment.toString());
        //this.dashboard.setTables();
        
        //this.dispose();
       
       
        
        
      
        
        
    }//GEN-LAST:event_addAppoinmentBtnActionPerformed

    private void specialityComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_specialityComboBoxItemStateChanged
           // this.createDoctorComboBox(getSpecialityComboBox().getSelectedItem().toString());

    }//GEN-LAST:event_specialityComboBoxItemStateChanged

    private void closeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMousePressed
           this.dispose();
    }//GEN-LAST:event_closeBtnMousePressed


    /**
     *
     * @return
     */
   
  
    private void createSpecialityComboBox(){
        SpecialityRefference refference=new SpecialityRefference();
       
        
        DefaultComboBoxModel newModel = new DefaultComboBoxModel(refference.getSpecialityTypes().toArray());
         getSpecialityComboBox().setModel( newModel );
         this.createDoctorComboBox(getSpecialityComboBox().getSelectedItem().toString());
    }
    private void createPatientComboBox(){
        
        Object[] items= FileService.getAllPatients().toArray();
  
         DefaultComboBoxModel newModel = new DefaultComboBoxModel(items);
         getPatientComboBox().setModel( newModel );     
        
        
    }
    private void  createDoctorComboBox(String speciality){
        if(!"".equals(speciality)){
          
        Object[] items= FileService.getMoBySpeciality(speciality).toArray();     
        
             DefaultComboBoxModel model = new DefaultComboBoxModel(items);
               getMedicalOfficerComboBox().setModel( model );
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
            java.util.logging.Logger.getLogger(AppointmentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AppointmentView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAppoinmentBtn;
    private javax.swing.JLabel closeBtn;
    private javax.swing.JComboBox<MedicalOfficer> doctorComboBox;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Patient> patientComboBox;
    private javax.swing.JComboBox<String> specialityComboBox;
    private javax.swing.JLabel symtompslabel;
    private javax.swing.JTextArea sysmtompsField;
    private javax.swing.JComboBox<String> timeComboBox;
    private javax.swing.JSpinner timeHour;
    private javax.swing.JSpinner timeMinute;
    // End of variables declaration//GEN-END:variables
}

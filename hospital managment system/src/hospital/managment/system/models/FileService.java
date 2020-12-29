/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system.models;
import hospital.managment.system.models.MedicalOfficer;
import hospital.managment.system.models.Patient;
import hospital.managment.system.models.Appointment;
import hospital.managment.system.models.PipeService;
import hospital.managment.system.models.Receptionist;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author sajath
 */
public class FileService {
      private static ArrayList<Patient> patientList=new ArrayList<Patient>();
      private static ArrayList<MedicalOfficer> officerList= new ArrayList<MedicalOfficer>();
       private static ArrayList<Receptionist> receptionistList=new ArrayList<Receptionist>();
        
       
    private static final String ADMIN_FILE_PATH = "files/admins.txt";
    private static final File ADMIN_FILE = new File(ADMIN_FILE_PATH);
       
    private static final String PATIENT_FILE_PATH = "files/patients.txt";
    private static final File PATIENTS_FILE = new File(PATIENT_FILE_PATH);
         
    private static final String MO_FILE_PATH = "files/medicalofficers.txt";
    private static final File MO_FILE = new File(MO_FILE_PATH);
         
    private static final String RECEPTIONIST_FILE_PATH = "files/receptionists.txt";
    private static  final File RECEPTIONIST_FILE = new File(RECEPTIONIST_FILE_PATH);
         
    private  static final String APPOINTMENTS_FILE_PATH="files/appointments.txt";
    private static final File APPOINTMENTS_FILE = new File(APPOINTMENTS_FILE_PATH);
         
    private static final String USER_FILE_PATH = "files/users.txt";
    private static final File USER_FILE = new File(USER_FILE_PATH);
        
    private static final String VISITOR_FILE_PATH = "files/visitors.txt";
    private static final File VISITOR_FILE = new File(VISITOR_FILE_PATH);
        
    private static final String COMPLAINT_FILE_PATH = "files/complaints.txt";
    private static final File COMPLAINT_FILE = new File(COMPLAINT_FILE_PATH);

    private static final String MAIL_FILE_PATH = "files/dispatchedMail.txt";
    private static final File MAIL_FILE = new File(MAIL_FILE_PATH);

    private static final String IMAGEPATH="src/resources/new/";

    private static final String LOGIN_FILE_PATH = "files/userLogin.txt";
    private static final File LOGIN_FILE = new File(LOGIN_FILE_PATH);

    private static final String SPECIALITY_REFFERENCE_FILE_PATH = "files/specialityRefference.txt";
    private static final File SPECIALITY_REFFERENCE_FILE = new File(SPECIALITY_REFFERENCE_FILE_PATH);
    private static final String COMPLAIN_REFFERENCE_FILE_PATH = "files/complainRefference.txt";
    private static final File COMPLAIN_REFFERENCE_FILE = new File(COMPLAIN_REFFERENCE_FILE_PATH);
    
    private static final String USERLOGIN_REPORT_FILE_PATH="files/reports/userlogin report.pdf";
    private static final File USERLOGIN_REPORT_FILE= new File(USERLOGIN_REPORT_FILE_PATH); 
    
    private static final String APPOINMENT_REPORT_FILE_PATH="files/reports/appoinment report.pdf";
    private static final File APPOINMENT_REPORT_FILE= new File(APPOINMENT_REPORT_FILE_PATH); 
    
    private static final String PATIENTCREDINTIAL_REPORT_FILE_PATH="files/reports/patient credintial report.pdf";
    private static final File PATIENTCREDINTIAL_REPORT_FILE= new File(PATIENTCREDINTIAL_REPORT_FILE_PATH); 
    
    
    
      public FileService(){
          this.getAllPatients();
          
      }
      
      public void setPatientList(ArrayList<Patient> list){
          this.patientList=list;
          
      }
      public void setOfficerList(ArrayList<MedicalOfficer> list){
          this.officerList=list;
          
      }
      public void setReceptionistList(ArrayList<Receptionist> list){
          this.receptionistList=list;
          
      }
      
      public ArrayList<Patient> getPatientList(){
          return this.patientList;
      }
      
     //files
      public static File getUserFile(){
          return USER_FILE;
      }
      public static File getAdminFile(){
          return ADMIN_FILE;
      }
      
       public static File getMoFile(){
          return MO_FILE;
      } 
         public static File getVisitorsFile(){
          return VISITOR_FILE;
      } 
          public static File getComplaintsFile(){
          return COMPLAINT_FILE;
      } 
            public static File getReceptionistFile(){
          return RECEPTIONIST_FILE;
      }   
           public static File getAppointmentsFile(){
          return APPOINTMENTS_FILE;
      } 
           public static File getMailsFile(){
          return MAIL_FILE;
      }   
       public static File getUserLoginFile(){
           return LOGIN_FILE;
       }
        public static File getPatientsFile(){
          return PATIENTS_FILE;
      }
         public static File getSpecialityRefferenceFile(){
          return SPECIALITY_REFFERENCE_FILE;
      }
    public static File getComplaintRefferenceFile(){
          return COMPLAIN_REFFERENCE_FILE;
      }
    public static File getAppoinmentReportFile(){
            return APPOINMENT_REPORT_FILE;
        }
    public static File getPatientCredintailReportFile(){
            return PATIENTCREDINTIAL_REPORT_FILE;
        }
    public static File getUserLoginReportFile(){
            return USERLOGIN_REPORT_FILE;
            
        }
       
       
       //file paths
       public static String getUserFilePath(){
          return USER_FILE_PATH;
      }
       public static String getAdminFilePath(){
          return ADMIN_FILE_PATH;
      }
       public static String getMoFilePath(){
          return MO_FILE_PATH;
      }
       
      public static String getPatientsFilePath(){
          return PATIENT_FILE_PATH;
      }
     
      public static String getReceptionistFilePath(){
          return RECEPTIONIST_FILE_PATH;
      }   
        public static String getAppointmentsFilePath(){
          return APPOINTMENTS_FILE_PATH;
      }
        public static String getVisitorsFilePath(){
          return VISITOR_FILE_PATH;
      }
    public static String getComplaintsFilePath(){
          return COMPLAINT_FILE_PATH;
      }
    public static String getImagePath(){
            return IMAGEPATH;
        }
    public static String getMailsFilePath(){
            return MAIL_FILE_PATH;
        }
    public static String getUserLoginFilePath(){
            return LOGIN_FILE_PATH;
        }
    public static String getSpecialityRefferenceFilePath(){
            return SPECIALITY_REFFERENCE_FILE_PATH;
        }
    public static String getComplainRefferenceFilePath(){
            return COMPLAIN_REFFERENCE_FILE_PATH;
        }
    public static String getAppoinmentReportFilePath(){
            return APPOINMENT_REPORT_FILE_PATH;
        }
    public static String getPatientCredintailReportFilePath(){
            return PATIENTCREDINTIAL_REPORT_FILE_PATH;
        }
    public static String getUserLoginReportFilePath(){
            return USERLOGIN_REPORT_FILE_PATH;
            
        }     
      
      //getters here
 
public  static ArrayList<Patient> getAllPatients(){
             ArrayList<Patient> allPatientList= new ArrayList<Patient>();
            try {
             BufferedReader reader = new BufferedReader(new FileReader(PATIENTS_FILE));
            String line;
            while ((line = reader.readLine()) != null) {

                 //username, password, email, etc

                Patient p=Patient.readPatientUser(line);//line with commas

                allPatientList.add(p);

            }
            reader.close();
             return allPatientList;


        } 
         catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }



      }

public static ArrayList<MedicalOfficer> getMoBySpeciality(String speciality){
       ArrayList<MedicalOfficer> specialityOfficer= new ArrayList<MedicalOfficer>();
         try {
             BufferedReader reader = new BufferedReader(new FileReader(MO_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
               
                 
                String[] data = line.split(","); //username, password, email, etc
                if(data[13].equals(speciality)){
                MedicalOfficer user=MedicalOfficer.readMoUser(line);
                
                specialityOfficer.add(user);
                }
            }
            reader.close();
            return specialityOfficer;
            
        } 
         catch (FileNotFoundException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }

       
   }   
   
public static MedicalOfficer getMoById(String id){
       MedicalOfficer officer=null;
         try {
             BufferedReader reader = new BufferedReader(new FileReader(MO_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                
                 
                String[] data = line.split(","); //username, password, email, etc
                if(data[4].equals(id)){
                
                
               officer=MedicalOfficer.readMoUser(line);
                }
            }
            reader.close();
            return officer;
            
        } 
         catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
       
   }
 
public static Patient getPatientById(String id){
       Patient patient=null;
         try {
             BufferedReader reader = new BufferedReader(new FileReader(PATIENTS_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                 
                String[] data = line.split(","); //username, password, email, etc
                if(data[4].equals(id)){
                
                
               patient=Patient.readPatientUser(line);
                }
            }
            reader.close();
            return patient;
            
        } 
         catch (FileNotFoundException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
       
   }
 
public static ArrayList<MedicalOfficer> getAllMo(ArrayList<String> list){
      ArrayList<MedicalOfficer> moOfficerList= new ArrayList<MedicalOfficer>();
    for(String line:list){
        MedicalOfficer officer=MedicalOfficer.readMoUser(line);
            moOfficerList.add(officer);
    }
    return moOfficerList;
}
    
  /*  public static void writeAppoinment(Appointment appointment)throws IOException {
        
        try
        {
            System.out.println("works");
        FileWriter writer=new FileWriter(APPOINTMENTS_FILE_PATH,true);
        PrintWriter out =new PrintWriter(writer);

        if(appointment!=null){
            out.print(appointment.getAppointmentNumber());
            out.print(","+appointment.getStatus());
             out.print(","+appointment.getPatient().toString());
            out.print(","+appointment.getAppointmentDate());
            out.print(","+appointment.getAppointmentTime());
            out.print(","+appointment.getMedicalOfficer().toString());
            out.print(","+appointment.getSpeciality());
            out.println(","+appointment.getSymtomps());
             Appointment.increment();

        }    
        writer.close();
        out.close();
           
        }
    catch(IOException exception){
        System.out.println(exception);
    }
    

    
    }*/
    
  /* public static void writeComplaint(Complaint compain)throws IOException {
        
        try
        {
            System.out.println("works");
        FileWriter writer=new FileWriter(COMPLAINT_FILE_PATH,true);
        PrintWriter out =new PrintWriter(writer);

        if(compain!=null){
            out.print(compain.getStrType());
            out.print(","+compain.getStrDate());
            out.print(","+compain.getStrComplaintBy());
            out.print(","+compain.getStrDescription());
            out.print(","+compain.getIntPhonrNumber());
            out.print(","+compain.getStrActionTaken());
             out.print(","+compain.getStrNote());
             out.println(","+compain.getAttachment());
             
    
           
            

        }    
        writer.close();
        out.close();
           
        }
    catch(IOException exception){
        System.out.println(exception);
    }
    

    
    }*/
    
  /*   public static void writeMail(DispatchedPostal mail)throws IOException {
        
        try
        {
            System.out.println("works");
        FileWriter writer=new FileWriter(getMailsFilePath(),true);
        PrintWriter out =new PrintWriter(writer);

        if(mail!=null){
            out.print(mail.getIntReferenceNo());
            out.print(","+mail.getStrDate());
            out.print(","+mail.getStrToName());
            out.print(","+mail.getStrToAddress());
            out.print(","+mail.getStrNote());
             out.println(","+mail.getAttachment());
             
    
           PostalMail.incrementRefferenceCount();
            

        }    
        writer.close();
        out.close();
           
        }
    catch(IOException exception){
        System.out.println(exception);
    }
    

    
    }*/
    
 /*    public static void writeVisitorRecord(Visitor record)throws IOException {
        
        try
        {
            System.out.println("works");
        FileWriter writer=new FileWriter(getVisitorsFilePath(),true);
        PrintWriter out =new PrintWriter(writer);

        if(record!=null){
            out.print(record.getStrDate());
             out.print(","+record.getIntId());
            out.print(","+record.getStrName());
            out.print(","+record.getStrPurpose());
            out.print(","+record.getIntPhoneNo());
            out.print(","+record.getStrInTime());
            out.print(","+record.getStrOutTime());
             out.print(","+record.getStrNote());
             out.println(","+record.getAttachment());
             
    
          
            

        }    
        writer.close();
        out.close();
            
        }
    catch(IOException exception){
        System.out.println(exception);
    }
    

    
    }*/
     
public static void writeLoginRecord(String filePath,String line)throws IOException {
             String[] lineList=line.split(",");
           if(isRecordExist(filePath,lineList[0])){ 
                            

           removeLine(filePath,lineList[0]);
            
              addLine(filePath,line);

       
       }
       else{
           addLine(filePath,line);
          
       }
    

    
    }
     
public static ArrayList<String> getPatientAppointments(String id){
         ArrayList<String> appointmentList= new ArrayList<String>();
          try {
             BufferedReader reader = new BufferedReader(new FileReader(APPOINTMENTS_FILE));
            String line;
            while ((line = reader.readLine()) != null) {              
                String[] data = line.split(","); //username, password, email, etc
                if(data[5].equals(id)){
                    
               
                appointmentList.add(line);
                
                }
            }
            reader.close();
           return appointmentList;
            
        } 
         catch (FileNotFoundException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
          
    
    }
      
public static ArrayList<String> getMOAppointments(String id){
         ArrayList<String> appointmentList= new ArrayList<String>();
          try {
             BufferedReader reader = new BufferedReader(new FileReader(APPOINTMENTS_FILE));
            String line;
            while ((line = reader.readLine()) != null) {              
                String[] data = line.split(","); //username, password, email, etc
                if(data[9].equals(id) && data[3].equals("Approved")){
                    
               
                appointmentList.add(line);
                
                }
            }
            reader.close();
           return appointmentList;
            
        } 
         catch (FileNotFoundException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
          
    
    }
       
   
    
   /* public static ArrayList<String> getAllAppointments(){
         ArrayList<String> appointmentList= new ArrayList<String>();
          try {
             BufferedReader reader = new BufferedReader(new FileReader(APPOINTMENTS_FILE));
            String line;
            while ((line = reader.readLine()) != null) {              
                String[] data = line.split(","); //username, password, email, etc
                
                    
               
                appointmentList.add(line);
                
                
            }
            reader.close();
           return appointmentList;
            
        } 
         catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    
    }*/
    
    /* public static ArrayList<String> getAllComplaints(){
         ArrayList<String> complainList= new ArrayList<String>();
          try {
             BufferedReader reader = new BufferedReader(new FileReader(COMPLAINT_FILE));
            String line;
            while ((line = reader.readLine()) != null) {              
                String[] data = line.split(","); //username, password, email, etc
                
                    
               
                complainList.add(line);
                
                
            }
            reader.close();
           return complainList;
            
        } 
         catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    
    }*/
          
   /*  public static ArrayList<String> getPatientComplaints(){
         ArrayList<String> complaintList= new ArrayList<String>();
          try {
               System.out.println("patient complaints");  
             BufferedReader reader = new BufferedReader(new FileReader(COMPLAINT_FILE));
            String line;
            while ((line = reader.readLine()) != null) {              
                String[] data = line.split(","); //username, password, email, etc
                
               
                    
               
                complaintList.add(line);
                
                
            }
            reader.close();
           return complaintList;
            
        } 
         catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
          
    
    }*/
   /*  public static ArrayList<String> getDispatchedMails(){
            ArrayList<String> mailList= new ArrayList<String>();
          try {
               System.out.println("mails");  
             BufferedReader reader = new BufferedReader(new FileReader(MAIL_FILE));
            String line;
            while ((line = reader.readLine()) != null) {              
                String[] data = line.split(","); //username, password, email, etc
                  
              
                    
               
                mailList.add(line);
                
                
            }
            reader.close();
           return mailList;
            
        } 
         catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
     
     
     }*/
     
  /*   public static ArrayList<String> getVisitorRecords(){
            ArrayList<String> recordList= new ArrayList<String>();
          try {
             BufferedReader reader = new BufferedReader(new FileReader(VISITOR_FILE));
            String line;
            while ((line = reader.readLine()) != null) { 
                               System.out.println("visitor record"+line);  

                String[] data = line.split(","); //username, password, email, etc
                  
              
                    
               
                recordList.add(line);
                
                
            }
            reader.close();
           return recordList;
            
        } 
         catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
     
     
     }*/
     
public static ArrayList<String> getRecords(File file){
            ArrayList<String> recordList= new ArrayList<String>();
          try {
             BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) { 
                               

                //String[] data = line.split(","); //username, password, email, etc
                  
              
                    
               
                recordList.add(line);
                
                
            }
            reader.close();
           return recordList;
            
        } 
         catch (FileNotFoundException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
     
     
     }

public static int getRecordCount(File file){
          int count=0;
           try {
             BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) { 

                count++;
           
            }
            reader.close();
           return count;
            
        } 
         catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
          
      }
    
    
public static boolean isRecordExist(String filePath,String key){//can be used for user name validation
      boolean isExist=false;
         try {
             BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
            String line;
            while ((line = reader.readLine()) != null) { 
              
                String[] data = line.split(",");
                if(data[0].toLowerCase().equals(key.toLowerCase())){
                    
                    isExist=true;
                    break;
                
                }
            }
            reader.close();
          
            
        } 
         catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
           
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
         return isExist;
         
   }
   
public static void removeLine(String filePath,String lineToRemove){
         
     try {

      File inFile = new File(filePath);

      if (!inFile.isFile()) {
        System.out.println("Parameter is not an existing file");
        return;
      }

      //Construct the new file that will later be renamed to the original filename.
      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

      BufferedReader br = new BufferedReader(new FileReader(filePath));
      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

      String line = null;

      //Read from the original file and write to the new
      //unless content matches data to be removed.
      while ((line = br.readLine()) != null) {
            String[] strLine=line.split(",");
        if (!strLine[0].equals(lineToRemove)) {

          pw.println(line);
          pw.flush();
        }
      }
      pw.close();
      br.close();

      //Delete the original file
      if (!inFile.delete()) {
        System.out.println("Could not delete file");
        return;
      }

      //Rename the new file to the filename the original file had.
      if (!tempFile.renameTo(inFile))
        System.out.println("Could not rename file");

    }
    catch (FileNotFoundException ex) {
       JOptionPane.showMessageDialog(null, ex.getMessage());
    }
    catch (IOException ex) {
       JOptionPane.showMessageDialog(null, ex.getMessage());
    }  
       
   }
   
public static void addLine(String filePath,String line){
        try
        {
            
        FileWriter writer=new FileWriter(filePath,true);
        PrintWriter out =new PrintWriter(writer);

        if(line!=null){
            out.println(line);
                                   
        }    
        writer.close();
        out.close();
          
        }
    catch(IOException exception){
        System.out.println(exception);
    }
       
   }
   
public static void deleteRecord(String filePath,String lineToRemove){
       
   
         try {

      File inFile = new File(filePath);

      if (!inFile.isFile()) {
       
                JOptionPane.showMessageDialog(null, "Parameter is not an existing file");

        return;
      }

      //Construct the new file that will later be renamed to the original filename.
      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

      BufferedReader br = new BufferedReader(new FileReader(filePath));
      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

      String line = null;

      //Read from the original file and write to the new
      //unless content matches data to be removed.
      while ((line = br.readLine()) != null) {
           
        if (!line.toLowerCase().equals(lineToRemove.toLowerCase())) {
            
          pw.println(line);
          pw.flush();
        }
      }
      pw.close();
      br.close();

      //Delete the original file
      if (!inFile.delete()) {
        JOptionPane.showMessageDialog(null, "Could not delete file");
        return;
      }

      //Rename the new file to the filename the original file had.
      if (!tempFile.renameTo(inFile))
        
      JOptionPane.showMessageDialog(null, "Could not delete file");

    }
    catch (FileNotFoundException ex) {
       JOptionPane.showMessageDialog(null, ex.getMessage());
    }
    catch (IOException ex) {
       JOptionPane.showMessageDialog(null, ex.getMessage());
    }
       
   }
public static void generatePdf( TableModel model,String path){
        
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(path));
            doc.open();
            PdfPTable pdfTable = new PdfPTable(model.getColumnCount());
            //adding table headers
            for (int i = 0; i < model.getColumnCount(); i++) {
                pdfTable.addCell(model.getColumnName(i));
            }
            //extracting data from the JTable and inserting it to PdfPTable
            for (int rows = 0; rows < model.getRowCount() ; rows++) {
                for (int cols = 0; cols < model.getColumnCount(); cols++) {
                    pdfTable.addCell(model.getValueAt(rows, cols).toString());

                }
            }
            doc.add(pdfTable);
            doc.close();
             JOptionPane.showMessageDialog(null, "Sucessfully Generated PDF");
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Document Not Found");
        } catch (FileNotFoundException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    
        
        
    } 
public static void generateApprovedAppoinmentReport(){
          Document document = new Document();
    try
    {
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("files/reports/approved appoinments.pdf"));
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
        table.addCell("Medical Officer Id");
        ArrayList<String> appointmentList =FileService.getRecords(FileService.getAppointmentsFile());
        
        
         for(int i=0; i<appointmentList.size(); i++){
             Appointment appoinment=Appointment.readAppoinment(appointmentList.get(i));
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
            table.addCell(appoinment.getMedicalOfficer().getIdCardNo());
                
             }
         
         }
 
 
        document.add(table);
 
        document.close();
        writer.close();
        JOptionPane.showMessageDialog(null, "Sucessfully Generated PDF");
        
    } catch (Exception e)
    {
         JOptionPane.showMessageDialog(null, "File Not Found");
    }
    
         
         
     }   
public static void generateCsvFile(TableModel model,String path) throws IOException{
       try  {
           
          // File file =new File(path);
          FileWriter fileWriter = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
           
            for (int row = 0; row < model.getRowCount(); row++){
            Object record= ((DefaultTableModel) model).getDataVector().elementAt(row);
                   String line= PipeService.formatTableString(record.toString());
                    bw.write(line+"\n");
            }
          bw.flush();
        bw.close();
        JOptionPane.showMessageDialog(null, "Sucessfully Generated CSV");
               


    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }    
    }
    
}

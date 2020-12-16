/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author sajath
 */
public class FileService {
      private static ArrayList<Patient> patientList=new ArrayList<Patient>();
      private static ArrayList<MedicalOfficer> officerList= new ArrayList<MedicalOfficer>();
       private static ArrayList<Receptionist> receptionistList=new ArrayList<Receptionist>();
        
       
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
      
      public static String getUserFilePath(){
          return USER_FILE_PATH;
      }
      public static File getUserFile(){
          return USER_FILE;
      }
       public static String getMoFilePath(){
          return MO_FILE_PATH;
      }
       public static File getMoFile(){
          return MO_FILE;
      }  
       public static File getUserLoginFile(){
           return LOGIN_FILE;
       }
       
      public static String getPatientsFilePath(){
          return PATIENT_FILE_PATH;
      }
      public static File getPatientsFile(){
          return PATIENTS_FILE;
      }
      public static String getReceptionistFilePath(){
          return RECEPTIONIST_FILE_PATH;
      }
      public static File getReceptionistFile(){
          return RECEPTIONIST_FILE;
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
         
      
      //getters here
      
      
      
      
      public  void getAllPatients(){
            try {
             BufferedReader reader = new BufferedReader(new FileReader(PATIENTS_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                 
                String[] data = line.split(","); //username, password, email, etc
           
                Patient p=this.createPatientUser(data);
                patientList.add(p);
               
            }
            reader.close();
            
        } 
         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
          
          
          
      }
      
      public Patient createPatientUser(String[] data){
          String userName=data[0];
           String name=data[1];
            String gender=data[2];
            String mobile=data[3];
            String idCard=data[4];
            String dob=data[5];
            String address=data[6];
            String status=data[7];
             String password=data[8];
              String bldGroup=data[9];
               String allergy=data[10];
               
               
               return new Patient(userName,name,gender,mobile,idCard,dob,address,status,password,bldGroup,allergy);
      }
      
   public static ArrayList<MedicalOfficer> getMoBySpeciality(String speciality){
       ArrayList<MedicalOfficer> specialityOfficer= new ArrayList<MedicalOfficer>();
         try {
             BufferedReader reader = new BufferedReader(new FileReader(MO_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                 
                String[] data = line.split(","); //username, password, email, etc
                if(data[13].equals(speciality)){
                MedicalOfficer user=createMOUser(data);
                
                specialityOfficer.add(user);
                }
            }
            reader.close();
            return specialityOfficer;
            
        } 
         catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

       
   }   
   
   
    public static MedicalOfficer createMOUser(String[] data){
          String userName=data[0];
           String name=data[1];
            String gender=data[2];
            String mobile=data[3];
            String idCard=data[4];
            String dob=data[5];
            String address=data[6];
            String status=data[7];
             String password=data[8];
              String staffId=data[9];
               String email=data[10];
               String date=data[11];
                String cv=data[12];
                String speciality=data[13];
                String image=data[14];
                
                File cvFile = new File(cv);
                 File staffImage = new File(image);
               
               return new MedicalOfficer(userName,name,gender,mobile,idCard,dob,address,status,password,staffId,email,date,cvFile,speciality,staffImage);
      }
    
    public static void writeAppoinment(Appointment appointment)throws IOException {
        
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
    

    
    }
    
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
    
     public static void writeMail(DispatchedPostal mail)throws IOException {
        
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
    

    
    }
    
     public static void writeVisitorRecord(Visitor record)throws IOException {
        
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
    

    
    }
     
       public static void writeLoginRecord(String filePath,String line)throws IOException {
             String[] lineList=line.split(",");
           if(isRecordExist(filePath,lineList[0])){ 
                            System.out.println("key"+lineList[0]);

           removeLine(filePath,lineList[0]);
             System.out.println("removing");
              addLine(filePath,line);

       
       }
       else{
           addLine(filePath,line);
          System.out.println("adding");
       }
    

    
    }
     
       public static ArrayList<String> getPatientAppointments(String id){
         ArrayList<String> appointmentList= new ArrayList<String>();
          try {
             BufferedReader reader = new BufferedReader(new FileReader(APPOINTMENTS_FILE));
            String line;
            while ((line = reader.readLine()) != null) {              
                String[] data = line.split(","); //username, password, email, etc
                if(data[3].equals(id)){
                    
               
                appointmentList.add(line);
                
                }
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
          
    
    }
      
       public static ArrayList<String> getMOAppointments(String id){
         ArrayList<String> appointmentList= new ArrayList<String>();
          try {
             BufferedReader reader = new BufferedReader(new FileReader(APPOINTMENTS_FILE));
            String line;
            while ((line = reader.readLine()) != null) {              
                String[] data = line.split(","); //username, password, email, etc
                if(data[9].equals(id) && data[3].equals("approved")){
                    
               
                appointmentList.add(line);
                
                }
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
          
    
    }
    
    public static ArrayList<String> getAllAppointments(){
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
    
    }
    
     public static ArrayList<String> getAllComplaints(){
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
    
    }
          
     public static ArrayList<String> getPatientComplaints(){
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
          
    
    }
     public static ArrayList<String> getDispatchedMails(){
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
     
     
     }
     
     public static ArrayList<String> getVisitorRecords(){
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
     
     
     }

    
    
   private static boolean isRecordExist(String filePath,String key){
      boolean isExist=false;
         try {
             BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
            String line;
            while ((line = reader.readLine()) != null) { 
              
                String[] data = line.split(",");
                  System.out.println("value"+data[0]);System.out.println("key"+key);
                if(data[0].equals(key)){
                    
                    isExist=true;
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
      ex.printStackTrace();
    }
    catch (IOException ex) {
      ex.printStackTrace();
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
    
    
}

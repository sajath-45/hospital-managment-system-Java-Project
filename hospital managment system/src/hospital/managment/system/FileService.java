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
        
       
       private  final String PATIENT_FILE_PATH = "files/patients.txt";
       private  final File PATIENTS_FILE = new File(PATIENT_FILE_PATH);
         
         private static final String MO_FILE_PATH = "files/medicalofficers.txt";
         private static final File MO_FILE = new File(MO_FILE_PATH);
         
         private static final String RECEPTIONIST_FILE_PATH = "files/receptionist.txt";
         private static  final File RECEPTIONIST_FILE = new File(RECEPTIONIST_FILE_PATH);
         
         private  static final String APPOINTMENTS_FILE_PATH="files/appointments.txt";
         
        private static final String USER_FILE_PATH = "files/users.txt";
        private static final File USER_FILE = new File(USER_FILE_PATH);
        
        private static final String VISITOR_FILE_PATH = "files/visitors.txt";
        private static final File VISITOR_FILE = new File(VISITOR_FILE_PATH);
        
         private static final String COMPLAINT_FILE_PATH = "files/complaints.txt";
        private static final File COMPLAINT_FILE = new File(COMPLAINT_FILE_PATH);
        
         private static final String MAIL_FILE_PATH = "files/complaints.txt";
        private static final File MAIL_FILE = new File(MAIL_FILE_PATH);
        
        private static final String IMAGEPATH="src/resources/new/";
      
      
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
      
      public String getUserFilePath(){
          return USER_FILE_PATH;
      }
      public static File getUserFile(){
          return USER_FILE;
      }
       public String getMOFilePath(){
          return MO_FILE_PATH;
      }
       public File getMoFile(){
          return MO_FILE;
      }    
      public String getPatientFilePath(){
          return PATIENT_FILE_PATH;
      }
      public File getPatientFile(){
          return PATIENTS_FILE;
      }
      public String getReceptionistFilePath(){
          return RECEPTIONIST_FILE_PATH;
      }
      public File getReceptionistFile(){
          return RECEPTIONIST_FILE;
      }
        
        public String getAppointmentsFilePath(){
          return APPOINTMENTS_FILE_PATH;
      }
        public String getVisitorsFilePath(){
          return VISITOR_FILE_PATH;
      }
         public String getComplaintsFilePath(){
          return COMPLAINT_FILE_PATH;
      }
        public String getImagePath(){
            return IMAGEPATH;
        }
         public String getMailsFilePath(){
            return MAIL_FILE_PATH;
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
            int mobile=Integer.parseInt(data[3]);
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
            int mobile=Integer.parseInt(data[3]);
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

               
               
               
               return new MedicalOfficer(userName,name,gender,mobile,idCard,dob,address,status,password,staffId,email,date,cv,speciality);
      }
    
    public static void addAppoinment(Appointment appointment)throws IOException {
        
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
            

        }    
        writer.close();
        out.close();
            Appointment.increment();
        }
    catch(IOException exception){
        System.out.println(exception);
    }
    

    
    }
    
    
}

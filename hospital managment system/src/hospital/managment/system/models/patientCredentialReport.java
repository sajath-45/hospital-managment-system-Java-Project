package hospital.managment.system.models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hospital.managment.system.models.User;
import java.util.ArrayList;

/**
 *
 * @author siva lathu
 */
public class patientCredentialReport {
    
    private ArrayList<User> loginList;
    
    public patientCredentialReport(ArrayList<User> loginList){
        setLoginList(loginList);
    }
    
    public ArrayList getLoginlist(){//get method to get the loginlist of patientcredentialreport
        return loginList;
    }
    
    public void setLoginList(ArrayList<User> loginList) {//method to set the loginlist of patientcredentialreport
        this.loginList=loginList;
    }
     
}

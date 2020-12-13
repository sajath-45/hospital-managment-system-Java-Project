package hospital.managment.system;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hospital.managment.system.UserLogin;
import java.util.ArrayList;

/**
 *
 * @author siva lathu
 */
public class userLogReport {
    
    private ArrayList<UserLogin> userLoginList;
    private String strDate;
    private String strUserType;
    
    public userLogReport(ArrayList<UserLogin> userLogInList, String Date, String userType){
        setUserLogIn(userLogInList);
        setStrDate(Date);
        setStrUserType(userType);
    }
    
    public ArrayList<UserLogin> getUserLogInList(){
        return userLoginList;
    }
    public String getStrDate(){
        return strDate;
    }
    public String getStrUserType(){
        return strUserType;
    }
    
    public void setUserLogIn(ArrayList<UserLogin> userLogInList) {
        this.userLoginList=userLogInList;
    }
    public void setStrDate(String date) {
        this.strDate=date;
    }
    public void setStrUserType(String userType) {
        this.strUserType=userType;
    }
    
}

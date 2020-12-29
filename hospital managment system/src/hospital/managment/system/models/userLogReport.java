package hospital.managment.system.models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    
    public ArrayList<UserLogin> getUserLogInList(){//get method to get the userloginlist of userlogreport
        return userLoginList;
    }
    public String getStrDate(){//get method to get the date of userlogreport
        return strDate;
    }
    public String getStrUserType(){//get method to get the usertype of userlogreport
        return strUserType;
    }
    
    public void setUserLogIn(ArrayList<UserLogin> userLogInList) {//method to set the userloginlist of userlogreport
        this.userLoginList=userLogInList;
    }
    public void setStrDate(String date) {//method to set the date of userlogreport
        this.strDate=date;
    }
    public void setStrUserType(String userType) {//method to set the usertype of userlogreport
        this.strUserType=userType;
    }
    
}

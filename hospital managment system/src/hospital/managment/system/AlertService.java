/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import javax.swing.JOptionPane;

/**
 *
 * @author sajath
 */
public class AlertService {
    
    public static int optionalPlane(String message,String header){//this function creates Joptional plane
         int dialogButton = JOptionPane.YES_NO_OPTION;//stores int value of the response by user if its yes or no
       int dialogResult = JOptionPane.showConfirmDialog (null,message,header,dialogButton);
       
       return dialogResult;
    }
    
    
    
}

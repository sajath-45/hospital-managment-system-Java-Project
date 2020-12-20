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
    
    public static int optionalPlane(String message,String header){
         int dialogButton = JOptionPane.YES_NO_OPTION;
       int dialogResult = JOptionPane.showConfirmDialog (null,message,header,dialogButton);
       
       return dialogResult;
    }
    
    
    
}

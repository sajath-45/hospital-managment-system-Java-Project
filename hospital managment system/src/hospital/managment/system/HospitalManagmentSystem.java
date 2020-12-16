/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import java.awt.SplashScreen;

/**
 *
 * @author sajath
 */
public class HospitalManagmentSystem {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        splashScreen screen = new splashScreen();
          screen.setVisible(true);
        Home home = new Home();
        
     
        try {
            for (int row = 0; row <=100; row++) {
                Thread.sleep(100);
                screen.loadingNumber.setText(Integer.toString(row)+"%");
                screen.loadingBar.setValue(row);
                if (row == 100) {
                    
                    screen.setVisible(false);
                    home.setVisible(true);
                }
            }
        } catch (InterruptedException e) {
        }
    }
    
}

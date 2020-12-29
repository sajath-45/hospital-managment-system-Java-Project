/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sajath
 */
public final class PipeService {
    
    public static String formatTableString(String line){
        return line.replace("[","").replace("]", "").replace(", ", ",");
    }
    
    public static String getDateSimpleFormat(Date date){
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date); 
     }
    public static String getTimeSipleFormat(Date date){
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");  
        return timeFormatter.format(date);
    }
    
    public static Date getStringToDateFormat(String value ){
        try {
            java.util.Date date=new SimpleDateFormat("dd/MM/yyyy").parse(value);
            return date;
        } catch (ParseException ex) {
            Logger.getLogger(PipeService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}

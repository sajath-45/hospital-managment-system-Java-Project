/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.managment.system;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    
    
}

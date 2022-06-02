package assignment1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Group 83
 * 
 * validates the input date 
 */
public class DateValidator {
    
        public boolean isValid(String input) {
        
        String date = input;
        DateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
        dFormat.setLenient(false);
        
        try{
        //instance of the current date    
        Date todayDate = dFormat.parse(dFormat.format( new Date()));
        //saves the input String as a Date
        Date inputDate = dFormat.parse(date);
        // checks that there is an input and not null
        if((date.trim().equals(""))){
            return false;
        }
        //checks that the input is not before the current date
        else if(todayDate.after(inputDate)){
            return false;

        }
        else{
            
            dFormat.parse(date);  
                
        }
          
        }  
        catch(ParseException e){
                return false;
        } 
        return true;
    }
    
}

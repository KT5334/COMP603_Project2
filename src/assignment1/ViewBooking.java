/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Group 83
 */
public class ViewBooking {
    
    private String bookingRef;
    private LinkedHashMap<String, String> bookings;
    
    public ViewBooking(String ref){
        this.bookingRef = ref;
    }
    
    //check if input reference is an existing reference
    public boolean validRef(){
            //temporary HashMap to store key value pairs
            LinkedHashMap <String, String> temp = new LinkedHashMap();
            
            BufferedReader rd = null;
            File file = new File ("./resources/Bookings.txt");
            
        try {
            rd = new BufferedReader(new FileReader(file));
            String line = null;
            //reads the file line by line
            while((line = rd.readLine()) != null){
                //seperates the line with a ~
                String str[] = line.split("~");
                //saves the key and values pairs on file and puts it on the temporary HashMap
                temp.put(str[0], str[1]);
            }
            //sets temp HashMap as bookings
            this.setBookings(temp);
            
            //return false if booking reference does not exist on file
            if(!temp.containsKey(this.getBookingRef())){
                return false;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ViewBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(rd != null){
                try {
                    rd.close();
                } catch (IOException ex) {
                    Logger.getLogger(ViewBooking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return true;
    }
    
    //prints the booking info on screen
    public void printBooking(){
        
        LinkedHashMap <String, String> temp = this.getBookings();
        //iterates through the HashMap
        for(Map.Entry<String, String> entry : temp.entrySet()){
            
            //if the current entry key matches the booking ref, print the value on screen
            if(entry.getKey().equals(this.getBookingRef())){
                System.out.println(entry.getValue());
            }

        }
    }

    /**
     * @return the bookingRef
     */
    public String getBookingRef() {
        return bookingRef;
    }

    /**
     * @param bookingRef the bookingRef to set
     */
    public void setBookingRef(String bookingRef) {
        this.bookingRef = bookingRef;
    }

    /**
     * @return the bookings
     */
    public LinkedHashMap<String, String> getBookings() {
        return bookings;
    }

    /**
     * @param bookings the bookings to set
     */
    public void setBookings(LinkedHashMap<String, String> bookings) {
        this.bookings = bookings;
    }
    
}

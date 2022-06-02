/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Group 83
 */
public class Booking {
    
    private String date;
    private String bookingRef;
    private String roomNo;
    private Guest guest;
    
    public Booking(String date, String room, Guest guest){
        this.date = date;
        this.guest = guest;
        this.bookingRef = this.date + this.guest.getlName();
        this.roomNo = room;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the bookingRef
     */
    public String getBookingRef() {
        return bookingRef;
    }

     /**
     * @return the roomNo Object
     */
    public String getRoom(){
        return roomNo;
    }

    /**
     * @return the guest
     */
    public Guest getGuest() {
        return guest;
    }

    /**
     * @param guest the guest to set
     */
    public void setGuest(Guest guest) {
        this.guest = guest;
    }
    //saves a record of the booking by writting on file
    public void saveRecord(){
        PrintWriter pw = null;
        try {
            File file = new File("./resources/Bookings.txt");
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            //writes a new line
            pw.write("\n");
            //appends the toString of class on file
            pw.write(this.toString());
            
        } catch (IOException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }
    
    @Override
    public String toString(){
        return this.getBookingRef()+ "~ Date: " + this.getDate()+ " Guest: " +this.guest+ " Room Number: " + this.getRoom();
    }
    
    
}

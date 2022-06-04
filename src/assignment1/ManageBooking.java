package assignment1;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class ManageBooking {

    private String bookingRef;
    private String fName;
    private String lName;
    private int roomNo;

    HotelDB db;
    Statement statement;
    Connection conn;

    public ManageBooking() {
        db = new HotelDB();
        conn = db.getConnection();
        try{
            statement = conn.createStatement();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void cancelBooking(){
        
        try {
            
            String getDate = "SELECT BOOKEDDATE FROM BOOKING WHERE REF = '"+this.getBookingRef()+"'";
            
            ResultSet rs = this.statement.executeQuery(getDate);
            
            String date="";
            //set retrived value of BOOKEDDATE to date
            while (rs.next()){
                date = rs.getString("BOOKEDDATE");
            }
            
            //updated the dates table to make the booked room available
            String cancel = "UPDATE \"" +date+"\""
                    +"SET AVAILABLE = 'YES'"
                    +"WHERE ROOMNO = "+this.getRoomNo();
            
            this.statement.executeUpdate(cancel);
            System.out.println("Updated room");
            //delete booking from database
            String deleteBooking = "DELETE FROM BOOKING WHERE REF = '"+this.getBookingRef()+"'";
            this.statement.executeUpdate(deleteBooking);
            System.out.println("Deleted Booking");
            //close connections
            this.statement.close();
            db.closeConnections();
            
        } catch (SQLException ex) {
            Logger.getLogger(ManageBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean validBooking(String ref){
        
        boolean isValid = true;
        
        try {
            String findRef = "SELECT FIRSTNAME, LASTNAME, ROOMNO FROM BOOKING WHERE REF = '"+ref+"'";
            
            ResultSet rs = this.statement.executeQuery(findRef);
            
            if(rs.next()){
                this.setfName(rs.getString("FIRSTNAME"));
                this.setlName(rs.getString("LASTNAME"));
                this.setRoomNo(rs.getInt("ROOMNO"));
                this.setBookingRef(ref);
            } else{
                isValid = false;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManageBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isValid;
    }

    /**
     * @return the bookingRef
     */
    public String getBookingRef() {
        return bookingRef;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the roomNo
     */
    public int getRoomNo() {
        return roomNo;
    }

    /**
     * @param roomNo the roomNo to set
     */
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * @param bookingRef the bookingRef to set
     */
    public void setBookingRef(String bookingRef) {
        this.bookingRef = bookingRef;
    }

}

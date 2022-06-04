/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
public class Booking {

    private String date;
    private String bookingRef;
    private int roomNo;
    private Guest guest;

    HotelDB db;
    Statement statement;
    Connection conn;

    public Booking(String date, int room, Guest guest) {
        db = new HotelDB();
        conn = db.getConnection();
        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        this.date = date;
        this.guest = guest;
        //booking ref with user info
        this.bookingRef = this.guest.getlName() + this.date+"rm"+room;
        this.roomNo = room;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
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
    public int getRoom() {
        return roomNo;
    }

    /**
     * @return the guest
     */
    public Guest getGuest() {
        return guest;
    }
    //creates a booking table if it does not exist and creates and entry with the booking details
    public void createBooking() {
        String table = "BOOKING";

        try {
            //checks if table exist and if not create it
            DatabaseMetaData databaseMetadata = db.getConnection().getMetaData();
            ResultSet resultSet = databaseMetadata.getTables(null, null, table, null);

            if (resultSet.next()) {
                System.out.println("Date table Exist");

            } else {
                String create = "CREATE TABLE " + table + " (REF VARCHAR (35),"
                        + "FIRSTNAME VARCHAR (20),"
                        + "LASTNAME VARCHAR (30),"
                        + "EMAIL VARCHAR(50),"
                        + "BOOKEDDATE VARCHAR(15),"
                        + "ROOMNO INT, PRIMARY KEY (REF))";

                this.statement.executeUpdate(create);
                System.out.println("Booking Table Created");
            }
            
            //inserts value into table
            String sqlInsert = "insert into " + table + " values('"
                    + this.getBookingRef() + "', '"
                    + this.getGuest().getfName() + "', '"
                    + this.getGuest().getlName() + "', '"
                    + this.getGuest().getEmail() + "', 'd"
                    + this.getDate()+ "', "
                    + this.getRoom() + ")";

            this.statement.executeUpdate(sqlInsert);
            this.statement.close();
            resultSet.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
        }

        db.closeConnections();
    }

}

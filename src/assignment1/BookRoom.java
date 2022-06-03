package assignment1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
public class BookRoom {

    private String date;

    private LinkedList<Integer> availableRooms;

    HotelDB db;
    Statement statement;
    Connection conn;

    public BookRoom(String date) {
        db = new HotelDB();
        conn = db.getConnection();
        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        this.date = date;
    }
    //checks the available rooms in the database
    public void checkRoomAvailability() {
        
        String table = this.getDate();
        
        String findRooms = "SELECT ROOMNO FROM \"d" + table + "\" WHERE AVAILABLE = 'YES'";
        
        ResultSet rs;
        //temporary LinkedList
        LinkedList<Integer> tempList = new LinkedList<Integer>();
        try {
            rs = this.statement.executeQuery(findRooms);
            while (rs.next()){
                int temp1 = rs.getInt("ROOMNO");
                
                tempList.add(temp1);
                
            }
            //save tempList to availableRooms
            this.setAvailableRooms(tempList);
            rs.close();
            
            
            System.out.println("Available Rooms: ");
            /*
            for (Integer list : tempList) {
                System.out.println("Room " + list);
            }*/
                
        } catch (SQLException ex) {
            Logger.getLogger(BookRoom.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //book room method to updated the database room availability
    public void bookRoom(int room) {
        String table = this.getDate();
        
        String bookRoom = "UPDATE \"d" + table + "\""
                +"SET AVAILABLE = 'NO'"
                +"WHERE ROOMNO = "+ room;
        
        try {
            this.statement.executeUpdate(bookRoom);
            //close connection
            this.statement.close();
            db.closeConnections();
        } catch (SQLException ex) {
            Logger.getLogger(BookRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the availableRooms
     */
    public LinkedList<Integer> getAvailableRooms() {
        return availableRooms;
    }

    /**
     * @param availableRooms the availableRooms to set
     */
    public void setAvailableRooms(LinkedList<Integer> availableRooms) {
        this.availableRooms = availableRooms;
    }





}

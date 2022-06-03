package assignment1;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Group 83
 */
public class BookRoom{
    
    private String date;

    private LinkedList <String> room;
    private LinkedHashMap <String, LinkedList<String>> bookedDates;
    
    public BookRoom (String date, LinkedList<String> room, LinkedHashMap <String, LinkedList<String>> bookedDates){
        this.date = date;

        this.room = room;
        this.bookedDates = bookedDates;
    }

    
    public void checkRoomAvailability(){
        LinkedList <String> tempList = this.getRoom();
        
        System.out.println("Available Rooms: ");
   
        for(String list: tempList){
            System.out.println("Room "+ list);
        }
        
    }
    
    public void bookRoom(String roomNum){
        
        LinkedList<String> tempList = this.getRoom();
        
        if (tempList.contains(roomNum)){
            tempList.remove(tempList.indexOf(roomNum));
        }
        this.setRoom(tempList);
    }
    
    public void saveBooking(){
        LinkedHashMap <String, LinkedList<String>> tempMap = this.getBookedDates();
        
        tempMap.put(this.getDate(), this.getRoom());
        
        this.setBookedDates(tempMap);
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
     * @return the room
     */
    public LinkedList <String> getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(LinkedList <String> room) {
        this.room = room;
    }

    /**
     * @return the bookedDates
     */
    public LinkedHashMap <String, LinkedList<String>> getBookedDates() {
        return bookedDates;
    }

    /**
     * @param bookedDates the bookedDates to set
     */
    public void setBookedDates(LinkedHashMap <String, LinkedList<String>> bookedDates) {
        this.bookedDates = bookedDates;
    }
    
    
    
    
}

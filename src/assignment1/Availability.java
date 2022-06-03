package assignment1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
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
public class Availability {
    
    private String date;
    private LinkedList <String> room;
    private LinkedHashMap <String, LinkedList<String>> bookedDates;
    
    public Availability (String date){
        
        this.date = date;
        this.room = checkAvailability(date);

    }
 
    //checks Dates.txt file if the date has been created.
    public LinkedList<String> checkAvailability(String date){
        //Temporary LinkedHashMap
        LinkedHashMap<String, LinkedList<String>> map = new LinkedHashMap();
        String key;
        BufferedReader rd = null;
        PrintWriter pw = null;
        //BufferedWriter pw = null;
        try {
            
            
            File file = new File ("./resources/Dates.txt");
           
            rd = new BufferedReader(new FileReader(file));
            
            String line = null;
            //Reads File line by line and saving it to the temporary LinkedHashMap
            while((line = rd.readLine()) != null){
                LinkedList<String> value = new LinkedList<String>(Arrays.asList(line.split(",")));
                key = value.removeFirst();
                map.put(key, value);
  
            }
            this.setBookedDates(map);
            //If the temporary map does not contain the input date as Key make a new key with new values
            if(!(map.containsKey(date))){
                String newKey = date;
                LinkedList<String> newValue = new LinkedList();
                
                for(int i = 1; i < 11; i++){
                   newValue.add(String.valueOf(i));
                }
                //put new map key and values into the temporary HashMap
                map.put(newKey, newValue);
                //save the temporary map in to bookedDatesMap of the class
                this.setBookedDates(map);
                
                //iterate through the temporary HashMap
                for(Map.Entry<String, LinkedList<String>> entry : map.entrySet()){
                    pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                    //print the key into the file
                    pw.write(entry.getKey());
                    
                    //iterate through the LinkedList values of the Hashmap
                    for(int i = 0; i < newValue.size(); i++){
                    //print a comma and the value for each iteration   
                    pw.write("," + newValue.get(i));
                    }
                    //print new line.
                    pw.write("\n");
                    
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Availability.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Availability.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if((rd != null) && (pw != null)){
                try {
                    rd.close();
                    pw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return map.get(date);
    }
    
    //saves the current bookedDates HashMap on file
    public void saveDates(){
        //temporary HashMap
        LinkedHashMap<String, LinkedList<String>> map = this.getBookedDates();
        PrintWriter pw = null;
        File file = new File ("./resources/Dates.txt");
        
        try {
        pw = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));
        for(Map.Entry<String, LinkedList<String>> entry : map.entrySet()){
                //print the key into the file
                pw.write(entry.getKey());
                
                //temporary LinkedList to store the value from the map
                LinkedList<String> tempList = map.get(entry.getKey());
                
                //iterate through the temporary LinkedList
                for(int i = 0; i < tempList.size(); i++){
                    //print a comma and the value for each iteration
                    pw.write("," + tempList.get(i));
                }
                //print new line.
                pw.write("\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Availability.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pw != null){
                pw.close();
            }
        }
        
    }
    

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the room
     */
    public LinkedList <String> getRoom() {
        return room;
    }
    
    @Override
    public String toString(){
        
        String s = "";
        Iterator<String>  rm= this.getRoom().iterator();
        while(rm.hasNext()){
            s = s+ rm.next() + ",";
        }
        
        return this.date + "," + s;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
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

    /**
     * @param room the room to set
     */
    public void setRoom(LinkedList <String> room) {
        this.room = room;
    }

    
    
}

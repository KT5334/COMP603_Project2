package assignment1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
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
public class Guest {
    
    private String fName;
    private String lName;
    private String email;
    
    public Guest (String first, String last, String email){
        this.fName = first;
        this.lName = last;
        this.email = email;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    //writes the guest information on file
    public void createGuest(){
        //Key for HashMap using the guest email. converts to lower case.
        String key = this.getEmail().toLowerCase();
        //value for HashMap using the guest name. converts to lower case.
        String value = this.getlName().toLowerCase()+ ", "+ this.getfName().toLowerCase();
        
        //temporary HashMap
        LinkedHashMap<String, String> guest = new LinkedHashMap();
        
        File file = new File("./resources/Guest.txt");
        
        BufferedReader rd = null;
        PrintWriter wr =null;
       
        try {
            
            rd = new BufferedReader(new FileReader(file));
            String line = null;
            //reads the file line by line
            while((line = rd.readLine()) != null){
                //seperates the line with a dash
                String str[] = line.split("-");
                //saves the key and values pairs on file and puts it on the temporary HashMap
                guest.put(str[0], str[1]);
            }
            
            //checks if the Key(guest email) and value(guest name) already exists from the read file and writes an new line if it does not.
            if(!(guest.containsKey(key) && guest.containsValue(value))){
                //if the key and value pair does not exist in the HashMap save it on the HashMap
                guest.put(key, value);
                for(Map.Entry<String, String> entry : guest.entrySet()){
                
                wr = new PrintWriter( new BufferedWriter(new FileWriter(file, true)));
                wr.write(entry.getKey() +"-" + entry.getValue());
                wr.write("\n");
                
                
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if((rd != null) && (wr != null)){
                try {
                    rd.close();
                    wr.close();
                } catch (IOException ex) {
                    Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    }
    
    @Override
    public String toString(){
        return "Email: "+this.getEmail() + "- Guest Name: " + this.getlName() +", "+ this.getfName();
    }
    
}

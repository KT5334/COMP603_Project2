/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Observable;

/**
 *
 * @author dorae
 */
public class Model extends Observable{
    public HotelData data;
    public String date;
    public String email;
    public String fName;
    public String lName;
    
    public void checkDate (String first, String last, String email){
        Guest guest = new Guest (first, last, email);
        
        this.data = guest.createGuest();
        
        if(data.emailFlag){
            
        }
        this.setChanged();
        
        this.notifyObservers(this.data);
    }
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Scanner;

/**
 *
 * @author dorae
 */
public class Assignment1New {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Menu menu = new MainMenu();
        //menu.runMenu();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Date: ");
        String date = sc.nextLine();
        
        DateValidator valid = new DateValidator();
        while (!(valid.isValid(date))) {
            System.out.println("Please enter a valid date. It must be in the correct format and not before the current date");
            date = sc.nextLine();
        }
        
        DatesDB dates = new DatesDB(date);
        dates.checkDate();
        
        BookRoom bk = new BookRoom (date);
        
        bk.checkRoomAvailability();
        bk.bookRoom(1);
        bk.checkRoomAvailability();
    }
    
}

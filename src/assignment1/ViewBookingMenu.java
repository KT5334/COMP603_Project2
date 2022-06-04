/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Scanner;

/**
 *
 * @author Group 83 
 */


public class ViewBookingMenu extends Menu{
    
    //header and options prompt
    public ViewBookingMenu()
    {
        this.setHeader("\n+-------------------------------------------+"
                    + "\n|               View Booking                |"
                    + "\n+-------------------------------------------+");
                   
    }
    
    public void veiwBooking()
    {
Scanner scan = new Scanner(System.in);

        System.out.println("To check you booking, please enter your booking reference:");
        String ref = scan.nextLine();

        ViewBooking view = new ViewBooking(ref); 
        
        //checks the user input if it is a valid reference
        while (!(view.validRef())) {
            //prompt the user to try another reference
            System.out.println("Please enter a valid booking reference (dd/mm/yyyylastname): ");
            ref = scan.nextLine();
            
            System.out.println("\n*");
            //saves the new input as bookingRef for view
            view.setBookingRef(ref);
        }
        
        //print booking info
        view.printBooking();

      System.out.println("\nEnter 1 to go back to main menu or 0 to exit");
    }
    

    //runs the cancellation menu
    @Override
    public void runMenu() {
        printMenu();
        veiwBooking();
        checkInput();
        performAction();
    }
   
} 

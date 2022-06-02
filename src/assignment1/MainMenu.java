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
public class MainMenu extends Menu{
    
    //header and options prompt
    public MainMenu()
    {
        this.setHeader("+-------------------------------------------+"
                + "\n|           Welcome to Mini Motel           |"
                + "\n+-------------------------------------------+"
                + "\nYour number 1 overnight place of rest for the solo traveller!"
        
                +"\nPlease enter your selection:"
                + "\n0) To exit"
                + "\n2) Book a room"
                + "\n3) View your booking"
                + "\n4) View FAQ's\n");
    }

    
    //checks if the user's input is valid
    @Override
    public int checkInput()
    {
        Scanner scan = new Scanner(System.in);
        boolean toContinue = true;

        while (toContinue)
        {
            try
            {         
                input = Integer.parseInt(scan.nextLine());
                if(input < 0 || input > 4)
                {
                    throw new IllegalArgumentException();   
                }
                else if (input == 1)
                {
                    throw new IllegalArgumentException();
                }
                toContinue = false;
            }
            catch (NumberFormatException e)
            {
                System.out.println("\nInvalid input. Please try again with a number.");
            }  
            catch(IllegalArgumentException i)
            {
                System.out.println("\nPlease only enter the numbers shown.");
            }
        }
        return input;
    }
    
    
    public void performAction()
    {
        Menu bookingm = new BookingMenu();
        Menu viewm = new ViewBookingMenu();
        Menu faqm = new FaqMenu();
  
        switch (input)
        {
            case 0:
                //exits the program
                System.out.println("\nThe program is now exiting. Have a lovely day!");
                System.exit(0);
                break;
            case 2:
                //goes to the booking menu
                bookingm.runMenu();
                break;
            case 3: 
                //goes to the cancellation menu    
                viewm.runMenu();
                break;
            case 4:
                //goes to the FAQ menu
                faqm.runMenu(); 
                break; 
            default:
                System.out.println("An unknown error has occured");    
        }
    }
    
    
    //runs the main menu
    @Override
    public void runMenu()
    {
        do 
        {
            printMenu();
            checkInput();
            performAction();
        }
        while (input != 1);
        //loops, so it takes the user back to the main menu when the user input a 1
    
    }
}

    
    

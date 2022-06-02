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
public abstract class Menu {
    
    private String header; 
    public int input = -1;
        
    
    //runs the menu
    public abstract void runMenu();

    
    //displays the menu
    public void printMenu()
    {
        System.out.println(this.getHeader());
    }
    
    
    //checks the if the user's input is valid
    public int checkInput()
    {
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        
        while (cont)
        {
            try
            {         
                input = Integer.parseInt(scan.nextLine());
                if(input < 0 || input > 1)
                {
                    throw new IllegalArgumentException();   
                }
                cont = false;
            }
            catch (NumberFormatException e)
            {
                System.out.println("\nInvalid input. Please try again with a number.");
            }  
            catch(IllegalArgumentException i)
            {
                System.out.println("\nNumber out of range. Please enter either 0 or 1 for the above options");
            }
        }
        return input;
    }
    
    
    //the system exits when the user inputs zero
    public void performAction()
    {
        if (input == 0)
            {
                System.out.println("\nThe program is now exiting. Have a lovely day!");
                System.exit(0);
            }
    };
    

    /**
     * @return the header
     */
    public String getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(String header) {
        this.header = header;
    }
    
}

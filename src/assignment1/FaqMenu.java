/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;



/**
 *
 * @author Group 83 
 */
public class FaqMenu extends Menu {
    
    Faq faq = new Faq();
    
    
    //header and options prompt
    public FaqMenu()
    {
        this.setHeader("\n+-------------------------------------------+"
                    + "\n|         Frequently Asked Questions        |"
                    + "\n+-------------------------------------------+"
        
                    +"\nPlease enter your selection:"
                    + "\n0) to exit"
                    + "\n1) to go back\n");      
    }
    
    
    //runs the FAQ menu
    @Override
    public void runMenu() 
    {
            printMenu();
            //displays the FAQ file
            faq.printFaq();
            checkInput();
            performAction();      
    }

    
}

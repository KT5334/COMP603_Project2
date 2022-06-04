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

public class BookingMenu {
    /*
    Scanner scan = new Scanner(System.in);

    public char confirm;

    //header and options prompt
    public BookingMenu() {
        this.setHeader("\n+-------------------------------------------+"
                + "\n|             Create a Booking              |"
                + "\n+-------------------------------------------+"
                + "\nPlease note, one single room per booking for an overnight stay only"
                + "\nPrice: $89 a stay\n");
    }

    public void creatingBooking() {
        //prompts the user to enter their details
        System.out.println("Please enter the following to create a booking:");
        System.out.println("Your first name?");
        String fName = scan.nextLine();
        System.out.println("Your last name?");
        String lName = scan.nextLine();
        System.out.println("Your email?");
        String email = scan.nextLine();
        Guest guest = new Guest(fName, lName, email);
        System.out.println("When would like to book for (dd/mm/yyyy)?");
        String date = scan.nextLine();

        //checks the if the date is valid
        DateValidator valid = new DateValidator();
        while (!(valid.isValid(date))) {
            System.out.println("Please enter a valid date. It must be in the correct format and not before the current date");
            date = scan.nextLine();
        }

        //checks and displays the available rooms
        Availability av = new Availability(date);

        boolean roomAv = true;
        
        while (roomAv) {
            if (av.getRoom().isEmpty()) {
                System.out.println("There are no available room on this date, please choose another date");
                date = scan.nextLine();
                
                while (!(valid.isValid(date))) {
                    System.out.println("Please enter a valid date. It must be in the correct format and not before the current date");
                    date = scan.nextLine();
                }
                av.setRoom(av.checkAvailability(date));
                av.setDate(date);
            } else {

                roomAv = false;
            }
        }

        BookRoom book = new BookRoom(av.getDate(), av.getRoom(), av.getBookedDates());
        book.checkRoomAvailability();

        boolean enterDate = true;

        System.out.println("Select one of the above rooms: ");
        String input = scan.nextLine();

        //checks if the user inputs a valid choice for the room
        while (enterDate) {
            if (book.getRoom().contains(input)) {
                book.bookRoom(input);
                enterDate = false;
            } else {
                System.out.println("Please enter a valid room");
                input = scan.nextLine();
            }

            //creates new booking instance with user input as parameters
            Booking newBk = new Booking(date, input, guest);

            //displays the users booking details for confirmation
            System.out.println("\nBooking for " + guest.getfName() + " " + guest.getlName() + " on the " + date + " for room number: " + newBk.getRoom() + ". Your email is: " + guest.getEmail() + " \nDo you confirm (y/n)?");
            confirm = scan.next().charAt(0);

            if (confirm == 'y' || confirm == 'Y') {
                //creates the guest profile if it does not exist on file
                guest.createGuest();
                //saves the booking 
                book.saveBooking();
                av.setBookedDates(book.getBookedDates());
                //writes the new dates on file
                av.saveDates();
                //creates a new booking record
                newBk.saveRecord();
                System.out.println("\nConfirmed! Thank you for your booking. Here is your booking refernce: "+newBk.getBookingRef()
                        + "\nEnter 1 to go back to main menu or 0 to exit");
            }
        }
        if (confirm == 'n' || confirm == 'N') {
            System.out.println("\nEnter 1 to go back to main menu or 0 to exit");
        }
    }

    //runs the booking menu
    @Override
    public void runMenu() {
        printMenu();
        creatingBooking();
        checkInput();
        performAction();
    }*/

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.util.LinkedList;


/**
 *
 * @author Group ID 83
 */


public class View extends JFrame implements ActionListener{
    
    Faq faq = new Faq();

    //Home Header Variables
    private JPanel headerHomePanel = new JPanel();
    private JLabel homeHeading;
    private JLabel homeLabel;
    private JLabel aboutLabel;
    
    //Home Center Panel Variables
    private BGPanel homePanel = new BGPanel();
    private JLabel promptLabel;
    
    //Home Options Variables
    private JPanel optionsPanel = new JPanel();
    private JButton bookButton;
    private JButton viewButton;
    private JButton faqButton;
    
    //Home and Exit Variables
    private JPanel southPanel = new JPanel();
    private JButton homeButton;
    private JButton exitButton;
    
    //Booking Variables
    private JPanel headerBookPanel = new JPanel();
    private JPanel bookPanel = new JPanel();
    private JLabel bookLabel;
    private JLabel bookDescription;
    private JLabel bookPrice;
    private JLabel bookingPrompt;
    private JLabel fName; 
    private JLabel lName;
    private JLabel email; 
    private JTextField userFName;
    private JTextField userLName;
    private JTextField userEmail;
    private JButton submitUserDets;

    //Date Variables
    private JPanel bookDatePanel = new JPanel();
    private JLabel dateOfStay;
    private JLabel invlaidDate;
    private JTextField userDateOfStay;
    private JButton submitBookDate;
    
    //Room Variables
    private JPanel roomPanel = new JPanel();
    private JLabel roomPrompt;
    private JComboBox<Integer> userRoom;
    private JButton submitRoom;
    
    //Booking Confirmation Variables
    private JPanel confirmationPanel = new JPanel();
    private JLabel bookingConfirmation;
    private JTextArea bkDetsArea;
    private JButton confirmBooking;
    
    //Reference Number Variables
    private JPanel refPanel = new JPanel();
    private JLabel showRef;
            
    //View Booking Variables
    private JPanel headerViewPanel = new JPanel();
    private JPanel viewBookingPanel = new JPanel();
    private JLabel viewLabel;
    private JLabel referencePrompt;
    private JTextField userReference;
    private JTextArea currentBookingArea;
    private JScrollPane vBookingScroll;
    private JButton submitRef;
    
    //Print Booking Variables
    private JPanel printBookingPanel = new JPanel();
    private JLabel bookingDisplayPrompt;
    private JLabel cancelPrompt;
    private JButton cancelButton;

    //Print Booking Variables
    private JPanel cancellationPanel = new JPanel();
     private JLabel cancelConfirmed;
    
    //FAQ Variables
    private JPanel headerFaqPanel = new JPanel();
    private JPanel faqPanel = new JPanel(); 
    private JLabel faqLabel;
    private JTextArea faqArea;
    
    public String custDate = "";
    public String firstN = "";
    public String lastN = "";
    public String custEmail = "";
    public String bkRef = "";
    public int rmNumber = 0;
    public LinkedList<Integer> roomList = new LinkedList<Integer>();
    
    //Main Page
    public View(){
        
        //Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);
        
        //Header Panel
        this.homeHeading = new JLabel("Welcome to Mini Motel!");
        homeHeading.setFont(new Font("Magneto", Font.BOLD, 40));
        homeHeading.setForeground(Color.BLACK);
        
        this.aboutLabel = new JLabel("Your number 1 overnight place of rest for the solo traveller!");
        aboutLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        aboutLabel.setLocation(400, 400);
        aboutLabel.setForeground(Color.RED);
        
        BoxLayout boxLayout = new BoxLayout(headerHomePanel, BoxLayout.Y_AXIS);
        headerHomePanel.setLayout(boxLayout);
        headerHomePanel.setBorder(new EmptyBorder(new Insets(40, 500, 30, 10)));
        headerHomePanel.add(homeHeading);
        headerHomePanel.add(this.aboutLabel);;
        headerHomePanel.setBackground(Color.LIGHT_GRAY);
        this.add(headerHomePanel, BorderLayout.NORTH); 
        
        //Center panel
        this.promptLabel = new JLabel("Please enter your selection on the left");
        promptLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        promptLabel.setForeground(Color.WHITE);
        
        homePanel.add(Box.createRigidArea(new Dimension(50, 200)));
        homePanel.add(this.promptLabel);
        this.add(homePanel, BorderLayout.CENTER);
        
        
       //Options panel
        this.bookButton = new JButton("Book");
        bookButton.setFont(new Font("Magneto", Font.PLAIN, 24));
        bookButton.setForeground(Color.BLACK);
        bookButton.addActionListener(this);
        
        this.viewButton = new JButton("View your booking");
        viewButton.setFont(new Font("Magneto", Font.PLAIN, 24));
        viewButton.setForeground(Color.BLACK);
        viewButton.addActionListener(this);
        
        this.faqButton = new JButton("FAQ");
        faqButton.setFont(new Font("Magneto", Font.PLAIN, 24));
        faqButton.setForeground(Color.BLACK);
        faqButton.addActionListener(this);
        
        BoxLayout boxLayout2 = new BoxLayout(optionsPanel, BoxLayout.Y_AXIS);
        optionsPanel.setLayout(boxLayout2);
        optionsPanel.setBorder(new EmptyBorder(new Insets(150, 10, 30, 10)));
        optionsPanel.add(this.bookButton);
        optionsPanel.add(Box.createRigidArea(new Dimension(10, 100)));
        optionsPanel.add(this.viewButton);
        optionsPanel.add(Box.createRigidArea(new Dimension(10, 100)));
        optionsPanel.add(this.faqButton);
        optionsPanel.add(Box.createRigidArea(new Dimension(10, 100)));
        optionsPanel.setBackground(Color.LIGHT_GRAY);
        this.add(optionsPanel, BorderLayout.WEST);
        
       
        //South Panel - Exit and Home button
        this.exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Magneto", Font.PLAIN, 24));
        exitButton.setForeground(Color.BLACK);
        exitButton.addActionListener(this);
        
        this.homeButton = new JButton("Home");
        homeButton.setFont(new Font("Magneto", Font.PLAIN, 24));
        homeButton.setForeground(Color.BLACK);
        homeButton.addActionListener(this);
        
        FlowLayout fLayout = new FlowLayout();
        fLayout.setAlignment(FlowLayout.RIGHT);
        southPanel.setLayout(fLayout);
        southPanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        southPanel.add(this.homeButton);
        southPanel.add(this.exitButton);
        southPanel.setBackground(Color.LIGHT_GRAY);
        this.add(southPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }


    public void createBooking() { 
        this.getContentPane().removeAll();
        
        //Booking Header
        this.bookLabel = new JLabel("Create a Booking");
        bookLabel.setFont(new Font("Magneto", Font.BOLD, 40));
        bookLabel.setForeground(Color.RED);  
        
        this.bookDescription = new JLabel("Please note, one single room per booking for an overnight stay only");
        bookDescription.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        bookDescription.setForeground(Color.BLACK);
        
        this.bookPrice = new JLabel("Price: $89 a stay");
        bookPrice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        bookPrice.setForeground(Color.BLACK);
        
        BoxLayout boxLayout2 = new BoxLayout(headerBookPanel, BoxLayout.Y_AXIS);
        headerBookPanel.setLayout(boxLayout2);
        headerBookPanel.setBorder(new EmptyBorder(new Insets(20, 400, 30, 10)));
        headerBookPanel.add(this.bookLabel);
        headerBookPanel.add(this.bookDescription);
        headerBookPanel.add(this.bookPrice);
        headerBookPanel.setBackground(Color.LIGHT_GRAY);
        this.add(headerBookPanel, BorderLayout.NORTH); 

        
        //Booking Panel - Users prompt for details
        this.bookingPrompt = new JLabel("Please enter the following to create a booking:");
        bookingPrompt.setFont(new Font("Calibri", Font.PLAIN, 20));
        
        this.fName = new JLabel("First name:");
        fName.setFont(new Font("Calibri", Font.PLAIN, 20));
        this.userFName = new JTextField(20);

        
        this.lName = new JLabel("Last name:");
        lName.setFont(new Font("Calibri", Font.PLAIN, 20));
        this.userLName = new JTextField(20);
        
        
        this.email = new JLabel("Email:");
        email.setFont(new Font("Calibri", Font.PLAIN, 20));
        this.userEmail = new JTextField(30);
        

        this.submitUserDets = new JButton ("Submit");
        submitUserDets.addActionListener(this);
        
        
        bookPanel.add(this.bookingPrompt);
        bookPanel.add(this.fName);
        bookPanel.add(this.userFName);
        bookPanel.add(this.lName);
        bookPanel.add(this.userLName);
        bookPanel.add(this.email);
        bookPanel.add(this.userEmail);
        bookPanel.add(this.submitUserDets);
        bookPanel.setBackground(Color.WHITE);
        this.add(bookPanel, BorderLayout.CENTER);


        //South Panel - Exit and Home button
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.revalidate();
        this.repaint();
          
    }
    
    //Check date availability
    public void checkDate(){
        //Heading
        this.getContentPane().removeAll();
        this.add(headerBookPanel, BorderLayout.NORTH); 
        
        //Center Panel
        this.dateOfStay = new JLabel("Date of stay: (dd-mm-yyyy)");
        dateOfStay.setFont(new Font("Calibri", Font.PLAIN, 20));
        this.invlaidDate = new JLabel("Please keep entering until it is a valid date");
        invlaidDate.setFont(new Font("Calibri", Font.PLAIN, 20));
        this.userDateOfStay = new JTextField(8);
        this.submitBookDate = new JButton ("Check Availability");
        submitBookDate.addActionListener(this);
        

        bookDatePanel.add(this.dateOfStay);
        bookDatePanel.add(this.invlaidDate);
        bookDatePanel.add(this.userDateOfStay);
        bookDatePanel.add(this.submitBookDate);
        bookDatePanel.setBackground(Color.WHITE);
        this.add(bookDatePanel, BorderLayout.CENTER);
        
        //South Panel - Exit and Home button
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.revalidate();
        this.repaint();
    }
    
    public void selectRoom(){
        BookRoom bkRoom = new BookRoom(custDate);
        bkRoom.checkRoomAvailability();
        roomList = bkRoom.getAvailableRooms();

        //Heading
        this.getContentPane().removeAll();
        this.add(headerBookPanel, BorderLayout.NORTH); 
        
        //Center Panel
        this.roomPrompt = new JLabel("Select one of the rooms:");
        roomPrompt.setFont(new Font("Calibri", Font.PLAIN, 20));
        this.userRoom = new JComboBox();
        
        //adds available rooms to combo box
        for(Integer list : roomList){
            userRoom.addItem(list);
        }
        userRoom.addActionListener(this);
        
        this.submitRoom = new JButton ("Submit");
        submitRoom.addActionListener(this);
        
        roomPanel.add(this.roomPrompt);
        roomPanel.add(this.userRoom);
        roomPanel.add(this.submitRoom);
        roomPanel.setBackground(Color.WHITE);
        this.add(roomPanel, BorderLayout.CENTER);
        
        //South Panel - Exit and Home button
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.revalidate();
        this.repaint();
    }
    
    public void confirmBooking(){
        //Heading
        this.getContentPane().removeAll();
        this.add(headerBookPanel, BorderLayout.NORTH); 
        
        //Center Panel
        this.bookingConfirmation = new JLabel("Here is your booking details, to confirm press book.");
        bookingConfirmation.setFont(new Font("Calibri", Font.PLAIN, 20));
        
        this.bkDetsArea = new JTextArea("Date: " +custDate+ " Name: " +firstN+" "+lastN+ " Room: " +rmNumber);
        bkDetsArea.setFont(new Font("Calibri", Font.PLAIN, 20));
        
        this.confirmBooking = new JButton ("Book");
        confirmBooking.addActionListener(this);
        
        confirmationPanel.add(this.bookingConfirmation);
        confirmationPanel.add(this.bkDetsArea);
        confirmationPanel.add(this.confirmBooking);
        confirmationPanel.setBackground(Color.WHITE);
        this.add(confirmationPanel, BorderLayout.CENTER);
        
        //South Panel - Exit and Home button
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.revalidate();
        this.repaint();
    }
    
    public void displayReference(){
        //Heading
        this.getContentPane().removeAll();
        this.add(headerBookPanel, BorderLayout.NORTH); 
        
        //Center Panel
        this.showRef = new JLabel("Confirmed! Thank you for your booking. Here is your booking reference number:" +bkRef);
        showRef.setFont(new Font("Calibri", Font.PLAIN, 20));

        refPanel.add(this.showRef);
        refPanel.setBackground(Color.WHITE);
        this.add(refPanel, BorderLayout.CENTER);
        
        //South Panel - Exit and Home button
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.revalidate();
        this.repaint();
    }
    
    public void viewBooking(){
        
        this.getContentPane().removeAll();
        
        //View Booking Header
        this.viewLabel = new JLabel("View Booking");
        viewLabel.setFont(new Font("Magneto", Font.BOLD, 40));
        viewLabel.setForeground(Color.RED);
        
        headerViewPanel.add(viewLabel);
        headerViewPanel.setBackground(Color.LIGHT_GRAY);
        this.add(headerViewPanel, BorderLayout.NORTH); 
        
        
        //View Booking Panel
        this.referencePrompt = new JLabel("To check you booking, please enter your booking reference:");
        referencePrompt.setFont(new Font("Calibri", Font.PLAIN, 20));
        this.userReference = new JTextField(15);
        
        this.submitRef = new JButton ("Submit");
        submitRef.addActionListener(this);
        
        viewBookingPanel.add(this.referencePrompt);
        viewBookingPanel.add(this.userReference);
        viewBookingPanel.add(this.submitRef);
        viewBookingPanel.setBackground(Color.WHITE);
        this.add(viewBookingPanel, BorderLayout.CENTER);
        
        
        //South Panel - Exit and Home button
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.revalidate();
        this.repaint();
    }
    
    public void getBooking(){
        this.getContentPane().removeAll();
        
        //View Booking Header
        this.add(headerViewPanel, BorderLayout.NORTH); 
        
        //Print Booking
        this.bookingDisplayPrompt = new JLabel("Here is your booking: " + bkRef + " Name: " +firstN+" "+lastN+ " Room: " +rmNumber);
        bookingDisplayPrompt.setFont(new Font("Calibri", Font.BOLD, 20));
        
        this.cancelPrompt = new JLabel("Would you like to cancel your booking? Otherwise click Home or Exit button");
        cancelPrompt.setFont(new Font("Calibri", Font.PLAIN, 20));
        
        this.cancelButton = new JButton ("CANCEL Booking");
        cancelButton.addActionListener(this);
        
        printBookingPanel.setBackground(Color.WHITE);
        printBookingPanel.add(bookingDisplayPrompt);
        printBookingPanel.add(cancelPrompt);
        printBookingPanel.add(cancelButton);
        this.add(printBookingPanel, BorderLayout.CENTER);
        
        //South Panel - Exit and Home button
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.revalidate();
        this.repaint();
    }
    
    public void cancelBooking(){
        //View Booking Header
        this.add(headerViewPanel, BorderLayout.NORTH); 
        
        //Print Booking
        this.cancelConfirmed = new JLabel("Your booking has been cancelled!");
        cancelConfirmed.setFont(new Font("Calibri", Font.PLAIN, 20));
        
        cancellationPanel.setBackground(Color.WHITE);
        cancellationPanel.add(cancelConfirmed);
        this.add(cancellationPanel, BorderLayout.CENTER);
        
        //South Panel - Exit and Home button
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.revalidate();
        this.repaint();
    }
           
    public void viewFaq(){
        this.getContentPane().removeAll();

        Faq faq = new Faq();
        
        //FAQ Header
        this.faqLabel = new JLabel("Frequently Asked Questions");
        faqLabel.setFont(new Font("Magneto", Font.BOLD, 40));
        faqLabel.setForeground(Color.RED);
        
        headerFaqPanel.add(faqLabel);
        headerFaqPanel.setBackground(Color.LIGHT_GRAY);
        this.add(headerFaqPanel, BorderLayout.NORTH); 
        
        //FAQ Center Panel
        this.faqArea = new JTextArea(faq.printFaq());
        faqArea.setFont(new Font("Calibri", Font.PLAIN, 20));
    //    faqArea.setBounds(10,70, 1360,550);
        
        
        faqPanel.add(faqArea);
        faqPanel.setBackground(Color.WHITE);
        this.add(faqPanel, BorderLayout.CENTER);
        
        //South Panel - Exit and Home button
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.revalidate();
        this.repaint();

    }
   

   @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.homeButton)
        {
            this.dispose();
            new View();
        }
        else if(e.getSource() == this.exitButton)
        {
            System.exit(0);  
        }
        else if(e.getSource() == this.bookButton)
        {
            this.createBooking();   
        }
        if(e.getSource() == this.submitUserDets)
        {
            firstN = userFName.getText();
            lastN = userLName.getText();
            custEmail = userEmail.getText();
            Guest guest = new Guest(firstN, lastN, custEmail);
            guest.createGuest();
            
            this.checkDate(); 
            //needs to check date availability
        }
        else if(e.getSource() == this.submitBookDate)
        {
            custDate = userDateOfStay.getText();
            DateValidator validator = new DateValidator();
            if ((validator.isValid(custDate))) {
                DatesDB dateDB = new DatesDB(custDate);
                dateDB.checkDate();
                this.selectRoom();    
            } 
     
        }
        else if(e.getSource() == this.submitRoom)
        {
            rmNumber = (Integer)userRoom.getSelectedItem();
            this.confirmBooking();            
        }
        else if(e.getSource() == this.confirmBooking)
        {
            Guest guestBk = new Guest(firstN, lastN, custEmail);
            BookRoom conBk = new BookRoom(custDate);
            conBk.bookRoom(rmNumber);
            
            Booking connBk = new Booking(custDate, rmNumber, guestBk);
            connBk.createBooking();
            bkRef = connBk.getBookingRef();
            
            this.displayReference(); 
            
        }
        else if(e.getSource() == this.viewButton)
        {
  
                this.viewBooking();   
            
        }
        else if(e.getSource() == this.submitRef)
        {
            bkRef = userReference.getText();
            ManageBooking mgmtBook = new ManageBooking();
            
            if ((mgmtBook.validBooking(bkRef))) {
                
                firstN = mgmtBook.getfName();
                lastN = mgmtBook.getlName();
                rmNumber = mgmtBook.getRoomNo();
                this.getBooking();
                
            } 

        }
        else if(e.getSource() == this.cancelButton)
        {
            ManageBooking mgntBk = new ManageBooking();
            mgntBk.validBooking(bkRef);
            mgntBk.cancelBooking();
          
            this.cancelBooking();
        }
        else if(e.getSource() == this.faqButton)
        {
            this.viewFaq();
        }        
        revalidate();
        repaint();   
    } 
    

}

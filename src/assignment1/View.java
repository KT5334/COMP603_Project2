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


/**
 *
 * @author dorae
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
    private JTextField userDateOfStay;
    private JButton submitBookDate;
    
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
    
    //FAQ Variables
    private JPanel headerFaqPanel = new JPanel();
    private JPanel faqPanel = new JPanel(); 
    private JLabel faqLabel;
    private JLabel faqArea;
    
    
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
        this.fName = new JLabel("First name:");
        this.userFName = new JTextField(20);
        this.lName = new JLabel("Last name:");
        this.userLName = new JTextField(20);
        this.email = new JLabel("Email:");
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
        this.dateOfStay = new JLabel("Date of stay: (dd/mm/yyyy)");
        this.userDateOfStay = new JTextField(8);
        this.submitBookDate = new JButton ("Check Availability");
        submitBookDate.addActionListener(this);
        
        bookDatePanel.add(this.dateOfStay);
        bookDatePanel.add(this.userDateOfStay);
        bookDatePanel.add(this.submitBookDate);
        bookDatePanel.setBackground(Color.WHITE);
        this.add(bookDatePanel, BorderLayout.CENTER);
        
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
        this.userReference = new JTextField(15);
        
        this.submitRef = new JButton ("Submit");
        submitRef.addActionListener(this);
        
        
    /**    this.currentBookingArea = new JTextArea();
        currentBookingArea.setBounds(1000,1000, 1360,580);
        currentBookingArea.setEditable(false);
        
        this.vBookingScroll = new JScrollPane(currentBookingArea);  
        vBookingScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); **/
        
    //    viewBookingPanel.add(vBookingScroll);
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
        this.bookingDisplayPrompt = new JLabel("Here is your booking:");
        
        printBookingPanel.setBackground(Color.WHITE);
        printBookingPanel.add(bookingDisplayPrompt);
        this.add(printBookingPanel, BorderLayout.CENTER);
        
        //South Panel - Exit and Home button
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.revalidate();
        this.repaint();
    }
            
    
    public void viewFaq(){
        this.getContentPane().removeAll();

        //FAQ Header
        this.faqLabel = new JLabel("Frequently Asked Questions");
        faqLabel.setFont(new Font("Magneto", Font.BOLD, 40));
        faqLabel.setForeground(Color.RED);
        
        headerFaqPanel.add(faqLabel);
        headerFaqPanel.setBackground(Color.LIGHT_GRAY);
        this.add(headerFaqPanel, BorderLayout.NORTH); 
        
        //FAQ Center Panel
        this.faqArea = new JLabel("");
        faqArea.setBounds(10,70, 1360,550);
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
            //submit button needs to work
            if(e.getSource() == this.submitUserDets)
            {
                //needs to check date availability
                this.checkDate();
                    if(e.getSource() == this.submitBookDate)
                    {
                        
                    }
            }
        }
        else if(e.getSource() == this.viewButton)
        {
            this.viewBooking();
            //needs to check user input
        }
        else if(e.getSource() == this.submitRef)
        {
            //need to print booking
            this.getBooking();
        }
        else if(e.getSource() == this.faqButton)
        {
            //need to print booking
            this.viewFaq();
        }        
        revalidate();
        repaint();   
    } 
    

}

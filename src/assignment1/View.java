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

    private JPanel headerPanel = new JPanel();
    private BGPanel homePanel = new BGPanel();
    private JPanel optionsPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    
    private JPanel bookPanel = new JPanel();
    private JPanel viewBookingPanel = new JPanel();
    private JPanel faqPanel = new JPanel();
    
    private JLabel heading;
    private JLabel homeLabel;
    private JLabel aboutLabel;
    private JLabel promptLabel;
    private JLabel faqLabel;
    private JLabel viewLabel;
    private JLabel bookLabel;
    
    private JButton homeButton;
    private JButton bookButton;
    private JButton viewButton;
    private JButton faqButton;
    private JButton exitButton;
    
    private JTextArea faqArea;
    private JTextArea currentBookingArea;
    private JScrollPane vBookingScroll;
    
    
    //Main Page
    public View(){
        
        //Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);
        
        //Header Panel
        this.heading = new JLabel("Welcome to Mini Motel!");
        heading.setFont(new Font("Magneto", Font.BOLD, 40));
        heading.setForeground(Color.BLACK);
        
        this.aboutLabel = new JLabel("Your number 1 overnight place of rest for the solo traveller!");
        aboutLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        aboutLabel.setLocation(400, 400);
        aboutLabel.setForeground(Color.WHITE);
        
        BoxLayout boxLayout = new BoxLayout(headerPanel, BoxLayout.Y_AXIS);
        headerPanel.setLayout(boxLayout);
        headerPanel.setBorder(new EmptyBorder(new Insets(40, 500, 30, 10)));
        headerPanel.add(heading);
        headerPanel.add(this.aboutLabel);;
        headerPanel.setBackground(Color.LIGHT_GRAY);
        this.add(headerPanel, BorderLayout.NORTH); 
        
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
        
        this.viewButton = new JButton("View your booking");
        viewButton.setFont(new Font("Magneto", Font.PLAIN, 24));
        viewButton.setForeground(Color.BLACK);
        
        this.faqButton = new JButton("FAQ");
        faqButton.setFont(new Font("Magneto", Font.PLAIN, 24));
        faqButton.setForeground(Color.BLACK);
        
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
        
        this.homeButton = new JButton("Home");
        homeButton.setFont(new Font("Magneto", Font.PLAIN, 24));
        homeButton.setForeground(Color.BLACK);
        
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


/**    public void createBooking() { 
        bookPanel.add(this.bookLabel);
        bookPanel.setBackground(Color.LIGHT_GRAY);
        bookPanel.setPreferredSize(new Dimension(1000,800));
        
        this.bookLabel = new JLabel("Create a Booking");
        bookLabel.setFont(new Font("Magneto", Font.BOLD, 30));
        bookLabel.setLocation(150, 200);
        bookLabel.setForeground(Color.RED);  
        
        this.getContentPane().removeAll();
        bookPanel.setVisible(true);
        this.add(bookPanel);
        this.revalidate();
        this.repaint();

    }**/
    
/**   public void viewBooking(){
        viewBookingPanel.add(this.viewLabel);
        viewBookingPanel.setBackground(Color.LIGHT_GRAY);
        viewBookingPanel.setPreferredSize(new Dimension(1000,800));
        viewBookingPanel.add(vBookingScroll);
        viewBookingPanel.setSize(1000,1000);  
        //viewBookingPanel.setLayout(null);  
        viewBookingPanel.setVisible(true);
        
        this.viewLabel = new JLabel("View Booking");
        viewLabel.setFont(new Font("Magneto", Font.BOLD, 30));
        viewLabel.setLocation(150, 200);
        viewLabel.setForeground(Color.RED);
        
        this.currentBookingArea = new JTextArea();
        currentBookingArea.setBounds(1000,1000, 1360,580);
        currentBookingArea.setEditable(false);
        
        this.vBookingScroll = new JScrollPane(currentBookingArea);  
        vBookingScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        
        viewBookingPanel.setVisible(true);
    }**/
    
/**    public void viewFaq(){
        
        Faq faq = new Faq();
        
        faqPanel.add(this.faqLabel);
        faqPanel.setBackground(Color.LIGHT_GRAY);
        faqPanel.setPreferredSize(new Dimension(100,800));
        faqPanel.add(faqArea);
        faqPanel.setSize(1000,1000);  
        faqPanel.setLayout(null);  
        faqPanel.setVisible(true);
        this.add(homePanel, BorderLayout.CENTER);
       
        this.faqLabel = new JLabel("Frequently Asked Questions");
        faqLabel.setFont(new Font("Magneto", Font.BOLD, 30));
        faqLabel.setLocation(10, 0);
        faqLabel.setForeground(Color.RED);
        
        
        this.faqArea = new JTextArea();
        faqArea.setBounds(10,70, 1360,550);
        faqArea.setEditable(false);
        bookPanel.setVisible(true);
    }**/
   
    public void addActionListener()
    {
        this.homeButton.addActionListener(this);
        this.bookButton.addActionListener(this);
        this.viewButton.addActionListener(this);
        this.faqButton.addActionListener(this);
        this.exitButton.addActionListener(this);
    }

   @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.homeButton)
        {
            this.dispose();
            new Frame();
        }
        else if(e.getSource() == this.exitButton)
        {
            System.exit(0);  
        }
       else
        {
            getContentPane().remove(homePanel); 
            getContentPane().remove(optionsPanel);
            
            if(e.getSource() == this.faqButton)
            {
                getContentPane().add(faqPanel); 
             }
            else if(e.getSource() == this.viewButton)
            {
                getContentPane().add(viewBookingPanel);
            }
            else if(e.getSource() == this.bookButton)
            {
                getContentPane().add(bookPanel);  
            } 
            
            this.revalidate();
            this.repaint();
        } 
    }

}

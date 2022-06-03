package assignment1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Group 83
 */
public class Guest {
    
    private String fName;
    private String lName;
    private String email;
    
    HotelDB db;
    Statement statement;
    Connection conn;
    
    public Guest (String first, String last, String email){
        db = new HotelDB();
        conn = db.getConnection();
        try{
            statement = conn.createStatement();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        this.fName = first;
        this.lName = last;
        this.email = email;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    //adds guest info in database if email is valid
    public void createGuest(){
   
        String table = "GUEST";
        
        //statement to insert email, last name and first name values in lower case to table
        String insert = "INSERT INTO " + table + " values("
                    +"'"+this.getEmail().toLowerCase()+"', "
                    +"'"+this.getlName().toLowerCase()+"', "
                    +"'"+this.getfName().toLowerCase()+"')";
        if(!this.checkEmail()){
            try {
                this.statement.executeUpdate(insert);
            } catch (SQLException ex) {
                Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        } else{
                System.out.println("Email already in use");
            }
        
        db.closeConnections();
        
    }
    //checks email if it already exist in the database return true if exists
    public boolean checkEmail(){
        boolean emailExist = false;
           
        String table = "GUEST";
        
        try{
            //checks if table exist and if not create it
            DatabaseMetaData databaseMetadata = db.getConnection().getMetaData();
            ResultSet resultSet = databaseMetadata.getTables(null, null, "GUEST", null);
            
            if(resultSet.next()){
                System.out.println("Table Exist");
                String findGuest = "SELECT * FROM "+ table +" WHERE EMAIL = '"+this.getEmail().toLowerCase()+"'";
                
                ResultSet rs = this.statement.executeQuery(findGuest);
                
                if(rs.next()){
                    emailExist = true;
                }
            }
            else{
                String create = "CREATE TABLE " + table + "(EMAIL VARCHAR (50),"
                        +"LASTNAME VARCHAR (30),"
                        +"FIRSTNAME VARCHAR (30), PRIMARY KEY (EMAIL))";
                
                this.statement.executeUpdate(create);
                System.out.println("Table created");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emailExist;
      }
    
    @Override
    public String toString(){
        return "Email: "+this.getEmail() + "- Guest Name: " + this.getlName() +", "+ this.getfName();
    }
    
}

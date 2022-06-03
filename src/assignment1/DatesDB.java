/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Group 83
 */
public class DatesDB {

    private String date;

    HotelDB db;
    Statement statement;
    Connection conn;

    public DatesDB(String date) {
        db = new HotelDB();
        conn = db.getConnection();
        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        this.date = date;
    }

    //check input date if a database exists if not create it and populate the values
    public void checkDate() {

        String table = this.getDate();

        try {
            //checks if table exist and if not create it
            DatabaseMetaData databaseMetadata = db.getConnection().getMetaData();
            ResultSet resultSet = databaseMetadata.getTables(null, null, "d"+table, null);

            if (resultSet.next()) {
                System.out.println("Date table Exist");

            } else {
                String create = "CREATE TABLE \"d" + table + "\" (ROOMNO int not null,"
                        + "AVAILABLE VARCHAR (5), PRIMARY KEY (ROOMNO))";

                this.statement.executeUpdate(create);
                System.out.println("Date created");

                String sqlInsert = "insert into \"d" + table + "\" values("
                        + "1, 'YES')," + "("
                        + "2, 'YES')," + "("
                        + "3, 'YES')," + "("
                        + "4, 'YES')," + "("
                        + "5, 'YES')," + "("
                        + "6, 'YES')," + "("
                        + "7, 'YES')," + "("
                        + "8, 'YES')," + "("
                        + "9, 'YES')," + "("
                        + "10, 'YES')";

                this.statement.executeUpdate(sqlInsert);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        db.closeConnections();
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }
}

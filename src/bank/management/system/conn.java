package bank.management.system;

import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//register driver
//create connection
//create statement
//execute query
//close connection

public class conn {
        Connection c;
        Statement s;
        public conn(){
            try {
               // Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankmanagementsystem", "postgres", "Latha@942");
                s = c.createStatement();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    public static void main(String[] args) {

    }
    }


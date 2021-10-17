/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.*;

/**
 *
 * @author Asus
 */
public class JDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String query = null;
        Connection conn = null;
        Statement statement = null;
        
        try {
            System.out.println("Connecting to mysql...");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            
            System.out.println("Success connect to mysql");
            System.out.println("Creating database for ebookshop_fiandimas...");
            
            statement = conn.createStatement();
            
            query = "CREATE DATABASE IF NOT EXISTS ebookshop_fiandimas";
            statement.execute(query);
            
            System.out.println("Success create ebookshop_fiandimas database");
            System.out.println("Creating books table for ebookshop_fiandimas database...");
        
            query = "CREATE TABLE IF NOT EXISTS `ebookshop_fiandimas`.`books` ( `id` INT NOT NULL , `title` VARCHAR(50) NOT NULL , `author` VARCHAR(50) NOT NULL , `price` FLOAT NOT NULL , `qty` INT NOT NULL , PRIMARY KEY (`id`));";
            statement.execute(query);
            
            System.out.println("Success create books table");
            System.out.println("Inserting dummy data for books table...");
            
            query = "INSERT INTO `ebookshop_fiandimas`.`books` (`id`, `title`, `author`, `price`, `qty`) VALUES ('1001', 'Java for dummies', 'Tan Ah Teck', '11.11', '11'), ('1002', 'More Java for dummies', 'Tan Ah Teck', '22.22', '22'), ('1003', 'More Java for more dummies', 'Mohammad Ali', '33.33', '33'), ('1004', 'A Cup of Java', 'Kumar', '44.44', '44'), ('1005', 'A Teaspoon of Java', 'Kevin Jones', '55.55', '55')";
            statement.execute(query);
            
            System.out.println("Success insert dummy data");
            
            System.out.println("Database: ebookshop_fiandimas");
            System.out.println("Table: books");
            query = "SELECT * FROM `ebookshop_fiandimas`.`books`";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                String id = result.getString("id");
                String title = result.getString("title");
                String author = result.getString("author");
                String price = result.getString("price");
                String qty = result.getString("qty");
                System.out.println(id  + " | " + title + " | " + author + " | " + price + " | " + qty);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
    }
}

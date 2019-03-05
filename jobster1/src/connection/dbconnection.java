package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {

   public Connection getConnection() {
       try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/sydbase","system","Yippass1");
           System.out.println("Connected to DB");
           return con;
       } catch (ClassNotFoundException e) {
    	   System.out.println("Not Connected to DB");
           e.printStackTrace();
       } catch (SQLException e) {
    	   System.out.println("Not Connected to DB");
           e.printStackTrace();
       }
       return null;
   }
}
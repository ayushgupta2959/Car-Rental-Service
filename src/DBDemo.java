import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBDemo {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    // Load the JDBC driver
    Class.forName("org.mariadb.jdbc.Driver");
    System.out.println("Driver loaded");

    // Try to connect
    Connection connection = DriverManager.getConnection
      ("jdbc:mysql://localhost/carService", "root", "home");

      PreparedStatement stmt=connection.prepareStatement("select * from Driver");
      ResultSet rs = stmt.executeQuery();
      while(rs.next()){  
      System.out.println(rs.getInt(1)+" "+rs.getString(2));  
      }

    System.out.println("It works!");

    connection.close();
  }
}
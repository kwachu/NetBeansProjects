/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;


//import dbconnect.MySQLAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
/**
 *
 * @author kwachu
 */
public class DBconnect {

    
          //private Connection connect = null;
          //private Statement statement = null;
          //private PreparedStatement preparedStatement = null;
          //private ResultSet resultSet = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
       Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection conn = DriverManager.getConnection
   ("jdbc:mysql://localhost:3306/javaDB", "javaDB", "javapass");

Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM `test_tab`");
String name;
name = rs.getString(1);
System.out.print(name);
stmt.close();
conn.close();
    }    
}


/**
 ZAPYTANIE DODAJCE
 INSERT INTO `javaDB`.`test_tab` (`name`, `test_tab_id`, `surname`, `age`) VALUES ('Jan', '1', 'Nowak', '44');
 
 POKAZUJACE
 
 
 **/
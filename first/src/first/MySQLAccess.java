package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Date;


public class MySQLAccess {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  public void readDataBase() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/javaDB?"
              + "user=javaDB&password=javapass");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      
      resultSet = statement.executeQuery("select * from test_tab");
      writeResultSet(resultSet);
      //writeMetaData(resultSet);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  public void writeDataBase(String[] tab) throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/javaDB?"
              + "user=javaDB&password=javapass");
      
      
      preparedStatement = connect.prepareStatement("INSERT INTO javaDB.test_tab (name, surname, age) VALUES (?, ?, ?)");

      preparedStatement.setString(1, tab[0]);
      preparedStatement.setString(2, tab[1]);
      preparedStatement.setString(3, tab[2]);

      preparedStatement.executeUpdate();
      
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }
  
  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      String user = resultSet.getString("name");
      String surname = resultSet.getString("surname");
      String age = resultSet.getString("age");
      //String website = resultSet.getString'("webpage");
      //String summery = resultSet.getString("summery");
      //int date = resultSet.getString("age").toString();
      //String comment = resultSet.getString("comments");
      System.out.println("User: " + user);
      System.out.println("Surname: " + surname);
      System.out.println("Age: " + age);
      //System.out.println("Website: " + website);
      //System.out.println("Summery: " + summery);
      //System.out.println("Date: " + date);
      //System.out.println("Comment: " + comment);
    }
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

} 
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
      
      resultSet = statement.executeQuery("select * from czlowiek");
      writeResultSet(resultSet);
      //writeMetaData(resultSet);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }
  
    public void readDBuser() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/javaDB?"
              + "user=javaDB&password=javapass");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      
      resultSet = statement.executeQuery("select * from czlowiek");
      writeResultSet(resultSet);
      //writeMetaData(resultSet);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }
  
  public void readDBzaloga(int nr) throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/javaDB?"
              + "user=javaDB&password=javapass");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      
      resultSet = statement.executeQuery("select * from czlowiek");
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
  
  public void addDBuser(String[] tab) throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/javaDB?"
              + "user=javaDB&password=javapass");
      
      
      preparedStatement = connect.prepareStatement("INSERT INTO javaDB.czlowiek (nazwisko, imie, urodziny, numer_legitymacji) VALUES (?, ?, ?, ?)");

      preparedStatement.setString(1, tab[0]);
      preparedStatement.setString(2, tab[1]);
      preparedStatement.setString(3, tab[2]);
      preparedStatement.setString(4, tab[3]);

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

    while (resultSet.next()) {

      String user = resultSet.getString("imie");
      String surname = resultSet.getString("nazwisko");
      String age = resultSet.getString("urodziny");
      String nr_leg = resultSet.getString("numer_legitymacji");

      if (user != ""){ 
          System.out.print("Imie: " + user + "   "); 
      }
      if ( surname != "") 
          System.out.println("Nazwisko: " + surname);
      if ( age != "")
          System.out.println("Data ur.: " + age);
      if (nr_leg != "")
          System.out.println("Legitymacja: " + nr_leg);

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
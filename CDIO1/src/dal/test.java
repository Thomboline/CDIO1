
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class test 
{
  public static void main(String[] argv) throws Exception 
  {
    String driverName = "com.jnetdirect.jsql.JSQLDriver";
    Class.forName(driverName);

    String serverName = "127.0.0.1";
    String portNumber = "1433";
    String mydatabase = serverName + ":" + portNumber;
    String url = "jdbc:JSQLConnect://" + mydatabase;
    String username = "username";
    String password = "password";

    Connection connection = DriverManager.getConnection(url, username, password);
    Statement stmt = connection.createStatement();
    String sql = "UPDATE my_table SET col_string='a new string' WHERE col_string = 'a string'";
    int updateCount = stmt.executeUpdate(sql);

  }
} 
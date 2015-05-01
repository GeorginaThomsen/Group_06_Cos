
package datasource;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Georgina Thomsen
 */
public class DBCommunication {
    
    private static String JDBC_Driver = "oracle.jdbc.driver.OracleDriver";//Can I make this final?
    private static String URL = "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat";//Can I make this final?
    private static String user = "cphgt44";//Put in your Oracle username.
    private static String pass = "cphgt44";//Put in your Oracle password.
    
    private Connection conn;//Can I make this non-private
    
    //Singleton:
    private static DBCommunication instance;

    private DBCommunication(){
       
        //'try catch' to catch ClassNotFoundException & SQLException.
        try{
        //Register JDBC driver:
        Class.forName(JDBC_Driver);
        //Open communication:
        conn = DriverManager.getConnection(URL, user, pass);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static DBCommunication getInstance(){
        //Singleton instance is not created until the getInstance() method is called for the first time. 
        //Ensures that singleton instances are created only when needed and only one connection at a time.
        if(instance == null)
            instance = new DBCommunication();
        return instance;
    }
    //I'm not sure about this:
    public Connection getConnection(){
        return conn;
    }
    
    
    
}

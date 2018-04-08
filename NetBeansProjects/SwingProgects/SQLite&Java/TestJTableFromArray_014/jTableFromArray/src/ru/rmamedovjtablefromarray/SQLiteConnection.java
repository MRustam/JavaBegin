package ru.rmamedovjtablefromarray;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SQLiteConnection {
    
    private static Connection con;
    
    public static Connection getConnection(){
        try {
            
             Driver driver = (Driver) Class.forName("org.sqlite.JDBC").newInstance();

              // создание подключение к базе данных по пути, указанному в урле
              String url = "jdbc:sqlite:../../TestJTableFromArray_014/Transport_market.db"; // БД будет браться из текущей папки, где запускается проект
              
              if (con == null) con = DriverManager.getConnection(url);
              
              return con;
              
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

}

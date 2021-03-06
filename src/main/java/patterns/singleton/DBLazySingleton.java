package patterns.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Arkadiusz.Ptak on 04.12.2017.
 *
 *
 */
public class DBLazySingleton {

    private static DBLazySingleton instance = null; // nie tworzy odrazu wszystkich instancji przy starcie apki (performance)
    private Connection conn = null;
    private DBLazySingleton(){

        try{
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBLazySingleton getInstance(){
        if(instance==null){// nie tworzy odrazu wszystkich instancji przy starcie apki (performance)
                    synchronized (DBLazySingleton.class) { //zabezpieczenie przy wielu watkach, zeby tylko 1sze odwolanie tworzylo
                        if(instance==null) {
                            instance = new DBLazySingleton();
                        }

            }
        }
        return instance;
    }
    public Connection getConnection(){
        if(conn==null){
            synchronized (DBLazySingleton.class) {
                if(conn==null) {
                    try {
                        String dBUrl = "jdbc:derby:memory:codejava/wedb;create=true";
                        conn = DriverManager.getConnection(dBUrl);
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }

            }
        }
        return conn;
    }
}

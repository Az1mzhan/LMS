package connection;

import java.sql.*;

public class PostgresConnectionSingleton implements IDB {
    private static PostgresConnectionSingleton instance;
    private static final String connectionUrl = "jdbc:postgresql://localhost:8000/LMS";
    private static final String user = "postgres";
    private static final String password = " ";
    private static Connection con;
    private PostgresConnectionSingleton() throws SQLException, ClassNotFoundException {
        // Here we load the driver’s class file into memory at the runtime
        Class.forName("org.postgresql.Driver")  ;
        // Establish the connection
        System.out.println(connectionUrl+ user+ password);
        con = DriverManager.getConnection(connectionUrl, user, password);
    }
    public static PostgresConnectionSingleton getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null)
            instance = new PostgresConnectionSingleton();
        return instance;
    }
    @Override
    public Connection getConnection() {
        return instance.con;
    }

}
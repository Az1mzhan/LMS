package connection;

import java.sql.*;

public class PostgresConnectionSingleton implements IDB {
    private static PostgresConnectionSingleton instance;
    private static final String connectionUrl = "jdbc:postgresql://localhost:8000/postgres";
    private static final String user = "postgres";
    private static final String password = " ";
    private Connection con;
    private PostgresConnectionSingleton() {
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");
            // Establish the connection
            con = DriverManager.getConnection(connectionUrl, user, password);
        } catch (Exception e) {
            System.out.println(e);
            con = null;
        }
    }
    public static PostgresConnectionSingleton getInstance() {
        if (instance == null)
            instance = new PostgresConnectionSingleton();
        return instance;
    }
    @Override
    public Connection getConnection() {
        return con;
    }
}
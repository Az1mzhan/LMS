package connection;

import java.sql.*;

public class PostgresConnection implements IDB {
    @Override
    public Connection getConnection() throws SQLException  {
        String connectionUrl = "jdbc:postgresql://localhost:8000/postgres";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", " ");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
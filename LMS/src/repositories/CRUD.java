package repositories;
import java.sql.SQLException;
import java.util.*;

public interface CRUD {
    void create () throws ClassNotFoundException, SQLException;
    List<Object> getAll() throws SQLException;
    void update () throws SQLException;
    void delete() throws SQLException ;
}

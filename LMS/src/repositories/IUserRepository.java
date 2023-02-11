package repositories;

import java.util.List;
import model.entities.User;

public interface IUserRepository {
    boolean createUser(User user);
    User getUser(int id);
    List<User> getAllUsers();
}

package by.tms.petstore.inMemoryDao;

import by.tms.petstore.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    User save(User user);
    List<User> saveList(List<User> users);
    Optional<User> findByUsername(String username);
    Optional<User> updateByUsername(String username, User user);
    Optional<User> deleteUser(String username);
}

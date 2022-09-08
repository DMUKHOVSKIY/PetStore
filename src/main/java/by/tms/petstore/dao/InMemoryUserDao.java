package by.tms.petstore.dao;

import by.tms.petstore.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryUserDao implements UserDao {
    private List<User> userList = new ArrayList();

    @Override
    public User save(User user) {
        userList.add(user);
        return user;
    }

    @Override
    public List<User> saveList(List<User> users) {
        userList.addAll(users);
        return userList;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        for (User listUser : userList) {
            if (listUser.getUsername().equals(username)) {
                return Optional.of(listUser);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> updateByUsername(String username, User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                userList.set(i, user);
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> deleteUser(String username) {
        for (User listUser : userList) {
            if (listUser.getUsername().equals(username)) {
                userList.remove(listUser);
                return Optional.of(listUser);
            }
        }
        return Optional.empty();
    }

}

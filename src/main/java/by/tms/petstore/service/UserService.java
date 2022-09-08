package by.tms.petstore.service;

import by.tms.petstore.dao.UserDao;
import by.tms.petstore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    private final AtomicLong atomicLong = new AtomicLong(0);

    public User save(User user) {
        user.setId(atomicLong.incrementAndGet());
        return userDao.save(user);
    }

    public List<User> saveList(List<User> users) {
        for (User user : users) {
            user.setId(atomicLong.incrementAndGet());
        }
        return userDao.saveList(users);
    }

    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public Optional<User> updateByUsername(String username, User user) {
        return userDao.updateByUsername(username, user);
    }

    public Optional<User> deleteUser(String username) {
        return userDao.deleteUser(username);
    }

}

package ua.bu.dao;

import org.springframework.stereotype.Component;
import ua.bu.entity.User;

import java.util.List;

@Component
public interface UserDao {

    List<User> getAll();

    User getById(int id);

    void deleteById(int id);

    void save(User user);

    boolean isLoginNameUnique(String loginName);

    public User updateUser(User user);


}

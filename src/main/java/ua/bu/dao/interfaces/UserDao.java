package ua.bu.dao.interfaces;

import org.springframework.stereotype.Component;
import ua.bu.entity.User;

import java.util.List;

@Component
public interface UserDao {

    List<User> getAll();

    User getById(long id);

    void deleteById(long id);

    void save(User user);

    boolean isLoginNameUnique(String loginName);

    User updateUser(User user);


}

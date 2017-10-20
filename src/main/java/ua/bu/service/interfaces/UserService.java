package ua.bu.service.interfaces;

import ua.bu.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void deleteById(long id);

    void save(User user);

    User getById(long id);

    void update(User user);

    List<String> getListNamesAllUsers();

    User getByName(String loginName);

     boolean save(String login, String password, String email ,String fname , String lname);
}

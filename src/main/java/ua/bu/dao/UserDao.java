package ua.bu.dao;

import ua.bu.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();


    void deleteById(int id);


}

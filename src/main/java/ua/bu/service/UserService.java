package ua.bu.service;

import ua.bu.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    void deleteById(int id);
}

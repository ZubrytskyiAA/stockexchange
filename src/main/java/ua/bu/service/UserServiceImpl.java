package ua.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bu.dao.interfaces.UserDao;
import ua.bu.entity.User;
import ua.bu.service.interfaces.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> getAll() {

        return userDao.getAll();

    }

    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    @Override
    public void save(User user) {
        if (userDao.isLoginNameUnique(user.getLoginName()))
        userDao.save(user);
    }

    @Override
    public User getById(long id) {
          return   userDao.getById(id);
    }

    @Override
    public void update(User user) {

        userDao.updateUser(user);
    }

    @Override
    public List<String> getListNamesAllUsers() {
        return userDao.getListNamesAllUsers();
    }

    @Override
    public User getByName(String loginName) {
        return userDao.getByName(loginName);
    }

}

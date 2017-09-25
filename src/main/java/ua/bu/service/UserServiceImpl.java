package ua.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bu.dao.UserDao;
import ua.bu.entity.User;

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
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void save(User user) {
        if (userDao.isLoginNameUnique(user.getLoginName()))
        userDao.save(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

}

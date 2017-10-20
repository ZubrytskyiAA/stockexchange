package ua.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bu.dao.interfaces.UserDao;
import ua.bu.entity.User;
import ua.bu.service.interfaces.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    User user;
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
    public boolean save(String login, String password, String email , String fname, String lname) {

        System.out.println("begin");
        if (login == null || password == null || email == null) {
            System.out.println(1);
            return false;
        } else if (login.length() < 1) {
            System.out.println(2);
            return false;
        } else if (getListNamesAllUsers().contains(login)) {
            System.out.println(3);
            return false;
        } else if (!password.matches("^(?=.{6,}).*$")) {
            System.out.println(4);
            return false;
        } else if (!password.matches("^(?=.*[0-9]).*$")) {
            System.out.println(5);
            return false;
        } else if (!password.matches("^(?=.*[a-z]).*$")) {
            System.out.println(6);
            return false;
        } else if (!password.matches("^(?=.*[A-Z]).*$")) {
            System.out.println(7);
            return false;
        } else if (!password.matches("^(?=.*[!@#$%^&_+=\\\\*\\\\-\\\\(\\\\)\\\\{\\\\}\\\\:\\\\;\\\\<\\\\>\\\\|\\\\,\\\\.\\\\?\\\\/\\\\'\\\\\"]).*$")) {
            System.out.println(8);
            return false;
        } else if ((email.indexOf(".") > 2) && (email.indexOf("@") > 0)) {

           User user = new User();
           user.setPassword(password);
           user.setLoginName(login);
           user.setEmail(email);
           user.setFirstName(fname);
           user.setLastName(lname);

           save(user);


            System.out.println(9);
            System.out.println(true);
            return true;
        }else {
            System.out.println(10);
            System.out.println(false);
            return false;
        }
    }

        @Override
        public User getById ( long id){
            return userDao.getById(id);
        }

        @Override
        public void update (User user){
            userDao.updateUser(user);
        }

        @Override
        public List<String> getListNamesAllUsers () {
            return userDao.getListNamesAllUsers();
        }

        @Override
        public User getByName (String loginName){
            return userDao.getByName(loginName);
        }

    }

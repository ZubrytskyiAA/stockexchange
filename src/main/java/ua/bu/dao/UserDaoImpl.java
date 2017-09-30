package ua.bu.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.bu.dao.interfaces.UserDao;
import ua.bu.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    protected EntityManager entityManager;




    @Override
    @Transactional
    public List<User> getAll() {
        return entityManager.createQuery("SELECT u FROM User u order by u.id", User.class).getResultList();

    }

    @Override
    public User getById(long id) {
        return entityManager.createQuery("select u from User u where u.id=:id", User.class)
                .setParameter("id", id)
                .getSingleResult();

    }

    @Override
    @Transactional
    public void deleteById(long id) {
             entityManager.createQuery(" delete FROM User u WHERE u.id=" + id).executeUpdate();
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public boolean isLoginNameUnique(String loginName) {
        List<User> users = entityManager.createQuery("select u from User u where u.loginName=:loginName", User.class)
                .setParameter("loginName", loginName)
                .getResultList();
        if (users.size() > 0) {
            return false;
        } else return true;

    }

    @Override
    @Transactional
    public User updateUser(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public List<String> getListNamesAllUsers() {
        return entityManager.createQuery("select u.loginName from User u", String.class)
                .getResultList();
    }


}

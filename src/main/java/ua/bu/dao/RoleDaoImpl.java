package ua.bu.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.bu.dao.interfaces.RoleDao;
import ua.bu.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(Role role) {
         entityManager.persist(role);
    }

    @Override
    public Role updateUser(Role role) {
        return entityManager.merge(role);
    }

    @Override
    public Role getById(long id) {
        return entityManager.createQuery("select r from Role r where r.id=:id", Role.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void deleteById(long id) {
        entityManager.createQuery(" delete FROM Role r WHERE r.id=" + id).executeUpdate();
    }
}

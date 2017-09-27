package ua.bu.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.bu.dao.interfaces.IssueDao;
import ua.bu.entity.Issue;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class IssueDaoImpl implements IssueDao {


    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    public List<Issue> getAll() {

        return entityManager.createQuery("SELECT i FROM Issue i order by i.id", Issue.class).getResultList();
    }

    @Override
    public Issue getById(int id) {
        return entityManager.createQuery("select i from Issue i where i.id=:id", Issue.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void deleteById(int id) {
        entityManager.createQuery(" delete FROM Issue i WHERE i.id=" + id).executeUpdate();
    }

    @Override
    @Transactional
    public void save(Issue issue) {
        entityManager.persist(issue);
    }

    @Override
    public boolean isLoginNameUnique(String name) {

        List<Issue> users = entityManager.createQuery("select i from Issue i where i.name=:name", Issue.class)
                .setParameter("name", name)
                .getResultList();
        if (users.size() > 0) {
            return false;
        } else return true;
    }

    @Override
    public void addIssueToUserId(int id) {

    }
}

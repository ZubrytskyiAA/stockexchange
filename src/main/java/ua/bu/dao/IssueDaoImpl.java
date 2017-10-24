package ua.bu.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.bu.dao.interfaces.IssueDao;
import ua.bu.entity.Issue;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.List;

@Component
public class IssueDaoImpl implements IssueDao {


    @PersistenceContext

    protected EntityManager entityManager;


    @Override
    public List<Issue> getAll() {

        return entityManager.createQuery("SELECT i FROM Issue i order by i.id", Issue.class).getResultList();
    }

    @Override
    public Issue getById(long id) {
        return entityManager.createQuery("select i from Issue i where i.id=:id", Issue.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Issue getByName(String name) {
        return entityManager.createQuery("select i from Issue i where i.name=:name", Issue.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public void deleteById(long id) {
        entityManager.createQuery(" delete FROM Issue i WHERE i.id=" + id).executeUpdate();
    }

    @Override
    @Transactional
    public void save(Issue issue) {
        issue.setCreateMoment(new Timestamp(System.currentTimeMillis()));

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
    public List<String> getAllActive() {

        return entityManager.createQuery("select i.name from Issue i where i.active = 1", String.class)
                .getResultList();
    }

    @Override
    public boolean isIssueActiveByName(String name) {
        List<String> nameIssue;
        nameIssue = entityManager.createQuery("select i.name from Issue i where i.active = 1 and i.name =:name", String.class)
                .setParameter("name", name)
                .getResultList();
        if (nameIssue.isEmpty()) {
            return false;
        } else return true;
    }

    @Override
    @Transactional
    public Issue updateIssue(Issue issue) {
        entityManager.merge(issue);
        return issue;
    }


}

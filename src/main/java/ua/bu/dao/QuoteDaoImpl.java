package ua.bu.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.bu.dao.interfaces.QuoteDao;
import ua.bu.entity.Issue;
import ua.bu.entity.Quote;
import ua.bu.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.List;

@Component
@Transactional
public class QuoteDaoImpl implements QuoteDao {
    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    @Transactional
    public void save(Quote quote) {
        quote.setCreateMoment(new Timestamp(System.currentTimeMillis()));
        entityManager.merge(quote);
    }

    @Override
    @Transactional
    public List<Quote> getAll() {
        return entityManager.createQuery("SELECT q FROM Quote q order by q.id", Quote.class).getResultList();
    }

    @Override
    public List<Quote> getAllQuoteByIssueId(long id) {

        return entityManager.createQuery("SELECT q FROM Quote q where q.issueId.id=:id order by q.price desc", Quote.class)
                .setParameter("id", id)
                .getResultList();

    }

    @Override
    public List<Quote> getAllQuoteByIssueName(String name) {
        return entityManager.createQuery("SELECT q FROM Quote q where q.issueId.name=:name order by q.price", Quote.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public Quote getById(long id) {

        return entityManager.find(Quote.class, id);
    }


    @Override
    @Transactional
    public void delete(Quote quote) {

        entityManager.createQuery("delete FROM Quote u WHERE u.id=" + quote.getId()).executeUpdate();
    }

    @Override
    public void update(Quote quote) {
        entityManager.merge(quote);
    }

    @Override
    public List<Quote> getAllQouteByIssueLessPrice(Issue issue, double price) {
        return entityManager.createQuery("SELECT q FROM Quote q where q.issueId=:issue and q.type = 'S' and q.price <= :price order by q.price , q.createMoment", Quote.class)
                .setParameter("issue", issue)
                .setParameter("price", price)
                .getResultList();
    }


    public List<Quote> getAllQouteByIssueMorePrice(Issue issue, double price) {
        return entityManager.createQuery("SELECT q FROM Quote q where q.issueId=:issue and q.type = 'P' and q.price >= :price order by q.price desc , q.createMoment", Quote.class)
                .setParameter("issue", issue)
                .setParameter("price", price)
                .getResultList();
    }

    @Override
    public List<Quote> getAllQuoteByUser(User user) {
        return entityManager.createQuery("SELECT q FROM Quote q where q.userId=:user", Quote.class)
                .setParameter("user", user)
                .getResultList();
    }


}

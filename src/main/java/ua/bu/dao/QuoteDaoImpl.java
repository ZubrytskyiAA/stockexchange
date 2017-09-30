package ua.bu.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.bu.dao.interfaces.QuoteDao;
import ua.bu.entity.Quote;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class QuoteDaoImpl implements QuoteDao {
    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    public void save(Quote quote) {
        entityManager.persist(quote);
    }

    @Override
    @Transactional
    public List<Quote> getAll() {
        return entityManager.createQuery("SELECT q FROM Quote q order by q.id", Quote.class).getResultList();
    }

    @Override
    public List<Quote> getAllQuoteByIssueId(long id) {

        return entityManager.createQuery("SELECT q FROM Quote q where q.issueId.id=:id order by q.price", Quote.class)
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
        return null;
    }

    @Override
    public Quote updateQuote(Quote quote) {
        return null;
    }

    @Override
    public void delete(Quote quote) {

    }
}

package ua.bu.dao;

import org.springframework.stereotype.Component;
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
    public List<Quote> getAll() {
        return null;
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

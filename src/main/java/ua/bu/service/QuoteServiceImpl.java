package ua.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bu.dao.interfaces.QuoteDao;
import ua.bu.entity.Quote;
import ua.bu.service.interfaces.QuoteService;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService{

    @Autowired
    private QuoteDao quoteDao;

    @Override
    public Quote save(Quote quote) {
        return null;
    }

    @Override
    public List<Quote> getAll() {
        return quoteDao.getAll();
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

    @Override
    public List<Quote> getAllQuoteByIssueId(long id) {
        return quoteDao.getAllQuoteByIssueId(id);
    }
}

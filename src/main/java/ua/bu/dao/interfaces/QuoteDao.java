package ua.bu.dao.interfaces;

import org.springframework.stereotype.Component;
import ua.bu.entity.Quote;

import java.util.List;

@Component
public interface QuoteDao {

    void save(Quote quote);

    List<Quote> getAll();

    List<Quote> getAllQuoteByIssueId(long id);

    List<Quote> getAllQuoteByIssueName(String name);

    Quote getById(long id);


    void delete(Quote quote);
    void update(Quote quote);

}

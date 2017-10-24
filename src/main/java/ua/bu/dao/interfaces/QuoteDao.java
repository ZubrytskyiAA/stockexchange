package ua.bu.dao.interfaces;

import org.springframework.stereotype.Component;
import ua.bu.entity.Issue;
import ua.bu.entity.Quote;
import ua.bu.entity.User;

import java.util.List;

@Component
public interface QuoteDao {

    void save(Quote quote);

    List<Quote> getAll();

    List<Quote> getAllQuoteByIssueId(long id);

    List<Quote> getAllQuoteByIssueName(String name);

    Quote getById(long id);


    void delete(Quote quote);
    Quote update(Quote quote);

    List<Quote> getAllQouteByIssueLessPrice(Issue issue, double price);
    List<Quote> getAllQouteByIssueMorePrice(Issue issue, double price);
    List<Quote> getAllQuoteByUser(User user);


}

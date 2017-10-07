package ua.bu.service.interfaces;

import ua.bu.entity.Quote;

import java.util.List;

public interface QuoteService {
    void save(Quote quote);

    List<Quote> getAll();

    Quote getById(long id);

    Quote updateQuote(Quote quote);

    void delete(Quote quote);

    List<Quote> getAllQuoteByIssueId(long id);

    List<Quote> getAllQuoteByIssueName(String name);

    void update(Quote quote);

    void changeExistQuote(Quote quote);

    void addQuote(Quote quote);

    List<Quote> getAllQuoteByUserName(String loginName);
}

package ua.bu.service.interfaces;

import ua.bu.entity.Quote;

import java.util.List;

public interface QuoteService {
    Quote save(Quote quote);

    List<Quote> getAll();

    Quote getById(long id);

    Quote updateQuote(Quote quote);

    void delete(Quote quote);

}

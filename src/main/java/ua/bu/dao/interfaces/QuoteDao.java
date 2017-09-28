package ua.bu.dao.interfaces;

import org.springframework.stereotype.Component;
import ua.bu.entity.Quote;

import java.util.List;

@Component
public interface QuoteDao {

    void save(Quote quote);

    List<Quote> getAll();

    Quote getById(long id);

    Quote updateQuote(Quote quote);

    void delete(Quote quote);


}

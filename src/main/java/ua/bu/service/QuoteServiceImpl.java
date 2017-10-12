package ua.bu.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.bu.dao.interfaces.QuoteDao;
import ua.bu.entity.Quote;
import ua.bu.service.interfaces.AssetService;
import ua.bu.service.interfaces.QuoteService;
import ua.bu.service.interfaces.TradeService;
import ua.bu.service.interfaces.UserService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    private static final Logger logger = Logger.getLogger(QuoteServiceImpl.class);
    @Autowired
    private QuoteDao quoteDao;
    @Autowired
    private TradeService tradeService;
    @Autowired
    private UserService userService;
    @Autowired
    private AssetService assetService;

    @Override
    public void save(Quote quote) {
        try {
            quoteDao.save(quote);
            logger.info("Quote from " + quote.getUserId().getLoginName() + " added!");
        } catch (Exception e) {
            logger.error(quote.toString() + " " + e.getMessage());
        }
    }

    @Override
    public List<Quote> getAll() {
        return quoteDao.getAll();
    }

    @Override
    public Quote getById(long id) {

        return quoteDao.getById(id);
    }

    @Override
    public Quote updateQuote(Quote quote) {
        return null;
    }

    @Transactional
    @Override
    public void delete(Quote quote) {
        quoteDao.delete(quote);
        assetService.changeAssetWhenDeleteQuote(quote);
    }

    @Override
    public List<Quote> getAllQuoteByIssueId(long id) {
        return quoteDao.getAllQuoteByIssueId(id);
    }

    @Override
    public List<Quote> getAllQuoteByIssueName(String name) {
        return quoteDao.getAllQuoteByIssueName(name);
    }

    @Override
    public void update(Quote quote) {
        Quote tempQuote = quoteDao.getById(quote.getId());

        if (tempQuote != null) {
            if (quote.getCreateMoment() == null) quote.setCreateMoment(new Timestamp(System.currentTimeMillis()));

            quoteDao.update(quote);

        }


    }

    @Override
    @Transactional
    public void changeExistQuote(Quote quote) {

        if (quote != null) {
            Quote oldQuote = getById(quote.getId());

            Quote tempQ = new Quote();
            tempQ.setUserId(oldQuote.getUserId());
            tempQ.setIssueId(oldQuote.getIssueId());
            tempQ.setType(oldQuote.getType());
            tempQ.setQty(quote.getQty());
            tempQ.setPrice(quote.getPrice());
            //надо позже еще вставить проверку на наличие активов!!!!!!!!!!!!!!
            tempQ.setCreateMoment(new Timestamp(System.currentTimeMillis()));

            save(tempQ);
            delete(getById(quote.getId()));

        }
    }

    @Override
    @Transactional
    public void addQuote(Quote quote) {
        if (quote != null) {
            if (quote.getType().equals("P")) {
                List<Quote> listQuote = quoteDao.getAllQouteByIssueLessPrice(quote.getIssueId(), quote.getPrice());
                tradeService.doDealByQuote(listQuote, quote);

            } else {
                List<Quote> listQuote = quoteDao.getAllQouteByIssueMorePrice(quote.getIssueId(), quote.getPrice());
                tradeService.doDealByQuote(listQuote, quote);

            }
        }
    }

    @Override
    public List<Quote> getAllQuoteByUserName(String loginName) {
        return quoteDao.getAllQuoteByUser(userService.getByName(loginName));
    }
}

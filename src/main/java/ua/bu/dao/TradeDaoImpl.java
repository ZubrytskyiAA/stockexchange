package ua.bu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.bu.dao.interfaces.AssetDao;
import ua.bu.dao.interfaces.IssueDao;
import ua.bu.dao.interfaces.QuoteDao;
import ua.bu.dao.interfaces.TradeDao;
import ua.bu.entity.Issue;
import ua.bu.entity.Quote;
import ua.bu.entity.Trade;
import ua.bu.service.interfaces.AssetService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.List;

@Transactional
@Component
public class TradeDaoImpl implements TradeDao {

    @PersistenceContext
    protected EntityManager entityManager;
    @Autowired
    AssetService assetService;
    @Autowired
    private QuoteDao quoteDao;
    @Autowired
    private AssetDao assetDao;
    @Autowired
    private IssueDao issueDao;

    @Override
    @Transactional
    public void save(Trade trade) {

        entityManager.merge(trade);
    }

    @Override
    @Transactional
    public List<Trade> getAll() {
        return entityManager.createQuery("SELECT t FROM Trade t order by t.id", Trade.class).getResultList();
    }

    @Override
    @Transactional
    public Trade getById(long id) {
        return entityManager.createQuery("select t from Trade t where t.id=:id", Trade.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    @Transactional
    public Trade updateTrade(Trade trade) {
        entityManager.merge(trade);
        return trade;
    }

    @Override
    @Transactional
    public void delete(Trade trade) {
        entityManager.remove(trade);
    }

    @Override
    @Transactional
    public void doDealByQuote(List<Quote> listQuote, Quote quote) {

        long qty = quote.getQty();

        if (!assetService.checkAssetByQuoteForEnough(quote)) {
            System.out.println("недостаточно активов");
            return;
        }


        while (qty > 0 && quote.getPrice() > 0) {
            if (!listQuote.isEmpty()) {
                Quote alreadyQuoted = listQuote.get(0);
                if (alreadyQuoted.getQty() >= qty) {
                    Trade trade = new Trade();
                    trade.setConfAction(quote.getType());
                    trade.setInitAction(alreadyQuoted.getType());
                    trade.setPrice(alreadyQuoted.getPrice());
                    trade.setQty(qty);
                    trade.setStatus(10);
                    trade.setTradeMoment(new Timestamp(System.currentTimeMillis()));
                    trade.setType("A");
                    trade.setVolume(alreadyQuoted.getPrice() * qty);
                    trade.setIssue(alreadyQuoted.getIssueId());
                    trade.setUserConf(quote.getUserId());
                    trade.setUserInit(alreadyQuoted.getUserId());
                    entityManager.merge(trade);
                    assetService.changeAssetAfterQuoteDeal(trade);
                    alreadyQuoted.setQty(alreadyQuoted.getQty() - qty);

                    if (alreadyQuoted.getQty() > 0) {
                        quoteDao.save(alreadyQuoted);
                    } else {
                        quoteDao.delete(alreadyQuoted);
                    }

                    break;

                } else {
                    Trade trade = new Trade();
                    trade.setConfAction(quote.getType());
                    trade.setInitAction(alreadyQuoted.getType());
                    trade.setPrice(alreadyQuoted.getPrice());
                    trade.setQty(alreadyQuoted.getQty());//
                    trade.setStatus(10);
                    trade.setTradeMoment(new Timestamp(System.currentTimeMillis()));
                    trade.setType("A");
                    trade.setVolume(alreadyQuoted.getPrice() * alreadyQuoted.getQty());
                    trade.setIssue(alreadyQuoted.getIssueId());
                    trade.setUserConf(quote.getUserId());
                    trade.setUserInit(alreadyQuoted.getUserId());
                    entityManager.merge(trade);
                    assetService.changeAssetAfterQuoteDeal(trade);
                    qty -= alreadyQuoted.getQty();

                    quoteDao.delete(alreadyQuoted);
                    listQuote.remove(0);

                }
            } else {
                // выставить котировку
                System.out.println("add quote");
                quote.setQty(qty);
                quoteDao.save(quote);
                assetService.changeAssetWhenAddQuote(quote);
                break;
            }

        }


    }

    @Override
    public List<Trade> getAllTradesByIssue(Issue issue) {
        return entityManager.createQuery("select t from Trade t where t.issue=:issue", Trade.class)
                .setParameter("issue", issue)
                .getResultList();
    }
}

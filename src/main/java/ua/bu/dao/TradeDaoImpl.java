package ua.bu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.bu.dao.interfaces.QuoteDao;
import ua.bu.dao.interfaces.TradeDao;
import ua.bu.entity.Quote;
import ua.bu.entity.Trade;

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
    private QuoteDao quoteDao;


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
    public void doDeal(List<Quote> listQuote, Quote quote) {
        System.out.println("======================tradedao===========");
        System.out.println(quote);

        long qty = quote.getQty();
        while (qty > 0) {
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
                    qty -= alreadyQuoted.getQty();

                    quoteDao.delete(alreadyQuoted);
                    listQuote.remove(0);
                }
            } else {
                // выставить котировку

                quote.setQty(qty);
                quoteDao.save(quote);
                break;
            }

        }


//        if(quote.getPrice()>0){
//            if(!listQuote.isEmpty()){
//
//            }
//        }
    }
}

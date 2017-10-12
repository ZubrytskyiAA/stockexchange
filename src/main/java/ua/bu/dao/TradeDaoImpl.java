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


    }

    @Override
    public List<Trade> getAllTradesByIssue(Issue issue) {
        return entityManager.createQuery("select t from Trade t where t.issue=:issue", Trade.class)
                .setParameter("issue", issue)
                .getResultList();
    }
}

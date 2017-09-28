package ua.bu.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.bu.dao.interfaces.TradeDao;
import ua.bu.entity.Trade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class TradeDaoImpl implements TradeDao {

    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    @Transactional
    public void save(Trade trade) {
        entityManager.persist(trade);
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
}

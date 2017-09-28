package ua.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bu.dao.interfaces.TradeDao;
import ua.bu.entity.Trade;
import ua.bu.service.interfaces.TradeService;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService{

    @Autowired
    private TradeDao tradeDao;

    @Override
    public void save(Trade trade) {
         tradeDao.save(trade);
    }

    @Override
    public List<Trade> getAll() {
        return tradeDao.getAll();
    }

    @Override
    public Trade getById(long id) {
        return tradeDao.getById(id);
    }

    @Override
    public Trade updateTrade(Trade trade) {
        return tradeDao.updateTrade(trade);
    }

    @Override
    public void delete(Trade trade) {
        tradeDao.delete(trade);

    }
}

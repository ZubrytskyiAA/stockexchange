package ua.bu.dao.interfaces;

import org.springframework.stereotype.Component;
import ua.bu.entity.Trade;

import java.util.List;

@Component
public interface TradeDao {
    void save(Trade trade);

    List<Trade> getAll();

    Trade getById(long id);

    Trade updateTrade(Trade trade);

    void delete(Trade trade);


}
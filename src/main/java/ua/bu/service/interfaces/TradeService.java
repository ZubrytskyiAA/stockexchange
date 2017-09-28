package ua.bu.service.interfaces;

import ua.bu.entity.Trade;

import java.util.List;

public interface TradeService {

    void save(Trade trade);

    List<Trade> getAll();

    Trade getById(long id);

    Trade updateTrade(Trade trade);

    void delete(Trade trade);

}

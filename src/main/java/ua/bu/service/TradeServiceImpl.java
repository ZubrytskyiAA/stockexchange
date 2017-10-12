package ua.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.bu.dao.interfaces.TradeDao;
import ua.bu.entity.Quote;
import ua.bu.entity.Trade;
import ua.bu.service.interfaces.AssetService;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.QuoteService;
import ua.bu.service.interfaces.TradeService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeDao tradeDao;
    @Autowired
    private IssueService issueService;
    @Autowired
    private AssetService assetService;
    @Autowired
    private QuoteService quoteService;


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

    @Override
    public List<Trade> getAllTradesByIssue(String name) {
        return tradeDao.getAllTradesByIssue(issueService.getByName(name));
    }

    @Override
    @Transactional
    public void doDealByQuote(List<Quote> listQuote, Quote quote) {
        if (!assetService.checkAssetByQuoteForEnough(quote)) {
            System.out.println("недостаточно активов");
            return;
        }
        long qty = quote.getQty();

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
                    tradeDao.updateTrade(trade);
                    assetService.changeAssetAfterQuoteDeal(trade);
                    alreadyQuoted.setQty(alreadyQuoted.getQty() - qty);

                    if (alreadyQuoted.getQty() > 0) {
                        quoteService.save(alreadyQuoted);
                    } else {
                        quoteService.delete(alreadyQuoted);
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
                    tradeDao.updateTrade(trade);
                    assetService.changeAssetAfterQuoteDeal(trade);
                    qty -= alreadyQuoted.getQty();

                    quoteService.delete(alreadyQuoted);
                    listQuote.remove(0);

                }
            } else {
                // выставить котировку
                System.out.println("add quote");
                quote.setQty(qty);
                quoteService.save(quote);
                assetService.changeAssetWhenAddQuote(quote);
                break;
            }

        }


    }


}

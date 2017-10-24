package ua.bu.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ua.bu.dao.interfaces.AssetDao;
import ua.bu.entity.Asset;
import ua.bu.entity.Quote;
import ua.bu.entity.Trade;
import ua.bu.service.interfaces.AssetService;
import ua.bu.service.interfaces.IssueService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {


    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private AssetDao assetDao;
    @Autowired
    private IssueService issueService;


    @Override
    public void save(Asset asset) {

        try {
            assetDao.save(asset);
            logger.info(" asset saved by " + SecurityContextHolder.getContext().getAuthentication().getName() + ", " + asset);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


    }

    @Override
    public List<Asset> getAll() {
        return assetDao.getAll();
    }

    @Override
    public Asset getById(long id) {
        return null;
    }

    @Override
    public Asset updateUser(Asset asset) {
        return null;
    }

    @Override
    public void delete(Asset asset) {

    }

    @Override
    public List<Asset> getAssetsByUserId(long id) {
        return assetDao.getAssetsByUserId(id);
    }

    @Override
    public List<Asset> getListAssetsByUserName(String name) {
        return assetDao.getListAssetsByUserName(name);
    }

    @Override
    public Asset getExistAsset(Asset asset) {
        return assetDao.getExistAsset(asset);
    }

    @Override
    public void addNewAsset(Asset asset) {
        Asset existAsset = null;
        try {
            existAsset = assetDao.getExistAsset(asset);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


        if (existAsset != null) {
            BigDecimal bdExistAsset = BigDecimal.valueOf(existAsset.getFree());
            BigDecimal bdEntredAsset = BigDecimal.valueOf(asset.getFree());
            existAsset.setFree(bdExistAsset.add(bdEntredAsset).doubleValue());

            save(existAsset);

        } else {
            save(asset);
        }

    }

    @Override
    public void withdrawAsset(Asset asset) {
        Asset existsAsset = null;
        try {
            existsAsset = assetDao.getExistAsset(asset);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        if (existsAsset != null) {
            BigDecimal bdsAsset = BigDecimal.valueOf(asset.getFree());
            BigDecimal bdEntredAsset = BigDecimal.valueOf(existsAsset.getFree());

            if (bdEntredAsset.compareTo(bdsAsset) >= 0) {
                existsAsset.setFree(bdEntredAsset.subtract(bdsAsset).doubleValue());
                save(existsAsset);
            }


        }
    }


    @Override
    public void changeAssetWhenAddQuote(Quote quote) {
        List<Asset> assetList;
        BigDecimal free;
        BigDecimal block;
        Asset asset;
        try {
            if (quote.getType().equals("S")) {
                assetList = assetDao.getAssetByUserAndByIssue(quote.getUserId(), quote.getIssueId());
                asset = assetList.get(0);
                free = BigDecimal.valueOf(asset.getFree()).subtract(BigDecimal.valueOf(quote.getQty()));
                block = BigDecimal.valueOf(asset.getBlocked()).add(BigDecimal.valueOf(quote.getQty()));
            } else {
                assetList = assetDao.getAssetByUserAndByIssue(quote.getUserId(), issueService.getByName("UAH"));
                asset = assetList.get(0);
                free = BigDecimal.valueOf(asset.getFree()).subtract(BigDecimal.valueOf(quote.getPrice()).multiply(BigDecimal.valueOf(quote.getQty())));
                block = BigDecimal.valueOf(asset.getBlocked()).add(BigDecimal.valueOf(quote.getPrice()).multiply(BigDecimal.valueOf(quote.getQty())));
            }

            asset.setFree(free.doubleValue());
            asset.setBlocked(block.doubleValue());

            save(asset);
            logger.info(" asset changed after adding quote :" + asset);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


    }

    @Override
    public void changeAssetWhenDeleteQuote(Quote quote) {
        List<Asset> assetList;
        BigDecimal free;
        BigDecimal block;
        Asset asset;
        try {
            if (quote.getType().equals("S")) {
                assetList = assetDao.getAssetByUserAndByIssue(quote.getUserId(), quote.getIssueId());
                asset = assetList.get(0);
                free = BigDecimal.valueOf(asset.getFree()).add(BigDecimal.valueOf(quote.getQty()));
                block = BigDecimal.valueOf(asset.getBlocked()).subtract(BigDecimal.valueOf(quote.getQty()));
            } else {
                assetList = assetDao.getAssetByUserAndByIssue(quote.getUserId(), issueService.getByName("UAH"));
                asset = assetList.get(0);
                free = BigDecimal.valueOf(asset.getFree()).add(BigDecimal.valueOf(quote.getPrice()).multiply(BigDecimal.valueOf(quote.getQty())));
                block = BigDecimal.valueOf(asset.getBlocked()).subtract(BigDecimal.valueOf(quote.getPrice()).multiply(BigDecimal.valueOf(quote.getQty())));
            }
            asset.setFree(free.doubleValue());
            asset.setBlocked(block.doubleValue());
            save(asset);
            logger.info(" asset changed after deleting quote :" + asset);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public boolean checkAssetByQuoteForEnough(Quote quote) {
        List<Asset> assetList;
        double sum = 0;
        if (quote.getType().equals("S")) {
            assetList = assetDao.getAssetByUserAndByIssue(quote.getUserId(), quote.getIssueId());
            if (assetList.isEmpty()) return false;
            sum = quote.getQty();
        } else {
            assetList = assetDao.getAssetByUserAndByIssue(quote.getUserId(), issueService.getByName("UAH"));
            if (assetList.isEmpty()) return false;
            sum = quote.getPrice() * quote.getQty();
        }

        if (assetList.get(0).getFree() >= sum) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void changeAssetAfterQuoteDeal(Trade trade) {
        List<Asset> assetListInitUserIssue;
        Asset assetInitUserIssue;
        List<Asset> assetListInitUserMoney;
        Asset assetInitUserMoney;
        List<Asset> assetListConfUserIssue;
        Asset assetConfUserIssue;
        List<Asset> assetListConfUserMoney;
        Asset assetConfUserMoney;

        if (trade.getInitAction().equals("S")) {
            //списываем с продавца бумаги
            assetListInitUserIssue = assetDao.getAssetByUserAndByIssue(trade.getUserInit(), trade.getIssue());
            assetInitUserIssue = assetListInitUserIssue.get(0);
            assetInitUserIssue.setBlocked(BigDecimal.valueOf(assetInitUserIssue.getBlocked()).subtract(BigDecimal.valueOf(trade.getQty())).doubleValue());
            // добавляем продавцу деньги
            assetListInitUserMoney = assetDao.getAssetByUserAndByIssue(trade.getUserInit(), issueService.getByName("UAH"));
            if (assetListInitUserMoney.isEmpty()) {
                assetInitUserMoney = new Asset();
                assetInitUserMoney.setUserId(trade.getUserInit());
                assetInitUserMoney.setIssueId(issueService.getByName("UAH"));
            } else {
                assetInitUserMoney = assetListInitUserMoney.get(0);
            }
            assetInitUserMoney.setFree(BigDecimal.valueOf(assetInitUserMoney.getFree()).add(BigDecimal.valueOf(trade.getVolume())).doubleValue());
            //списываем с покупателя деньги
            assetListConfUserIssue = assetDao.getAssetByUserAndByIssue(trade.getUserConf(), issueService.getByName("UAH"));
            assetConfUserIssue = assetListConfUserIssue.get(0);
            assetConfUserIssue.setFree(BigDecimal.valueOf(assetConfUserIssue.getFree()).subtract(BigDecimal.valueOf(trade.getVolume())).doubleValue());
            //добавляем покупателю бумаги
            assetListConfUserMoney = assetDao.getAssetByUserAndByIssue(trade.getUserConf(), trade.getIssue());
            if (assetListConfUserMoney.isEmpty()) {
                assetConfUserMoney = new Asset();
                assetConfUserMoney.setIssueId(trade.getIssue());
                assetConfUserMoney.setUserId(trade.getUserConf());
            } else {
                assetConfUserMoney = assetListConfUserMoney.get(0);
            }
            assetConfUserMoney.setFree(BigDecimal.valueOf(assetConfUserMoney.getFree()).add(BigDecimal.valueOf(trade.getQty())).doubleValue());


        } else {

            //покупка!!!!!
            //списываем с покупателя деньги
            assetListInitUserMoney = assetDao.getAssetByUserAndByIssue(trade.getUserInit(), issueService.getByName("UAH"));
            assetInitUserMoney = assetListInitUserMoney.get(0);
            assetInitUserMoney.setBlocked(BigDecimal.valueOf(assetInitUserMoney.getBlocked()).subtract(BigDecimal.valueOf(trade.getVolume())).doubleValue());
            // добавляем покупателю бумаги
            assetListInitUserIssue = assetDao.getAssetByUserAndByIssue(trade.getUserInit(), trade.getIssue());
            if (assetListInitUserIssue.isEmpty()) {
                assetInitUserIssue = new Asset();
                assetInitUserIssue.setIssueId(trade.getIssue());
                assetInitUserIssue.setUserId(trade.getUserInit());

            } else {
                assetInitUserIssue = assetListInitUserIssue.get(0);
            }
            assetInitUserIssue.setFree(BigDecimal.valueOf(assetInitUserIssue.getFree()).add(BigDecimal.valueOf(trade.getQty())).doubleValue()); //++
            //списываем с продавца бумаги
            assetListConfUserIssue = assetDao.getAssetByUserAndByIssue(trade.getUserConf(), trade.getIssue());
            assetConfUserIssue = assetListConfUserIssue.get(0);
            assetConfUserIssue.setFree(BigDecimal.valueOf(assetConfUserIssue.getFree()).subtract(BigDecimal.valueOf(trade.getQty())).doubleValue());
            //добавляем продавцу деньги
            assetListConfUserMoney = assetDao.getAssetByUserAndByIssue(trade.getUserConf(), issueService.getByName("UAH"));
            if (assetListConfUserMoney.isEmpty()) {
                assetConfUserMoney = new Asset();
                assetConfUserMoney.setIssueId(issueService.getByName("UAH"));
                assetConfUserMoney.setUserId(trade.getUserConf());
            } else {
                assetConfUserMoney = assetListConfUserMoney.get(0);
            }
            assetConfUserMoney.setFree(BigDecimal.valueOf(assetConfUserMoney.getFree()).add(BigDecimal.valueOf(trade.getVolume())).doubleValue());
        }

        save(assetInitUserIssue);
        save(assetInitUserMoney);
        save(assetConfUserIssue);
        save(assetConfUserMoney);


    }


}

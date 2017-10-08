package ua.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bu.dao.interfaces.AssetDao;
import ua.bu.entity.Asset;
import ua.bu.entity.Quote;
import ua.bu.entity.Trade;
import ua.bu.service.interfaces.AssetService;
import ua.bu.service.interfaces.IssueService;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetDao assetDao;
    @Autowired
    private IssueService issueService;

    {

    }

    @Override
    public void save(Asset asset) {

        assetDao.save(asset);
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
        Asset asset1 = assetDao.getExistAsset(asset);

        if (asset1 == null) {
            assetDao.save(asset);
        } else {
            asset1.addFree(asset.getFree());
            assetDao.save(asset1);
        }

    }

    @Override
    public void withdrawAsset(Asset asset) {
        Asset asset1 = assetDao.getExistAsset(asset);

        if (asset1 == null) {
            assetDao.save(asset);
        } else {
            asset1.withdrawAsset(asset.getFree());
            assetDao.save(asset1);
        }
    }


    @Override
    public void changeAssetWhenAddQuote(Quote quote) {
        List<Asset> assetList;
        double free = 0;
        double block = 0;
        Asset asset;

        if (quote.getType().equals("S")) {
            assetList = assetDao.getAssetByUserAndByIssue(quote.getUserId(), quote.getIssueId());
            asset = assetList.get(0);
            free = asset.getFree() - quote.getQty();
            block = asset.getBlocked() + quote.getQty();
        } else {
            assetList = assetDao.getAssetByUserAndByIssue(quote.getUserId(), issueService.getByName("UAH"));
            asset = assetList.get(0);
            free = asset.getFree() - quote.getPrice() * quote.getQty();
            block = asset.getBlocked() + quote.getPrice() * quote.getQty();
        }

        asset.setFree(free);
        asset.setBlocked(block);
        save(asset);

    }

    @Override
    public void changeAssetWhenDeleteQuote(Quote quote) {
        List<Asset> assetList;
        double free = 0;
        double block = 0;
        Asset asset;

        if (quote.getType().equals("S")) {
            assetList = assetDao.getAssetByUserAndByIssue(quote.getUserId(), quote.getIssueId());
            asset = assetList.get(0);
            free = asset.getFree() + quote.getQty();
            block = asset.getBlocked() - quote.getQty();
        } else {
            assetList = assetDao.getAssetByUserAndByIssue(quote.getUserId(), issueService.getByName("UAH"));
            asset = assetList.get(0);
            free = asset.getFree() + quote.getPrice() * quote.getQty();
            block = asset.getBlocked() - quote.getPrice() * quote.getQty();
        }
        asset.setFree(free);
        asset.setBlocked(block);
        save(asset);
    }

    @Override
    public boolean checkAssetByQuoteForEnough(Quote quote) {
        List<Asset> assetList;
        double sum = 0;
        if (quote.getType().equals("S")) {
            assetList = assetDao.getAssetByUserAndByIssue(quote.getUserId(), quote.getIssueId());
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
            assetInitUserIssue.setBlocked(assetInitUserIssue.getBlocked() - trade.getQty());
            // добавляем продавцу деньги
            assetListInitUserMoney = assetDao.getAssetByUserAndByIssue(trade.getUserInit(), issueService.getByName("UAH"));
            if (assetListInitUserMoney.isEmpty()) {
                assetInitUserMoney = new Asset();
                assetInitUserMoney.setUserId(trade.getUserInit());
                assetInitUserMoney.setIssueId(issueService.getByName("UAH"));
            } else {
                assetInitUserMoney = assetListInitUserMoney.get(0);
            }
            assetInitUserMoney.setFree(assetInitUserMoney.getFree() + trade.getVolume());
            //списываем с покупателя деньги
            assetListConfUserIssue = assetDao.getAssetByUserAndByIssue(trade.getUserConf(), issueService.getByName("UAH"));
            assetConfUserIssue = assetListConfUserIssue.get(0);
            assetConfUserIssue.setFree(assetConfUserIssue.getFree() - trade.getVolume());
            //добавляем покупателю бумаги
            assetListConfUserMoney = assetDao.getAssetByUserAndByIssue(trade.getUserConf(), trade.getIssue());
            if (assetListConfUserMoney.isEmpty()) {
                assetConfUserMoney = new Asset();
                assetConfUserMoney.setIssueId(trade.getIssue());
                assetConfUserMoney.setUserId(trade.getUserConf());
            } else {
                assetConfUserMoney = assetListConfUserMoney.get(0);
            }
            assetConfUserMoney.setFree(assetConfUserMoney.getFree() + trade.getQty());


        } else {

            //покупка!!!!!
            //списываем с покупателя деньги
            assetListInitUserMoney = assetDao.getAssetByUserAndByIssue(trade.getUserInit(), issueService.getByName("UAH"));
            assetInitUserMoney = assetListInitUserMoney.get(0);
            assetInitUserMoney.setBlocked(assetInitUserMoney.getBlocked() - trade.getVolume());
            // добавляем покупателю бумаги
            assetListInitUserIssue = assetDao.getAssetByUserAndByIssue(trade.getUserInit(), trade.getIssue());
            if (assetListInitUserIssue.isEmpty()) {
                assetInitUserIssue = new Asset();
                assetInitUserIssue.setIssueId(trade.getIssue());
                assetInitUserIssue.setUserId(trade.getUserInit());

            } else {
                assetInitUserIssue = assetListInitUserIssue.get(0);
            }
            assetInitUserIssue.setFree(assetInitUserIssue.getFree() + trade.getQty()); //++
            //списываем с продавца бумаги
            assetListConfUserIssue = assetDao.getAssetByUserAndByIssue(trade.getUserConf(), trade.getIssue());
            assetConfUserIssue = assetListConfUserIssue.get(0);
            assetConfUserIssue.setFree(assetConfUserIssue.getFree() - trade.getQty());
            //добавляем продавцу деньги
            assetListConfUserMoney = assetDao.getAssetByUserAndByIssue(trade.getUserConf(), issueService.getByName("UAH"));
            if (assetListConfUserMoney.isEmpty()) {
                assetConfUserMoney = new Asset();
                assetConfUserMoney.setIssueId(issueService.getByName("UAH"));
                assetConfUserMoney.setUserId(trade.getUserConf());
            } else {
                assetConfUserMoney = assetListConfUserMoney.get(0);
            }
            assetConfUserMoney.setFree(assetConfUserMoney.getFree() + trade.getVolume());
        }

        save(assetInitUserIssue);
        save(assetInitUserMoney);
        save(assetConfUserIssue);
        save(assetConfUserMoney);


    }


}

package ua.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bu.dao.interfaces.AssetDao;
import ua.bu.entity.Asset;
import ua.bu.service.interfaces.AssetService;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetDao assetDao;

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


}

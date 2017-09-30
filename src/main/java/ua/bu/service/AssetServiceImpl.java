package ua.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bu.dao.interfaces.AssetDao;
import ua.bu.entity.Asset;
import ua.bu.entity.User;
import ua.bu.service.interfaces.AssetService;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetDao assetDao;
    @Override
    public Asset save(Asset issue) {
        return null;
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
}

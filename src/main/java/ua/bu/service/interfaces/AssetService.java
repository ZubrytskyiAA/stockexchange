package ua.bu.service.interfaces;

import ua.bu.entity.Asset;

import java.util.List;

public interface AssetService {
    void save(Asset issue);

    List<Asset> getAll();

    Asset getById(long id);

    Asset updateUser(Asset asset);

    void delete(Asset asset);

    List<Asset> getAssetsByUserId(long id);

    List<Asset> getListAssetsByUserName(String name);

    Asset getExistAsset(Asset asset);

    void addNewAsset(Asset asset);

    void withdrawAsset(Asset asset);
}

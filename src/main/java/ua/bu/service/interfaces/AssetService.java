package ua.bu.service.interfaces;

import ua.bu.entity.Asset;
import ua.bu.entity.User;

import java.util.List;

public interface AssetService {
    Asset save(Asset issue);

    List<Asset> getAll();

    Asset getById(long id);

    Asset updateUser(Asset asset);

    void delete(Asset asset);
    List<Asset> getAssetsByUserId(long id);

}

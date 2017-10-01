package ua.bu.dao.interfaces;


import org.springframework.stereotype.Component;
import ua.bu.entity.Asset;
import ua.bu.entity.User;

import java.util.List;

@Component
public interface AssetDao {

    void save(Asset asset);

    List<Asset> getAll();

    Asset getById(long id);

    Asset updateUser(Asset asset);

    void delete(Asset asset);

    List<Asset> getAssetsByUserId(long id);

    List<Asset>  getListAssetsByUserName(String name);

    //void deleteById(long id);


    // void changeBlock(double block);

    //int changeFree(double free);
    Asset getExistAsset(Asset asset);



}

package ua.bu.dao.interfaces;


import org.springframework.stereotype.Component;
import ua.bu.entity.Asset;

import java.util.List;

@Component
public interface AssetDao {

    void save(Asset issue);

    List<Asset> getAll();

    Asset getById(long id);

    Asset updateUser(Asset asset);

    void delete(Asset asset);


    //void deleteById(long id);


    // void changeBlock(double block);

    //int changeFree(double free);


}

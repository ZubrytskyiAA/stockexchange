package ua.bu.dao;

import org.springframework.stereotype.Component;
import ua.bu.dao.interfaces.AssetDao;
import ua.bu.entity.Asset;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class AssetDaoImpl implements AssetDao {
    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    public void save(Asset issue) {
        entityManager.persist(issue);
    }

    @Override
    public List<Asset> getAll() {
        return null;
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
}

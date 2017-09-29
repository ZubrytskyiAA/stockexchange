package ua.bu.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public List<Asset> getAll() {
        return entityManager.createQuery("SELECT a FROM Asset a order by a.id", Asset.class).getResultList();
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

        return entityManager.createQuery("SELECT a FROM Asset a where a.userId.id=:userId order by a.id", Asset.class)
                .setParameter("userId", id)
                .getResultList();
    }
}

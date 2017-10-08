package ua.bu.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.bu.dao.interfaces.AssetDao;
import ua.bu.entity.Asset;
import ua.bu.entity.Issue;
import ua.bu.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class AssetDaoImpl implements AssetDao {
    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    @Transactional
    public void save(Asset asset) {
        entityManager.merge(asset);

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

        return entityManager.createQuery("SELECT a FROM Asset a where a.userId.id=:userId and (a.free > 0 or a.blocked > 0) order by a.id", Asset.class)
                .setParameter("userId", id)
                .getResultList();
    }


    @Override
    public List<Asset> getListAssetsByUserName(String name) {
        return entityManager.createQuery("SELECT a FROM Asset a where a.userId.loginName=:loginName and (a.free > 0 or a.blocked > 0) order by a.id", Asset.class)
                .setParameter("loginName", name)
                .getResultList();
    }

    @Override
    public  List<Asset> getAssetByUserAndByIssue(User user, Issue issue) {
        return entityManager.createQuery("SELECT a FROM Asset a where a.userId=:userId and a.issueId=:issueId", Asset.class)
                .setParameter("userId", user)
                .setParameter("issueId", issue)
                .getResultList();
    }

    @Override
    public Asset getExistAsset(Asset asset) {


        List<Asset> assetList = entityManager.createQuery("SELECT a FROM Asset a where a.issueId=:issueId and a.userId=:userId", Asset.class)
                .setParameter("issueId", asset.getIssueId())
                .setParameter("userId", asset.getUserId())
                .getResultList();
        if (assetList.isEmpty()) {
            return null;

        } else {
            return assetList.get(0);
        }


    }
}

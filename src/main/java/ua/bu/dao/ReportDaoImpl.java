package ua.bu.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.bu.dao.interfaces.ReportDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class ReportDaoImpl implements ReportDao {

    @PersistenceContext
    protected EntityManager entityManager;

}

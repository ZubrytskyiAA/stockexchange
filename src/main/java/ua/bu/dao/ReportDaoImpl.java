package ua.bu.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.bu.dao.interfaces.ReportDao;
import ua.bu.entity.Quote;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class ReportDaoImpl implements ReportDao {

    @PersistenceContext
    protected EntityManager entityManager;

//    public List<Object> getAll() {
//
//        Timestamp dt = new Timestamp(System.currentTimeMillis());
//        System.out.println(dt.toString());
//        List objectList= new ArrayList<>();
//        System.out.println("==========++++");
//       List<Object[]> author = entityManager.createQuery("SELECT count(id) , sum(volume) , sum(qty),  userInit.loginName FROM Trade  where trade_moment >  current_date group by userInit.loginName ")
//                .getResultList();
//for( Object[] text : author) {
//    System.out.println(
//            "count deals = "
//            + text[0]
//            +", summary volume = "
//            + text[1]
//            + ", total qty = "
//            + text[2]
//            + ", userName= "
//            + text[3]);
//}
//        return  null;
//
//    }



//    public List<Object> getTradeInformationByIssue() {
//
//        Timestamp dt = new Timestamp(System.currentTimeMillis());
//        System.out.println(dt.toString());
//        List objectList= new ArrayList<>();
//        System.out.println("==========++++");
//        List<Object[]> author = entityManager.createQuery("SELECT count(id) , avg(price) , sum(volume) , sum(qty),  issue.name FROM Trade  where trade_moment >  current_date group by issue.name ")
//                .getResultList();
//        for( Object[] text : author) {
//            System.out.println(
//                    "count deals = "
//                            + text[0]
//                            +", average price = "
//                            + text[1]
//                            +", summary volume = "
//                            + text[2]
//                            + ", total qty = "
//                            + text[3]
//                            + ", userName= "
//                            + text[4]);
//        }
//        return  null;
//
//    }





}

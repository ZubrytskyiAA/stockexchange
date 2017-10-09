package ua.bu.dao.interfaces;


import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface ReportDao {

    List<Object> getAll();
    List<Object> getTradeInformationByIssue();

}

package ua.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bu.dao.interfaces.ReportDao;
import ua.bu.service.interfaces.ReportService;

@Service
public class ReportServiceImpl  implements ReportService{

    @Autowired
    private ReportDao reportDao;


}

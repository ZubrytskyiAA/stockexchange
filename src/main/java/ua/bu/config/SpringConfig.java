package ua.bu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.bu.dao.IssueDaoImpl;
import ua.bu.dao.TradeDaoImpl;
import ua.bu.dao.UserDaoImpl;
import ua.bu.dao.interfaces.IssueDao;
import ua.bu.dao.interfaces.TradeDao;
import ua.bu.dao.interfaces.UserDao;
import ua.bu.service.IssueServiceImpl;
import ua.bu.service.TradeServiceImpl;
import ua.bu.service.UserServiceImpl;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.TradeService;
import ua.bu.service.interfaces.UserService;

@Configuration
public class SpringConfig {

    @Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }

    @Bean
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }


    @Bean
    public IssueService getIssueService() {
        return new IssueServiceImpl();
    }

    @Bean
    public IssueDao getIssueDao() {
        return new IssueDaoImpl();
    }


    @Bean
    public TradeService getTradeService() {
        return new TradeServiceImpl();
    }

    @Bean
    public TradeDao getTradeDao() {
        return new TradeDaoImpl();
    }


}

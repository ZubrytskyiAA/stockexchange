package ua.bu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.bu.dao.*;
import ua.bu.dao.interfaces.*;
import ua.bu.service.*;
import ua.bu.service.interfaces.*;

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
    public ReportService getReportService() {
        return new ReportServiceImpl();
    }

    @Bean
    public ReportDao getReportDao() {
        return new ReportDaoImpl();
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


    @Bean
    public AssetService getAssetService() {
        return new AssetServiceImpl();
    }

    @Bean
    public AssetDao getAssetDao() {
        return new AssetDaoImpl();
    }


    @Bean
    public QuoteService getQuoteService() {
        return new QuoteServiceImpl();
    }

    @Bean
    public QuoteDao getQuoteDao() {
        return new QuoteDaoImpl();
    }

}

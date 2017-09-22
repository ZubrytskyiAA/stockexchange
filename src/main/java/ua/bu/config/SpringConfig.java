package ua.bu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ua.bu.dao.UserDao;
import ua.bu.dao.UserDaoImpl;
import ua.bu.service.UserService;
import ua.bu.service.UserServiceImpl;
@Configuration
public class SpringConfig {

    @Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }


    @Bean
    public UserDao getUserDaoImpl() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/se");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return new UserDaoImpl(dataSource);
    }
}

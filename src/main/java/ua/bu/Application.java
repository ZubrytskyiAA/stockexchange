package ua.bu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.bu.config.SpringConfig;
import ua.bu.entity.Trade;
import ua.bu.entity.User;
import ua.bu.service.interfaces.UserService;

import java.sql.Timestamp;
import java.util.List;

public class Application {
    public static void main(String[] args) {

//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        System.out.println("dsada");
//
//        UserService service = context.getBean(UserService.class);
//
//        List<User> users = service.getAll();

//        users.forEach(System.out::println);


        Trade trade = new Trade();
        trade.setId(1);
        trade.setPrice(1);
        trade.setTradeMoment(new Timestamp(System.currentTimeMillis()));
        trade.setId(1);

        System.out.println(trade);





    }

}

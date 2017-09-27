package ua.bu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.bu.config.SpringConfig;
import ua.bu.entity.User;
import ua.bu.service.interfaces.UserService;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("dsada");

        UserService service = context.getBean(UserService.class);

        List<User> users = service.getAll();

        users.forEach(System.out::println);




        ;
//        User user = new User();
//        user.setName("Acecream");




//        List<Commodity> commodities= comService.getAll();
//        commodities.forEach(System.out::println);
//        System.out.println("==================================");


    }

}

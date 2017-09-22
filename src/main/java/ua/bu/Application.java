package ua.bu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.bu.config.SpringConfig;
import ua.bu.entity.Issue;
import ua.bu.entity.User;
import ua.bu.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("dsada");

        UserService service = context.getBean(UserService.class);


        ;
//        User user = new User();
//        user.setName("Acecream");


        List<User> user11 = service.getAll();

        Issue issue1 = new Issue();
        issue1.setId(1);
        issue1.setName("sa1");
        issue1.setFullName("dasda");
        Issue issue2 = new Issue();
        issue2.setId(2);
        issue2.setName("sa2");
        issue2.setFullName("dasda2");
        Issue issue3 = new Issue();
        issue1.setId(3);
        issue1.setName("sa3");
        issue1.setFullName("dasda3");





        user11.get(0).setIssues(new ArrayList<Issue>());
        user11.get(0).getIssues().add(issue1);
        user11.get(0).getIssues().add(issue2);
        user11.get(0).getIssues().add(issue3);
        user11.forEach(System.out::println);
        System.out.println("==================================");

//        List<Commodity> commodities= comService.getAll();
//        commodities.forEach(System.out::println);
//        System.out.println("==================================");


    }

}

package ua.bu.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeController {


    @GetMapping("")
    public String index() {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();


        if(auth.getAuthorities().toString().contains("TRADER")) {
            Principal principal = auth;
            System.out.println("===========================++");
            System.out.println(name);
            System.out.println(auth.getAuthorities().toString());
            System.out.println("====___=========");
            System.out.println( principal.toString());
            System.out.println("====___=========");

        }
        return "index";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @GetMapping("/login")
    public String login() {
        return "loginPage";
    }


    @GetMapping("/error_page")
    public String errorPage() {
        return "errorPage";
    }

}

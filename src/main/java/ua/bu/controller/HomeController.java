package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.bu.dao.interfaces.ReportDao;

import java.util.Locale;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ReportDao reportDao;

    @GetMapping("/")
    public String index(Locale locale) {
        return "index";
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

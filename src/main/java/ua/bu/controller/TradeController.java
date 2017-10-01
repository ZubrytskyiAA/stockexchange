package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.bu.entity.Issue;
import ua.bu.entity.User;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.TradeService;
import ua.bu.service.interfaces.UserService;


@Controller
@RequestMapping("/trade/")
public class TradeController {


    @Autowired
    private UserService userService;
    @Autowired
    private IssueService issueService;
    @Autowired
    private TradeService tradeService;





    @GetMapping("/alltrades")
    public String getAlltrades(Model model) {
        model.addAttribute("trades", tradeService.getAll());
        System.out.println("=======================================================");
        System.out.println(tradeService.getAll());
        return "tradeList";
    }



}

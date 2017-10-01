package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.bu.entity.Issue;
import ua.bu.entity.Trade;
import ua.bu.entity.User;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.TradeService;
import ua.bu.service.interfaces.UserService;

import java.sql.Timestamp;


@Controller
@RequestMapping("/trade")
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

        return "tradeList";
    }


//    @GetMapping("")
//    public String editPage( Model model) {
//
//
//        Trade trade = new Trade();
//        trade.setConfAction("S");
//        trade.setInitAction("P");
//        trade.setPrice(22.51);
//        trade.setQty(2);
//        trade.setStatus(10);
//        trade.setTradeMoment(new Timestamp(System.currentTimeMillis()));
//        trade.setType("A");
//        trade.setVolume(45.02);
//        trade.setIssue(issueService.getById(1));
//        trade.setUserConf(userService.getById(1));
//        trade.setUserInit(userService.getById(1));
//        System.out.println(trade);
//
//
//
//        Trade trade1 = tradeService.getById(1);
//        System.out.println("=============trade1");
//        System.out.println(trade1);
//
//
//        trade1.setPrice(666);
//        tradeService.save(trade);
//        System.out.println("====================");
//
//
//        return "redirect:/";
//    }



}

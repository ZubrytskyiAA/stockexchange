package ua.bu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.bu.entity.Trade;
import ua.bu.service.interfaces.ReportService;
import ua.bu.service.interfaces.TradeService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/report")
public class ReportController {


    @Autowired
    private TradeService tradeService;

    @Autowired
    private ReportService userService;


    @GetMapping("")
    public String trades(Model model) {
        List<Trade> trades = tradeService.getAll();
        Set<String> uniqNames = new HashSet<>();
        for (Trade x : trades) {
            uniqNames.add(x.getIssue().getName());
        }

        model.addAttribute("trades", trades);
        model.addAttribute("uniqNames", uniqNames);
        model.addAttribute("selectedIssueName", "");

        System.out.println("===========================");
        trades.forEach(System.out::println);
        System.out.println("=============uniq==============");
        uniqNames.forEach(System.out::println);


        return "reportView";
    }


    @GetMapping("/{name}")
    public String getAllUsers(@PathVariable("name") String name, Model model) {
        List<Trade> trades = tradeService.getAllTradesByIssue(name);
        Set<String> uniqNames = new HashSet<>();
        for (Trade x : tradeService.getAll()) {
            uniqNames.add(x.getIssue().getName());
        }

        model.addAttribute("trades", trades);
        model.addAttribute("uniqNames", uniqNames);
        model.addAttribute("selectedIssueName", name);


        return "reportView";
    }


}

package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.bu.entity.Trade;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.TradeService;
import ua.bu.service.interfaces.UserService;

import java.util.ArrayList;
import java.util.List;


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


    @GetMapping("")
    public String editPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        List<Trade> tradeList = tradeService.getAll();
        List<Integer> intList = new ArrayList<>();


        if (!tradeList.isEmpty()) {
            int size = tradeList.size();
            int step = 10;


            for (int i = 0; i <= (size - 1) / step; i++) {
                intList.add(i);
            }
            if (size >= step) {
                model.addAttribute("trades", tradeList.subList(0, step));
            } else {
                model.addAttribute("trades", tradeList.subList(0, size));

            }
            model.addAttribute("listSize", size);
            model.addAttribute("listLinks", intList);
            model.addAttribute("currentPage", 0);
        }


        return "tradeList";
    }



    @GetMapping("/{id}")
    public String getListQuotes(@PathVariable("id") int id, Model model) {


        List<Trade> tradeList = tradeService.getAll();



        if (!tradeList.isEmpty()) {
            int size = tradeList.size();
            int step = 10;

            List<Integer> intList = new ArrayList<>();
            for (int i = 0; i <= (size - 1) / step; i++) {
                intList.add(i);
            }
            if (size < id * step) {
                model.addAttribute("trades", tradeList.subList(size / step * step, size / step * step + size % step));
                model.addAttribute("currentPage", size / step);
            } else if (size > (id + 1) * step) {
                model.addAttribute("trades", tradeList.subList(id * step, (id + 1) * step));
                model.addAttribute("currentPage", id);
            } else {
                model.addAttribute("trades", tradeList.subList(id * step, size));
                model.addAttribute("currentPage", id);
            }
            model.addAttribute("listSize", size);
            model.addAttribute("listLinks", intList);
        }


        return "tradeList";


    }


}
